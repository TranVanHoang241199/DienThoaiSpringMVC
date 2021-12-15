package org.o7planning.hellospringmvc.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.o7planning.hellospringmvc.bean.DienThoaiBean;
import org.o7planning.hellospringmvc.bean.LoaiBean;
import org.o7planning.hellospringmvc.bo.AdminBo;
import org.o7planning.hellospringmvc.bo.DienThoaiBo;
import org.o7planning.hellospringmvc.bo.LoaiBo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
	@RequestMapping("/DangNhapAdmin")
	public ModelAndView DangNhap(Model model, HttpServletResponse response, HttpServletRequest request,
			HttpSession session) {
		try {
			String path = "admin/dangnhap_admin";

			AdminBo aBo = new AdminBo();

			String user = request.getParameter("user_admin");
			String pass = request.getParameter("password_admin");

			if (session.getAttribute("adminUser") != null)
				session.invalidate();

			if (aBo.DangNhap(user, pass)) {
				session.setAttribute("adminUser", user);
				response.sendRedirect("MenuAdmin");
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

			ArrayList<LoaiBean> dsLoai = lBo.getLoai();
			ArrayList<DienThoaiBean> dsdt = dtBo.getDienThoai();

			if (!dsLoai.isEmpty())
				session.setAttribute("tbLoai", "Các sản phẩm.");
			else
				session.setAttribute("tbLoai", "không có sản phẩm nào.");

			String timkiem = request.getParameter("timadmin");
			String mladm = request.getParameter("mladm");
			String xoadt = request.getParameter("xoadt");

			if (timkiem != null)
				dsdt = dtBo.getTimKiem2(timkiem);
			else if (mladm != null)
				dsdt = dtBo.getTimKiem2(mladm);
			if (xoadt != null)
				dtBo.xoadt(Integer.parseInt(xoadt));

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
				session.setAttribute("tbLoai", "Các sản phẩm.");
			else
				session.setAttribute("tbLoai", "không có sản phẩm nào.");

			// sua

			String thaydoiloai = request.getParameter("taydoiLoai");
			String suaLoai = request.getParameter("sualoai");
			String xoaLoai = request.getParameter("xoaloai");
			String maLoai = request.getParameter("namema");
			String tenLoai = request.getParameter("nameloai");

			if (maLoai != null && tenLoai != null) {
				lBo.themLoai(maLoai, tenLoai);
				session.setAttribute("tttl", "Thêm Thành Công!");
			} else if (suaLoai != null) {
				lBo.suaLoai(suaLoai, thaydoiloai);
				session.setAttribute("tttl", "Sửa Thành Công");
			} else if (xoaLoai != null) {
				lBo.xoaLoai(xoaLoai);
				session.setAttribute("tttl", "Xóa Thành Công");
			} else
				session.setAttribute("tttl", "Thao tác tất Bại");

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

			ArrayList<DienThoaiBean> dsDT = dtBo.getDienThoai();

			String tenDT = request.getParameter("tendt");
			String gia = request.getParameter("giadt");
			String anh = request.getParameter("anhdt");
			String soLuong = request.getParameter("soluongdt");
			String maLoai = request.getParameter("mldt");

			String xoadt = request.getParameter("xoadt");

			if (tenDT != null && maLoai != null) {
				dtBo.themDienThoai2(tenDT, Long.parseLong(gia), anh, Long.parseLong(soLuong), maLoai);
			}

			if (xoadt != null)
				dtBo.xoadt(Integer.parseInt(xoadt));

			dsDT = dtBo.getDienThoai();
			session.setAttribute("dsDT", dsDT);
			String path = "admin/dthoai_admin";
			if (!dsDT.isEmpty())
				session.setAttribute("tbDT", "Tìm thấy " + dsDT.size() + "kết quả");
			else
				session.setAttribute("tbDT", "không có sản phẩm nào.");
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

}
