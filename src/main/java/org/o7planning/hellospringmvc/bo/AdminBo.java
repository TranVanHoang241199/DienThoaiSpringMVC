package org.o7planning.hellospringmvc.bo;

import org.o7planning.hellospringmvc.dao.AdminDao;

public class AdminBo {
	AdminDao aDao = new AdminDao();

	public boolean DangNhap(String user, String pass) throws Exception {
		return aDao.DangNhap(user, pass);
	}
}
