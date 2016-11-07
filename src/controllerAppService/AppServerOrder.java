package controllerAppService;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import bean.Order;
import bo.OrderBo;

@Path("/serverOrder")
public class AppServerOrder {
	OrderBo orderBo = new OrderBo();
	
	
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_XML)
	public ArrayList<Order> getList(){
		return orderBo.getList();
	}
//	@POST
//	@Path("/Menu")
//	@Consumes(MediaType.APPLICATION_XML)
//	@Produces(MediaType.APPLICATION_XML)
//	public Response orderMenu( ArrayList<Order> alItem) {
//		int result =5;
//		System.out.println(" sgdhsd");
//		
//		
//		return Response.status(200).entity(result).build();//just test
//	}
}
