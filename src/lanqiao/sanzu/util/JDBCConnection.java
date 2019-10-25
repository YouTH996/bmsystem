package lanqiao.sanzu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCConnection {
	Connection conn=null;
	PreparedStatement ps = null;
	ResultSet rs=null;
	private final String driverClass = "com.mysql.jdbc.Driver";   //加载数据库驱动程序
	private final String url = "jdbc:mysql://47.103.120.104:3306/db_bms?useUnicode=true&characterEncoding=utf8";
    private final String user = "root";
    private final String pwd = "123456";
	
	public Connection JDBCConn(){
		try {
				Class.forName(driverClass);
	            conn = DriverManager.getConnection(url, user, pwd);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
			}
		return conn;
		
	}
}
