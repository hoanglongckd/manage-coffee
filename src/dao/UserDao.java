package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.User;
import bean.User;
import libraryConnectDb.LibraryConnectDb;

public class UserDao {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;

	LibraryConnectDb lb = new LibraryConnectDb();

	public User checkLogin(String username, String password) {
		User Item = null;
		conn = lb.getConnectMySQL();
		String query = "SELECT * FROM user WHERE username= ?&& password =? ";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, username);
			pst.setString(2, password);
			rs = pst.executeQuery();
			while (rs.next()) {
				Item = new User(rs.getInt("id"),rs.getInt("idNguoiQuanLy"),rs.getInt("idNhanVien"),rs.getString("username"),rs.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return Item;
	}

	public void setItemStatus(int id_user) {
		conn = lb.getConnectMySQL();
		String query = "UPDATE user SET trangThaiDangNhap=? WHERE id =? ";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, 1);
			pst.setInt(2, id_user);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public User getItemByIdNhanVien(int idNhanVien) {
		User objItem = null;
		conn = lb.getConnectMySQL();
		
		String query = "SELECT * FROM User WHERE idUser = ? LIMIT 1";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1,idNhanVien );
			rs = pst.executeQuery();
			if(rs.next()){
				objItem = new User(rs.getInt("idUser"),rs.getInt("idNguoiQuanLy"),rs.getInt("idNhanVien"),
						rs.getString("username"),rs.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return objItem;
	}

}
