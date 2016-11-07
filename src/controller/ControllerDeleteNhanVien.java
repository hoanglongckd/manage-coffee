package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.NhanVienBo;

public class ControllerDeleteNhanVien extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControllerDeleteNhanVien() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idNhanVien= Integer.parseInt(request.getParameter("idNhanVien")+"");
		System.out.println(idNhanVien+"---------");
		if(NhanVienBo.getInstance().delItem(idNhanVien)){
			response.sendRedirect(request.getContextPath() + "admin/listNhanVien");
		}
		else{
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/admin/danh-sach-nhan-vien.jsp");
			dispatcher.forward(request, response);
		}
	}
}
