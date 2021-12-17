package org.o7planning.hellospringmvc.bo;

import java.util.ArrayList;

import org.o7planning.hellospringmvc.bean.LichSuMuaHangBean;
import org.o7planning.hellospringmvc.dao.LichSuMuaHangDao;

public class LichSuMuaHangBo {
	LichSuMuaHangDao lsDao = new LichSuMuaHangDao();

	public ArrayList<LichSuMuaHangBean> getLSMH() throws Exception {
		return lsDao.getLSMH();
	}

	public boolean themLSMH(String tenKH, String tenDN, String Email, long gia, long soLuong, String trangThai,
			String ghiChu) throws Exception {
		return lsDao.themLSMH(tenKH, tenDN, Email, gia, soLuong, trangThai, ghiChu);
	}

	public ArrayList<LichSuMuaHangBean> timLSMH(String user) throws Exception {
		return lsDao.timLSMH(user);
	}

	public ArrayList<LichSuMuaHangBean> timkiemls(long maLS, String user) throws Exception {
		return lsDao.timkiemls(maLS, user);
	}
	
	public ArrayList<LichSuMuaHangBean> timkiemMa(long maLS) throws Exception {
		return lsDao.timkiemMa(maLS);
	}
}
