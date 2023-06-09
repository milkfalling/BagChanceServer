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
import web.member.bean.PostDetail;
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
	public List<PostDetail> selectPostDetailByStoryId(PostDetail postdetail) {
		String sql = "select pic from story_pic where story_id =?"; 
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, postdetail.getSid());
			ResultSet rs = pstmt.executeQuery();
			List<PostDetail> list = new ArrayList<>();
			while (rs.next()) {
				PostDetail pd = new PostDetail();  
				pd.setPic(rs.getBytes("pic"));
				list.add(pd);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
