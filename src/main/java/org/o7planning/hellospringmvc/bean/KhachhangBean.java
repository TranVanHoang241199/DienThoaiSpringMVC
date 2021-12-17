package org.o7planning.hellospringmvc.bean;

public class KhachhangBean {
	private long maKH;
	private String tenKH;
	private String diaChi;
	private String sdt;
	private String email;
	private String tenDN;
	private String pass;

	public KhachhangBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public KhachhangBean(String tenKH, String diaChi, String sdt, String email, String tenDN, String pass) {
		super();
		this.tenKH = tenKH;
		this.diaChi = diaChi;
		this.sdt = sdt;
		this.email = email;
		this.tenDN = tenDN;
		this.pass = pass;
	}

	public KhachhangBean(long maKH, String tenKH, String diaChi, String sdt, String email, String tenDN, String pass) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.diaChi = diaChi;
		this.sdt = sdt;
		this.email = email;
		this.tenDN = tenDN;
		this.pass = pass;
	}

	public long getMaKH() {
		return maKH;
	}

	public void setMaKH(long maKH) {
		this.maKH = maKH;
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTenDN() {
		return tenDN;
	}

	public void setTenDN(String tenDN) {
		this.tenDN = tenDN;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
