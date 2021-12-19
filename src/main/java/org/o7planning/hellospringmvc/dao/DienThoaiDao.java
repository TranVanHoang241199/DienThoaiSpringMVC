package org.o7planning.hellospringmvc.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.o7planning.hellospringmvc.bean.DienThoaiBean;

public class DienThoaiDao {
	public ArrayList<DienThoaiBean> getDienThoai() throws Exception {
		ArrayList<DienThoaiBean> ds = new ArrayList<DienThoaiBean>();
		KN_SQL dc = new KN_SQL();
		dc.ketNoi();

		String sql = "SELECT * FROM DienThoai";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			int maDT = rs.getInt("MaDT");
			String tenDT = rs.getString("TenDT");
			long gia = rs.getLong("Gia");
			String anh = rs.getString("Anh");
			Date ngayNhap = rs.getDate("NgayNhap");
			long soLuong = rs.getLong("SoLuong");
			String maLoai = rs.getString("MaLoai");
			int sao = rs.getInt("sao");
			String danhGia = rs.getString("DanhGia");
			ds.add(new DienThoaiBean(maDT, tenDT, gia, anh, ngayNhap, soLuong, maLoai, sao, danhGia));
		}
		dc.cn.close();
		return ds;
	}

	public ArrayList<DienThoaiBean> getTimKiem(String tim) throws Exception {
		ArrayList<DienThoaiBean> ds = new ArrayList<DienThoaiBean>();
		KN_SQL dc = new KN_SQL();
		dc.ketNoi();

		String sql = "SELECT * FROM DienThoai WHERE TenDT like '%?%' or  MaLoai like '%?%'";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, tim);
		cmd.setString(2, tim);
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			int maDT = rs.getInt("MaDT");
			String tenDT = rs.getString("TenDT");
			long gia = rs.getLong("Gia");
			String anh = rs.getString("Anh");
			Date ngayNhap = rs.getDate("NgayNhap");
			long soLuong = rs.getLong("SoLuong");
			String maLoai = rs.getString("MaLoai");
			int sao = rs.getInt("sao");
			String danhGia = rs.getString("DanhGia");
			ds.add(new DienThoaiBean(maDT, tenDT, gia, anh, ngayNhap, soLuong, maLoai, sao, danhGia));
		}
		dc.cn.close();
		return ds;
	}

	public boolean themDienThoai(String maDT, String tenDT, long gia, String anh, String ngayNhap, Long soLuong,
			String maLoai, int sao, String danhGia) throws Exception {
		boolean kt = false;
		KN_SQL dc = new KN_SQL();
		dc.ketNoi();
		String sql = "INSERT INTO dbo.DienThoai (MaDT, TenDT, Gia, Anh, NgayNhap, SoLuong, MaLoai, sao, DanhGia)\r\n"
				+ "VALUES	(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, maLoai);
		cmd.setString(2, tenDT);
		cmd.setLong(3, gia);
		cmd.setString(4, anh);
		cmd.setDate(5, Date.valueOf(ngayNhap));
		cmd.setLong(6, soLuong);
		cmd.setString(7, maLoai);
		cmd.setInt(8, sao);
		cmd.setString(9, danhGia);

		if (cmd.executeUpdate() != 0)
			kt = true;
		dc.cn.close();
		return kt;
	}

	public boolean themDienThoai2(String tenDT, long gia, String anh, Long soLuong, String maLoai) throws Exception {
		boolean kt = false;
		KN_SQL dc = new KN_SQL();
		dc.ketNoi();
		String sql = "INSERT INTO dbo.DienThoai (TenDT, Gia, Anh, SoLuong, MaLoai, NgayNhap)\r\n" + "VALUES	(?, ?, ?, ?, ?, getDate())";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, tenDT);
		cmd.setLong(2, gia);
		cmd.setString(3, anh);
		cmd.setLong(4, soLuong);
		cmd.setString(5, maLoai);
		if (cmd.executeUpdate() != 0)
			kt = true;
		dc.cn.close();
		return kt;
	}

	public boolean xoadt(int maDT) throws Exception {
		boolean kt = false;
		KN_SQL dc = new KN_SQL();
		dc.ketNoi();

		String sql = "DELETE FROM dbo.DienThoai WHERE MaDT=?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setInt(1, maDT);

		if (cmd.executeUpdate() != 0)
			kt = true;
		dc.cn.close();
		return kt;
	}
}
