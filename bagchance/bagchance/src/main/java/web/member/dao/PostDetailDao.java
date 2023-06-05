package web.member.dao;

import java.util.List;

import web.member.bean.PostDetail;

public interface PostDetailDao {
	
	List<PostDetail> selectPostDetailByStoryId(PostDetail postdetail);

}
