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
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import web.member.bean.Comment;
import web.member.service.CommentService;
import web.member.service.impl.CommentServiceImpl;

@WebServlet("/postdetail/*")
public class CommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Gson gson = new GsonBuilder().setDateFormat("yyyy/MM/dd HH:mm:ss").create();
	private static final CommentService SERVICE = new CommentServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    String pathInfo = req.getPathInfo();
	    pathInfo = pathInfo.substring(1);
	    String[] pathVariables = pathInfo.split("/");
	    Comment pd = new Comment();
	    pd.setSid(pathVariables[0]);
	    List<Comment> pdl = SERVICE.selectStoryDetailByStoryId(pd);

	    pdl.forEach(pdupp -> {
	        String pduppBase64 = Base64.getEncoder().encodeToString(pdupp.getProfile_pic());
	        pdupp.setPpBase64(pduppBase64);
	        pdupp.setProfile_pic(null);
	    });
	    
	    
	    
	    resp.setContentType("application/json");
	    resp.setCharacterEncoding("UTF-8");
	    
	    
	    
	    try (PrintWriter writer = resp.getWriter()) {
	        gson.toJson(pdl, writer);
	    }
	}


}
