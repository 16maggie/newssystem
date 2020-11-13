package com.hnjd.news.dao;

import java.sql.SQLException;
import java.util.List;

import com.hnjd.news.entity.Topic;

public interface TopicDao {
	public int addTopic(Topic topic)  throws SQLException;
	public List<Topic> getAllTopic()  throws SQLException;
}
