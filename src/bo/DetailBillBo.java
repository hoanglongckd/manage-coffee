package bo;

import java.util.ArrayList;

import bean.DetailBill;
import dao.DetailBillDao;

public class DetailBillBo {
	DetailBillDao itemDao = new DetailBillDao();
	CostBo costBo = new CostBo();
	
	public ArrayList<DetailBill> getList() {
		return itemDao.getList();
	}

	public int addItem(DetailBill Item) {
		return itemDao.addItem(new DetailBill(0, Item.getId_bill(),Item.getId_menu() ,Item.getCount_menu(), costBo.getItemById(Item.getId_bill()).getCost() *Item.getCount_menu(), 0));
	}
	public int editItem(DetailBill Item) {
		return itemDao.editItem(Item);
	}

	public DetailBill getItemById(int Id) {
		
		return itemDao.getItemByID(Id);
	}

	public int delItem(int id) {
		return itemDao.delItemByID(id);
	}

	public ArrayList<DetailBill> getOrderByIdBill(int idBill) {
		return itemDao.getOrderByIdBill(idBill);
	}

}
