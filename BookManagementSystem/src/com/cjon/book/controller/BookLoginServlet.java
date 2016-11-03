package com.cjon.book.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cjon.book.service.BookService;

@WebServlet("/bookLogin")
public class BookLoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		String callback = request.getParameter("callback");

		BookService service = new BookService();		
		boolean result = service.loginBook(id, pw);
		
		if(result) {
			HttpSession session = request.getSession(true);
			session.setAttribute("id", id);
		}
				
		response.setContentType("text/plain; charset=utf8");
		PrintWriter out = response.getWriter();
		out.println(callback + "(" + result + ")");
		out.flush();
		out.close();
		
		
		
	}




}
