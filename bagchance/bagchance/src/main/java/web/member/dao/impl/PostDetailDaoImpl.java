package web.member.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import web.member.bean.PostDetail;
import web.member.bean.StoryPic;
import web.member.dao.PostDetailDao;

public class PostDetailDaoImpl implements PostDetailDao{
	
	private DataSource dataSource;

	public PostDetailDaoImpl() {
		try {
			dataSource = (DataSource) new InitialContext().lookup("java:/comp/env/jdbc/bagchance");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<PostDetail> selectStoryDetailByStoryId(PostDetail postdetail) {
		String sql = "SELECT cu.profile_pic, cu.nickname, sc.comment, sc.LAST_UPDATE_DATE FROM story_comments sc JOIN user cu ON sc.uid = cu.id WHERE sc.story_id = ?";

; //這個欄位要給storyId
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, postdetail.getSid());
			ResultSet rs = pstmt.executeQuery();
			List<PostDetail> list = new ArrayList<>();
			while (rs.next()) {
				PostDetail pd = new PostDetail();  
				pd.setProfile_pic(rs.getBytes("profile_pic"));
				pd.setNickname(rs.getString("nickname"));
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
