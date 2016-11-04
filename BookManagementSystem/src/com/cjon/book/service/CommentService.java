package com.cjon.book.service;

import com.cjon.book.dao.CommentDAO;

public class CommentService {

	public boolean insertComment(String isbn, String id, String comment) {
		CommentDAO dao=new CommentDAO();
		boolean result=dao.insert(isbn, id, comment);
		
		return result;
	}

	public String selectAllComment(String isbn) {
		System.out.println("commentService에 들어왕");
		
		CommentDAO dao=new CommentDAO();
		String result=dao.selectAll(isbn);
		
		return result;
	}

	public String searchComment(String text) {
		
		CommentDAO dao=new CommentDAO();
		String result=dao.searchByKeyword(text);
		
		return result;
	}

	public String searchById(String id) {
		
		CommentDAO dao=new CommentDAO();
		String result=dao.searchById(id);
		
		return result;
	}

	public boolean deleteComment(String seq) {
		CommentDAO dao=new CommentDAO();
		boolean result=dao.delete(seq);
		
		return result;
	}

}
