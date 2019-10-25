package lanqiao.sanzu.service;

import java.util.Vector;

import lanqiao.sanzu.entity.Book;

public interface BookService {
	/**
	 * 添加图书校验功能
	 */
	public boolean addBook(Book book);
	
	/**
	 * 删除图书信息校验功能
	 */
	public boolean deleteBook(Book book);
	
	/**
	 * 修改图书信息校验功能
	 */
	public boolean updateBook(Book book);
	
	/**
	 * 查询图书信息校验功能
	 */
	public Vector<Book> selectAllBook();
	
	/**
	 * 根据条件查询图书信息校验功能
	 */
	public Vector<Book> selectBookByCondition(Book book);
	
	/**
	 * 借书更改图书状态校验功能
	 */
	public boolean updateBookStatus(Book book);
}
