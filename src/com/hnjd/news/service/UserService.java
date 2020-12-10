package com.hnjd.news.service;

import java.sql.SQLException;

import com.hnjd.news.dao.UserDao;
import com.hnjd.news.dao.UserDaoImpl;
import com.hnjd.news.entity.User;

public class UserService {
	
	UserDao userDao = new UserDaoImpl();
	
	//�û�ע�Ṧ��
	public boolean registerUser(User user) {
		int result = 0;
		try {
			//�ж��û����Ƿ����
			boolean flag = userDao.getUserByName(user.getUname());
			if(!flag) {
				//ִ�����ݿ����Ӳ���
				result = userDao.addUser(user);
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return result>0?true:false;
	}

	
	//�û���¼
	public User userLogin(String uname , String upwd) {
		User user = null;
		try {
			user = userDao.getUserByNamePwd(uname, upwd);
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return user;
	}
	
}
