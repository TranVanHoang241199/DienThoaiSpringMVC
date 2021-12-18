package org.o7planning.hellospringmvc.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.o7planning.hellospringmvc.bean.LichSuMuaHangBean;

public class LichSuMuaHangDao {
	public ArrayList<LichSuMuaHangBean> getLSMH() throws Exception {
		ArrayList<LichSuMuaHangBean> ds = new ArrayList<LichSuMuaHangBean>();
		KN_SQL dc = new KN_SQL();
		dc.ketNoi();

		String sql = "SELECT * FROM dbo.LichSuMuaHang";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();

		while (rs.next()) {
			long maLSMH = rs.getLong("MaLSMH");
			String tenKH = rs.getString("TenKH");
			String tenDN = rs.getString("TenDN");
			String email = rs.getString("Email");
			long gia = rs.getLong("Gia");
			Date ngayMua = rs.getDate("NgayMua");
			long soLuong = rs.getLong("SoLuong");
			String trangThai = rs.getString("TrangThai");
			String ghiChu = rs.getString("GhiChu");
			ds.add(new LichSuMuaHangBean(maLSMH, tenKH, tenDN, email, gia, ngayMua, soLuong, trangThai, ghiChu));
		}

		dc.cn.close();
		return ds;
	}

	public boolean themLSMH(String tenKH, String tenDN, String Email, long gia, long soLuong, String trangThai,
			String ghiChu) throws Exception {
		boolean kt = false;
		KN_SQL dc = new KN_SQL();
		dc.ketNoi();
		String sql = "INSERT INTO dbo.LichSuMuaHang (TenDN, Gia, NgayMua, SoLuong, TrangThai, GhiChu, tenKH, Email)\r\n"
				+ "VALUES	(?, ?, getDate(), ?, ?, ?, ?, ?)";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, tenDN);
		cmd.setLong(2, gia);
		cmd.setLong(3, soLuong);
		cmd.setString(4, trangThai);
		cmd.setString(5, ghiChu);
		cmd.setString(6, tenKH);
		cmd.setString(7, Email);

		if (cmd.executeUpdate() != 0)
			kt = true;
		dc.cn.close();
		return kt;
	}

	public ArrayList<LichSuMuaHangBean> timLSMH(String user) throws Exception {
		ArrayList<LichSuMuaHangBean> ds = new ArrayList<LichSuMuaHangBean>();
		KN_SQL dc = new KN_SQL();
		dc.ketNoi();

		String sql = "SELECT * FROM dbo.LichSuMuaHang WHERE TenDN = ?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, user);
		ResultSet rs = cmd.executeQuery();

		while (rs.next()) {
			long maLSMH = rs.getLong("MaLSMH");
			String tenKH = rs.getString("TenKH");
			String tenDN = rs.getString("TenDN");
			String email = rs.getString("Email");
			long gia = rs.getLong("Gia");
			Date ngayMua = rs.getDate("NgayMua");
			long soLuong = rs.getLong("SoLuong");
			String trangThai = rs.getString("TrangThai");
			String ghiChu = rs.getString("GhiChu");
			ds.add(new LichSuMuaHangBean(maLSMH, tenKH, tenDN, email, gia, ngayMua, soLuong, trangThai, ghiChu));
		}

		dc.cn.close();
		return ds;
	}

	public ArrayList<LichSuMuaHangBean> timkiemls(long maLS, String user) throws Exception {
		ArrayList<LichSuMuaHangBean> ds = new ArrayList<LichSuMuaHangBean>();
		KN_SQL dc = new KN_SQL();
		dc.ketNoi();

		String sql = "SELECT * FROM dbo.LichSuMuaHang WHERE MaLSMH = ? and TenDN = ?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setLong(1, maLS);
		cmd.setString(2, user);
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			long maLSMH = rs.getLong("MaLSMH");
			String tenKH = rs.getString("TenKH");
			String tenDN = rs.getString("TenDN");
			String email = rs.getString("Email");
			long gia = rs.getLong("Gia");
			Date ngayMua = rs.getDate("NgayMua");
			long soLuong = rs.getLong("SoLuong");
			String trangThai = rs.getString("TrangThai");
			String ghiChu = rs.getString("GhiChu");
			ds.add(new LichSuMuaHangBean(maLSMH, tenKH, tenDN, email, gia, ngayMua, soLuong, trangThai, ghiChu));
		}
		dc.cn.close();
		return ds;
	}

	public ArrayList<LichSuMuaHangBean> timkiemMa(long maLS) throws Exception {
		ArrayList<LichSuMuaHangBean> ds = new ArrayList<LichSuMuaHangBean>();
		KN_SQL dc = new KN_SQL();
		dc.ketNoi();

		String sql = "SELECT * FROM dbo.LichSuMuaHang WHERE MaLSMH = ?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setLong(1, maLS);
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			long maLSMH = rs.getLong("MaLSMH");
			String tenKH = rs.getString("TenKH");
			String tenDN = rs.getString("TenDN");
			String email = rs.getString("Email");
			long gia = rs.getLong("Gia");
			Date ngayMua = rs.getDate("NgayMua");
			long soLuong = rs.getLong("SoLuong");
			String trangThai = rs.getString("TrangThai");
			String ghiChu = rs.getString("GhiChu");
			ds.add(new LichSuMuaHangBean(maLSMH, tenKH, tenDN, email, gia, ngayMua, soLuong, trangThai, ghiChu));
		}
		dc.cn.close();
		return ds;
	}

	public LichSuMuaHangBean getChiTietLS(long ma) throws Exception {
		LichSuMuaHangBean ds = null;
		KN_SQL dc = new KN_SQL();
		dc.ketNoi();

		String sql = "SELECT * FROM dbo.LichSuMuaHang WHERE MaLSMH = ?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setLong(1, ma);
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			long maLSMH = rs.getLong("MaLSMH");
			String tenKH = rs.getString("TenKH");
			String tenDN = rs.getString("TenDN");
			String email = rs.getString("Email");
			long gia = rs.getLong("Gia");
			Date ngayMua = rs.getDate("NgayMua");
			long soLuong = rs.getLong("SoLuong");
			String trangThai = rs.getString("TrangThai");
			String ghiChu = rs.getString("GhiChu");
			ds = new LichSuMuaHangBean(maLSMH, tenKH, tenDN, email, gia, ngayMua, soLuong, trangThai, ghiChu);
		}
		dc.cn.close();
		return ds;
	}
}
