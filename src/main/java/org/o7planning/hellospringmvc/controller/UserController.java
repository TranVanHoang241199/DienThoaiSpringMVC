package org.o7planning.hellospringmvc.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.o7planning.hellospringmvc.bean.DienThoaiBean;
import org.o7planning.hellospringmvc.bean.KhachhangBean;
import org.o7planning.hellospringmvc.bean.LichSuMuaHangBean;
import org.o7planning.hellospringmvc.bean.LoaiBean;
import org.o7planning.hellospringmvc.bean.ThongSoDTBean;
import org.o7planning.hellospringmvc.bo.DienThoaiBo;
import org.o7planning.hellospringmvc.bo.GioHangBo;
import org.o7planning.hellospringmvc.bo.KhachHangBo;
import org.o7planning.hellospringmvc.bo.LichSuMuaHangBo;
import org.o7planning.hellospringmvc.bo.LoaiBo;
import org.o7planning.hellospringmvc.bo.ThongSoDTBo;
import org.o7planning.hellospringmvc.capcha.VerifyUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	public ArrayList<String> getNut() {
		ArrayList<String> ds = new ArrayList<String>();
		ds.add(0, "btn btn-primary");
		ds.add(1, "btn btn-secondary");
		ds.add(2, "btn btn-success");
		ds.add(3, "btn btn-black");
		ds.add(4, "btn btn-info");
		ds.add(5, "btn btn-warning");
		ds.add(6, "btn btn-danger");
		ds.add(7, "btn btn-dark");
		ds.add(8, "btn btn-light");
		return ds;
	}

	@RequestMapping("/Menu")
	public ModelAndView menu(Model model, HttpServletResponse response, HttpServletRequest request,
			HttpSession session) {
		try {
			String path = "user/menu_user";

			LoaiBo lBo = new LoaiBo();
			DienThoaiBo dtBo = new DienThoaiBo();

			ArrayList<DienThoaiBean> dsDT = dtBo.getDienThoai();
			ArrayList<LoaiBean> dsLoai = lBo.getLoai();

			String tim = request.getParameter("timuser");
			String timl = request.getParameter("timl");
			String dangxuat = request.getParameter("dx");
			String mlnut = request.getParameter("mlnut");

			// tìm kiếm
			if (tim != null)
				dsDT = dtBo.getTimKiem2(tim);
			else if (timl != null)
				dsDT = dtBo.getTimKiem2(timl);
			else if (mlnut != null)
				dsDT = dtBo.getTimKiem2(mlnut);

			// đăng xuất
			if (dangxuat != null) {
				session.removeAttribute("gh");
				session.removeAttribute("tbdnkh");
			}

			// gio hang
			String maDT = request.getParameter("ms");
			String tenDT = request.getParameter("ts");
			String maLoai = request.getParameter("ml");
			String anh = request.getParameter("ah");
			String gia = request.getParameter("gia");

			// Xử lý thêm giỏ hàng
			if (maDT != null) {
				GioHangBo gh;
				if (session.getAttribute("gh") == null) {
					gh = new GioHangBo();
					session.setAttribute("gh", gh);
				}
				gh = (GioHangBo) session.getAttribute("gh");
				gh.themGH(maDT, tenDT, maLoai, anh, Long.parseLong(gia), (long) 1);
				session.setAttribute("gh", gh);
			}

			if (dsDT.size() > 0)
				session.setAttribute("tbdt", "tìm thấy " + dsDT.size() + " kết quả.");
			else
				session.setAttribute("tbdt", "không có sản phẩm nào.");

			session.setAttribute("dsMau", getNut());
			session.setAttribute("dsDT", dsDT);
			session.setAttribute("dsLoai", dsLoai);
			return new ModelAndView(path);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping("/GioHang")
	public ModelAndView gioHang(Model model, HttpServletResponse response, HttpServletRequest request,
			HttpSession session) {
		try {
			String path = "user/giohang_user";

			String xoa = request.getParameter("xoa");
			String xoaALL = request.getParameter("xoaALL");
			String them = request.getParameter("them");
			String sl = request.getParameter("sl");

			GioHangBo gh;

			session.removeAttribute("tbGH");

			if (session.getAttribute("gh") != null) {
				gh = (GioHangBo) session.getAttribute("gh");
				if (xoa != null) {
					gh.xoaGH(xoa);
				} else if (them != null) {
					session.setAttribute("tbGH", "cập nhật thành công.");
					gh.capNhatSL(them, Long.parseLong(sl));
				}
				if (xoaALL != null) {
					session.removeAttribute("gh");
					session.removeAttribute("dsGH");
				} else {
					session.setAttribute("gh", gh);
					session.setAttribute("dsGH", gh.dsGH);
				}
			}

			return new ModelAndView(path);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping("/DangNhap")
	public ModelAndView dangNhap(Model model, HttpServletResponse response, HttpServletRequest request,
			HttpSession session) {
		try {
			String path = "user/dangnhap_user";

			KhachHangBo khBo = new KhachHangBo();

			String tenDN = request.getParameter("namekhachhang");
			String pass = request.getParameter("paskhachhang");

			if (tenDN != null && pass != null) {
				if (khBo.dangNhap(tenDN, pass)) {
					session.removeAttribute("tbdnkh2");
					session.setAttribute("tbdnkh", tenDN);
					response.sendRedirect("Menu");
				} else
					session.setAttribute("tbdnkh2", "đăng nhập sai.");
			}

			return new ModelAndView(path);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping("/DangKy")
	public ModelAndView dangKy(Model model, HttpServletResponse response, HttpServletRequest request,
			HttpSession session) {
		try {
			String path = "user/dangky_user";

			String name = request.getParameter("name_user");
			String dc = request.getParameter("dc_user");
			String sdt = request.getParameter("sdt_user");
			String email = request.getParameter("email_user");
			String tk = request.getParameter("tk_user");
			String pass1 = request.getParameter("pass_user1");
			String pass2 = request.getParameter("pass_user2");
			System.out.println(name);

			boolean valid = true;
			String errorString = "";

			String gRecaptchaResponse = request.getParameter("g-recaptcha-response");

			valid = VerifyUtils.verify(gRecaptchaResponse);
			if (!valid) {
				model.addAttribute("error", "Captcha invalid!");
			} else if (name != null || dc != null || sdt != null || email != null || tk != null || pass1 != null
					|| pass2 != null) {
				if (pass1.equals(pass2)) {
					boolean isValid = new KhachHangBo().checkTaiKhoan(tk);
					if (!isValid) {
						boolean dk_tc = new KhachHangBo().dangKy(new KhachhangBean(name, dc, sdt, email, tk, pass1));
						if (dk_tc) {
							session.removeAttribute("tb_Register_User");
							response.sendRedirect("DangNhap");
						} else
							session.setAttribute("tb_Register_User", "Đăng ký thất bại");
					} else
						session.setAttribute("tb_Register_User", "Tài khoản đã tồn tại");
				} else
					session.setAttribute("tb_Register_User", "passwork và Nhập lại Passwork không hớp");
			} else {
				session.setAttribute("tb_Register_User",
						"Bạn hãy nhập đầy đủ thông tin để đủ điều kiện đăng ký tài khoản");
			}

			return new ModelAndView(path);
		} catch (

		Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping("/DatMua")
	public ModelAndView datMua(Model model, HttpServletResponse response, HttpServletRequest request,
			HttpSession session) {
		try {
			String path = "user/datmua_user";

			KhachHangBo khBo = new KhachHangBo();
			LichSuMuaHangBo lsBo = new LichSuMuaHangBo();
			GioHangBo gh = (GioHangBo) session.getAttribute("gh");

			String hvt = request.getParameter("kh_ten");
			String dc = request.getParameter("kh_diachi");
			String sdt = request.getParameter("kh_dienthoai");
			String email = request.getParameter("kh_email");
			String tendn = request.getParameter("kh_cmnd");

			KhachhangBean khBean = new KhachhangBean("Enter Name", "Enter Address", "Enter Phone", "...@gmail.com",
					"Nhập tên đăng nhập", "");

			if (session.getAttribute("tbdnkh") != null) {
				String taiKhoan = (String) session.getAttribute("tbdnkh");
				khBean = khBo.checkTKTT(taiKhoan);
			}

			if (hvt != null && dc != null && sdt != null) {
				lsBo.themLSMH(hvt, tendn, email, gh.tongTien(), gh.tongSachHC(), "Chưa xác nhận.", "");
				session.removeAttribute("gh");
			}

			session.setAttribute("khBean", khBean);
			return new ModelAndView(path);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping("/LichSuMuaHang")
	public ModelAndView LSMH(Model model, HttpServletResponse response, HttpServletRequest request,
			HttpSession session) {
		try {
			String path = "user/lichsumuahang_user";

			String key = request.getParameter("timkey");

			LichSuMuaHangBo lsBo = new LichSuMuaHangBo();

			ArrayList<LichSuMuaHangBean> dsLS = null;

			if (session.getAttribute("tbdnkh") != null) {
				String tk = (String) session.getAttribute("tbdnkh");

				if (key != null)
					dsLS = lsBo.timkiemls(Long.parseLong(key), tk);
				else
					dsLS = lsBo.timLSMH(tk);
			}

			session.setAttribute("dsLS", dsLS);
			return new ModelAndView(path);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping("/ChiTietLichSuMuaHang")
	public ModelAndView xemChiTietLSMH(Model model, HttpServletResponse response, HttpServletRequest request,
			HttpSession session) {
		try {
			String path = "user/ctls_user";

			LichSuMuaHangBo lsBo = new LichSuMuaHangBo();

			String ma = request.getParameter("ctls");
			LichSuMuaHangBean lsBean = lsBo.getChiTietLS(Integer.parseInt(ma));

			session.setAttribute("ctLS", lsBean);
			return new ModelAndView(path);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping("/ThongTinKH")
	public ModelAndView TTKhachHang(Model model, HttpServletResponse response, HttpServletRequest request,
			HttpSession session) {
		try {
			String path = "user/ttkhachhang_user";

			KhachHangBo khBo = new KhachHangBo();

			String maKH = request.getParameter("kh_ma");
			String tenKH = request.getParameter("kh_ten");
			String diaChi = request.getParameter("kh_sdt");
			String sdt = request.getParameter("kh_dc");
			String email = request.getParameter("kh_email");
			String tenDN = request.getParameter("kh_tdn");

			KhachhangBean khBean = null;

			if (maKH != null || tenKH != null || diaChi != null || sdt != null || tenDN != null) {
				khBo.themKH(Long.parseLong(maKH), tenKH, diaChi, sdt, email, tenDN);
				session.setAttribute("tBTDKH", "Cập Nhật thông tin thành công");
			} else
				session.setAttribute("tBTDKH", "Cập Nhật thông tin thành công");

			if (session.getAttribute("tbdnkh") != null) {
				String taiKhoan = (String) session.getAttribute("tbdnkh");
				khBean = khBo.checkTKTT(taiKhoan);
			}

			session.setAttribute("khBean", khBean);
			return new ModelAndView(path);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping("/ChiTietDT")
	public ModelAndView chiTietDT(Model model, HttpServletResponse response, HttpServletRequest request,
			HttpSession session) {
		try {
			String path = "user/chitietdienthoai_user";

			DienThoaiBo dtBo = new DienThoaiBo();
			ThongSoDTBo tsBo = new ThongSoDTBo();

			// mua
			String maDT = request.getParameter("ms");
			String tenDT = request.getParameter("ts");
			String maLoai = request.getParameter("ml");
			String anh = request.getParameter("ah");
			String gia = request.getParameter("gia");

			if (maDT != null) {
				GioHangBo gh;
				if (session.getAttribute("gh") == null) {
					gh = new GioHangBo();
					session.setAttribute("gh", gh);
				}
				gh = (GioHangBo) session.getAttribute("gh");
				gh.themGH(maDT, tenDT, maLoai, anh, Long.parseLong(gia), (long) 1);
				session.setAttribute("gh", gh);
			}else {
				String maDTT = request.getParameter("maDTT");
				session.setAttribute("maDTT", maDTT);
			}
			
			String maDT1 = (String) session.getAttribute("maDTT");

			DienThoaiBean dtBean = dtBo.getDTBean(Integer.parseInt(maDT1));
			ThongSoDTBean tsBean = tsBo.getTSMaDT(dtBean.getMaDT());

			session.setAttribute("dtBean", dtBean);
			session.setAttribute("tsBean", tsBean);
			return new ModelAndView(path);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
