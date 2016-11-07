package com.cjon.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.json.simple.JSONObject;

import com.cjon.book.common.DBTemplate;

public class RentDAO {

	public String detail(String id) {
		
		Connection con = DBTemplate.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String result = null;
		try {
			String sql = "select bisbn, btitle, bauthor, bimgbase64, bpublisher from book where rent=?";
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			JSONObject obj;
			
			while(rs.next()) {
				obj = new JSONObject();
				obj.put("isbn", rs.getString("bisbn"));
				obj.put("title", rs.getString("btitle"));
				obj.put("author", rs.getString("bauthor"));
				obj.put("base64", rs.getString("bimgbase64"));
				obj.put("publisher", rs.getString("bpublisher"));
				
				result = obj.toJSONString();
			}
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			DBTemplate.close(rs);
			DBTemplate.close(pstmt);
			DBTemplate.close(con);
		} 
		
		System.out.println(result);
		
		return result;
	}

	public boolean isRent(String id) {
		
		Connection con = DBTemplate.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String result = null;
		boolean myResult=false;
		
		try {
			String sql = "select bisbn from book where rent=?";
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			JSONObject obj;
			while(rs.next()) {
				obj = new JSONObject();
				obj.put("isbn", rs.getString("bisbn"));
				
				result = obj.toJSONString();
			}
			
			if(result!=null){//대여중이라면
				myResult=true;
			}
			else{//대여하지않았다면
				myResult=false;
			}
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			DBTemplate.close(rs);
			DBTemplate.close(pstmt);
			DBTemplate.close(con);
		} 
		
		System.out.println(result);
		
		return myResult;
	}



	public boolean returnBook(String id) {
		
		Connection con = DBTemplate.getConnection();
		PreparedStatement pstmt = null;
		
		boolean result = false;
		try {
		
			String sql = "update book set rent=null where rent=?";
			
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			int count = pstmt.executeUpdate();
			
			if( count == 1 ) {
				result = true;
				DBTemplate.commit(con);
			} else {
				DBTemplate.rollback(con);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			DBTemplate.close(pstmt);
			DBTemplate.close(con);
		} 
		return result;
		
		
	}

}
