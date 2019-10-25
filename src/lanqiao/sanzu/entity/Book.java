package lanqiao.sanzu.entity;

import java.sql.Date;

public class Book {
	private String bookName;   //书名
	private int bookId;   //书号
	private String author;    //作者
	private Date storageTime;    //入库时间
	private String borrow;     //是否借出
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(String bookName, int bookId, String author, Date storageTime, String borrow) {
		this.bookName = bookName;
		this.bookId = bookId;
		this.author = author;
		this.storageTime = storageTime;
		this.borrow = borrow;
	}
	
	public Book(String bookName, String author, String borrow) {
		this.bookName = bookName;
		this.author = author;
		this.borrow = borrow;
	}
	
	public Book(String bookName, int bookId, String author, String borrow) {
		this.bookName = bookName;
		this.author = author;
		this.borrow = borrow;
	}
	
	public Book(String bookName, int bookId, String author, Date storageTime) {
		this.bookName = bookName;
		this.bookId = bookId;
		this.author = author;
		this.storageTime = storageTime;
	}
	public Book(String borrow) {
		this.borrow=borrow;
	}
	public Book(int bookId, String bookName) {
		// TODO Auto-generated constructor stub
		this.bookId = bookId;
		this.bookName = bookName;
	}
	public Book(int bookId, String bookName, String borrow) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.borrow = borrow;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getStorageTime() {
		return storageTime;
	}
	public void setStorageTime(Date storageTime) {
		this.storageTime = storageTime;
	}
	public String getBorrow() {
		return borrow;
	}
	public void setBorrow(String borrow) {
		this.borrow = borrow;
	}
	
	
}
