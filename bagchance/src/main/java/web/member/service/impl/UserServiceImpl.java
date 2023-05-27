package web.member.service.impl;

import java.util.List;

import web.member.bean.User;
import web.member.dao.UserDao;
import web.member.dao.impl.UserDaoImpl;
import web.member.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao dao;

	public UserServiceImpl() {
		dao = new UserDaoImpl();
	}
	
	@Override
	public boolean register(User user) {
		String mail = user.getMail();
		//FIXME 有效的EMAIL地址比起限制長度應該要用別的(像是調用selectByMail)，但先測試就不管
		if (mail.length() < 10 || mail.length() > 255) {
			return false;
		}

		String password = user.getPassword();
		if (password.length() < 6 || password.length() > 12) {
			return false;
		}

		String nickname = user.getNickname();
		if (nickname.length() < 1 || nickname.length() > 20) {
			return false;
		}

		if (dao.selectByMail(mail) != null) {
			return false;
		}

		return dao.insert(user) >= 1;
	}

	@Override
	public User edit(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		return dao.selectAll();
	}

}
