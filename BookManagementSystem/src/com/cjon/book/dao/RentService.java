package com.cjon.book.dao;

public class RentService {

	public String currentStatus(String id) {
		RentDAO dao=new RentDAO();
		String result=dao.detail(id);
		
		return result;
	}

	public boolean isRent(String id) {
		RentDAO dao=new RentDAO();
		boolean result=dao.isRent(id);
		
		return result;
	}

	public String rentId(String isbn) {
		RentDAO dao=new RentDAO();
		String result=dao.RentId(isbn);
		
		return result;
	}

	public boolean returnBook(String id) {
		RentDAO dao=new RentDAO();
		boolean result=dao.returnBook(id);
		
		return result;
	}

}
