package org.o7planning.hellospringmvc.bo;

import java.sql.Date;
import java.util.ArrayList;

import org.o7planning.hellospringmvc.bean.DienThoaiBean;
import org.o7planning.hellospringmvc.dao.DienThoaiDao;

public class DienThoaiBo {
	DienThoaiDao dtDao = new DienThoaiDao();

	public ArrayList<DienThoaiBean> getDienThoai() throws Exception {
		return dtDao.getDienThoai();
	}
	
	public ArrayList<DienThoaiBean> getTimKiem(String tim) throws Exception {
		return dtDao.getTimKiem(tim);
	}
	
	public ArrayList<DienThoaiBean> getTimKiem2(String key) throws Exception {
		ArrayList<DienThoaiBean> ds = new ArrayList<DienThoaiBean>();
		for (DienThoaiBean d : getDienThoai()) {
			if(d.getTenDT().toUpperCase().trim().contains(key.toUpperCase().trim())||d.getMaLoai().contains(key.trim()))
				ds.add(d);
		}
		return ds;
	}

	public boolean themDienThoai(String maDT, String tenDT, long gia, String anh, String ngayNhap, long soLuong,
			String maLoai, int sao, String danhGia) throws Exception {
		return dtDao.themDienThoai(maDT, tenDT, gia, anh, ngayNhap, soLuong, maLoai, sao, danhGia);
	}

	public boolean themDienThoai2(String tenDT, long gia, String anh, Long soLuong, String maLoai) throws Exception {
		return dtDao.themDienThoai2(tenDT, gia, anh, soLuong, maLoai);
	}

	public boolean xoadt(int maDT) throws Exception {
		return dtDao.xoadt(maDT);
	}
}
