package web.member.controller;

import javax.servlet.http.HttpServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import web.member.bean.Story;
import web.member.bean.User;
import web.member.service.StoryService;
import web.member.service.UserService;
import web.member.service.impl.StoryServiceImpl;
import web.member.service.impl.UserServiceImpl;

@WebServlet("/story/*")
public class StoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Gson gson = new GsonBuilder().setDateFormat("yyyy/MM/dd HH:mm:ss").create();
	private static final StoryService SERVICE = new StoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		//取得網址後面的字串
//		String pathInfo = req.getPathInfo();
//		pathInfo = pathInfo.substring(1);
//		String[] pathVariables = pathInfo.split("/");
//		
		Story story = new Story();
		List<Story> storyList = SERVICE.findAll();
		if (req.getSession(false) != null) {
			req.changeSessionId(); // ←產生新的Session ID
		} // ↓此屬性物件即用來區分是否登入中
		HttpSession session = req.getSession();// 獲取當前的會話。如果沒有現有的會話，這將創建一個新的會話。
		session.setAttribute("storyList", storyList); // 用setAttribute存取所有資料
		System.out.println(gson.toJson(storyList));
		resp.getWriter().write(gson.toJson(storyList));
	}
}
