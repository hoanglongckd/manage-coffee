package controller.quanLyNhanVien;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.NhanVien;
import bo.NhanVienBo;


@WebServlet("/admin/listNhanVien")
public class ControllerListNhanVien extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControllerListNhanVien() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	ArrayList<NhanVien> listNhanVien = NhanVienBo.getInstance().getListNhanVienDetailByIdQuan(1);
		request.setAttribute("listNhanVien", listNhanVien);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/danh-sach-nhan-vien.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
