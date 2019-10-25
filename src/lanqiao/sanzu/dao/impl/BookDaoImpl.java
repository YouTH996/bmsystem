package lanqiao.sanzu.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import lanqiao.sanzu.dao.BookDao;
import lanqiao.sanzu.entity.Book;
import lanqiao.sanzu.entity.User;
import lanqiao.sanzu.util.JDBCConnection;

public class BookDaoImpl implements BookDao {
	Connection conn=null;
	PreparedStatement ps = null;
	ResultSet rs=null;

	@Override
	public int addBook(Book book) {
		int n=0;
		try {
		    conn =new JDBCConnection().JDBCConn();
			ps = conn.prepareStatement("insert into book values(?,?,?,?,?)");
			ps.setString(1, book.getBookName());
			ps.setInt(2, book.getBookId());
			ps.setString(3, book.getAuthor());
			ps.setDate(4, book.getStorageTime());
			ps.setString(5, book.getBorrow());
			n=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
				try {
					if(ps!=null)	ps.close();
					if(conn!=null)	conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		return n;
	}

	@Override
	public int deleteBook(Book book) {
		int n=0;
		try {
		    conn =new JDBCConnection().JDBCConn();
			ps = conn.prepareStatement("delete  book where bookname =? and bookid =? and author =? and storagetime=? and borrow =? ");
			ps.setString(1, book.getBookName());
			ps.setInt(2, book.getBookId());
			ps.setString(3, book.getAuthor());
			ps.setDate(4, book.getStorageTime());
			ps.setString(5, book.getBorrow());
			n=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
				try {
					if(ps!=null)	ps.close();
					if(conn!=null)	conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		return n;
	}

	@Override
	public int updateBook(Book book) {
		int n=0;
		try {
		    conn = new JDBCConnection().JDBCConn();
			ps = conn.prepareStatement("update book set bookname=?,bookid=? ,author=?,storagetime=?,borrow=? where bookid=?");
			ps.setString(1, book.getBookName());
			ps.setInt(2, book.getBookId());
			ps.setString(3, book.getAuthor());
			ps.setDate(4, book.getStorageTime());
			ps.setString(5, book.getBorrow());
			ps.setInt(6, book.getBookId());
			n=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
				try {
					if(ps!=null)	ps.close();
					if(conn!=null)	conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		return n;
	}

	@Override
	public Vector<Book> selectAllBook() {
		Vector<Book> vector=new Vector<>();
		try {
		    conn = new JDBCConnection().JDBCConn();
			ps = conn.prepareStatement("select * from book order by bookid");
			rs=ps.executeQuery();
			
			while(rs.next()){
				Book book2=new Book();
				book2.setBookName(rs.getString(1));
				book2.setBookId(rs.getInt(2));
				book2.setAuthor(rs.getString(3));
				book2.setStorageTime(rs.getDate(4));
				book2.setBorrow(rs.getString(5));
				vector.add(book2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
				try {
					if(rs!=null)	rs.close();
					if(ps!=null)	ps.close();
					if(conn!=null)	conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		return vector;
	}

	@Override
	public Vector<Book> selectBookByCondition(Book book) {
		Vector<Book> vector=new Vector<>();
		try {
			String sql="select * from book where 1=1";
		    conn = new JDBCConnection().JDBCConn();
		   if(!"".equals(book.getBorrow())) {
			   sql+=" and borrow='"+book.getBorrow()+"'";
		   }
		   if(!"".equals(book.getBookName())){
			   sql+=" and bookname like'%"+book.getBookName()+"%'";
		   }
		   if(0!=(book.getBookId())) {
			   sql+=" and bookid= "+book.getBookId()+"";
		   }
		   if(!"".equals(book.getAuthor())) {
			   sql+=" and author like '%"+book.getAuthor()+"%'";
		   }
		   if(null!=(book.getStorageTime())) {
			   sql+=" and storagetime=to_date('"+book.getStorageTime()+"','yyyy-mm-dd' )";
		   }
			ps = conn.prepareStatement(sql+" order by bookid");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Book book2=new Book();
				book2.setBookName(rs.getString(1));
				book2.setBookId(rs.getInt(2));
				book2.setAuthor(rs.getString(3));
				book2.setStorageTime(rs.getDate(4));
				book2.setBorrow(rs.getString(5));
				vector.add(book2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
				try {
					if(rs!=null)	rs.close();
					if(ps!=null)	ps.close();
					if(conn!=null)	conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		return vector;
	}

	@Override
	public int updateBookStatus(Book book) {
		int n=0;
		try {
		    conn = new JDBCConnection().JDBCConn();
			ps = conn.prepareStatement("update book set borrow=? where bookid=? and bookname=?");
			ps.setString(1, book.getBorrow());
			ps.setInt(2, book.getBookId());
			ps.setString(3, book.getBookName());
			n=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
				try {
					if(ps!=null)	ps.close();
					if(conn!=null)	conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		return n;
	}
	

}
