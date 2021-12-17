package org.o7planning.hellospringmvc.bo;

import java.util.ArrayList;

import org.o7planning.hellospringmvc.bean.GioHangBean;

public class GioHangBo {
	
	public ArrayList<GioHangBean> dsGH = new ArrayList<GioHangBean>();

	public void themGH(String maDT, String tenDT, String tacGia, String anh, long gia, long slMua) {
		for (GioHangBean ghBean : dsGH) {
			if (ghBean.getMaDT().equals(maDT)) {
				ghBean.setSlMua(ghBean.getSlMua() + slMua);
				return;
			}
		}
		dsGH.add(new GioHangBean(maDT, tenDT, tacGia, anh, gia, slMua));
	}

	public void xoaGH(String maDT) {
		for (GioHangBean ghBean : dsGH) {
			if (ghBean.getMaDT().equals(maDT)) {
				dsGH.remove(ghBean);
				return;
			}
		}
	}

	public void capNhatSL(String maDT, long slMua) {
		for (GioHangBean ghBean : dsGH) {
			if (ghBean.getMaDT().equals(maDT)) {
				ghBean.setSlMua(slMua);
				return;
			}
		}
	}

	public long tongTien() {
		long t = 0;
		for (GioHangBean ghBean : dsGH) {
			t += ghBean.getThanhTien();
		}
		return t;
	}

	public long tongSachHC() {
		long t = 0;
		for (GioHangBean ghBean : dsGH) {
			t += ghBean.getSlMua();
		}
		return t;
	}
}
