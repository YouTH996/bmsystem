package lanqiao.sanzu.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import lanqiao.sanzu.dao.UserDao;
import lanqiao.sanzu.entity.User;
import lanqiao.sanzu.util.JDBCConnection;

public class UserDaoImpl implements UserDao {
	Connection conn=null;
	PreparedStatement ps = null;
	ResultSet rs=null;

	@Override
	public User login(User user) {
		User user1=new User();
		try {
		    conn = new JDBCConnection().JDBCConn();
			ps = conn.prepareStatement("select * from users where  username=? and userpassword=?");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getUserpwd());
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				user1.setUserid(rs.getInt(1));
				user1.setUsername(rs.getString(2));
				user1.setUserpwd(rs.getString(3));
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
		return user1;
	}

	@Override
	public int registerUser(User user) {
		int n=0;
		try {
		    conn =new JDBCConnection().JDBCConn();
			ps = conn.prepareStatement("insert into users values(?,?,?)");
			ps.setInt(1, user.getUserid());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getUserpwd());
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
	public int deleteUser(User user) {
		int n=0;
		try {
		    conn = new JDBCConnection().JDBCConn();
			ps = conn.prepareStatement("delete users where username=? and userpassword=? and userid=?");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getUserpwd());
			ps.setInt(3, user.getUserid());
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
	public int updateUser(User user) {
		int n=0;
		try {
		    conn =new JDBCConnection().JDBCConn();
			ps = conn.prepareStatement("update users set username=?,userpassword=? where userid=?");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getUserpwd());
			ps.setInt(3, user.getUserid());
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
	public Vector<User> selectAllUser() {
		Vector<User> vector=new Vector<>();
		try {
		    conn = new JDBCConnection().JDBCConn();
			ps = conn.prepareStatement("select * from users order by userid");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				User user2=new User();
				user2.setUserid(rs.getInt(1));
				user2.setUsername(rs.getString(2));
				user2.setUserpwd(rs.getString(3));
				vector.add(user2);
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
	public Vector<User> selectUserByUserName(User user) {
		Vector<User> vector=new Vector<>();
		try {
		    conn =new JDBCConnection().JDBCConn();
			ps = conn.prepareStatement("select * from users where username like ? order by userid");
			ps.setString(1, "%"+user.getUsername()+"%");
			rs=ps.executeQuery();
			while(rs.next()){
				User user2=new User();
				user2.setUserid(rs.getInt(1));
				user2.setUsername(rs.getString(2));
				user2.setUserpwd(rs.getString(3));
				vector.add(user2);
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
	public int updateUserPwd(User user) {
		int n=0;
		try {
		    conn = new JDBCConnection().JDBCConn();
			ps = conn.prepareStatement("update users set username=?,userpassword=? where username=?");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getUserpwd());
			ps.setString(3, user.getUsername());
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
