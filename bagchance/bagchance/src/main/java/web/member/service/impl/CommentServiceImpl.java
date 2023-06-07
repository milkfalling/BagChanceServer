package web.member.service.impl;

import java.util.List;

import web.member.bean.Comment;
import web.member.dao.CommentDao;
import web.member.dao.impl.CommentDaoImpl;
import web.member.service.CommentService;

public class CommentServiceImpl implements CommentService{

private CommentDao dao;
	
	public CommentServiceImpl() {
		dao = new CommentDaoImpl();
	}
	
	@Override
	public List<Comment> selectStoryDetailByStoryId(Comment postdetail){
		return dao.selectStoryDetailByStoryId(postdetail);
	}

	@Override
	public List<Comment> selectCommentByUserId(Comment comment) {
		return dao.selectCommentByUserId(comment);
	}

}
