package com.hnjd.news.dao;

import java.sql.SQLException;

import com.hnjd.news.entity.User;

public interface UserDao {
	public int addUser(User user)  throws SQLException;
	
	public boolean getUserByName(String userName) throws SQLException ;
	
	public User getUserByNamePwd(String uname , String upwd)  throws SQLException ;
}
