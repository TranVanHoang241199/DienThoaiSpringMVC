package org.o7planning.hellospringmvc.controller;

import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.o7planning.hellospringmvc.dao.KN_SQL;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddBookController {
	@RequestMapping("/addbook")
	public ModelAndView addbook(Model model, HttpServletRequest request, HttpSession session,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		DiskFileItemFactory factory = new DiskFileItemFactory();
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
		String dirUrl1 = request.getServletContext().getRealPath("") + File.separator + "files";
		response.getWriter().println(dirUrl1);
		int ml = Integer.parseInt(request.getParameter("ml"));

		try {
			String dirUrlTemp = null;
			java.util.List<FileItem> fileItems = upload.parseRequest(request);
			for (FileItem fileItem : fileItems) {
				if (!fileItem.isFormField()) {
					String nameimg = fileItem.getName();
					if (!nameimg.equals("")) {
						String dirUrl = request.getServletContext().getRealPath("") + File.separator + "files";
						File dir = new File(dirUrl);
						if (!dir.exists()) {
							dir.mkdir();
						}
						String fileImg = dirUrl + File.separator + nameimg;
						File file = new File(fileImg);
						if (file.exists()) {
							file.delete();
						}
						fileItem.write(file);
						try {
							System.out.println("UPLOAD THÀNH CÔNG...!");
							System.out.println("Đường dẫn lưu file là: " + fileImg);
							dirUrlTemp = "files/" + nameimg;
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
			KN_SQL dc = new KN_SQL();
			dc.ketNoi();
			String sql = "update DienThoai set Anh= ? where MaDT=?";
			PreparedStatement cmd = dc.cn.prepareStatement(sql);
			cmd.setString(1, dirUrlTemp);
			cmd.setInt(2, ml);
			cmd.execute();
			dc.cn.close();
			return new ModelAndView("redirect:/AddThoaiAdmin");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("ml", ml);
			return new ModelAndView("admin/UploadPic");
		}
	}
	
	@RequestMapping("/ThemDT")
	public ModelAndView themDT(Model model, HttpServletRequest request, HttpSession session,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		DiskFileItemFactory factory = new DiskFileItemFactory();
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
		String dirUrl1 = request.getServletContext().getRealPath("") + File.separator + "files";
		response.getWriter().println(dirUrl1);
		String tenDT = request.getParameter("tendt");
		String gia = request.getParameter("giadt");
		String soLuong = request.getParameter("soluongdt");
		String maLoai = request.getParameter("mldt");
		try {
			String dirUrlTemp = null;
			java.util.List<FileItem> fileItems = upload.parseRequest(request);
			for (FileItem fileItem : fileItems) {
				if (!fileItem.isFormField()) {
					String nameimg = fileItem.getName();
					if (!nameimg.equals("")) {
						String dirUrl = request.getServletContext().getRealPath("") + File.separator + "files";
						File dir = new File(dirUrl);
						if (!dir.exists()) {
							dir.mkdir();
						}
						String fileImg = dirUrl + File.separator + nameimg;
						File file = new File(fileImg);
						if (file.exists()) {
							file.delete();
						}
						fileItem.write(file);
						try {
							System.out.println("UPLOAD THÀNH CÔNG...!");
							System.out.println("Đường dẫn lưu file là: " + fileImg);
							dirUrlTemp = "files/" + nameimg;
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
			KN_SQL dc = new KN_SQL();
			dc.ketNoi();
			String sql = "INSERT INTO DienThoai(Anh, TenDT, Gia, SoLuong, MaLoai, NgayNhap) VALUES(?, ?, ?, ?, ?, getDate())";
			PreparedStatement cmd = dc.cn.prepareStatement(sql);
			cmd.setString(1, dirUrlTemp);
			cmd.setString(2, tenDT);
			cmd.setLong(3, Long.parseLong(gia));
			cmd.setLong(4, Long.parseLong(soLuong));
			cmd.setString(5, maLoai);
			cmd.execute();
			dc.cn.close();
			
			response.sendRedirect("AddThoaiAdmin");
			return new ModelAndView("redirect:/dthoai_admin");
		} catch (Exception e) {
			System.out.println("Lỗi");
			e.printStackTrace();
			return new ModelAndView("admin/AddThoaiAdmin");
		}
	}
	

}
