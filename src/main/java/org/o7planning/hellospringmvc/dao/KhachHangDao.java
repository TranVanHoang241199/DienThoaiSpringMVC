package org.o7planning.hellospringmvc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.o7planning.hellospringmvc.bean.KhachhangBean;

public class KhachHangDao {
	public ArrayList<KhachhangBean> getKhachHang() throws Exception {
		ArrayList<KhachhangBean> ds = new ArrayList<KhachhangBean>();

		KN_SQL dc = new KN_SQL();
		dc.ketNoi();

		String sql = "SELECT * FROM KhachHang";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			long maKH = rs.getLong("MaKH");
			String tenKH = rs.getString("TenKH");
			String diaChi = rs.getString("DiaChi");
			String sdt = rs.getString("SDT");
			String email = rs.getString("Email");
			String tenDN = rs.getString("TenDN");
			String pass = rs.getString("PassDN");
			ds.add(new KhachhangBean(maKH, tenKH, diaChi, sdt, email, tenDN, pass));
		}

		dc.cn.close();
		return ds;
	}

	public boolean checkTaiKhoan(String taiKhoan) throws Exception {
		boolean isValid = false;
		// B1: Kết nối
		KN_SQL dc = new KN_SQL();
		dc.ketNoi();

		// B2: lấy dữ liệu
		String sql = "SELECT * FROM KhachHang WHERE TenDN=?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, taiKhoan);
		ResultSet rs = cmd.executeQuery();
		if (rs.next())
			isValid = true;
		dc.cn.close();
		return isValid;
	}

	public boolean dangKy(KhachhangBean kh) throws Exception {
		boolean isValid = false;
		// B1: ket noi
		KN_SQL dc = new KN_SQL();
		dc.ketNoi();

		// B2: lay du lieu
		String sql = "INSERT INTO dbo.KhachHang (TenKH, DiaChi, SDT, Email, TenDN, PassDN) VALUES(?, ?, ?, ?, ?, ?)";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, kh.getTenKH());
		cmd.setString(2, kh.getDiaChi());
		cmd.setString(3, kh.getSdt());
		cmd.setString(4, kh.getEmail());
		cmd.setString(5, kh.getTenDN());
		cmd.setString(6, kh.getPass());

		if (cmd.executeUpdate() == 1)
			isValid = true;

		return isValid;
	}

	public boolean xoaKhachHang(String maKH) throws Exception {
		boolean kt = false;
		KN_SQL dc = new KN_SQL();
		dc.ketNoi();

		String sql = "DELETE FROM dbo.KhachHang WHERE MaKH=?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, maKH);

		if (cmd.executeUpdate() != 0)
			kt = true;
		dc.cn.close();
		return kt;
	}

	public KhachhangBean checkTKTT(String taiKhoan) throws Exception {
		KhachhangBean kh = null;
		// B1: Kết nối
		KN_SQL dc = new KN_SQL();
		dc.ketNoi();

		// B2: lấy dữ liệu
		String sql = "SELECT * FROM KhachHang WHERE TenDN=?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, taiKhoan);
		ResultSet rs = cmd.executeQuery();
		if (rs.next()) {
			long maKH = rs.getLong("MaKH");
			String tenKH = rs.getString("TenKH");
			String diaChi = rs.getString("DiaChi");
			String sdt = rs.getString("SDT");
			String email = rs.getString("Email");
			String tenDN = rs.getString("TenDN");
			String pass = rs.getString("PassDN");
			kh = new KhachhangBean(maKH, tenKH, diaChi, sdt, email, tenDN, pass);
		}
		dc.cn.close();
		return kh;
	}

	public boolean themKH(long maKH, String tenKH, String diaChi, String sdt, String email, String tenDN)
			throws Exception {
		boolean kt = false;
		// B1: Kết nối
		KN_SQL dc = new KN_SQL();
		dc.ketNoi();

		// B2: lấy dữ liệu
		String sql = "UPDATE dbo.KhachHang SET TenKH=?, DiaChi=?, SDT=?, Email=?, TenDN=? WHERE MaKH=?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);

		cmd.setString(1, tenKH);
		cmd.setString(2, diaChi);
		cmd.setString(3, sdt);
		cmd.setString(4, email);
		cmd.setString(5, tenDN);
		cmd.setLong(6, maKH);

		if (cmd.executeUpdate() != 0) {
			kt = true;
		}
		dc.cn.close();
		return kt;
	}
}