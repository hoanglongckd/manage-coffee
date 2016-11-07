package bean;

public class NhanVien {
	private int id;
	private int idAnh;
	private int idQuan;
	private String ten;
	private String GhiChu;
	
	
	
	public NhanVien(int id, int idAnh, int idQuan, String ten, String ghiChu) {
		super();
		this.id = id;
		this.idAnh = idAnh;
		this.idQuan = idQuan;
		this.ten = ten;
		GhiChu = ghiChu;
	}
	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdAnh() {
		return idAnh;
	}
	public void setIdAnh(int idAnh) {
		this.idAnh = idAnh;
	}
	public int getIdQuan() {
		return idQuan;
	}
	public void setIdQuan(int idQuan) {
		this.idQuan = idQuan;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getGhiChu() {
		return GhiChu;
	}
	public void setGhiChu(String ghiChu) {
		GhiChu = ghiChu;
	}
	
	
	
}
