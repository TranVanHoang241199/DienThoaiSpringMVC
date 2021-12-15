package org.o7planning.hellospringmvc.bo;

import java.util.ArrayList;

import org.o7planning.hellospringmvc.bean.LoaiBean;
import org.o7planning.hellospringmvc.dao.LoaiDao;

public class LoaiBo {
	LoaiDao lDao = new LoaiDao();
	
	public ArrayList<LoaiBean> getLoai() throws Exception{
		return lDao.getLoai();
	}
	
	public boolean themLoai(String maLoai, String tenLoai) throws Exception {
		return lDao.themLoai(maLoai, tenLoai);
	}
	
	public boolean suaLoai(String maLoai, String tenLoai) throws Exception {
		return lDao.suaLoai(maLoai, tenLoai);
	}
	
	public boolean xoaLoai(String maLoai) throws Exception {
		return lDao.xoaLoai(maLoai);
	}
}
