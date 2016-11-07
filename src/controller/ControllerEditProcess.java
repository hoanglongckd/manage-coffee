package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Process;
import bo.ProcessBo;

/**
 * Servlet implementation class ControllerIndexTable
 */

public class ControllerEditProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerEditProcess() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProcessBo ItemBo = new ProcessBo();

		if (request.getParameter("submit") != null) {

			int id_menu =0;
			 int id =0;
			 int id_material =0;
			 int id_shop =0;
			 int quantity =0;
			//String name  =new String( request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
			 if(request.getParameter("id")!=null){
				 id_material = Integer.parseInt(request.getParameter("id"));
			 }
			 if(request.getParameter("id_material")!=null){
				 id_material = Integer.parseInt(request.getParameter("id_material"));
			 }
			 if(request.getParameter("id_shop")!=null){
				 id_shop = Integer.parseInt(request.getParameter("id_shop"));
			 }
			 if(request.getParameter("quantity")!=null){
				 id_shop = Integer.parseInt(request.getParameter("quantity"));
			 }
			 if(request.getParameter("id_menu ")!=null){
				 id_shop = Integer.parseInt(request.getParameter("id_menu"));
			 } 
			Process Item = new Process(id, id_menu, id_material, id_shop, quantity);
			int result = ItemBo.editItem(Item);
			if(result >0){
				response.sendRedirect(request.getContextPath()+"/admin/indexProcess?msg=1");
			}else{
				response.sendRedirect(request.getContextPath()+"/admin/indexProcess?msg=0");
			}

		} else {
			int Id = Integer.parseInt(request.getParameter("id"));
			Process Item = ItemBo.getItemById(Id);
			request.setAttribute("objItem", Item);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/editProcess.jsp");
			rd.forward(request, response);
		}
	}
}
