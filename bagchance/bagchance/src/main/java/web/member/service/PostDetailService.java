package web.member.service;

import java.util.List;

import web.member.bean.PostDetail;

public interface PostDetailService {
	List<PostDetail> selectStoryDetailByStoryId(PostDetail postdetail);
	
}
