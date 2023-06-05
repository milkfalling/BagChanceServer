package web.member.service.impl;

import java.util.List;

import web.member.bean.PostDetail;
import web.member.dao.PostDetailDao;
import web.member.dao.impl.PostDetailDaoImpl;
import web.member.service.PostDetailService;

public class PostDetailServiceImpl implements PostDetailService{

private PostDetailDao dao;
	
	public PostDetailServiceImpl() {
		dao = new PostDetailDaoImpl();
	}
	
	@Override
	public List<PostDetail> selectStoryDetailByStoryId(PostDetail postdetail){
		return dao.selectStoryDetailByStoryId(postdetail);
	}

}
