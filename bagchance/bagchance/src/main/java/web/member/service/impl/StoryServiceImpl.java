package web.member.service.impl;

import java.util.List;

import web.member.bean.Story;
import web.member.dao.StoryDao;
import web.member.dao.impl.StoryDaoImpl;
import web.member.dao.impl.UserDaoImpl;
import web.member.service.StoryService;
//商業邏輯部分
public class StoryServiceImpl implements StoryService {

	private StoryDao dao;
	
	public StoryServiceImpl() {
		dao = new StoryDaoImpl();
	}

	@Override
	public List<Story> findAll() {
//		System.out.println("==================selectAll開始執行===========================================");
		return dao.selectAll();
	}

}
