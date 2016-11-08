package controllerAppService;

import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import bean.Bill;
import bean.DetailBill;
import bean.LoginedAccount;
import bean.Order;
import bean.OrderList;
import bean.PrimitiveType;
import bo.BillBo;
import bo.DetailBillBo;
import bo.OrderBo;
import bo.TableBo;

@Path("/serverOrder")
public class AppServerOrder {
	OrderBo orderBo = new OrderBo();
	BillBo billBo = new BillBo();
	DetailBillBo detailBillBo = new DetailBillBo();
	TableBo tableBo = new TableBo();

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_XML)
	public ArrayList<Order> getList() {
		return orderBo.getList();
	}

	@POST
	@Path("/Menu")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response orderMenu(OrderList Item) {
		ArrayList<LoginedAccount> listLoginedAccounts = AppServerLogin.getListLoginedAccounts();
		PrimitiveType<Integer> result = new PrimitiveType<>();
		if (!listLoginedAccounts.isEmpty()) {
			for (LoginedAccount loginedAccount : listLoginedAccounts) {
				if (Item.getKey().equals(loginedAccount.getKey())) {
					int idBill = billBo.addItem(new Bill(Item.getIdTable(), Item.getIdStaff()));
					tableBo.setStatusTable(Item.getIdTable());
					for (Order order : Item.getOrders()) {
						detailBillBo.addItem(new DetailBill(idBill, order.getId_menu(), order.getCount_menu()));
					}
					result.setValue(1);
					break;
				} else {
					result.setValue(0);
				}
			}
		} else {
			result.setValue(0);
		}

		return Response.status(200).entity(result).build();// just test
	}
}
