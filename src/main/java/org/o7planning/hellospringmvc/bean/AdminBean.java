package org.o7planning.hellospringmvc.bean;

public class AdminBean {
	private String tenDN;
	private String matKhau;
	private boolean quyen;

	public AdminBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminBean(String tenDN, String matKhau, boolean quyen) {
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

	public boolean isQuyen() {
		return quyen;
	}

	public void setQuyen(boolean quyen) {
		this.quyen = quyen;
	}

}
