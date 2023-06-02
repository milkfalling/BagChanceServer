package web.member.service.impl;

import java.util.List;

import web.member.bean.Story;
import web.member.dao.StoryDao;
import web.member.service.StoryService;

public class StoryServiceImpl implements StoryService {

	private StoryDao dao;

	@Override
	public List<Story> findAll(Story story) {
		return dao.selectAll();
	}

}
