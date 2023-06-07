package web.member.service.impl;

import java.util.List;

import web.member.bean.MeRightPath;
import web.member.dao.MeRightPathDao;
import web.member.dao.impl.MeRightPathDaoImpl;
import web.member.service.MeRightPathService;

public class MeRightPathServiceImpl implements MeRightPathService {
	
private MeRightPathDao dao;
	
	public MeRightPathServiceImpl(){
		dao = new MeRightPathDaoImpl();
	}

	@Override
	public List<MeRightPath> findAllPath(MeRightPath meRightPath) {
		return dao.selectAllPostPath(meRightPath);
	}

	
}
