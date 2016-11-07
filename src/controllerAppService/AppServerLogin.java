package controllerAppService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import bean.PrimitiveType;
import bean.User;
import bo.UserBo;

@Path("/serverApp")
public class AppServerLogin {

	UserBo userBo = new UserBo();

	@GET
	@Path("/login")
	@Produces(MediaType.APPLICATION_XML)
	public Response Login(@QueryParam("username") String username, @QueryParam("password") String password) {
		// boolean check = userBo.CheckLogin(username, password);
		PrimitiveType<Integer> result = new PrimitiveType<>();
		User Item = userBo.CheckLogin(username, password);
		if (Item != null) {
			System.out.println("asfha");
			if (Item.getStatus() == 0) {
				result.setValue(Item.getId_user());
				userBo.setItemInStatus(Item.getId_user());
			} else {
				result.setValue(0);
			}
		} else {
			result.setValue(0);
		}

		// result.setValue(Item.getStatus());

		return Response.status(200).entity(result).build();
	}

}
