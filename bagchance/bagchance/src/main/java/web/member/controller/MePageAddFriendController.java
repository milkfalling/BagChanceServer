package web.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import web.member.bean.MePageAddFriend;
import web.member.bean.User;
import web.member.service.MePageAddFriendService;
import web.member.service.impl.MePageAddFriendServiceImpl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

@WebServlet("/addFriend/*")
public class MePageAddFriendController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Gson gson = new GsonBuilder().setDateFormat("yyyy/MM/dd HH:mm:ss").create();
	private static final MePageAddFriendService SERVICE = new MePageAddFriendServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    String pathInfo = req.getPathInfo();
	    pathInfo = pathInfo.substring(1);
	    String[] pathVariables = pathInfo.split("/");
	    MePageAddFriend mpaf = new MePageAddFriend();
	    mpaf.setInviter(pathVariables[0]);
	    mpaf.setBeinvited(pathVariables[1]);
		MePageAddFriend addFriend = SERVICE.mePageAddFriend(mpaf);
	    resp.setContentType("application/json");
	    resp.setCharacterEncoding("UTF-8");
	    try (PrintWriter writer = resp.getWriter()) {
	        gson.toJson(addFriend, writer);
	    }
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MePageAddFriend mpaf= gson.fromJson(req.getReader(), MePageAddFriend.class);
		boolean result = SERVICE.addFriend(mpaf);
		JsonObject reqBody = new JsonObject();
		reqBody.addProperty("successful", result);
		resp.setCharacterEncoding("UTF-8");
		String message = (result ? "成功添加好友!去聊天吧!" : "請洽客服處");
		JsonObject respBody = new JsonObject();		
		respBody.addProperty("message", message);
		resp.getWriter().write(respBody.toString());
	}
}
