package bo;

import java.util.ArrayList;

import bean.Luong;
import dao.LuongDao;



public class LuongBo {
	
	private static LuongBo x ;
	private LuongBo(){}
	public static LuongBo getInstance (){
		if (x==null) return (x = new LuongBo());
		return x;
	}
	LuongDao LuongDao = new LuongDao();
	
	LuongDao  Luongdao   = new LuongDao();
	
	//
	public ArrayList<Luong> getListLuong() {
		return LuongDao.getListLuong();
	}
	public ArrayList<Luong> getListLuong(int idQuan) {
		return LuongDao.getListLuong(idQuan);
	}

	public boolean addItem(Luong Luong) {
		return LuongDao.addLuong(Luong);
	}
	public boolean editItem(Luong Luong) {
		return LuongDao.editLuong(Luong);
	}
	
	public Luong getItemById(int id){
		return LuongDao.getItemByID(id);
	}
	

	
//	public Luong getItemById(int taId) {
//		
//		return LuongDao.getItemByID(taId);
//	}

	public boolean delItem(int tid) {
		if(LuongDao.delLuongByID(tid)==1)
			return true;
		else return false;
	}
}