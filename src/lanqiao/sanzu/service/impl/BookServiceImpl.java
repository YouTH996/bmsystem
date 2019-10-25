package lanqiao.sanzu.service.impl;

import java.util.Vector;

import lanqiao.sanzu.dao.BookDao;
import lanqiao.sanzu.dao.impl.BookDaoImpl;
import lanqiao.sanzu.entity.Book;
import lanqiao.sanzu.service.BookService;

public class BookServiceImpl implements BookService {
	BookDao bookdao=new BookDaoImpl(); 

	@Override
	public boolean addBook(Book book) {
		int n=bookdao.addBook(book);
		if(n>0)	return true;
		return false;
	}

	@Override
	public boolean deleteBook(Book book) {
		int n=bookdao.deleteBook(book);
		if(n>0)	return true;
		return false;
	}

	@Override
	public boolean updateBook(Book book) {
		int n=bookdao.updateBook(book);
		if(n>0)	return true;
		return false;
	}

	@Override
	public Vector<Book> selectAllBook() {
		// TODO Auto-generated method stub
		return new BookDaoImpl().selectAllBook();
	}

	@Override
	public Vector<Book> selectBookByCondition(Book book) {
		// TODO Auto-generated method stub
		return new BookDaoImpl().selectBookByCondition(book);
	}

	@Override
	public boolean updateBookStatus(Book book) {
		int n=bookdao.updateBookStatus(book);
		if(n>0)	return true;
		return false;
	}

}
