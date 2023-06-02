package web.member.service;

import java.util.List;

import web.member.bean.User;

public interface UserService {

	boolean register(User user);

	User edit(User user);

	User login(User user);

	List<User> findAll();

}
