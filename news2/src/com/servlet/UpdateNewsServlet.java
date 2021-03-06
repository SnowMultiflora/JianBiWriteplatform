package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.SqlHelper;
import com.pojo.News;

/**
 * Servlet implementation class UpdateNewsServlet
 */
@WebServlet("/admin/UpdateNewsServlet")
public class UpdateNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateNewsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ntitle=request.getParameter("ntitle");
		String ndate=request.getParameter("ndate");
		String ncontent=request.getParameter("ncontent1");
		String cid=request.getParameter("cid");
		String nid=request.getParameter("nid");
		String author=request.getParameter("author");
		String teacher=request.getParameter("teacher");
		System.out.println(teacher);
		//String nid=UUID.randomUUID().toString();
		News news = new News();
		news.setNcontent(ncontent);
		news.setNdate(ndate);
		news.setCid(cid);
		news.setNtitle(ntitle);
		news.setNid(nid);
		news.setAuthor(author);
		news.setTeacher(teacher);
		SqlHelper sqlHelper=new SqlHelper();
		boolean b = sqlHelper.updateNews(news);
		sqlHelper.destroy();
		if(!b){
			response.getWriter().write("false");
			sqlHelper.destroy();
		}else{
			response.getWriter().write("true");
		}
	}

}
