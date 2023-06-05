package web.member.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	public List<MePageAllPost> mePageAllPost (MePageAllPost mepageallpost) {
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

}
