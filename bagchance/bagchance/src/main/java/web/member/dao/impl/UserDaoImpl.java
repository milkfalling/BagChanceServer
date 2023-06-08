package web.member.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import web.member.bean.User;
import web.member.dao.UserDao;

public class UserDaoImpl implements UserDao {
	private DataSource dataSource;

	public UserDaoImpl() {
		try {
			dataSource = (DataSource) new InitialContext().lookup("java:/comp/env/jdbc/bagchance");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int insert(User user) {
		String sql = "insert into User(MAIL, PASSWORD, NICKNAME) values(?,?,?)";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, user.getMail());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getNickname());
			return pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public User selectByMail(String mail) {
		String sql = "select * from USER where mail = ?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, mail);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					User user = new User();
					user.setId(rs.getInt("id"));
					user.setMail(rs.getString("mail"));
					user.setPhone(rs.getString("phone"));
					user.setPassword(rs.getString("password"));
					user.setNickname(rs.getString("nickname"));
					user.setGender(rs.getBoolean("gender"));
					user.setBirthday(rs.getTimestamp("birthday"));
					user.setExplore_area(rs.getString("explore_area"));
					user.setProfile_pic(rs.getBytes("profile_pic"));
					user.setProfile_intro(rs.getString("profile_intro"));
					user.setUser_status(rs.getString("user_status"));
					user.setCreate_date(rs.getTimestamp("create_date"));
					user.setLast_update_date(rs.getTimestamp("last_update_date"));
					user.setToken_google(rs.getString("token_google"));
					user.setToken_facebook(rs.getString("token_facebook"));
					return user;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<User> selectAll() {

		String sql = "select * from User";
		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			List<User> list = new ArrayList<>();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setMail(rs.getString("mail"));
				user.setPhone(rs.getString("phone"));
				user.setPassword(rs.getString("password"));
				user.setNickname(rs.getString("nickname"));
				user.setGender(rs.getBoolean("gender"));
				user.setBirthday(rs.getTimestamp("birthday"));
				user.setExplore_area(rs.getString("explore_area"));
				user.setProfile_pic(rs.getBytes("profile_pic"));
				user.setProfile_intro(rs.getString("profile_intro"));
				user.setUser_status(rs.getString("user_status"));
				user.setCreate_date(rs.getTimestamp("create_date"));
				user.setLast_update_date(rs.getTimestamp("last_update_date"));
				user.setToken_google(rs.getString("token_google"));
				user.setToken_facebook(rs.getString("token_facebook"));
				list.add(user);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int updateByUsername(User user) {
		StringBuilder sql = new StringBuilder("update User").append(" set NICKNAME = ?");
		String password = user.getPassword();
//		String profile_pic = user.getProfile_pic();
		if (password != null && !password.isEmpty()) {
			sql.append(", PASSWORD = ?");
		}
//		if (profile_pic != null && !profile_pic.isEmpty()) {
//			sql.append(", PROFILE_PIC = ?");
//		}
		sql.append(" where MAIL = ? ");
		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setString(1, user.getNickname());
			int positionOfUsername = 2;
			if (password != null && !password.isEmpty()) {
				pstmt.setString(2, user.getPassword());
				positionOfUsername++;
			}
//			if (profile_pic != null && !profile_pic.isEmpty()) {
//				pstmt.setString(3, user.getProfile_pic());
//				positionOfUsername++;
//			}
			pstmt.setString(positionOfUsername, user.getMail());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public User selectByMailAndPassword(User user) {
		String sql = "select * from USER where mail = ? and password = ?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, user.getMail());
			pstmt.setString(2, user.getPassword());
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					user = new User();
					user.setId(rs.getInt("id"));
					user.setMail(rs.getString("mail"));
					user.setPhone(rs.getString("phone"));
					user.setPassword(rs.getString("password"));
					user.setNickname(rs.getString("nickname"));
					user.setGender(rs.getBoolean("gender"));
					user.setBirthday(rs.getTimestamp("birthday"));
					user.setExplore_area(rs.getString("explore_area"));
					user.setProfile_pic(rs.getBytes("profile_pic"));
					user.setProfile_intro(rs.getString("profile_intro"));
					user.setUser_status(rs.getString("user_status"));
					user.setCreate_date(rs.getTimestamp("create_date"));
					user.setLast_update_date(rs.getTimestamp("last_update_date"));
					user.setToken_google(rs.getString("token_google"));
					user.setToken_facebook(rs.getString("token_facebook"));
					return user;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int add(User user) {
		String sql = "insert into USER(MAIL, PASSWORD, NICKNAME) values(?, ?)";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, user.getMail());
			pstmt.setString(2, user.getPassword());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

}
