package bean;

public class MaterialsUsedInDay {
	private int id;
	private int id_import;
	private int acountSold;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_import() {
		return id_import;
	}
	public void setId_import(int id_import) {
		this.id_import = id_import;
	}
	public int getAcountSold() {
		return acountSold;
	}
	public void setAcountSold(int acountSold) {
		this.acountSold = acountSold;
	}
	public MaterialsUsedInDay() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MaterialsUsedInDay(int id, int id_import, int acountSold) {
		super();
		this.id = id;
		this.id_import = id_import;
		this.acountSold = acountSold;
	}
	
	
	

}
