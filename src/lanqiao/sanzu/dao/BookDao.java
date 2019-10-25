package lanqiao.sanzu.dao;

import java.util.Vector;

import lanqiao.sanzu.entity.Book;
import lanqiao.sanzu.entity.User;

public interface BookDao {
	/**
	 * 添加图书功能
	 */
	public int addBook(Book book);
	
	/**
	 * 删除图书信息功能
	 */
	public int deleteBook(Book book);
	
	/**
	 * 修改图书信息功能
	 */
	public int updateBook(Book book);
	
	/**
	 * 查询图书信息功能
	 */
	public Vector<Book> selectAllBook();
	
	/**
	 * 根据条件查询图书信息功能
	 */
	public Vector<Book> selectBookByCondition(Book book);
	
	/**
	 * 借书更改图书状态功能
	 */
	public int updateBookStatus(Book book);
}
