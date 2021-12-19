package org.o7planning.hellospringmvc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.o7planning.hellospringmvc.bean.ThongSoDTBean;

public class ThongSoDTDao {
	public ArrayList<ThongSoDTBean> getThongSo() throws Exception {
		ArrayList<ThongSoDTBean> ds = new ArrayList<ThongSoDTBean>();
		KN_SQL dc = new KN_SQL();
		dc.ketNoi();

		String sql = "SELECT * FROM dbo.ThongSoKyThuat";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();

		while (rs.next()) {
			int maTS = rs.getInt("MaTSKT");
			String mangHinh = rs.getString("MangHinh");
			String cameraSau = rs.getString("CameraSau");
			String cameraTruoc = rs.getString("CameraTruoc");
			String cpu = rs.getString("CPU");
			String heDieuHanh = rs.getString("HeDieuHanh");
			String boNhoRam = rs.getString("BoNhoVaRam");
			String pin = rs.getString("Pin");
			String ketNoi = rs.getString("KetNoi");
			int maDT = rs.getInt("MaDT");
			ds.add(new ThongSoDTBean(maTS, mangHinh, cameraSau, cameraTruoc, cpu, heDieuHanh, boNhoRam, pin, ketNoi,
					maDT));
		}
		dc.cn.close();
		return ds;
	}

	public ThongSoDTBean getTSMaDT(int maDT) throws Exception {
		ThongSoDTBean ds = new ThongSoDTBean();
		KN_SQL dc = new KN_SQL();
		dc.ketNoi();

		String sql = "SELECT * FROM dbo.ThongSoKyThuat WHERE MaDT = ?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setInt(1, maDT);
		ResultSet rs = cmd.executeQuery();

		if (rs.next()) {
			int maTS = rs.getInt("MaTSKT");
			String mangHinh = rs.getString("MangHinh");
			String cameraSau = rs.getString("CameraSau");
			String cameraTruoc = rs.getString("CameraTruoc");
			String cpu = rs.getString("CPU");
			String heDieuHanh = rs.getString("HeDieuHanh");
			String boNhoRam = rs.getString("BoNhoVaRam");
			String pin = rs.getString("Pin");
			String ketNoi = rs.getString("KetNoi");
			int maDTT = rs.getInt("MaDT");
			ds = new ThongSoDTBean(maTS, mangHinh, cameraSau, cameraTruoc, cpu, heDieuHanh, boNhoRam, pin, ketNoi,
					maDTT);
		}
		dc.cn.close();
		return ds;
	}

	public boolean themThongSo(String mangHinh, String cameraSau, String cameraTruoc, String cpu, String heDieuHanh,
			String boNhoRam, String pin, String ketNoi, int maDT) throws Exception {
		boolean kt = false;
		KN_SQL dc = new KN_SQL();
		dc.ketNoi();
		String sql = "INSERT INTO dbo.ThongSoKyThuat (MangHinh, CameraSau, CameraTruoc, CPU, HeDieuHanh, BoNhoVaRam, Pin, KetNoi, MaDT)\r\n"
				+ "VALUES	(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, mangHinh);
		cmd.setString(2, cameraSau);
		cmd.setString(3, cameraTruoc);
		cmd.setString(4, cpu);
		cmd.setString(5, heDieuHanh);
		cmd.setString(6, boNhoRam);
		cmd.setString(7, pin);
		cmd.setString(8, ketNoi);
		cmd.setInt(9, maDT);

		if (cmd.executeUpdate() != 0)
			kt = true;
		dc.cn.close();
		return kt;
	}
	
	public boolean CapNhatThongSo(String mangHinh, String cameraSau, String cameraTruoc, String cpu, String heDieuHanh,
			String boNhoRam, long pin, String ketNoi, int maDT) throws Exception {
		boolean kt = false;
		KN_SQL dc = new KN_SQL();
		dc.ketNoi();
		String sql = "UPDATE dbo.ThongSoKyThuat SET MangHinh = ?, CameraSau = ?, CameraTruoc = ?, CPU = ?, HeDieuHanh = ?, BoNhoVaRam = ?, Pin = ?, KetNoi = ? WHERE MaDT = ?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, mangHinh);
		cmd.setString(2, cameraSau);
		cmd.setString(3, cameraTruoc);
		cmd.setString(4, cpu);
		cmd.setString(5, heDieuHanh);
		cmd.setString(6, boNhoRam);
		cmd.setLong(7, pin);
		cmd.setString(8, ketNoi);
		cmd.setInt(9, maDT);

		if (cmd.executeUpdate() != 0)
			kt = true;
		dc.cn.close();
		return kt;
	}
	
	public boolean checkTSKT(int maDT) throws Exception {
		boolean kt = false;
		KN_SQL dc= new KN_SQL();
		dc.ketNoi();
		
		String sql = "DELETE FROM dbo.ThongSoKyThuat WHERE maDT=?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setInt(1, maDT);
		
		if(cmd.executeUpdate()!=0)
			kt = true;
		dc.cn.close();
		return kt;
	}
}
