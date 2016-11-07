package bean;

import java.sql.Timestamp;

public class DetailBill {
	private int id_detail;
	private int id_bill;
	private int id_table;
	private int status_pay;
	private Timestamp date_invoice;
	
	public int getId_detail() {
		return id_detail;
	}
	public void setId_detail(int id_detail) {
		this.id_detail = id_detail;
	}
	public int getId_bill() {
		return id_bill;
	}
	public void setId_bill(int id_bill) {
		this.id_bill = id_bill;
	}
	public int getId_table() {
		return id_table;
	}
	public void setId_table(int id_table) {
		this.id_table = id_table;
	}
	public int getStatus_pay() {
		return status_pay;
	}
	public void setStatus_pay(int status_pay) {
		this.status_pay = status_pay;
	}
	public Timestamp getDate_invoice() {
		return date_invoice;
	}
	public void setDate_invoice(Timestamp date_invoice) {
		this.date_invoice = date_invoice;
	}
	
	public DetailBill() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DetailBill(int id_detail, int id_bill, int id_table, int status_pay, Timestamp date_invoice) {
		super();
		this.id_detail = id_detail;
		this.id_bill = id_bill;
		this.id_table = id_table;
		this.status_pay = status_pay;
		this.date_invoice = date_invoice;
		
	}
	

}
