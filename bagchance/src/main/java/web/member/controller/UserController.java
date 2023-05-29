package web.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import web.member.bean.User;
import web.member.service.UserService;
import web.member.service.impl.UserServiceImpl;

@WebServlet("/user/*")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Gson gson = new GsonBuilder()
	.setDateFormat("yyyy/MM/dd HH:mm:ss")
    .create();
	private static final UserService SERVICE = new UserServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user= gson.fromJson(req.getReader(), User.class);
		boolean result = SERVICE.register(user);
		JsonObject reqBody = new JsonObject();
		reqBody.addProperty("successful", result);
		String message = "註冊" + (result ? "成功" : "失敗");
		JsonObject respBody = new JsonObject();		
		respBody.addProperty("message", message);
		resp.getWriter().write(respBody.toString());
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//取得網址後面的字串
		String pathInfo = req.getPathInfo();
		pathInfo = pathInfo.substring(1);
		String[] pathVariables = pathInfo.split("/");
		
		User user = new User();
		user.setMail(pathVariables[0]);
		user.setPassword(pathVariables[1]);
		user = SERVICE.login(user);

		if (user != null) {
			if (req.getSession(false) != null) {
				req.changeSessionId(); // ←產生新的Session ID
			} // ↓此屬性物件即用來區分是否登入中
			HttpSession session = req.getSession();//獲取當前的會話。如果沒有現有的會話，這將創建一個新的會話。
			session.setAttribute("user", user); //用setAttribute存取所有資料
		}
		resp.getWriter().write(gson.toJson(user));
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = gson.fromJson(req.getReader(), User.class);
		
		//所以這一段code是在確保整個put的過程是在同一個session上面執行的說
		HttpSession session = req.getSession();
		User seUser = (User) session.getAttribute("user");
		Integer id = seUser.getId();
		user.setId(id);
		//於是經過了前面的認證後才會開始edit流程
		User result = SERVICE.edit(user);
		JsonObject respBody = new JsonObject();		
		respBody.addProperty("successful", result != null);
		String message = "儲存" + (result != null ? "成功" : "失敗");
		respBody.addProperty("message", message);
		resp.getWriter().write(respBody.toString());
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//使當前會話失效
        req.getSession().invalidate();
        HttpSession session = req.getSession(false);//false代表如果沒有新session也不會建立新的session
        JsonObject respBody = new JsonObject();	
        
        if (session != null) {
            try {
                session.getAttribute("checkValidity");
                // session有效
            } catch (IllegalStateException e) {
            	respBody.addProperty("message", "登出成功但session還在");
        		resp.getWriter().write(respBody.toString());
                // session無效
            }
        } else {
        	respBody.addProperty("message", "登出成功且session不存在");
        	resp.getWriter().write(respBody.toString());
        	//session不存在
        }
	}
	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//拿到新產生的session ID(當前登入的資料)去做寫出(顯示在編輯頁)
		User user  = (User) req.getSession().getAttribute("user");
		user.setPassword(null);//設定帶入的密碼資料為空
		resp.getWriter().write(gson.toJson(user));
	}

}
