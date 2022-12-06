package model;

public class Dichvu {
	protected int ma;
	protected String ten;
	protected int gia;
	protected int thoigiandukien;
	public Dichvu() {
	}
	
	

	public Dichvu(String ten, int thoigiandukien, int gia) {
		super();
		this.ten = ten;
		this.thoigiandukien = thoigiandukien;
		this.gia = gia;
	}

	public Dichvu(int ma, String ten, int gia, int thoigiandukien) {
		super();
		this.ma = ma;
		this.ten = ten;
		this.thoigiandukien = thoigiandukien;
		this.gia = gia;
	}

	public int getMa() {
		return ma;
	}

	public void setMa(int ma) {
		this.ma = ma;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public int getGia() {
		return gia;
	}

	public void setGia(Integer gia) {
		this.gia = gia;
	}

	public int getThoigiandukien() {
		return thoigiandukien;
	}

	public void setThoigiandukien(Integer thoigiandukien) {
		this.thoigiandukien = thoigiandukien;
	}

}
