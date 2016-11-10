package controller.quanLyNhanVien;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Anh;
import bean.NhanVien;
import bean.User;
import bo.AnhBo;
import bo.NhanVienBo;
import bo.UserBo;

@WebServlet("/admin/updateNhanVien")
public class ControllerUpdateNhanVien extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControllerUpdateNhanVien() {
        super();
    }
    UserBo userBo = new UserBo();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idNhanVien=Integer.parseInt(request.getParameter("idNhanVien"));
		NhanVien nhanVien = NhanVienBo.getInstance().getItemById(idNhanVien);
		Anh anh = AnhBo.getInstance().getItemById(nhanVien.getIdAnh());
		User user = userBo.getItemByIdNhanVien(idNhanVien);
		if(user==null)System.out.println("NULLLLLLLL");
		request.setAttribute("nhanVien", nhanVien);
		request.setAttribute("anh", anh);
		request.setAttribute("user", user);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/chinh-sua-nhan-vien.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String ghiChu = request.getParameter("ghiChu");
		
		response.sendRedirect(request.getContextPath()+"/admin/listNhanVien");
	}

}
