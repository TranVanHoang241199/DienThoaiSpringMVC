package org.o7planning.hellospringmvc.bean;

import java.sql.Date;

public class DienThoaiBean {
	private int maDT;
	private String tenDT;
	private long gia;
	private String anh;
	private Date ngayNhap;
	private long soLuong;
	private String maLoai;
	private int sao;
	private String danhGia;

	public DienThoaiBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public DienThoaiBean(int maDT, String tenDT, long gia, String anh, long soLuong, String maLoai) {
		super();
		this.maDT = maDT;
		this.tenDT = tenDT;
		this.gia = gia;
		this.anh = anh;
		this.soLuong = soLuong;
		this.maLoai = maLoai;
	}


	public DienThoaiBean(int maDT, String tenDT, long gia, String anh, Date ngayNhap, long soLuong, String maLoai,
			int sao, String danhGia) {
		super();
		this.maDT = maDT;
		this.tenDT = tenDT;
		this.gia = gia;
		this.anh = anh;
		this.ngayNhap = ngayNhap;
		this.soLuong = soLuong;
		this.maLoai = maLoai;
		this.sao = sao;
		this.danhGia = danhGia;
	}

	public int getMaDT() {
		return maDT;
	}

	public void setMaDT(int maDT) {
		this.maDT = maDT;
	}

	public String getTenDT() {
		return tenDT;
	}

	public void setTenDT(String tenDT) {
		this.tenDT = tenDT;
	}

	public long getGia() {
		return gia;
	}

	public void setGia(long gia) {
		this.gia = gia;
	}

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

	public Date getNgayNhap() {
		return ngayNhap;
	}

	public void setNgayNhap(Date ngayNhap) {
		this.ngayNhap = ngayNhap;
	}

	public long getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(long soLuong) {
		this.soLuong = soLuong;
	}

	public String getMaLoai() {
		return maLoai;
	}

	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
	}

	public int getSao() {
		return sao;
	}

	public void setSao(int sao) {
		this.sao = sao;
	}

	public String getDanhGia() {
		return danhGia;
	}

	public void setDanhGia(String danhGia) {
		this.danhGia = danhGia;
	}

}
