package web.member.service.impl;

import java.util.List;

import web.member.bean.Story;
import web.member.dao.StoryDetailDao;
import web.member.dao.impl.StoryDetailDaoImpl;
import web.member.service.StoryDetailService;

public class StoryDetailServiceImpl implements StoryDetailService {
private StoryDetailDao dao;
	
	public StoryDetailServiceImpl() {
		dao = new StoryDetailDaoImpl();
	}
	
	@Override
	public List<Story> selectStoryDetailByUserId(Story story) {
		return dao.selectStoryDetailByUserId(story);
	}

}
