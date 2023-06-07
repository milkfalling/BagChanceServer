package web.member.dao;

import java.util.List;

import web.member.bean.Story;

public interface StoryDetailDao {
	
	List<Story> selectStoryDetailByUserId(Story story);

}
