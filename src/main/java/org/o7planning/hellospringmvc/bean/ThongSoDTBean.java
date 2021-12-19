package org.o7planning.hellospringmvc.bean;

public class ThongSoDTBean {
	private int maTS;
	private String mangHinh;
	private String cameraSau;
	private String cameraTruoc;
	private String cpu;
	private String heDieuHanh;
	private String boNhoRam;
	private String pin;
	private String ketNoi;
	private int maDT;

	public ThongSoDTBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ThongSoDTBean(int maTS, String mangHinh, String cameraSau, String cameraTruoc, String cpu, String heDieuHanh,
			String boNhoRam, String pin, String ketNoi, int maDT) {
		super();
		this.maTS = maTS;
		this.mangHinh = mangHinh;
		this.cameraSau = cameraSau;
		this.cameraTruoc = cameraTruoc;
		this.cpu = cpu;
		this.heDieuHanh = heDieuHanh;
		this.boNhoRam = boNhoRam;
		this.pin = pin;
		this.ketNoi = ketNoi;
		this.maDT = maDT;
	}

	public int getMaTS() {
		return maTS;
	}

	public void setMaTS(int maTS) {
		this.maTS = maTS;
	}

	public String getMangHinh() {
		return mangHinh;
	}

	public void setMangHinh(String mangHinh) {
		this.mangHinh = mangHinh;
	}

	public String getCameraSau() {
		return cameraSau;
	}

	public void setCameraSau(String cameraSau) {
		this.cameraSau = cameraSau;
	}

	public String getCameraTruoc() {
		return cameraTruoc;
	}

	public void setCameraTruoc(String cameraTruoc) {
		this.cameraTruoc = cameraTruoc;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getHeDieuHanh() {
		return heDieuHanh;
	}

	public void setHeDieuHanh(String heDieuHanh) {
		this.heDieuHanh = heDieuHanh;
	}

	public String getBoNhoRam() {
		return boNhoRam;
	}

	public void setBoNhoRam(String boNhoRam) {
		this.boNhoRam = boNhoRam;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getKetNoi() {
		return ketNoi;
	}

	public void setKetNoi(String ketNoi) {
		this.ketNoi = ketNoi;
	}

	public int getMaDT() {
		return maDT;
	}

	public void setMaDT(int maDT) {
		this.maDT = maDT;
	}

}
