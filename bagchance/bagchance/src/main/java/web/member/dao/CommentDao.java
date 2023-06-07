package web.member.dao;

import java.util.List;

import web.member.bean.Comment;

public interface CommentDao {
	List<Comment> selectStoryDetailByStoryId(Comment postdetail);

	List<Comment> selectCommentByUserId(Comment comment);
}