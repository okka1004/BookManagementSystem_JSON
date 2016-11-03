package com.cjon.book.common;

public class InsertFormat {

	private String isbn;
	private String title;
	private String author;
	private String price;
	private String date;
	private String page;
	private String translator;
	private String supplement;
	private String imgurl;
	private String publisher;
	private String imgbase64;
	
	public String getImgbase64() {
		return imgbase64;
	}

	public void setImgbase64(String imgbase64) {
		this.imgbase64 = imgbase64;
	}

	public InsertFormat() {
		super();
	}

	public InsertFormat(String isbn, String title, String author, String price, String date, String page,
			String translator, String supplement, String imgurl, String publisher, String imgbase64) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.price = price;
		this.date = date;
		this.page = page;
		this.translator = translator;
		this.supplement = supplement;
		this.imgurl = imgurl;
		this.publisher = publisher;
		this.imgbase64 = imgbase64;
	}
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getTranslator() {
		return translator;
	}
	public void setTranslator(String translator) {
		this.translator = translator;
	}
	public String getSupplement() {
		return supplement;
	}
	public void setSupplement(String supplement) {
		this.supplement = supplement;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
}
