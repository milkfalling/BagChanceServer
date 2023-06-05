package web.member.service;

import java.util.List;

import web.member.bean.PostDetail;
import web.member.bean.StoryPic;

public interface StoryService {
	
	List<StoryPic> findAll(StoryPic storyPic);
}
