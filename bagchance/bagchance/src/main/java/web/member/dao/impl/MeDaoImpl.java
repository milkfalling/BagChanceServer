package web.member.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import web.member.bean.MePageAllPost;
import web.member.dao.MeDao;

public class MeDaoImpl implements MeDao {
	private DataSource dataSource;

	public MeDaoImpl() {
		try {
			dataSource = (DataSource) new InitialContext().lookup("java:/comp/env/jdbc/bagchance");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<MePageAllPost> mePageAllPost(MePageAllPost mepageallpost) {
		String sql = "SELECT s.uid, s.content, s.Last_update_date, s.id AS storyId, MAX(sp.pic) AS pic FROM story s LEFT JOIN story_pic sp ON s.id = sp.story_id WHERE s.uid = ? GROUP BY s.id";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, mepageallpost.getUid());
			ResultSet rs = pstmt.executeQuery();
			List<MePageAllPost> list = new ArrayList<>();
			while (rs.next()) {
				MePageAllPost mpap = new MePageAllPost();
				mpap.setUid(rs.getString("uid"));
				mpap.setContent(rs.getString("content"));
				mpap.setLast_update_date(rs.getTimestamp("Last_update_date"));
				mpap.setStoryId(rs.getString("storyId"));
				mpap.setPic(rs.getBytes("pic"));
				list.add(mpap);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String deletePost(MePageAllPost MePageAllPost) {
	    Connection conn = null;
	    try {
	        conn = dataSource.getConnection();
	        conn.setAutoCommit(false); // disable auto-commit

	        String deleteStoryPicQuery = "DELETE FROM story_pic WHERE story_id = ?";
	        PreparedStatement deleteStoryPicStmt = conn.prepareStatement(deleteStoryPicQuery);
	        deleteStoryPicStmt.setString(1, MePageAllPost.getStoryId()); // replace storyPicId with actual id
	        int d1 = deleteStoryPicStmt.executeUpdate();

	        String deleteStoryQuery = "DELETE FROM story WHERE id = ?";
	        PreparedStatement deleteStoryStmt = conn.prepareStatement(deleteStoryQuery);
	        deleteStoryStmt.setString(1, MePageAllPost.getStoryId()); // replace storyId with actual id
	        int d2 = deleteStoryStmt.executeUpdate();

	        if (d1 > 0 && d2 > 0) {
	            conn.commit(); // commit the transaction
	            conn.setAutoCommit(true); // enable auto-commit
	            return "1";
	        } else {
	            System.err.print("Transaction is being rolled back");
	            conn.rollback();
	            return null;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    } finally {
	        // Make sure to close the connection
	        if (conn != null) {
	            try {
	                conn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}

}
