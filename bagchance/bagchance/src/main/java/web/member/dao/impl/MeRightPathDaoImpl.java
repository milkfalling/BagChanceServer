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
import web.member.bean.MeRightPath;
import web.member.dao.MeRightPathDao;

public class MeRightPathDaoImpl implements MeRightPathDao {

	private DataSource dataSource;

	public MeRightPathDaoImpl() {
		try {
			dataSource = (DataSource) new InitialContext().lookup("java:/comp/env/jdbc/bagchance");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<MeRightPath> selectAllPostPath(MeRightPath meRightPath) {
		String sql = "SELECT s.location, s.longitude, s.latitude, s.Last_update_date, s.id AS storyId FROM story s WHERE s.uid = ? GROUP BY s.id";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, meRightPath.getUid());
			ResultSet rs = pstmt.executeQuery();
			List<MeRightPath> list = new ArrayList<>();
			while (rs.next()) {
				MeRightPath mpap = new MeRightPath();
				mpap.setLocation(rs.getString("location"));
				mpap.setLongitude(rs.getString("longitude"));
				mpap.setLatitude(rs.getString("latitude"));
				mpap.setLast_update_date(rs.getTimestamp("Last_update_date"));
				mpap.setStoryId(rs.getString("storyId"));
				list.add(mpap);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
