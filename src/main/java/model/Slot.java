package model;

public class Slot {
	protected int ma;
	protected String ten;

	public Slot() {
	}

	public Slot(String ten) {
		super();
		this.ten = ten;
	}

	public Slot(int ma, String ten) {
		super();
		this.ma = ma;
		this.ten = ten;
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

}
