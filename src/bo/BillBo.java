package bo;

import java.util.ArrayList;

import bean.Bill;
import dao.BillDao;



public class BillBo {
	BillDao  itemDao   = new BillDao();
	public ArrayList<Bill> getList() {
		return itemDao.getList();
	}

	public int addItem(Bill Item) {
		return itemDao.addItem(Item);
	}
//	public int editItem(Bill Item) {
//		return itemDao.editItem(Item);
//	}
//
//	public Bill getItemById(int Id) {
//		
//		return itemDao.getItemByID(Id);
//	}
//
//	public int delItem(int id) {
//		return itemDao.delItemByID(id);
//	}

	
}
