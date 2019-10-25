package lanqiao.sanzu.entity;

import java.sql.Date;

public class Borrow {
	private int userid;    
	private String username;
	private int bookid;
	private String bookname;
	private String borrowTime;    //借阅时长
	private Date borrowDate;     //借阅日期
	private Date returnDate;    //归还日期
	private Date dueDate;     //应归还日期
	private String borrowname;    //借书人姓名
	private int borrowno;      //借书编号
	
	
	public Borrow() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Borrow(int userid, String username, int bookid, String bookname, String borrowTime, Date borrowDate,
			Date returnDate, Date dueDate, String borrowname) {
		this.userid = userid;
		this.username = username;
		this.bookid = bookid;
		this.bookname = bookname;
		this.borrowTime = borrowTime;
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;
		this.dueDate = dueDate;
		this.borrowname = borrowname;
	}
	
	public Borrow(int userid, String username, int bookid, String bookname, String borrowTime, Date borrowDate,
			 Date dueDate) {
		this.userid = userid;
		this.username = username;
		this.bookid = bookid;
		this.bookname = bookname;
		this.borrowTime = borrowTime;
		this.borrowDate = borrowDate;
		this.dueDate = dueDate;
	}
	
	
	public Borrow(String username, int userid, int bookid, String bookname, Date borrowDate, String borrowTime,
			Date dueDate) {
		this.userid = userid;
		this.username = username;
		this.bookid = bookid;
		this.bookname = bookname;
		this.borrowTime = borrowTime;
		this.borrowDate = borrowDate;
		this.dueDate = dueDate;
		
	}
	public Borrow(String username, String bookname) {
		this.username = username;
		this.bookname = bookname;
	}
	public Borrow(String username) {
		this.username = username;
	}
	public Borrow(String username, int bookid, Date returnDate) {
		this.username = username;
		this.bookid = bookid;
		this.returnDate = returnDate;
	}
	public Borrow(int borrowno, String username, int bookid, Date returnDate) {
		this.borrowno=borrowno;
		this.username = username;
		this.bookid = bookid;
		this.returnDate = returnDate;
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
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getBorrowTime() {
		return borrowTime;
	}
	public void setBorrowTime(String borrowTime) {
		this.borrowTime = borrowTime;
	}
	public Date getBorrowDate() {
		return borrowDate;
	}
	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public String getBorrowname() {
		return borrowname;
	}
	public void setBorrowname(String borrowname) {
		this.borrowname = borrowname;
	}
	
	public int getBorrowno() {
		return borrowno;
	}
	public void setBorrowno(int borrowno) {
		this.borrowno = borrowno;
	}
	
}
