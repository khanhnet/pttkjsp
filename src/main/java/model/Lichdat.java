package model;

public class Lichdat {
	protected int ma;
	protected String  thoigianbatdau;
	protected String thoigianketthuc;
	protected int maslot;
	protected int makhachhang;
	protected int manhanvien;
	public Lichdat() {
	}
	
	

	public Lichdat(int maslot, int makhachhang, int manhanvien, String thoigianketthuc,String thoigianbatdau) {
		super();
		this.maslot = maslot;
		this.makhachhang = makhachhang;
		this.manhanvien = manhanvien;
		this.thoigianketthuc = thoigianketthuc;
		this.thoigianbatdau = thoigianbatdau;
	}

	public Lichdat(int ma,int maslot, int makhachhang, int manhanvien, String thoigianketthuc,String thoigianbatdau) {
		super();
		this.ma = ma;
		this.maslot = maslot;
		this.makhachhang = makhachhang;
		this.manhanvien = manhanvien;
		this.thoigianketthuc = thoigianketthuc;
		this.thoigianbatdau = thoigianbatdau;
	}

	public int getMa() {
		return ma;
	}

	public void setMa(int ma) {
		this.ma = ma;
	}

	public int getMaslot() {
		return maslot;
	}

	public void setMaslot(int maslot) {
		this.maslot = maslot;
	}
	public int getMakhachhang() {
		return makhachhang;
	}

	public void setMakhachhang(int makhachhang) {
		this.makhachhang = makhachhang;
	}
	public int getManhanvien() {
		return manhanvien;
	}

	public void setManhanvien(int manhanvien) {
		this.manhanvien = manhanvien;
	}
	public String getThoigianketthuc() {
		return thoigianketthuc;
	}

	public void setThoigianketthuc(String thoigianketthuc) {
		this.thoigianketthuc = thoigianketthuc;
	}
	public String getThoigianbatdau() {
		return thoigianbatdau;
	}

	public void setThoigianbatdau(String thoigianbatdau) {
		this.thoigianbatdau = thoigianbatdau;
	}

}
