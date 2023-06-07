package web.member.service;

import java.util.List;

import web.member.bean.MePageAllPost;

public interface MeService {

	List<MePageAllPost> findAll(MePageAllPost mepageallpost);

	String deletePost(MePageAllPost MePageAllPost);
}
