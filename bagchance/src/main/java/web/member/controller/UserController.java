package web.member.controller;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import web.member.bean.User;
import web.member.service.UserService;
import web.member.service.impl.UserServiceImpl;

@WebServlet("/user/*")
public class UserController extends HttpServlet {
	private static final Gson GSON = new Gson();
	private static final long serialVersionUID = 1L;
	private UserService service;

	@Override
	public void init() throws ServletException {
		service = new UserServiceImpl();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = GSON.fromJson(req.getReader(), User.class);
		boolean result = service.register(user);
		JsonObject respBody = new JsonObject();
		respBody.addProperty("successful", result);
		respBody.addProperty("message", result ? "註冊成功" : "註冊失敗");
		resp.getWriter().write(respBody.toString());
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String pathInfo = req.getPathInfo();
		if (pathInfo == null || Objects.equals(pathInfo, "/")) {
			List<User> list = service.findAll();
			resp.getWriter().write(GSON.toJson(list));
		}
	}

}
