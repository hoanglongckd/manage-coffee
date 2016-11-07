package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Bill;
import bean.Unit;
import libraryConnectDb.LibraryConnectDb;

public class BillDao {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;

	LibraryConnectDb lb = new LibraryConnectDb();

	public ArrayList<Bill> getList() {
		Bill Item = null;
		ArrayList<Bill> alItem = new ArrayList<Bill>();
		conn = lb.getConnectMySQL();
		String query = "SELECT * FROM  donvitinh ";
		try {
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				Item = new Bill(rs.getInt("id"),rs.getInt("idNhanVien"),rs.getInt("idBan"),rs.getInt("trangThaiThanhToan"),rs.getTimestamp("ngayLapHoaDon"),rs.getString("ghiChu"));
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
	

	public int addItem(Bill Item) {
		conn = lb.getConnectMySQL();
		int result =0;
		String query = "INSERT INTO hoadon(idNhanVien,idban,trangThaiThanhToan,ngayLapHoaDon,ghiChu) VALUES(?,?,?,?,?)";
		
		try {
			pst = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			pst.setInt(1, Item.getId_staff());
			pst.setInt(2, Item.getId_table());
			pst.setInt(3, Item.getStatus_pay());
			pst.setTimestamp(4, Item.getDate_single_up());
			pst.setString(5, Item.getNote());
			pst.executeUpdate();
			ResultSet rsk = pst.getGeneratedKeys();
			while(rsk.next()){
				result = rsk.getInt(1);
			}
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

	public int editItem(Unit Item) {
		conn = lb.getConnectMySQL();
		int result =0;
		String query = "UPDATE  donvitinh SET tenDonViTinh= ? WHERE id =? LIMIT 1";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1,Item.getName());
			pst.setInt(2, Item.getId_unit());
			
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

	public Unit getItemByID(int Id) {
		Unit objItem = null;
		conn = lb.getConnectMySQL();
		
		String query = "SELECT * FROM donvitinh WHERE id = ? LIMIT 1";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1,Id );
			rs = pst.executeQuery();
			if(rs.next()){
				objItem =  new Unit(rs.getInt("id"), rs.getString("tenDonViTinh"));
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
		String query = "DELETE FROM  donvitinh WHERE id =? LIMIT 1";
		
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
