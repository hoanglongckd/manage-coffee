package controllerAppService;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import bean.Menu;
import bo.MenuBo;

@Path("/serverMenu")
public class AppServerMenu {

	MenuBo menuBo = new MenuBo();	

	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_XML)
	public ArrayList<Menu> getListMenu(){
		return menuBo.getListMenu();
	}
	

}
