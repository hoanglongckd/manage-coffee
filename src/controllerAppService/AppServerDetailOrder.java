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

@Path("/serverDetailOrder")
public class AppServerDetailOrder {
	OrderBo orderBo = new OrderBo();
	BillBo billBo = new BillBo();
	DetailBillBo detailBillBo = new DetailBillBo();

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_XML)
	public Response getListTable(@QueryParam("idTable") String idTableS,@QueryParam("key") String key) {
		OrderType<ArrayList<DetailOrderList>> result = new OrderType<>();
		ArrayList<LoginedAccount> listLoginedAccounts = AppServerLogin.getListLoginedAccounts();
		if(!listLoginedAccounts.isEmpty()){
			for (LoginedAccount loginedAccount : listLoginedAccounts) {
				if(key.equals(loginedAccount.getKey())){
					System.out.println("v1");
					int idTable = Integer.parseInt(idTableS);
					Bill itemBill = billBo.getItemByIdTable(idTable);
					DetailOrderList detaiOrderList = new DetailOrderList(detailBillBo.getOrderByIdBill(itemBill.getId_bill()), itemBill.getSumMoney());
					billBo.setStatusPay(itemBill.getId_bill());
					result.setValue(detaiOrderList);
					break;
				}else{
					System.out.println("v2");
					result.setValue(null);
				}
			}
		}else{
			System.out.println("v3");
			result.setValue(null);
		}
		return Response.status(200).entity(result).build();

	}
	

	
}
