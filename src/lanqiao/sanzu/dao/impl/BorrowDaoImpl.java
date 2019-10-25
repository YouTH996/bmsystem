package lanqiao.sanzu.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import lanqiao.sanzu.dao.BorrowDao;
import lanqiao.sanzu.entity.Book;
import lanqiao.sanzu.entity.Borrow;
import lanqiao.sanzu.entity.User;
import lanqiao.sanzu.util.JDBCConnection;

public class BorrowDaoImpl implements BorrowDao {
	Connection conn=null;
	PreparedStatement ps = null;
	ResultSet rs=null;


	@Override
	public int borrow(Borrow borrow) {
		int n=0;
		try {
		    conn = new JDBCConnection().JDBCConn();
			ps = conn.prepareStatement("insert into borrow (bookid,bookname,username,userid,borrowtime,borrowdate,duedate) values(?,?,?,?,?,?,?) ");
			ps.setInt(1, borrow.getBookid());
			ps.setString(2, borrow.getBookname());
			ps.setString(3, borrow.getUsername());
			ps.setInt(4, borrow.getUserid());
			ps.setString(5, borrow.getBorrowTime());
			ps.setDate(6, borrow.getBorrowDate());
			ps.setDate(7, borrow.getDueDate());
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
	public Vector<Borrow> selectAllBorrow() {
		Vector<Borrow> vector=new Vector<>();
		try {
		    conn = new JDBCConnection().JDBCConn();
			ps = conn.prepareStatement("select * from borrow order by borrowno");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				Borrow borrow=new Borrow();
				borrow.setBorrowno(rs.getInt(1));
				borrow.setBookid(rs.getInt(2));
				borrow.setBookname(rs.getString(3));
				borrow.setUsername(rs.getString(4));
				borrow.setUserid(rs.getInt(5));
				borrow.setBorrowTime(rs.getString(6));
				borrow.setBorrowDate(rs.getDate(7));
				borrow.setReturnDate(rs.getDate(8));
				borrow.setDueDate(rs.getDate(9));
				vector.add(borrow);
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
	public int updateBorrow(Borrow borrow) {
		int n=0;
		try {
		    conn = new JDBCConnection().JDBCConn();
			ps = conn.prepareStatement("update borrow set bookid=?,bookname=?,username=?,userid=?,borrowtime=?,borrowdate=?,returndate=?,duedate=? where borrowno=?");
			ps.setInt(1, borrow.getBookid());
			ps.setString(2, borrow.getBookname());
			ps.setString(3, borrow.getUsername());
			ps.setInt(4, borrow.getUserid());
			ps.setString(5, borrow.getBorrowTime());
			ps.setDate(6, borrow.getBorrowDate());
			ps.setDate(7, borrow.getReturnDate());
			ps.setDate(8, borrow.getDueDate());
			ps.setInt(9, borrow.getBorrowno());
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
	public Vector<Borrow> selectBorrowByCondition(Borrow borrow) {
		Vector<Borrow> vector=new Vector<>();
		try {
			String sql="select * from borrow  where 1=1";
		    conn = new JDBCConnection().JDBCConn();
		   if(null!=(borrow.getUsername())) {
			   sql+=" and username like '%"+borrow.getUsername()+"%'";
		   }
		   if(0!=(borrow.getUserid())){
			   sql+=" and userid ="+borrow.getUserid()+"";
		   }
		   if(0!=(borrow.getBookid())) {
			   sql+=" and bookid= "+borrow.getBookid()+"";
		   }
		   if(null!=(borrow.getBookname())) {
			   sql+=" and bookname like '%"+borrow.getBookname()+"%'";
		   }
		   if(null!=(borrow.getBorrowDate())) {
			   sql+=" and borrowdate=to_date('"+borrow.getBorrowDate()+"','yyyy-mm-dd' )";
		   }
		   if(null!=(borrow.getBorrowTime())) {
			   sql+=" and borrowtime='"+borrow.getBorrowTime()+"'";
		   }
			ps = conn.prepareStatement(sql+" order by borrowno");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Borrow borrow2=new Borrow();
				borrow2.setBorrowno(rs.getInt(1));
				borrow2.setBookid(rs.getInt(2));
				borrow2.setBookname(rs.getString(3));
				borrow2.setUsername(rs.getString(4));
				borrow2.setUserid(rs.getInt(5));
				borrow2.setBorrowTime(rs.getString(6));
				borrow2.setBorrowDate(rs.getDate(7));
				borrow2.setReturnDate(rs.getDate(8));
				borrow2.setDueDate(rs.getDate(9));
				vector.add(borrow2);
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
	public int returnBook(Borrow borrow) {
		int n=0;
		try {
		    conn = new JDBCConnection().JDBCConn();
			ps = conn.prepareStatement("update borrow set returndate=? where username=? and bookid=? and borrowno=?");
			ps.setDate(1, borrow.getReturnDate());
			ps.setString(2, borrow.getUsername());
			ps.setInt(3, borrow.getBookid());
			ps.setInt(4, borrow.getBorrowno());
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
