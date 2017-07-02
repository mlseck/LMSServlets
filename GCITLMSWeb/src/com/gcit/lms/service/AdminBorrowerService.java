package com.gcit.lms.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.gcit.lms.dao.AuthorDAO;
import com.gcit.lms.dao.BookDAO;
import com.gcit.lms.dao.BorrowerDAO;
import com.gcit.lms.entity.Book;
import com.gcit.lms.entity.Borrower;

public class AdminBorrowerService {
	ConnectionUtil cUtil = new ConnectionUtil();
	
	
	public void saveBorrower(Borrower borrower) throws SQLException{
		Connection conn = null;
		
		conn = cUtil.getConnection();
		BorrowerDAO pdao = new BorrowerDAO(conn);
		try{
			if (borrower.getCardNo() != null){
				pdao.updateBorrower(borrower);
			}
			else{
				pdao.addBorrower(borrower);
			}
			conn.commit();
		} catch(SQLException e){
			e.printStackTrace();
			conn.rollback();
		} finally{
			if(conn != null){
				conn.close();
			}
		}
	}
	
	public void deleteBorrower(Borrower borrower) throws SQLException{
		Connection conn = null;
		
		conn = cUtil.getConnection();
		BorrowerDAO pdao = new BorrowerDAO(conn);
		try {
			pdao.deleteBorrower(borrower);
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			conn.rollback();
		} finally{
			if (conn != null){
				conn.close();
			}
		}
	}
	
	public Integer getBorrowersCount() throws SQLException {
		Connection conn = null;
		conn = cUtil.getConnection();
		BorrowerDAO bodao = new BorrowerDAO(conn);
		try {
				return bodao.getBorrowersCount();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		
		return null;
	}
	
	public List<Borrower> getAllBorrowers(Integer pageNo, String searchString) throws SQLException{
		Connection conn = null;
		
		conn = cUtil.getConnection();
		BorrowerDAO bodao = new BorrowerDAO(conn);
		try {
			return bodao.readAllBorrowers(pageNo, searchString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(conn != null){
				conn.close();
			}
		}
		return null;
	}
	
}
