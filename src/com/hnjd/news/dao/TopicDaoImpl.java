package com.hnjd.news.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hnjd.news.entity.Topic;

public class TopicDaoImpl extends BaseDao implements TopicDao{

	@Override
	public int addTopic(Topic topic) throws SQLException {
		String sql = "insert into topic (tname) values (?)";
		int result = excuteUpdate(sql , topic.getTname());
		return result;
	}

	@Override
	public List<Topic> getAllTopic() throws SQLException {
		List<Topic> topicList = new ArrayList<Topic>();
		String sql = "select * from topic";
		ResultSet resultSet = excuteQuery(sql);
		while(resultSet.next()) {
			Topic topic = new Topic();
			topic.setTid(resultSet.getInt("tid"));
			topic.setTname(resultSet.getString("tname"));
			topicList.add(topic);
		}
		return topicList;
	}

}
