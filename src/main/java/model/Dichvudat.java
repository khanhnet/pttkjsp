package model;

public class Dichvudat {
	protected int ma;
	protected int madichvu;
	protected int malichdat;
	protected int gia;

	public Dichvudat() {
	}

	public Dichvudat(int madichvu, int malichdat, int gia) {
		super();
		this.madichvu = madichvu;
		this.malichdat = malichdat;
		this.gia = gia;
	}

	public Dichvudat(int ma, int madichvu, int malichdat, int gia) {
		super();
		this.ma = ma;
		this.madichvu = madichvu;
		this.malichdat = malichdat;
		this.gia = gia;
	}

	public int getMalichdat() {
		return malichdat;
	}

	public void setMalichdat(int malichdat) {
		this.malichdat = malichdat;
	}

	public int getMadichvu() {
		return madichvu;
	}

	public void setMadichvu(int madichvu) {
		this.madichvu = madichvu;
	}

	public int getMa() {
		return ma;
	}

	public void setMa(int ma) {
		this.ma = ma;
	}

	public int getGia() {
		return gia;
	}

	public void setGia(Integer gia) {
		this.gia = gia;
	}

}
