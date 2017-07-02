package com.gcit.lms.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.gcit.lms.dao.BookLoansDAO;
import com.gcit.lms.dao.BranchDAO;
import com.gcit.lms.entity.BookLoans;
import com.gcit.lms.entity.Borrower;
import com.gcit.lms.entity.Branch;

public class AdminLoanService {
	ConnectionUtil cUtil = new ConnectionUtil();
	
	public List<BookLoans> getLoansFromBorrower(Borrower b) throws SQLException{
		Connection conn = null;
		
		conn = cUtil.getConnection();
		BookLoansDAO bldao = new BookLoansDAO(conn);
		try {
			return bldao.getLoansByCardNo(b.getCardNo());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if(conn!=null){
				conn.close();
			}
		}
		return null;
		
	}
	
	public BookLoans getLoanByPK(Integer cardNo, Integer bookId, Integer branchId, String dateOut) throws SQLException{
		Connection conn = null;
		
		conn = cUtil.getConnection();
		BookLoansDAO bldao = new BookLoansDAO(conn);
		try {
			return bldao.getBookLoansByPK(bookId, branchId, cardNo, dateOut);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if(conn !=null){
				conn.close();
			}
		}
		return null;
	}
	public void overwriteLoan(BookLoans l) throws SQLException{
		Connection conn = null;
		
		conn = cUtil.getConnection();
		BookLoansDAO bldao = new BookLoansDAO(conn);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
		String date = l.getDueDate();
		LocalDateTime dueDate = LocalDateTime.parse(date, formatter);
		l.setDueDate(dueDate.plusDays(30).toString());
		try {
			bldao.updateBookLoans(l);
			conn.commit();
		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
		} finally{
			if(conn!=null){
				conn.close();
			}
		}		
	}
	public Integer getLoansCount() throws SQLException {
		Connection conn = null;
		conn = cUtil.getConnection();
		BookLoansDAO bldao = new BookLoansDAO(conn);
		try {
				return bldao.getBookLoansCount();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		
		return null;
	}
	
	public List<BookLoans> getAllLoans(Integer pageNo, String searchString) throws SQLException{
		Connection conn = null;
		
		conn = cUtil.getConnection();
		BookLoansDAO bldao = new BookLoansDAO(conn);
		try {
			return bldao.readAllBookLoans(pageNo, searchString);
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
