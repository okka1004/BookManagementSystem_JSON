package com.cjon.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.cjon.book.common.DBTemplate;

public class CommentDAO {

	public boolean insert(String isbn, String id, String comment) {
		Connection con = DBTemplate.getConnection();
		PreparedStatement pstmt = null;
		
		boolean result = false;
		
		System.out.println("DAO의 isbn은?? "+isbn);
		try {

			String sql = "insert into book_comment(bisbn, mid, ctext)"
					+ "values (?, ?, ?)";
			
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, isbn);
			pstmt.setString(2, id);
			pstmt.setString(3, comment);
			
			int count = pstmt.executeUpdate();
			
			// 결과값은 영향을 받은 레코드의 수
			if( count == 1 ) {
				result = true;
				// 정상처리이기 때문에 commit
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

	public String selectAll(String isbn) {
		
		System.out.println("commentDAO이 들어왕");
		
		Connection con = DBTemplate.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String result = null;
		
		try {
			String sql = "select mid, ctext from book_comment where bisbn=?";
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, isbn);
			System.out.println(isbn);
			
			rs = pstmt.executeQuery();
			JSONArray arr = new JSONArray();
			
			while(rs.next()) {
				System.out.println("드루왕");
				
				System.out.println(rs.getString("mid")+" / " +rs.getString("ctext"));
				
				JSONObject obj = new JSONObject();
				obj.put("id", rs.getString("mid"));
				obj.put("comment", rs.getString("ctext"));
				arr.add(obj);
			}
			result = arr.toJSONString();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			DBTemplate.close(rs);
			DBTemplate.close(pstmt);
			DBTemplate.close(con);
		} 
		return result;
		
	}

	public String searchByKeyword(String text) {
		
		Connection con = DBTemplate.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String result = null;
		
		System.out.println("text : "+text);
		
		try {
			String sql = "select bc.seq, bc.mid, b.btitle, b.bauthor, b.bpublisher, bc.ctext "
							+"from book_comment bc "
							+"inner join book b "
							+"where bc.bisbn=b.bisbn "
							+"AND bc.ctext like ?";

			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, "%" + text + "%");
			
			rs = pstmt.executeQuery();
			JSONArray arr = new JSONArray();
			
			while(rs.next()) {

				JSONObject obj = new JSONObject();
				
				obj.put("seq", rs.getString("bc.seq"));
				obj.put("id", rs.getString("bc.mid"));
				obj.put("title", rs.getString("b.btitle"));
				obj.put("author", rs.getString("b.bauthor"));
				obj.put("publisher", rs.getString("b.bpublisher"));
				obj.put("comment", rs.getString("bc.ctext"));

				arr.add(obj);
			}
			result = arr.toJSONString();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			DBTemplate.close(rs);
			DBTemplate.close(pstmt);
			DBTemplate.close(con);
		} 
		return result;
	}

	public String searchById(String id) {
		
		Connection con = DBTemplate.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String result = null;
		
		System.out.println("id : "+id);
		
		try {
			String sql = "select bc.seq, bc.mid, b.btitle, b.bauthor, b.bpublisher, bc.ctext "
							+"from book_comment bc "
							+"inner join book b "
							+"where bc.bisbn=b.bisbn "
							+"AND bc.mid=?";

			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			JSONArray arr = new JSONArray();
			
			while(rs.next()) {

				JSONObject obj = new JSONObject();
				
				obj.put("seq", rs.getString("bc.seq"));
				obj.put("id", rs.getString("bc.mid"));
				obj.put("title", rs.getString("b.btitle"));
				obj.put("author", rs.getString("b.bauthor"));
				obj.put("publisher", rs.getString("b.bpublisher"));
				obj.put("comment", rs.getString("bc.ctext"));

				arr.add(obj);
			}
			result = arr.toJSONString();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			DBTemplate.close(rs);
			DBTemplate.close(pstmt);
			DBTemplate.close(con);
		} 
		return result;
	}

	public boolean delete(String seq) {
		
		Connection con = DBTemplate.getConnection();
		PreparedStatement pstmt = null;
		
		boolean result = false;
		try {
			System.out.println(seq);
			String sql = "delete from book_comment where seq=?";
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, seq);
			
			int count = pstmt.executeUpdate();
			// 결과값은 영향을 받은 레코드의 수
			if( count == 1 ) {
				result = true;
				// 정상처리이기 때문에 commit
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
