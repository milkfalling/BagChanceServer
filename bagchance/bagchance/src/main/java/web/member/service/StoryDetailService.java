package web.member.service;

import java.util.List;

import web.member.bean.Story;

public interface StoryDetailService {

	List<Story> selectStoryDetailByUserId(Story story);
	
}
