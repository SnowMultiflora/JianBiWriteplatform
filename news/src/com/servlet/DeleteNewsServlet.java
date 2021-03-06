package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.SqlHelper;

/**
 * Servlet implementation class DeleteNewsServlet
 */
@WebServlet("/admin/DeleteNewsServlet")
public class DeleteNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteNewsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nid=request.getParameter("nid");
		if(null==nid){
			response.sendRedirect("newsInfoList.jsp");
			return;
		}
		SqlHelper sqlHelper=new SqlHelper();
		boolean b=sqlHelper.deleteNewsById(nid);
		if(b){
			response.sendRedirect("newsInfoList.jsp");
		}else{
			response.sendRedirect("deleteNewsError.jsp");
		}
		sqlHelper.destroy();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
