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
		// TODO Auto-generated method stub
		return false;
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
