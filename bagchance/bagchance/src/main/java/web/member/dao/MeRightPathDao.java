package web.member.dao;

import java.util.List;

import web.member.bean.MeRightPath;

public interface MeRightPathDao {
	
	
	List<MeRightPath> selectAllPostPath(MeRightPath meRightPath);
}
