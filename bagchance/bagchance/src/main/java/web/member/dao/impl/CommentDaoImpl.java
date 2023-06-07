package web.member.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import web.member.bean.Comment;
import web.member.dao.CommentDao;

public class CommentDaoImpl implements CommentDao{
	
	private DataSource dataSource;

	public CommentDaoImpl() {
		try {
			dataSource = (DataSource) new InitialContext().lookup("java:/comp/env/jdbc/bagchance");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	//這是一個貼文下的所有留言
	@Override
	public List<Comment> selectStoryDetailByStoryId(Comment postdetail) {
		String sql = "SELECT cu.profile_pic, cu.nickname, sc.uid, sc.comment, sc.LAST_UPDATE_DATE FROM story_comments sc JOIN user cu ON sc.uid = cu.id WHERE sc.story_id = ?"; 
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, postdetail.getSid());
			ResultSet rs = pstmt.executeQuery();
			List<Comment> list = new ArrayList<>();
			while (rs.next()) {
				Comment pd = new Comment();  
				pd.setProfile_pic(rs.getBytes("profile_pic"));
				pd.setNickname(rs.getString("nickname"));
				pd.setUid(rs.getString("uid"));
				pd.setComment(rs.getString("comment"));
				pd.setLAST_UPDATE_DATE(rs.getTimestamp("LAST_UPDATE_DATE"));
				list.add(pd);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
//這是我自己留過的言
	@Override
	public List<Comment> selectCommentByUserId(Comment comment) {
		String sql = "select sc.story_id, sc.comment, sc.last_update_date,u.PROFILE_PIC,u.nickname from story_comments sc left join user u on sc.uid = u.id where uid = ? and story_id = ?"; 
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, comment.getUid());
			pstmt.setString(2, comment.getSid());
			ResultSet rs = pstmt.executeQuery();
			List<Comment> list = new ArrayList<>();
			while (rs.next()) {
				Comment pd = new Comment();  
				pd.setProfile_pic(rs.getBytes("profile_pic"));
				pd.setNickname(rs.getString("nickname"));
				pd.setSid(rs.getString("story_id"));
				pd.setComment(rs.getString("comment"));
				pd.setLAST_UPDATE_DATE(rs.getTimestamp("LAST_UPDATE_DATE"));
				list.add(pd);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
