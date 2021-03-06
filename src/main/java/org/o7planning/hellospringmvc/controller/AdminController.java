package org.o7planning.hellospringmvc.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.o7planning.hellospringmvc.bean.DienThoaiBean;
import org.o7planning.hellospringmvc.bean.KhachhangBean;
import org.o7planning.hellospringmvc.bean.LichSuMuaHangBean;
import org.o7planning.hellospringmvc.bean.LoaiBean;
import org.o7planning.hellospringmvc.bean.ThongSoDTBean;
import org.o7planning.hellospringmvc.bo.AdminBo;
import org.o7planning.hellospringmvc.bo.DienThoaiBo;
import org.o7planning.hellospringmvc.bo.KhachHangBo;
import org.o7planning.hellospringmvc.bo.LichSuMuaHangBo;
import org.o7planning.hellospringmvc.bo.LoaiBo;
import org.o7planning.hellospringmvc.bo.ThongSoDTBo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
	private static final String UPLOAD_DIRECTORY = "resources/img";
	private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3; // 3MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

	@RequestMapping("/DangNhapAdmin")
	public ModelAndView DangNhap(Model model, HttpServletResponse response, HttpServletRequest request,
			HttpSession session) {
		try {
			String path = "admin/dangnhap_admin";

			AdminBo aBo = new AdminBo();

			String user = request.getParameter("user_admin");
			String pass = request.getParameter("password_admin");

			if (session.getAttribute("adminUser") != null)
				session.removeAttribute("adminUser");
			if (user != null)
				if (aBo.dangNhap(user, pass)) {
					session.setAttribute("adminUser", user);
					response.sendRedirect("MenuAdmin");
				} else {
					session.setAttribute("adminUser", "????ng nh???p th???t b???i.");
				}

			return new ModelAndView(path);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping("/MenuAdmin")
	public ModelAndView menu(Model model, HttpServletResponse response, HttpServletRequest request,
			HttpSession session) {
		try {
			LoaiBo lBo = new LoaiBo();
			DienThoaiBo dtBo = new DienThoaiBo();
			ThongSoDTBo tsBo = new ThongSoDTBo();

			ArrayList<LoaiBean> dsLoai = lBo.getLoai();
			ArrayList<DienThoaiBean> dsdt = dtBo.getDienThoai();

			if (!dsLoai.isEmpty())
				session.setAttribute("tbLoai", "C??c s???n ph???m.");
			else
				session.setAttribute("tbLoai", "kh??ng c?? s???n ph???m n??o.");

			String timkiem = request.getParameter("timadmin");
			String mladm = request.getParameter("mladm");
			String xoadt = request.getParameter("xoadt");

			if (timkiem != null)
				dsdt = dtBo.getTimKiem2(timkiem);
			else if (mladm != null)
				dsdt = dtBo.getTimKiem2(mladm);
			if (xoadt != null) {
				tsBo.deleteTSKT(Integer.parseInt(xoadt));
				dtBo.xoadt(Integer.parseInt(xoadt));
			}

			dsdt = dtBo.getDienThoai();
			session.setAttribute("dsDT", dsdt);
			session.setAttribute("dsLoaim", dsLoai);
			String path = "admin/menu_admin";
			return new ModelAndView(path);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping("/LoaiAdmin")
	public ModelAndView loaiSanPham(Model model, HttpServletResponse response, HttpServletRequest request,
			HttpSession session) {
		try {

			if (session.getAttribute("tttl") != null)
				session.removeAttribute("tttl");

			String path = "admin/loai_admin";
			LoaiBo lBo = new LoaiBo();

			ArrayList<LoaiBean> dsLoai = lBo.getLoai();

			if (!dsLoai.isEmpty())
				session.setAttribute("tbLoai", "C??c s???n ph???m.");
			else
				session.setAttribute("tbLoai", "kh??ng c?? s???n ph???m n??o.");

			// sua

			String thaydoiloai = request.getParameter("taydoiLoai");
			String suaLoai = request.getParameter("sualoai");
			String xoaLoai = request.getParameter("xoaloai");
			String maLoai = request.getParameter("namema");
			String tenLoai = request.getParameter("nameloai");

			if (maLoai != null && tenLoai != null) {
				lBo.themLoai(maLoai, tenLoai);
				session.setAttribute("tttl", "Th??m Th??nh C??ng!");
			} else if (suaLoai != null) {
				lBo.suaLoai(suaLoai, thaydoiloai);
				session.setAttribute("tttl", "S???a Th??nh C??ng");
			} else if (xoaLoai != null) {
				lBo.xoaLoai(xoaLoai);
				session.setAttribute("tttl", "X??a Th??nh C??ng");
			} else
				session.setAttribute("tttl", "Thao t??c t???t B???i");

			dsLoai = lBo.getLoai();
			session.setAttribute("dsLoai", dsLoai);
			return new ModelAndView(path);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping("/AddThoaiAdmin")
	public ModelAndView dienThoai(Model model, HttpServletResponse response, HttpServletRequest request,
			HttpSession session) {
		try {

			DienThoaiBo dtBo = new DienThoaiBo();
			LoaiBo loaiBo = new LoaiBo();
			ThongSoDTBo tsBo = new ThongSoDTBo();

			List<LoaiBean> loaiList = loaiBo.getLoai();
			session.setAttribute("loaiList", loaiList);

			ArrayList<DienThoaiBean> dsDT = dtBo.getDienThoai();

			String xoadt = request.getParameter("xoadt");

			if (xoadt != null) {
				tsBo.deleteTSKT(Integer.parseInt(xoadt));
				dtBo.xoadt(Integer.parseInt(xoadt));
			}

			dsDT = dtBo.getDienThoai();
			session.setAttribute("dsDT", dsDT);
			String path = "admin/dthoai_admin";
			if (!dsDT.isEmpty())
				session.setAttribute("tbDT", "T??m th???y " + dsDT.size() + " k???t qu???");
			else
				session.setAttribute("tbDT", "kh??ng c?? s???n ph???m n??o.");
			return new ModelAndView(path);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping("/addPhone")
	public ModelAndView AddHost(Model model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		DienThoaiBo dienThoaiBo = new DienThoaiBo();
		String tendt = "";
		String giadt = "";
		String soluongdt = "";
		String mldt = "";
		String img = "";

		if (!ServletFileUpload.isMultipartContent(request)) { //
			request.setAttribute("resultadd", (long) 0);
			return new ModelAndView("redirect:/AddThoaiAdmin");
		}

		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(MEMORY_THRESHOLD);
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setFileSizeMax(MAX_FILE_SIZE);
		upload.setSizeMax(MAX_REQUEST_SIZE);

		String uploadPath = request.getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;

		File uploadDir = new File(uploadPath);
		System.out.println(uploadDir);

		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		try {
			List<FileItem> fileItems = upload.parseRequest(request); // l???y v??? c??c ?????i t?????ng g???i l??n
			int s = fileItems.size();
			if (fileItems != null && fileItems.size() > 0) {
				int i = 0;
				for (FileItem item : fileItems) { // duy???t c??c ?????i t?????ng g???m file v?? c??c control
					if (!item.isFormField()) { // n???u k ph???i control => upfile l??n

						String fileName = item.getName(); // get t??n file vd: anh1.png
						String filePath = uploadPath + File.separator + fileName; // get ???????ng d???n file
						File storeFile = new File(filePath); // t???o file
						item.write(storeFile); // l??u file

						img = fileName;
					} else {
						String getitem = item.getFieldName();

						if (getitem.equals("tendt")) {
							tendt = item.getString();
						}
						if (getitem.equals("giadt")) {
							giadt = item.getString();
						}
						if (getitem.equals("soluongdt")) {
							soluongdt = item.getString();
						}
						if (getitem.equals("mldt")) {
							mldt = item.getString();
						}
					}
				}

			}
			DienThoaiBean dtbean = new DienThoaiBean(tendt, Long.parseLong(giadt), img, Long.parseLong(soluongdt),
					mldt);

			int rs = dienThoaiBo.AddPhone(dtbean);

			if (rs > 0) {
				return new ModelAndView("redirect:/AddThoaiAdmin");
			} else {
				return new ModelAndView("redirect:/AddThoaiAdmin");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ModelAndView("redirect:/AddThoaiAdmin");
	}

	@RequestMapping("/editDienThoai")
	public ModelAndView editDienThoai(Model model, HttpServletResponse response, HttpServletRequest request,
			HttpSession session) {
		try {
			String path = "admin/editdienthoai_admin";

			DienThoaiBo dtBo = new DienThoaiBo();

			String maSP = request.getParameter("maSP");

			String tenDT = request.getParameter("tendt");
			String gia = request.getParameter("gia");
			String soLuong = request.getParameter("soLuong");
			String maLoai = request.getParameter("mldt");
			String img = request.getParameter("txtfile");
			
			session.removeAttribute("tB");

			if (tenDT != null || gia != null || soLuong != null || maLoai != null || img != null) {
				boolean kt = dtBo.editPhome(Integer.parseInt(maSP), tenDT, Long.parseLong(gia), img, Long.parseLong(soLuong),
						maLoai);
				if(kt)
					session.setAttribute("tB", "C???p nh???t th??nh c??ng.");
			}

			DienThoaiBean dtBean = dtBo.getDTBean(Integer.parseInt(maSP));

			session.setAttribute("dtBean", dtBean);
			return new ModelAndView(path);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@RequestMapping("/dangXuatadmin")
	public ModelAndView DangXuat(Model model, HttpServletResponse response, HttpServletRequest request,
			HttpSession session) {
		try {
			response.sendRedirect("Menu");
			return new ModelAndView("helloworld");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	@RequestMapping("/TTKhachHang")
	public ModelAndView TTKhachHang(Model model, HttpServletResponse response, HttpServletRequest request,
			HttpSession session) {
		try {
			String path = "admin/ttkhachhang_admin";

			KhachHangBo khBo = new KhachHangBo();
			ArrayList<KhachhangBean> dsKH = khBo.getKhachHang();

			String xoaKH = request.getParameter("xoaKH");
			String timkiem = request.getParameter("timkey");

			if (xoaKH != null) {
				khBo.xoaKhachHang(xoaKH);
				session.setAttribute("tbKH", "X??a Th??nh C??ng");
				dsKH = khBo.getKhachHang();
			} else
				session.setAttribute("tbKH", "Thao t??c t???t B???i");

			if (timkiem != null)
				dsKH = khBo.timKhachHang(timkiem);

			session.setAttribute("dsKH", dsKH);
			return new ModelAndView(path);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping("/lichSuAdmin")
	public ModelAndView lichSuAdmin(Model model, HttpServletResponse response, HttpServletRequest request,
			HttpSession session) {
		try {
			String path = "admin/lichsu_admin";

			LichSuMuaHangBo lsBo = new LichSuMuaHangBo();

			ArrayList<LichSuMuaHangBean> dsLS = lsBo.getLSMH();

			String timkey = request.getParameter("timkey");
			if (timkey != null)
				dsLS = lsBo.timkiemMa(Long.parseLong(timkey));

			session.setAttribute("dsLS", dsLS);
			return new ModelAndView(path);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping("/thongSoDT")
	public ModelAndView thongSoDT(Model model, HttpServletResponse response, HttpServletRequest request,
			HttpSession session) {
		try {
			String path = "admin/thongsodt_admin";

			ThongSoDTBo tsBo = new ThongSoDTBo();

			ThongSoDTBean tsBean = null;

			String msdt = request.getParameter("msdt");
			String mangHinh = request.getParameter("DT_mangHinh");
			String cameraSau = request.getParameter("DT_CSau");
			String cameraTruoc = request.getParameter("DT_CTruoc");
			String cpu = request.getParameter("DT_Cpu");
			String heDieuHanh = request.getParameter("DT_HDH");
			String boNhoRam = request.getParameter("DT_Ram");
			String pin = request.getParameter("DT_Pin");
			String ketNoi = request.getParameter("DT_KN");

			if (session.getAttribute("tbtcs") != null)
				session.removeAttribute("tbtcs");

			if (msdt != null) {
				if (mangHinh != null) {
					tsBo.CapNhatThongSo(mangHinh, cameraSau, cameraTruoc, cpu, heDieuHanh, boNhoRam,
							Long.parseLong(pin), ketNoi, Integer.parseInt(msdt));
					session.setAttribute("tbtcs", "Th??nh c??ng");
				}
				tsBean = tsBo.getTSMaDT(Integer.parseInt(msdt));
			}

			session.setAttribute("tbTS", Integer.parseInt(msdt));
			session.setAttribute("tsBean", tsBean);
			return new ModelAndView(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	@RequestMapping("/ChiTietLichSuMuaHangAdmin")
	public ModelAndView xemChiTietLSMH(Model model, HttpServletResponse response, HttpServletRequest request,
			HttpSession session) {
		try {
			String path = "admin/ctls_admin";

			LichSuMuaHangBo lsBo = new LichSuMuaHangBo();

			LichSuMuaHangBean lsBean;

			String ma = request.getParameter("ctls");
			String trangThai = request.getParameter("status");

			session.removeAttribute("tbctls");

			int rs = lsBo.suaLSTT(Integer.parseInt(ma), trangThai);

			if (rs != 0)
				session.setAttribute("tbctls", "x??c nh???n ????n h??ng th??nh c??ng.");

			lsBean = lsBo.getChiTietLS(Integer.parseInt(ma));
			session.setAttribute("ctLSs", lsBean);
			return new ModelAndView(path);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
