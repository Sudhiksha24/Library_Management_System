package com.wipro.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wipro.book.bean.AuthorBean;
import com.wipro.book.bean.Bookbean;
import com.wipro.book.util.DBUtil;

public class BookDao {
	public int createBook(Bookbean bookBean) {
	    Connection connection = DBUtil.getDBConnection();
	    String query = "INSERT INTO Book_TABLE (ISBN, Book_Name, Book_Type, Cost, Author_code) VALUES (?,?,?,?,?)";
	    try {
	        PreparedStatement ps = connection.prepareStatement(query);
	        ps.setString(1, bookBean.getIsbn());
	        ps.setString(2, bookBean.getBookName());
	        ps.setString(3, String.valueOf(bookBean.getBookType()));
	        ps.setFloat(4, bookBean.getCost());
	        ps.setInt(5, bookBean.getAuthor().getAuthorCode());
	        int row = ps.executeUpdate();
	        if (row > 0) {
	            return 1;
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return 0;
	}

	public Bookbean fetchBook(String isbn) {
		Connection connection=DBUtil.getDBConnection();
		String query="SELECT * FROM Book_TABLE WHERE ISBN=?";
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setString(1,isbn);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				Bookbean bookbean=new Bookbean();
				bookbean.setIsbn(rs.getString("ISBN"));
				bookbean.setBookName(rs.getString("Book_NAME"));
				bookbean.setBookType(rs.getString("Book_TYPE").charAt(0));
				bookbean.setCost(rs.getFloat("COST"));
			    bookbean.setAuthor(new AuthorDao().getAuthor(rs.getInt("Author_code")));
		        return bookbean;
			}
		    }catch(SQLException e) {
		    	e.printStackTrace();
		    }
		return null;
	}

}