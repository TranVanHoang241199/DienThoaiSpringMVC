package org.o7planning.hellospringmvc.bo;

import java.util.ArrayList;

import org.o7planning.hellospringmvc.bean.KhachhangBean;
import org.o7planning.hellospringmvc.dao.KhachHangDao;

public class KhachHangBo {
	KhachHangDao khDao = new KhachHangDao();

	public ArrayList<KhachhangBean> getKhachHang() throws Exception {
		return khDao.getKhachHang();
	}

	public boolean dangNhap(String tenDN, String pass) throws Exception {
		boolean kt = false;
		for (KhachhangBean i : getKhachHang()) {
			if (i.getTenDN().equals(tenDN.trim()) && i.getPass().equals(pass.trim()))
				kt = true;
		}
		return kt;
	}

	public boolean checkTaiKhoan(String taiKhoan) throws Exception {
		return khDao.checkTaiKhoan(taiKhoan);
	}

	public boolean dangKy(KhachhangBean kh) throws Exception {
		return khDao.dangKy(kh);
	}

	public boolean xoaKhachHang(String maKH) throws Exception {
		return khDao.xoaKhachHang(maKH);
	}

	public ArrayList<KhachhangBean> timKhachHang(String key) throws Exception {
		ArrayList<KhachhangBean> ds = new ArrayList<KhachhangBean>();
		
		for (KhachhangBean k : getKhachHang()) {
			if(k.getTenDN().toUpperCase().contains(key.toUpperCase().trim())||k.getTenKH().toUpperCase().contains(key.toUpperCase().trim()))
				ds.add(k);
		}
		return ds;
	}

	public KhachhangBean checkTKTT(String taiKhoan) throws Exception {
		return khDao.checkTKTT(taiKhoan);
	}
}
