package web.member.service;

import java.util.List;

import web.member.bean.Comment;

public interface CommentService {

	List<Comment> selectStoryDetailByStoryId(Comment postdetail);
}
