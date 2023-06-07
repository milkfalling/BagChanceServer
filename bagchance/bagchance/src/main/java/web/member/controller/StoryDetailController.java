package web.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import web.member.bean.Story;
import web.member.service.PostDetailService;
import web.member.service.StoryDetailService;
import web.member.service.impl.PostDetailServiceImpl;
import web.member.service.impl.StoryDetailServiceImpl;

@WebServlet("/storydetail/*")
public class StoryDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Gson gson = new GsonBuilder().setDateFormat("yyyy/MM/dd HH:mm:ss").create();
	private static final StoryDetailService SERVICE = new StoryDetailServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		pathInfo = pathInfo.substring(1);
		String[] pathVariables = pathInfo.split("/");
		Story story = new Story();
		story.setUid(pathVariables[0]);
		List<Story> sl = SERVICE.selectStoryDetailByUserId(story);
		sl.forEach(slp -> {
			String slpB64 = Base64.getEncoder().encodeToString(slp.getProfile_pic());
			slp.setPpBase64(slpB64);
			slp.setProfile_pic(null);
		});
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		System.out.println("=========================="+ sl);
		try (PrintWriter writer = resp.getWriter()) {
			gson.toJson(sl, writer);

		}
	}
}