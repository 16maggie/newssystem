package com.hnjd.news.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hnjd.news.entity.User;

public class UserDaoImpl extends BaseDao implements UserDao{

	@Override
	public int addUser(User user) throws SQLException {
		String sql = "insert into news_users (uname,upwd) values (?,?)";
		int result = excuteUpdate(sql , user.getUname(),user.getUpwd());
		return result;
	}

	@Override
	public boolean getUserByName(String userName) throws SQLException {
		String sql = "select * from news_users where uname = ?";
		ResultSet result = excuteQuery(sql , userName);
		return result.next()?true:false;
	}

	@Override
	public User getUserByNamePwd(String uname, String upwd) throws SQLException {
		String sql = "select * from news_users where uname = ? and upwd = ?";
		ResultSet resultSet = excuteQuery(sql , uname, upwd);
		User user = null;
		if(resultSet.next()) {
			user = new User();
			user.setUid(resultSet.getInt("uid"));
			user.setUname(resultSet.getString("uname"));
			user.setUpwd(resultSet.getString("upwd"));
		}
		return user;
	}

}
