package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import bean.DetailBill;
import libraryConnectDb.LibraryConnectDb;

public class DetailBillDao {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;

	LibraryConnectDb lb = new LibraryConnectDb();

	public void addItem(DetailBill obj) {
//		conn = lb.getConnectMySQL();
//		
//		String query = "INSERT INTO hoadon(idNhanVien,idban,trangThaiThanhToan,ngayLapHoaDon,ghiChu) VALUES(?,?,?,?,?)";
//		
//		try {
//			pst = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
//			pst.setInt(1, Item.getId_staff());
//			pst.setInt(2, Item.getId_table());
//			pst.setInt(3, Item.getStatus_pay());
//			pst.setTimestamp(4, Item.getDate_single_up());
//			pst.setString(5, Item.getNote());
//			pst.executeUpdate();
//			ResultSet rsk = pst.getGeneratedKeys();
//			while(rsk.next()){
//				result = rsk.getInt(1);
//			}
//			result =1;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//			try {
//				pst.close();
//				conn.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
		}
		
		
		
	

}
