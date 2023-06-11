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
import com.google.gson.JsonObject;

import web.member.bean.Comment;
import web.member.bean.MePageAddFriend;
import web.member.bean.TopupProducts;
import web.member.service.CommentService;
import web.member.service.PremiumTopupProductsService;
import web.member.service.impl.CommentServiceImpl;
import web.member.service.impl.PremiumTopupProductsServiceImpl;

@WebServlet("/topupproducts/*")
public class PremiumTopupProductsController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	private static final Gson gson = new GsonBuilder().setDateFormat("yyyy/MM/dd HH:mm:ss").create();
	private static final PremiumTopupProductsService SERVICE = new PremiumTopupProductsServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    String pathInfo = req.getPathInfo();
//	    pathInfo = pathInfo.substring(1);
//	    String[] pathVariables = pathInfo.split("/");
//	    TopupProducts topupProducts = new TopupProducts();
//	    topupProducts.setUid(pathVariables[0]);
	    List<TopupProducts> tp = SERVICE.TopupProducts();
	    tp.forEach(tpp -> {
	        String ppBase64 = Base64.getEncoder().encodeToString(tpp.getPRODUCT_PIC());
//	        String spPrice = tpp.getPRODUCT_PRICE().toString();
	        tpp.setPpBase64(ppBase64);
	        tpp.setPRODUCT_PIC(null);
	    });
	    
	    resp.setContentType("application/json");
	    resp.setCharacterEncoding("UTF-8");
	    try (PrintWriter writer = resp.getWriter()) {
	        gson.toJson(tp, writer);
	    }
	    
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TopupProducts tp= gson.fromJson(req.getReader(), TopupProducts.class);
		System.out.println(tp.getOrder_status());
//		boolean result = SERVICE.addFriend(mpaf);
		JsonObject reqBody = new JsonObject();
//		reqBody.addProperty("successful", result);
		resp.setCharacterEncoding("UTF-8");
//		String message = (result ? "成功送出邀請" : "請再試一次");
		JsonObject respBody = new JsonObject();		
//		respBody.addProperty("message", message);
		resp.getWriter().write(respBody.toString());
	}
}
