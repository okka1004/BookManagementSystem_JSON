package com.cjon.book.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/bookLogout")
public class BookLogoutServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("들어와?");
		
		String callback = request.getParameter("callback");
		boolean result=false;
		
		HttpSession session=request.getSession(true);
		
		String id = (String)session.getAttribute("id");
		
		if( id == null ) {
			System.out.println("세션이 존재하지 않아");
		}
		else{
	        session.invalidate();
	        result=true;
		}

        response.setContentType("text/plain; charset=utf8");
		PrintWriter out = response.getWriter();
		out.println(callback + "(" + result + ")");
		out.flush();
		out.close();
		
	}

}
