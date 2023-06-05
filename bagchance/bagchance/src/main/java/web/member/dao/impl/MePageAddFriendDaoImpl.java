package web.member.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import web.member.bean.MePageAddFriend;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import web.member.dao.MePageAddFriendDao;

public class MePageAddFriendDaoImpl implements MePageAddFriendDao {
	
	private DataSource dataSource;

	public MePageAddFriendDaoImpl() {
		try {
			dataSource = (DataSource) new InitialContext().lookup("java:/comp/env/jdbc/bagchance");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public MePageAddFriend MePageAddFriend(MePageAddFriend mepageaddfriend) {
		String sql = "SELECT status FROM chat WHERE (INVITE_UID, BE_INVITED_UID) IN ((?, ?), (?, ?)) having status =1 or status=0 ";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, mepageaddfriend.getInviter());
			pstmt.setString(2, mepageaddfriend.getBeinvited());
			pstmt.setString(3, mepageaddfriend.getBeinvited());
			pstmt.setString(4, mepageaddfriend.getInviter());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				MePageAddFriend MePageAddFriend = new MePageAddFriend();
				MePageAddFriend.setStatus(rs.getString("status"));
				return MePageAddFriend;
			}else {
				System.out.print("貓咪");
			}


		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int addFriend(MePageAddFriend mepageaddfriend) {
		String sql = "insert into chat values(default,?,?,0,default,default)";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, mepageaddfriend.getInviter());
			pstmt.setString(2, mepageaddfriend.getBeinvited());
			return pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}


}
