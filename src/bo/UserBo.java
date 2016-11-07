package bo;

import bean.User;
import dao.UserDao;

public class UserBo {
	UserDao userDao = new UserDao();

	public User CheckLogin(String username, String password) {
		return userDao.checkLogin(username, password);
	}

	public void setItemInStatus(int id_user) {
		 userDao.setItemStatus(id_user);
		
	}

}
