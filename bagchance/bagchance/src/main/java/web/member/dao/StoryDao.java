package web.member.dao;

import java.util.List;
import web.member.bean.Story;

public interface StoryDao {
		
		Story selectStroyById(Integer id);
		
		List<Story> selectAll();
		
	}
