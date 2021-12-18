package org.o7planning.hellospringmvc.bo;

import java.util.ArrayList;

import org.o7planning.hellospringmvc.bean.AdminBean;
import org.o7planning.hellospringmvc.dao.AdminDao;

public class AdminBo {
	AdminDao aDao = new AdminDao();

	public ArrayList<AdminBean> getAdmin() throws Exception {
		return aDao.getAdmin();
	}

	public boolean dangNhap(String user, String pass) throws Exception {
		for (AdminBean a : getAdmin())
			if (a.getTenDN().equals(user) && a.getMatKhau().equals(pass))
				return true;
		return false;
	}

	public boolean dangNhap2(String user, String pass) throws Exception {
		return aDao.DangNhap(user, pass);
	}
}
