package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.NhanVien;
import bo.NhanVienBo;

public class ControllerAddNhanVien extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControllerAddNhanVien() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/admin/them-nhan-vien.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("submit")!=null){
			String hoTen = request.getParameter("ten");
			int idQuan = Integer.parseInt(request.getParameter("quan"));
			String ghiChu = request.getParameter("ghichu");
			int idAnh = Integer.parseInt(request.getParameter("anh"));
			System.out.println("anh:"+idAnh+"quan:"+idQuan+"ten:"+hoTen+"ghichu:"+ghiChu);
		
			NhanVien nhanVien = new NhanVien(0,idAnh,idQuan,hoTen,ghiChu);
			
			if (NhanVienBo.getInstance().addItem(nhanVien)) {
				response.sendRedirect(request.getContextPath()+"/admin/listNhanVien");
			}
			else {
				System.out.println("Fail");
			}
		}else{
			System.out.println("xxxxxxxxxxxxx");
		}
	}

}
