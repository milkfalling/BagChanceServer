package web.member.service.impl;

import java.util.List;

import web.member.dao.PremiumTopupProductsDao;
import web.member.dao.impl.PremiumTopupProductsDaoImpl;
import web.member.service.PremiumTopupProductsService;
import web.member.bean.*;


public class PremiumTopupProductsServiceImpl implements PremiumTopupProductsService {

private PremiumTopupProductsDao dao;
	
	public PremiumTopupProductsServiceImpl() {
		dao = new PremiumTopupProductsDaoImpl();
	}
	
	@Override
	public List<TopupProducts> TopupProducts( ) {
		
		return dao.topupProducts();
	}

}
