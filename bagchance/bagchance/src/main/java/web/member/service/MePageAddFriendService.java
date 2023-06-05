package web.member.service;

import web.member.bean.MePageAddFriend;

public interface MePageAddFriendService {
	
	MePageAddFriend mePageAddFriend(MePageAddFriend mepageaddfriend);
	Boolean addFriend(MePageAddFriend mepageaddfriend);
}
