package bo;

import java.util.ArrayList;

import bean.NhanVien;
import dao.NhanVienDao;



public class NhanVienBo {
	
	private static NhanVienBo x ;
	private NhanVienBo(){}
	public static NhanVienBo getInstance (){
		if (x==null) return (x = new NhanVienBo());
		return x;
	}
	NhanVienDao NhanVienDao = new NhanVienDao();
	
	NhanVienDao  NhanViendao   = new NhanVienDao();
	
	//
	public ArrayList<NhanVien> getListNhanVien() {
		return NhanVienDao.getListNhanVien();
	}

	public boolean addItem(NhanVien NhanVien) {
		return NhanVienDao.addNhanVien(NhanVien);
	}
	public boolean editItem(NhanVien NhanVien) {
		return NhanVienDao.editNhanVien(NhanVien);
	}
	
	public NhanVien getItemById(int id){
		return NhanVienDao.getItemByID(id);
	}
	

	
//	public NhanVien getItemById(int taId) {
//		
//		return NhanVienDao.getItemByID(taId);
//	}

	public boolean delItem(int tid) {
		if(NhanVienDao.delNhanVienByID(tid)==1)
			return true;
		else return false;
	}
}