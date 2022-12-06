package model;

public class Khachhang {
	protected int ma;
	protected String ten;
	protected String sdt;
	protected String email;
	protected String diachi;

	public Khachhang() {
	}

	public Khachhang(String ten, String email, String sdt, String diachi) {
		super();
		this.ten = ten;
		this.email = email;
		this.sdt = sdt;
		this.diachi = diachi;
	}

	public Khachhang(int ma, String ten, String email, String sdt, String diachi) {
		super();
		this.ma = ma;
		this.ten = ten;
		this.email = email;
		this.sdt = sdt;
		this.diachi = diachi;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

}
