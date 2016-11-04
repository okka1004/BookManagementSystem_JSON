package com.cjon.book.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cjon.book.service.CommentService;


@WebServlet("/commentInsert")
public class CommentInsertServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("서평이 들어왕");
		
		String comment=request.getParameter("comment");
		String isbn=request.getParameter("isbn");
		String id=request.getParameter("id");
		
		
		
		String callback = request.getParameter("callback");
		
		CommentService service = new CommentService();
		boolean result = service.insertComment(isbn, id, comment);

		response.setContentType("text/plain; charset=utf8");
		PrintWriter out = response.getWriter();
		out.println(callback + "(" + result + ")");
		out.flush();
		out.close();
	}


}
