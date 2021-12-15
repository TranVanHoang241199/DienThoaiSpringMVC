package org.o7planning.hellospringmvc.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.o7planning.hellospringmvc.bean.DienThoaiBean;
import org.o7planning.hellospringmvc.bean.LoaiBean;
import org.o7planning.hellospringmvc.bo.DienThoaiBo;
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
			
			session.setAttribute("dsMau", getNut());
			session.setAttribute("dsDT", dsDT);
			session.setAttribute("dsLoai", dsLoai);
			return new ModelAndView(path);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/*
	 * @RequestMapping("/GioHang") public ModelAndView gioHang(Model model,
	 * HttpServletResponse response, HttpServletRequest request, HttpSession
	 * session) { try { String path = "user/giohang_user";
	 * 
	 * return new ModelAndView(path); } catch (Exception e) { e.printStackTrace();
	 * return null; } }
	 */
	
	
}
