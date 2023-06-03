package web.member.dao;

import java.util.List;

import web.member.bean.StoryPic;

public interface StoryDao {
	
		
		List<StoryPic> selectAllStoryPicsByUserId(StoryPic storyPic);
		
	}
