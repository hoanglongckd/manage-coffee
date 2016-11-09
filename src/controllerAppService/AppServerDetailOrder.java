package controllerAppService;

import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import bean.Bill;
import bean.DetailOrderList;
import bean.LoginedAccount;
import bean.OrderType;
import bo.BillBo;
import bo.DetailBillBo;
import bo.OrderBo;
import bo.TableBo;

@Path("/serverDetailOrder")
public class AppServerDetailOrder {
	OrderBo orderBo = new OrderBo();
	BillBo billBo = new BillBo();
	DetailBillBo detailBillBo = new DetailBillBo();
	TableBo tableBo = new TableBo();

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_XML)
	public Response getListTable(@QueryParam("idTable") String idTableS, @QueryParam("key") String key) {
		OrderType<DetailOrderList> result = new OrderType<>();// cai ni ne m
		ArrayList<LoginedAccount> listLoginedAccounts = AppServerLogin.getListLoginedAccounts();
		if (!listLoginedAccounts.isEmpty()) {
			for (LoginedAccount loginedAccount : listLoginedAccounts) {
				if (key.equals(loginedAccount.getKey())) {
					System.out.println("v1");
					int idTable = 0;
					try {
						idTable = Integer.parseInt(idTableS);
					} catch (NumberFormatException e) {
						result.setValue(null);// mấy cái ni nè
					}

					Bill itemBill = billBo.getItemByIdTable(idTable);
					if (itemBill != null) {
						System.err.println("it" + itemBill.getId_bill() + "" + itemBill.getSumMoney());

						DetailOrderList detaiOrderList = new DetailOrderList(
								detailBillBo.getOrderByIdBill(itemBill.getId_bill()), itemBill.getSumMoney());
						if (detaiOrderList.getDetaiBill().size() > 0) {
							result.setValue(detaiOrderList);// hắn k có hiên thị
							break;
						} else {
							result.setValue(new DetailOrderList());
						}
						 billBo.setStatusPay(itemBill.getId_bill());
						 tableBo.setStatusTable(idTable,0);

					} else {
						result.setValue(new DetailOrderList());
					}
				} else {
					System.out.println("v2");
					result.setValue(new DetailOrderList());
				}
			}
		} else {
			System.out.println("v3");
			result.setValue(new DetailOrderList());
		}
		return Response.status(200).entity(result).build();

	}

}
