package web.member.service;

import java.util.List;
import web.member.bean.Story;

public interface StoryService {
	
	List<Story> findAll(Story story);
	
}
