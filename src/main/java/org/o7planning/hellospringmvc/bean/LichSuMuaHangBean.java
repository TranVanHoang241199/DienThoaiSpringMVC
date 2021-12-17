package org.o7planning.hellospringmvc.bean;

import java.sql.Date;

public class LichSuMuaHangBean {
	public long maLSMH;
	public String tenKH;
	public String tenDN;
	public String email;
	public long gia;
	public Date ngayMua;
	public long soLuong;
	public String trangThai;
	public String ghiChu;

	public LichSuMuaHangBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LichSuMuaHangBean(long maLSMH, String tenKH, String tenDN, String email, long gia, Date ngayMua,
			long soLuong, String trangThai, String ghiChu) {
		super();
		this.maLSMH = maLSMH;
		this.tenKH = tenKH;
		this.tenDN = tenDN;
		this.email = email;
		this.gia = gia;
		this.ngayMua = ngayMua;
		this.soLuong = soLuong;
		this.trangThai = trangThai;
		this.ghiChu = ghiChu;
	}

	public long getMaLSMH() {
		return maLSMH;
	}

	public void setMaLSMH(long maLSMH) {
		this.maLSMH = maLSMH;
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	public String getTenDN() {
		return tenDN;
	}

	public void setTenDN(String tenDN) {
		this.tenDN = tenDN;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getGia() {
		return gia;
	}

	public void setGia(long gia) {
		this.gia = gia;
	}

	public Date getNgayMua() {
		return ngayMua;
	}

	public void setNgayMua(Date ngayMua) {
		this.ngayMua = ngayMua;
	}

	public long getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(long soLuong) {
		this.soLuong = soLuong;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

}
