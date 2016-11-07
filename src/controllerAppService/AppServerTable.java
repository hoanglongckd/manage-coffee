package controllerAppService;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import bean.Table;
import bo.TableBo;

@Path("/serverTable")
public class AppServerTable {

	TableBo taBo = new TableBo();
	
	

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_XML)

	public ArrayList<Table> getListTable() {

		return taBo.getListTable();

	}
	
	
	

//	@POST
//	@Path("/addTable")
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response addPlace(Table Item) {
//		Table result = taBo.addItem(Item);
//		return Response.status(200).entity(result).build();//just test
//	}
	
}
