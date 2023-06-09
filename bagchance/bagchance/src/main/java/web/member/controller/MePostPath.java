package web.member.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import web.member.bean.MePageAllPost;
import web.member.bean.MeRightPath;
import web.member.service.MeRightPathService;
import web.member.service.MeService;
import web.member.service.impl.MeRightPathServiceImpl;
import web.member.service.impl.MeServiceImpl;

@WebServlet("/mepostpath/*")
public class MePostPath extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private static final Gson gson = new GsonBuilder().setDateFormat("yyyy/MM/dd HH:mm:ss").create();
	private static final MeRightPathService SERVICE = new MeRightPathServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 取得網址後面的字串
		String pathInfo = req.getPathInfo();
		pathInfo = pathInfo.substring(1);
		String[] pathVariables = pathInfo.split("/");
		MeRightPath meRightPath = new MeRightPath();
		meRightPath.setUid(pathVariables[0]);
		List<MeRightPath> meRightPathList = SERVICE.findAllPath(meRightPath);
		if (req.getSession(false) != null) {
			req.changeSessionId(); // ←產生新的Session ID
		} // ↓此屬性物件即用來區分是否登入中
		HttpSession session = req.getSession();// 獲取當前的會話。如果沒有現有的會話，這將創建一個新的會話。
		session.setAttribute("MeRightPathList ", meRightPathList ); // 用setAttribute存取所有資料
		resp.setCharacterEncoding("UTF-8");
//		System.out.println(gson.toJson(storyPicList));
		resp.getWriter().write(gson.toJson(meRightPathList));
	}
}
