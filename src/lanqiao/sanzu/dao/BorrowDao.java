package lanqiao.sanzu.dao;

import java.util.Vector;

import lanqiao.sanzu.entity.Borrow;

public interface BorrowDao {
	/**
	 * 借书功能
	 * @param borrow
	 * @return
	 */
	public int borrow(Borrow borrow);
	
	/**
	 * 修改借阅功能
	 */
	public int updateBorrow(Borrow borrow);
	/**
	 * 查询所有借阅信息
	 */
	public Vector<Borrow> selectAllBorrow();
	
	/**
	 * 按条件查询借阅信息
	 */
	public Vector<Borrow> selectBorrowByCondition(Borrow borrow);
	
	/**
	 * 还书功能
	 */
	public int returnBook(Borrow borrow);
}
