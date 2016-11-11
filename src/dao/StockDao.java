package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Stock;
import libraryConnectDb.LibraryConnectDb;

public class StockDao {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;

	LibraryConnectDb lb = new LibraryConnectDb();

	public ArrayList<Stock> getList() {
		Stock Item = null;
		ArrayList<Stock> alItem = new ArrayList<Stock>();
		conn = lb.getConnectMySQL();
		String query = "SELECT * FROM  kho WHERE idQuan = ? ";
		try {
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			pst.setInt(1, 1);
			while (rs.next()) {
				Item = new Stock(rs.getInt("id"),rs.getInt("idNguyenLieu"),rs.getInt("idQuan"), rs.getInt("tongSoTrongKho"));
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
	

	public int addItem(Stock Item) {
		conn = lb.getConnectMySQL();
		int result =0;
		String query = "INSERT INTO kho(idNguyenLieu,idQuan,tongSoTrongKho) VALUES(?,?,?)";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, Item.getId_material());
			pst.setInt(2, Item.getId_shop());
			pst.setInt(3, Item.getTotalNumber());
			
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

	public int editItem(Stock Item) {
		conn = lb.getConnectMySQL();
		int result =0;
		String query = "UPDATE  kho SET idNguyenLieu =? ,idQuan = ?,tongSoTrongKho =? WHERE id =? LIMIT 1";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, Item.getId_material());
			pst.setInt(2, Item.getId_shop());
			pst.setInt(3, Item.getTotalNumber());
			pst.setInt(4, Item.getId_stock());
			
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

	public Stock getItemByID(int Id) {
		Stock objItem = null;
		conn = lb.getConnectMySQL();
		
		String query = "SELECT * FROM kho WHERE id = ?  LIMIT 1";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1,Id );
			rs = pst.executeQuery();
			if(rs.next()){
				objItem =  new Stock(rs.getInt("id"),rs.getInt("idNguyenLieu"),rs.getInt("idQuan"), rs.getInt("tongSoTrongKho"));
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
		String query = "DELETE FROM  kho WHERE id =? LIMIT 1";
		
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
