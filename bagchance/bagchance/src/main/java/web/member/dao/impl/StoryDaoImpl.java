package web.member.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import web.member.bean.StoryPic;
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
	public List<StoryPic> selectAllStoryPicsByUserId(StoryPic storyPic) {
//		System.out.println("==================selectAll開始執行===========================================");
		String sql = "SELECT *\r\n" + "FROM story_pic sp\r\n" + "JOIN user u ON sp.story_id = u.id\r\n"
				+ "WHERE u.id = ?"; //這個欄位要給userId
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, storyPic.getId());
			ResultSet rs = pstmt.executeQuery();
			
//			 ResultSetMetaData rsmd = rs.getMetaData();
//	            int columnCount = rsmd.getColumnCount();
//
//	            // 列印欄位名稱
//	            for (int i = 1; i <= columnCount; i++) {
//	                String columnName = rsmd.getColumnName(i);
//	                System.out.println("Column " + i + ": " + columnName);
//	            }
//	            
			List<StoryPic> list = new ArrayList<>();
			while (rs.next()) {
				StoryPic sp = new StoryPic();
				sp.setId(rs.getString("id"));
				sp.setStoryId(rs.getString("story_Id"));
				sp.setPic(rs.getByte("pic"));
				sp.setCreateDate(rs.getTimestamp("create_Date"));

				list.add(sp);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
