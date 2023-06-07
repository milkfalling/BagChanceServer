package web.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import web.member.bean.Comment;
import web.member.bean.PostDetail;
import web.member.service.CommentService;
import web.member.service.PostDetailService;
import web.member.service.impl.CommentServiceImpl;
import web.member.service.impl.PostDetailServiceImpl;

@WebServlet("/mepagemidpostpic/*")
public class MePageMidPostPicController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Gson gson = new GsonBuilder().setDateFormat("yyyy/MM/dd HH:mm:ss").create();
	private static final PostDetailService SERVICE = new PostDetailServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    String pathInfo = req.getPathInfo();
	    pathInfo = pathInfo.substring(1);
	    String[] pathVariables = pathInfo.split("/");
	    PostDetail pd = new PostDetail();
	    pd.setSid(pathVariables[0]);
	    List<PostDetail> pdl = SERVICE.selectStoryDetailByStoryId(pd);
	    pdl.forEach(pdp -> {
	        String pdpBase64 = Base64.getEncoder().encodeToString(pdp.getPic());
	        pdp.setBase64Pic(pdpBase64);
	        pdp.setPic(null);
	    });
	    resp.setContentType("application/json");
	    resp.setCharacterEncoding("UTF-8");
	    try (PrintWriter writer = resp.getWriter()) {
	        gson.toJson(pdl, writer);
	    }
	}

}
