package web.member.service.impl;

import java.util.List;

import web.member.bean.MePageAllPost;
import web.member.dao.MeDao;
import web.member.dao.impl.MeDaoImpl;
import web.member.service.MeService;
//商業邏輯部分
public class MeServiceImpl implements MeService {

	private MeDao dao;
	
	public MeServiceImpl() {
		dao = new MeDaoImpl();
	}

	@Override
	public List<MePageAllPost> findAll(MePageAllPost mepageallpost) {
		return dao.mePageAllPost(mepageallpost);
	}

	@Override
	public String deletePost(MePageAllPost mePageAllPost) {
		
		return dao.deletePost(mePageAllPost);
	}

}
