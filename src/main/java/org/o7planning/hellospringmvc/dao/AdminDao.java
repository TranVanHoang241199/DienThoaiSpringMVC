package org.o7planning.hellospringmvc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.o7planning.hellospringmvc.bean.AdminBean;

public class AdminDao {

	public ArrayList<AdminBean> getAdmin() throws Exception {
		ArrayList<AdminBean> ds = new ArrayList<AdminBean>();
		KN_SQL dc = new KN_SQL();
		dc.ketNoi();

		String sql = "SELECT * FROM dbo.adminn";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			String tenDN = rs.getString("TenDangNhap");
			String matKhau = rs.getString("MatKhau");
			Boolean quyen = rs.getBoolean("Quyen");
			ds.add(new AdminBean(tenDN, matKhau, quyen));
		}
		dc.cn.close();
		return ds;
	}

	public boolean DangNhap(String user, String pass) throws Exception {
		boolean kt = false;
		KN_SQL dc = new KN_SQL();
		dc.ketNoi();

		String sql = "SELECT * FROM dbo.adminn WHERE TenDangNhap = ? AND MatKhau = ?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, user);
		cmd.setString(2, pass);
		ResultSet rs = cmd.executeQuery();
		if (rs.next())
			kt = true;

		dc.cn.close();
		return kt;
	}

}
