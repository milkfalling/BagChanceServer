package web.member.dao;
import web.member.bean.MePageAddFriend;

public interface MePageAddFriendDao {

	MePageAddFriend MePageAddFriend(MePageAddFriend mepageaddfriend);
	
	int addFriend(MePageAddFriend mepageaddfriend);
}
