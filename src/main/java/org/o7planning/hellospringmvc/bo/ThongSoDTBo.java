package org.o7planning.hellospringmvc.bo;

import java.util.ArrayList;

import org.o7planning.hellospringmvc.bean.ThongSoDTBean;
import org.o7planning.hellospringmvc.dao.ThongSoDTDao;

public class ThongSoDTBo {
	ThongSoDTDao tsDao = new ThongSoDTDao();

	public ArrayList<ThongSoDTBean> getThongSo() throws Exception {
		return tsDao.getThongSo();
	}

	public ThongSoDTBean getTSMaDT(int maDT) throws Exception {
		return tsDao.getTSMaDT(maDT);
	}

	public boolean themThongSo(String mangHinh, String cameraSau, String cameraTruoc, String cpu, String heDieuHanh,
			String boNhoRam, String pin, String ketNoi, int maDT) throws Exception {
		return tsDao.themThongSo(mangHinh, cameraSau, cameraTruoc, cpu, heDieuHanh, boNhoRam, pin, ketNoi, maDT);
	}
	
	public boolean CapNhatThongSo(String mangHinh, String cameraSau, String cameraTruoc, String cpu, String heDieuHanh,
			String boNhoRam, long pin, String ketNoi, int maDT) throws Exception {
		return tsDao.CapNhatThongSo(mangHinh, cameraSau, cameraTruoc, cpu, heDieuHanh, boNhoRam, pin, ketNoi, maDT);
	}
	
	public boolean checkTSKT(int maDT) throws Exception {
		return tsDao.checkTSKT(maDT);
	}
}
