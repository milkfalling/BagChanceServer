package web.member.dao;

import java.util.List;

import web.member.bean.MePageAllPost;

public interface MeDao {
	
		
		List<MePageAllPost> mePageAllPost (MePageAllPost mepageallpost); 
		
		String deletePost(MePageAllPost MePageAllPost );
		
}
