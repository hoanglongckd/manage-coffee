package bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement

public class Order {
	private int idStaff;
	private int idTable;
	private int id_menu;
	private int count_menu;
	
	
	public int getIdStaff() {
		return idStaff;
	}
	@XmlElement
	public void setIdStaff(int idStaff) {
		this.idStaff = idStaff;
	}
	public int getIdTable() {
		return idTable;
	}
	@XmlElement
	public void setIdTable(int idTable) {
		this.idTable = idTable;
	}
	
	public int getId_menu() {
		return id_menu;
	}
	@XmlElement
	public void setId_menu(int id_menu) {
		this.id_menu = id_menu;
	}
	public int getCount_menu() {
		return count_menu;
	}
	@XmlElement
	public void setCount_menu(int count_menu) {
		this.count_menu = count_menu;
	}
	
	
	public Order(int idStaff, int idTable, int id_menu,int count_menu) {
		
		this.idStaff = idStaff;
		this.idTable = idTable;
		
		this.id_menu = id_menu;
		this.count_menu = count_menu;
		
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Order [idStaff=" + idStaff + ", idTable=" + idTable + ", id_menu=" + id_menu + ", count_menu="
				+ count_menu + "]";
	}
	
}
