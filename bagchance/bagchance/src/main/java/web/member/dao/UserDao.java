package web.member.dao;

import java.util.List;
import web.member.bean.User;

public interface UserDao {
	
	int insert(User user);
	
	int updateByUsername(User user);
	
	User selectByMail(String mail);
	
	User selectByMailAndPassword(User user);
	
	List<User> selectAll();
	
	int add(User user);

}
