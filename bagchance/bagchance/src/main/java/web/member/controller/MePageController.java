package web.member.controller;

import javax.servlet.http.HttpServlet;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import web.member.bean.MePageAllPost;
import web.member.service.MeService;
import web.member.service.impl.MeServiceImpl;

@WebServlet("/me/*")
public class MePageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Gson gson = new GsonBuilder().setDateFormat("yyyy/MM/dd HH:mm:ss").create();
	private static final MeService SERVICE = new MeServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 取得網址後面的字串
		String pathInfo = req.getPathInfo();
		pathInfo = pathInfo.substring(1);
		String[] pathVariables = pathInfo.split("/");
		MePageAllPost mePageAllPost = new MePageAllPost();
		mePageAllPost.setUid(pathVariables[0]);
		List<MePageAllPost> mePageAllPostList = SERVICE.findAll(mePageAllPost);
		mePageAllPostList.forEach(mpap -> {
			String storypicBase64 = Base64.getEncoder().encodeToString(mpap.getPic());
			mpap.setPicBase64(storypicBase64);
			mpap.setPic(null);
		});
		if (req.getSession(false) != null) {
			req.changeSessionId(); // ←產生新的Session ID
		} // ↓此屬性物件即用來區分是否登入中
		HttpSession session = req.getSession();// 獲取當前的會話。如果沒有現有的會話，這將創建一個新的會話。
		session.setAttribute("mePageAllPost", mePageAllPostList); // 用setAttribute存取所有資料
		resp.setCharacterEncoding("UTF-8");
//		System.out.println(gson.toJson(storyPicList));
		resp.getWriter().write(gson.toJson(mePageAllPostList));
	}
	

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String pathInfo = req.getPathInfo();
			pathInfo = pathInfo.substring(1);
			String[] pathVariables = pathInfo.split("/");
			MePageAllPost MePageAllPost = new MePageAllPost();
			MePageAllPost.setStoryId(pathVariables[0]);
			String deleteSuccess = SERVICE.deletePost(MePageAllPost);
			JsonObject respBody = new JsonObject();                   
			resp.setCharacterEncoding("UTF-8");
			String message = "刪除" + (deleteSuccess !=null ? "成功，請刷新頁面" : "失敗，請洽客服處");
			respBody.addProperty("message", message);
			resp.getWriter().write(respBody.toString());          
	}
}
