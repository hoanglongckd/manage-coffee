package bo;

import bean.DetailBill;
import dao.DetailBillDao;

public class DetailBillBo {
	DetailBillDao itemDao = new DetailBillDao();

	public void addDetailBill(DetailBill obj) {

		itemDao.addItem(obj);

	}

}
