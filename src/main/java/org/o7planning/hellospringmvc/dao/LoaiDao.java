package org.o7planning.hellospringmvc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.o7planning.hellospringmvc.bean.LoaiBean;

public class LoaiDao {
	public ArrayList<LoaiBean> getLoai() throws Exception {
		ArrayList<LoaiBean> ds = new ArrayList<LoaiBean>();
		KN_SQL dc = new KN_SQL();
		dc.ketNoi();

		String sql = "SELECT * FROM Loai";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			String maLoai = rs.getString("MaLoai");
			String tenLoai = rs.getString("TenLoai");
			ds.add(new LoaiBean(maLoai, tenLoai));
		}
		dc.cn.close();
		return ds;
	}
	
	public boolean themLoai(String maLoai, String tenLoai) throws Exception {
		boolean kt = false;
		KN_SQL dc= new KN_SQL();
		dc.ketNoi();
		String sql = "INSERT INTO dbo.Loai (MaLoai, TenLoai)\r\n" + 
				"VALUES	(?, ?)";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, maLoai);
		cmd.setString(2, tenLoai);
		
		if(cmd.executeUpdate()!=0)
			kt = true;
		dc.cn.close();
		return kt;
	}
	
	public boolean suaLoai(String maLoai, String tenLoai) throws Exception {
		boolean kt = false;
		KN_SQL dc= new KN_SQL();
		dc.ketNoi();
		String sql = "UPDATE dbo.Loai SET TenLoai= ? WHERE MaLoai= ?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, tenLoai);
		cmd.setString(2, maLoai);
		
		if(cmd.executeUpdate()!=0)
			kt = true;
		dc.cn.close();
		return kt;
	}
	
	public boolean xoaLoai(String maLoai) throws Exception {
		boolean kt = false;
		KN_SQL dc= new KN_SQL();
		dc.ketNoi();
		
		String sql = "DELETE FROM dbo.Loai WHERE MaLoai=?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, maLoai);
		
		if(cmd.executeUpdate()!=0)
			kt = true;
		dc.cn.close();
		return kt;
	}
}
