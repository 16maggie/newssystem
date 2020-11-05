package com.hnjd.news.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.hnjd.news.entity.Comment;


public class CommentsDaoImpl extends BaseDao implements CommentsDao {

	@Override
	public List<Comment> getCommentsByNid(int nid) throws SQLException {
		 String sql = "SELECT * FROM `comments` WHERE `cnid` = ?"
	                + " ORDER BY `cdate` desc";
		 List<Comment> list = new ArrayList<Comment>();
		 try {
        	ResultSet  rs = excuteQuery(sql, nid);
            while (rs.next()) {
            	Comment comment = new Comment();
                comment.setCid(rs.getInt("cid"));
                comment.setCnid(rs.getInt("cnid"));
                comment.setCauthor(rs.getString("cauthor"));
                comment.setCip(rs.getString("cip"));
                comment.setCcontent(rs.getString("ccontent"));
                comment.setCdate(rs.getTimestamp("cdate"));
                list.add(comment);
            }
	      } catch (SQLException e) {
	            e.printStackTrace();
	            throw e;
	      } 
		  return list;
	}

	@Override
	public int addComment(Comment comment) throws SQLException {
		String sql = "INSERT INTO `comments`(`CNID`, `CCONTENT`, `CDATE`," +
        		"`CIP`,`CAUTHOR`) VALUES(?, ?, ?, ?, ?)";
        Object[] params = new Object[] { comment.getCnid(),
                comment.getCcontent(), comment.getCdate(), comment.getCip(),
                comment.getCauthor() };
        int result = 0;
        try {
            result = excuteUpdate(sql, params);
        }catch (Exception e) {
			// TODO: handle exception
		}
        return result;
	}

	@Override
	public int deleteCommentsByNid(int nid) throws SQLException {
		  String sql = "DELETE FROM `comments` WHERE `CNID` = ?";
	        int result = 0;
	        try {
	            result = excuteUpdate(sql, nid);
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw e;
	        }
	        return result;
	}

	@Override
	public int deleteCommentsById(int cid) throws SQLException {
		 String sql = "DELETE FROM `comments` WHERE `CID` = ?";
	        int result = 0;
	        try {
	            result = excuteUpdate(sql, cid);
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw e;
	        }
	        return result;
	}

}
