package org.o7planning.hellospringmvc.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.o7planning.hellospringmvc.bean.DienThoaiBean;
import org.o7planning.hellospringmvc.bean.KhachhangBean;
import org.o7planning.hellospringmvc.bean.LichSuMuaHangBean;
import org.o7planning.hellospringmvc.bean.LoaiBean;
import org.o7planning.hellospringmvc.bo.DienThoaiBo;
import org.o7planning.hellospringmvc.bo.GioHangBo;
import org.o7planning.hellospringmvc.bo.KhachHangBo;
import org.o7planning.hellospringmvc.bo.LichSuMuaHangBo;
import org.o7planning.hellospringmvc.bo.LoaiBo;
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

			// tìm kiếm
			if (tim != null)
				dsDT = dtBo.getTimKiem2(tim);
			else if (timl != null)
				dsDT = dtBo.getTimKiem2(timl);

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

			if (session.getAttribute("gh") != null) {
				gh = (GioHangBo) session.getAttribute("gh");
				if (xoa != null) {
					gh.xoaGH(xoa);
				} else if (them != null)
					gh.capNhatSL(them, Long.parseLong(sl));

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
				khBo.dangNhap(tenDN, pass);
				session.setAttribute("tbdnkh", tenDN);
				path = "user/menu_user";
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

			if (name != null && dc != null && sdt != null && email != null && tk != null && pass1 != null
					&& pass2 != null) {
				if (pass1.equals(pass2)) {
					boolean isValid = new KhachHangBo().checkTaiKhoan(tk);
					if (!isValid) {
						boolean dk_tc = new KhachHangBo().dangKy(new KhachhangBean(name, dc, sdt, email, tk, pass1));
						if (dk_tc) {
							session.setAttribute("tb_Register_User", "Đăng ký thành công");
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
		} catch (Exception e) {
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
			GioHangBo gh = (GioHangBo)session.getAttribute("gh");

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
			
			if (hvt!=null && dc!=null && sdt!=null) {
				lsBo.themLSMH(hvt, tendn,email ,gh.tongTien(), gh.tongSachHC(), "Đã Thanh Toán", "");
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
			
			if(session.getAttribute("tbdnkh")!=null) {
				String tk = (String)session.getAttribute("tbdnkh");
				
				if(key!=null)
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
}
