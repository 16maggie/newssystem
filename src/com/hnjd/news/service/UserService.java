package com.hnjd.news.service;

import java.sql.SQLException;

import com.hnjd.news.dao.UserDao;
import com.hnjd.news.dao.UserDaoImpl;
import com.hnjd.news.entity.User;

public class UserService {
	
	UserDao userDao = new UserDaoImpl();
	
	//用户注册功能
	public boolean registerUser(User user) {
		int result = 0;
		try {
			//判断用户名是否存在
			boolean flag = userDao.getUserByName(user.getUname());
			if(!flag) {
				//执行数据库的添加操作
				result = userDao.addUser(user);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return result>0?true:false;
	}

	
	//用户登录
	public User userLogin(String uname , String upwd) {
		User user = null;
		try {
			user = userDao.getUserByNamePwd(uname, upwd);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return user;
	}
	
}
