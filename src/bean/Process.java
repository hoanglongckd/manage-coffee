package bean;

public class Process {
	private int id;
	private int id_menu;
	private int id_material;
	private int id_shop;
	private int quantity;
	public int getId_menu() {
		return id_menu;
	}
	public void setId_menu(int id_menu) {
		this.id_menu = id_menu;
	}
	public int getId_material() {
		return id_material;
	}
	public void setId_material(int id_material) {
		this.id_material = id_material;
	}
	public int getId_shop() {
		return id_shop;
	}
	public void setId_shop(int id_shop) {
		this.id_shop = id_shop;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Process(int id, int id_menu, int id_material, int id_shop, int quantity) {
		super();
		this.id = id;
		this.id_menu = id_menu;
		this.id_material = id_material;
		this.id_shop = id_shop;
		this.quantity = quantity;
	}
	public Process() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
