package org.o7planning.hellospringmvc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDao {

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
