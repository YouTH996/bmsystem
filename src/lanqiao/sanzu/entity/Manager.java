package lanqiao.sanzu.entity;

public class Manager {
	private int mid;     //管理员编号
	private String mname;    //管理员用户名
	private String mpassword;   //管理员密码
	
	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Manager(int mid, String mname, String mpassword) {
		this.mid = mid;
		this.mname = mname;
		this.mpassword = mpassword;
	}
	public Manager(String mname, String mpassword) {
		this.mname = mname;
		this.mpassword = mpassword;
	}

	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMpassword() {
		return mpassword;
	}
	public void setMpassword(String mpassword) {
		this.mpassword = mpassword;
	}
	

}
