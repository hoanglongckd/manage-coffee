package bo;

import java.util.ArrayList;

import bean.Order;
import dao.OrderDao;

public class OrderBo {
	OrderDao orderDao = new OrderDao();
	public ArrayList<Order> getList() {
		return orderDao.getList();
	}
	public static void main(String[] args) {
		OrderBo o = new OrderBo();
		for(Order i:o.getList() ){
			System.out.println(i.getIdStaff());
			
		}
	}

}
