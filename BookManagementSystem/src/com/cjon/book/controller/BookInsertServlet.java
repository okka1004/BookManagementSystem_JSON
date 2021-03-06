package com.cjon.book.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cjon.book.common.InsertFormat;
import com.cjon.book.service.BookService;


@WebServlet("/bookinsert")
public class BookInsertServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println(request.getParameter("imgbase64"));
		
		InsertFormat inf=new InsertFormat(request.getParameter("isbn"), request.getParameter("title"),
									request.getParameter("author"), request.getParameter("price"),
									request.getParameter("date"), request.getParameter("page"),
									request.getParameter("translator"), request.getParameter("supplement"), 
									request.getParameter("imgurl"),	request.getParameter("publisher"),
									request.getParameter("imgbase64"));
		
		String callback = request.getParameter("callback");
		
		BookService service = new BookService();
		boolean result = service.insertBook(inf);

		response.setContentType("text/plain; charset=utf8");
		PrintWriter out = response.getWriter();
		out.println(callback + "(" + result + ")");
		out.flush();
		out.close();
	}
}
