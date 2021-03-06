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
 * Servlet implementation class InsertNewsServlet
 */
@WebServlet("/admin/InsertNewsServlet")
public class InsertNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertNewsServlet() {
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
		String author=request.getParameter("author");
		String teacher=request.getParameter("teacher");
		if(teacher==null||teacher==""){
			teacher="--";
		}
		String tex="无";
		if(ntitle==null || ndate==null || cid==null||author==null){
			response.getWriter().write("null");
	}
		String nid=UUID.randomUUID().toString();
		News news = new News();
		news.setNcontent(ncontent);
		news.setNdate(ndate);
		news.setCid(cid);
		news.setNtitle(ntitle);
		news.setNid(nid);
		news.setAuthor(author);
		news.setTeacher(teacher);
		news.setTex(tex);
		SqlHelper sqlHelper=new SqlHelper();
		boolean b = sqlHelper.insertNews(news);
		sqlHelper.destroy();
		if(!b){
			response.getWriter().write("false");
			sqlHelper.destroy();
		}else{
			response.getWriter().write("true");
		}
	}
	}
