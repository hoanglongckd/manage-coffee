package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Material;
import bo.MaterialBo;
import bo.UnitBo;

/**
 * Servlet implementation class ControllerIndexTable
 */

public class ControllerEditMaterial extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerEditMaterial() {
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
		UnitBo uBo = new UnitBo();
		MaterialBo maBo = new MaterialBo();
		
		request.setAttribute("alItemU", uBo.getList());
		request.setAttribute("alItemP", maBo.getListPicture());
		if (request.getParameter("submit") != null) {
			int Id = Integer.parseInt(request.getParameter("id"));
			int id_picture =0;
			 
			 int id_unit =0;
			 String name;
			 String note;
			//String name  =new String( request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
			 if(request.getParameter("picture")!=null){
				 id_picture = Integer.parseInt(request.getParameter("picture"));
			 }
			 
			 if(request.getParameter("unit")!=null){
				 id_unit = Integer.parseInt(request.getParameter("unit"));
			 }
			name  =new String( request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
			note = new String( request.getParameter("note").getBytes("ISO-8859-1"),"UTF-8");
			Material Item = new Material(Id, id_picture, id_unit, 1, name, note);
			int result = maBo.editItem(Item);
			if(result >0){
				response.sendRedirect(request.getContextPath()+"/admin/indexMaterial?msg=1");
			}else{
				response.sendRedirect(request.getContextPath()+"/admin/indexMaterial?msg=0");
			}
		} else {
			int Id = Integer.parseInt(request.getParameter("id"));
			Material Item = maBo.getItemById(Id);
			request.setAttribute("objItem", Item);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/editMaterial.jsp");
			rd.forward(request, response);
		}
	}
}
