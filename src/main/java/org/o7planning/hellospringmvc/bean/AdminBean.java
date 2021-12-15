package org.o7planning.hellospringmvc.bean;

public class AdminBean {
	private String tenDN;
	private String matKhau;
	private String quyen;

	public AdminBean() {
		super();
	}

	public AdminBean(String tenDN, String matKhau, String quyen) {
		super();
		this.tenDN = tenDN;
		this.matKhau = matKhau;
		this.quyen = quyen;
	}

	public String getTenDN() {
		return tenDN;
	}

	public void setTenDN(String tenDN) {
		this.tenDN = tenDN;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getQuyen() {
		return quyen;
	}

	public void setQuyen(String quyen) {
		this.quyen = quyen;
	}

}
