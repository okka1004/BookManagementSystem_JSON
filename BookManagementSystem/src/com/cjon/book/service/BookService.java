package com.cjon.book.service;

import com.cjon.book.common.InsertFormat;
import com.cjon.book.dao.BookDAO;

public class BookService {

	// 리스트를 가져오는 일을 하는 method
	public String getList(String keyword) {
		// 일반적인 로직처리 나와요!!
		
		// 추가적으로 DB처리가 나올 수 있어요!
		// DB처리는 Service에서 처리는하는게 아니라..다른 객체를 이용해서
		// Database처리를 하게 되죠!!
		BookDAO dao = new BookDAO();
		String result = dao.select(keyword);	
		
		return result;
	}

	public boolean updateBook(String isbn, String title, String author, String price) {
		BookDAO dao = new BookDAO();
		boolean result = dao.update(isbn, title, author, price);	
		return result;
	}

	public boolean deleteBook(String isbn) {

		BookDAO dao=new BookDAO();
		boolean result=dao.delete(isbn);
		
		return result;
	}

	public boolean insertBook(InsertFormat inf) {
		
		BookDAO dao=new BookDAO();
		boolean result=dao.insert(inf);
		
		return result;
	}

	public String detailBook(String isbn) {
		BookDAO dao=new BookDAO();
		String result=dao.detail(isbn);
		
		return result;
	}

	public boolean joinBook(String id, String pw) {
		BookDAO dao=new BookDAO();
		boolean result=dao.join(id, pw);
		
		return result;
	}

	public boolean loginBook(String id, String pw) {
		BookDAO dao=new BookDAO();
		boolean result=dao.login(id, pw);
		
		return result;
	}

	public boolean rentBook(String isbn, String id) {
		BookDAO dao=new BookDAO();
		boolean result=dao.rent(isbn, id);
		
		return result;
	}



}












