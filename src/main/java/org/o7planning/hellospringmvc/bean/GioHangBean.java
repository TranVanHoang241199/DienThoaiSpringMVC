package org.o7planning.hellospringmvc.bean;

public class GioHangBean {
	private String maDT;
	private String tenDT;
	private String tenLoai;
	private String anh;
	private long gia;
	private long slMua;

	public GioHangBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GioHangBean(String maDT, String tenDT, String tenLoai, String anh, long gia, long slMua) {
		super();
		this.maDT = maDT;
		this.tenDT = tenDT;
		this.tenLoai = tenLoai;
		this.anh = anh;
		this.gia = gia;
		this.slMua = slMua;
	}

	public String getMaDT() {
		return maDT;
	}

	public void setMaDT(String maDT) {
		this.maDT = maDT;
	}

	public String getTenDT() {
		return tenDT;
	}

	public void setTenDT(String tenDT) {
		this.tenDT = tenDT;
	}

	public String getTenLoai() {
		return tenLoai;
	}

	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

	public long getGia() {
		return gia;
	}

	public void setGia(long gia) {
		this.gia = gia;
	}

	public long getSlMua() {
		return slMua;
	}

	public void setSlMua(long slMua) {
		this.slMua = slMua;
	}
	
	public long getThanhTien() {
		return slMua*gia;
	}
}
