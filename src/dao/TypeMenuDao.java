package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import bean.TypeMenu;
import libraryConnectDb.LibraryConnectDb;

public class TypeMenuDao {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;

	LibraryConnectDb lb = new LibraryConnectDb();

	public ArrayList<TypeMenu> getListTypeMenu() {
		TypeMenu Item = null;
		ArrayList<TypeMenu> alItem = new ArrayList<TypeMenu>();
		conn = lb.getConnectMySQL();
		String query = "SELECT * FROM loaithuctap ";
		try {
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				Item = new TypeMenu(rs.getInt("id"), rs.getString("tenLoaiThucTham"));
				alItem.add(Item);
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
		return alItem;
	}

	public int addTypeMenu(TypeMenu typeMenu) {
		conn = lb.getConnectMySQL();
		int result =0;
		String query = "INSERT INTO loaithucpham(tenLoaiThucPham) VALUES(?)";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1,typeMenu.getNameType() );
			pst.executeUpdate();
			result =1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return result;
	}

	public int editTable(TypeMenu typeMenu) {
		conn = lb.getConnectMySQL();
		int result =0;
		String query = "UPDATE  loaithucdon SET tenLoaiThucPham =? WHERE id =? LIMIT 1";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(2,typeMenu.getIdType());
			pst.setString(1,typeMenu.getNameType());
			pst.executeUpdate();
			result =1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return result;
		
	}

	public TypeMenu getItemByID(int tyId) {
		TypeMenu objItem = null;
		conn = lb.getConnectMySQL();
		
		String query = "SELECT * FROM loaithucdon WHERE id = ? LIMIT 1";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1,tyId );
			rs = pst.executeQuery();
			if(rs.next()){
				objItem = new TypeMenu(rs.getInt("id"), rs.getString("tenLoaiThucPham"));
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

	public int delItemByID(int id) {
		conn = lb.getConnectMySQL();
		int result =0;
		String query = "DELETE FROM  loaithucdon WHERE id =? LIMIT 1";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1,id );
			pst.executeUpdate();
			result =1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return result;
	}

}
