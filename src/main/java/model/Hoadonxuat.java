package model;

public class Hoadonxuat {
	protected int ma;
	protected int trangthai;
	protected int malichdat;
	protected String thoigiantao;

	public Hoadonxuat() {
	}

	public Hoadonxuat(int trangthai, int malichdat,String thoigiantao) {
		super();
		this.trangthai = trangthai;
		this.malichdat = malichdat;
		this.thoigiantao = thoigiantao;
	}
	
	public Hoadonxuat(int trangthai, int malichdat) {
		super();
		this.trangthai = trangthai;
		this.malichdat = malichdat;
	}

	public Hoadonxuat(int ma, int trangthai, int malichdat,String thoigiantao) {
		super();
		this.ma = ma;
		this.trangthai = trangthai;
		this.malichdat = malichdat;
		this.thoigiantao = thoigiantao;
	}

	public int getMalichdat() {
		return malichdat;
	}

	public void setMalichdat(int malichdat) {
		this.malichdat = malichdat;
	}

	public int getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(int trangthai) {
		this.trangthai = trangthai;
	}

	public int getMa() {
		return ma;
	}

	public void setMa(int ma) {
		this.ma = ma;
	}
	
	public String getThoigiantao() {
		return thoigiantao;
	}

	public void setThoigiantao(String thoigiantao) {
		this.thoigiantao = thoigiantao;
	}

}
