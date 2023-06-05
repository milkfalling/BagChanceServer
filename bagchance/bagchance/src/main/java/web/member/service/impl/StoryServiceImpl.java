package web.member.service.impl;

import java.util.List;

import web.member.bean.StoryPic;
import web.member.dao.StoryDao;
import web.member.dao.impl.StoryDaoImpl;
import web.member.service.StoryService;
//商業邏輯部分
public class StoryServiceImpl implements StoryService {

	private StoryDao dao;
	
	public StoryServiceImpl() {
		dao = new StoryDaoImpl();
	}

	@Override
	public List<StoryPic> findAll(StoryPic storyPic) {
		return dao.selectAllStoryPicsByUserId(storyPic);
	}

}
