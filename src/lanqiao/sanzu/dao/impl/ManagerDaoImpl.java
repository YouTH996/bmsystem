package lanqiao.sanzu.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lanqiao.sanzu.dao.ManagerDao;
import lanqiao.sanzu.entity.Manager;
import lanqiao.sanzu.util.JDBCConnection;



public class ManagerDaoImpl implements ManagerDao {

	@Override
	public Manager login(Manager manager) {
		Manager manager1=new Manager();
		Connection conn=null;
		PreparedStatement ps = null;
		try {
			conn=new JDBCConnection().JDBCConn();
			ps = conn.prepareStatement("select * from manager where  mname=? and mpassword=?");
			ps.setString(1, manager.getMname());
			ps.setString(2, manager.getMpassword());
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				manager1.setMid(rs.getInt(1));
				manager1.setMname(rs.getString(2));
				manager1.setMpassword(rs.getString(3));
			}
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
		return manager1;
	}

	@Override
	public int UpdateMpwd(Manager manager) {
		int n=0;
		Connection conn=null;
		PreparedStatement ps = null;
		try {
		    conn = new JDBCConnection().JDBCConn();
			ps = conn.prepareStatement("update manager set mpassword=? where mname=?");
			ps.setString(1, manager.getMpassword());
			ps.setString(2, manager.getMname());
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

