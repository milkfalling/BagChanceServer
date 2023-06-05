package web.member.service.impl;

import web.member.bean.MePageAddFriend;
import web.member.dao.MePageAddFriendDao;
import web.member.dao.impl.MePageAddFriendDaoImpl;
import web.member.service.MePageAddFriendService;

public class MePageAddFriendServiceImpl implements MePageAddFriendService {

	private MePageAddFriendDao dao;
	
	public MePageAddFriendServiceImpl(){
		dao = new MePageAddFriendDaoImpl();
	}
	
	public MePageAddFriend mePageAddFriend(MePageAddFriend mepageaddfriend) {
		return dao.MePageAddFriend(mepageaddfriend);
	}

	@Override
	public Boolean addFriend(MePageAddFriend mepageaddfriend) {
		return dao.addFriend(mepageaddfriend) >= 1;
	}
}
