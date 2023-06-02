package web.member.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import web.member.bean.Story;
import web.member.dao.StoryDao;

public class StoryDaoImpl implements StoryDao {
	private DataSource dataSource;
	
	public StoryDaoImpl() {
		try {
			dataSource = (DataSource) new InitialContext().lookup("java:/comp/env/jdbc/bagchance");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public Story selectStroyById(Integer id) {
		return null;
	}

	@Override
	public List<Story> selectAll() {
//		System.out.println("==================selectAll開始執行===========================================");
		String sql = "select * from story";
		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			List<Story> list = new ArrayList<>();
			while (rs.next()) {
				Story story = new Story();
				story.setId(rs.getString("id"));
				story.setUid(rs.getString("uid"));
				story.setLocation(rs.getString("location"));
				story.setLongitude(rs.getString("longitude"));
				story.setLatitude(rs.getString("latitude"));
				story.setContent(rs.getString("content"));
				list.add(story);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//456456456456456456564456
}
