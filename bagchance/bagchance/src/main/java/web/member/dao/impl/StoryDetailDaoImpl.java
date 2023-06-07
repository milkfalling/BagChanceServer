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
import web.member.bean.Story;
import web.member.dao.StoryDetailDao;

public class StoryDetailDaoImpl implements StoryDetailDao{
	private DataSource dataSource;

	public StoryDetailDaoImpl() {
		try {
			dataSource = (DataSource) new InitialContext().lookup("java:/comp/env/jdbc/bagchance");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Story> selectStoryDetailByUserId(Story story) {
		String sql = "select sc.story_id, s.uid, s.location, s.longitude,s.latitude,s.content,s.last_update_date,u.profile_pic,nickname from story_comments sc left join story s on sc.story_id = s.id left join user u on s.uid = u.id where sc.uid=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, story.getUid());
			ResultSet rs = pstmt.executeQuery();
			List<Story> list = new ArrayList<>();
			while (rs.next()) {
				Story s = new Story();  
				s.setSid(rs.getString("story_id"));
				s.setUid(rs.getString("uid"));
				s.setLocation(rs.getString("location"));
				s.setLongitude(rs.getString("Longitude"));
				s.setLatitude(rs.getString("Latitude"));
				s.setContent(rs.getString("content"));
				s.setLast_update_date(rs.getString("Last_update_date"));
				s.setProfile_pic(rs.getBytes("Profile_pic"));
				s.setNickname(rs.getString("nickname"));
				list.add(s);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
