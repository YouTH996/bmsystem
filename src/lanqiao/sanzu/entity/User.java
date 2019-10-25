package lanqiao.sanzu.entity;

public class User {
	private int userid;    //用户编号
	private String username;    //用户名
	private String userpwd;    //用户密码
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public User(int userid, String username, String userpwd) {
		this.userid = userid;
		this.username = username;
		this.userpwd = userpwd;
	}
	
	
	
	public User(String username, String userpwd) {
		this.username = username;
		this.userpwd = userpwd;
	}


	public User(String username) {
		this.username = username;
	}
	
	public User(String username,int userid) {
		this.username = username;
		this.userid=userid;
	}


	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
}
