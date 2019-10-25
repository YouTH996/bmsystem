package lanqiao.sanzu.service;

import java.util.Vector;

import lanqiao.sanzu.entity.Borrow;

public interface BorrowService {
	/**
	 * 借书校验功能
	 * @param borrow
	 * @return
	 */
	public boolean borrow(Borrow borrow);
	
	/**
	 * 修改借阅校验功能
	 */
	public boolean updateBorrow(Borrow borrow);
	
	/**
	 * 查询所有借阅信息校验功能
	 */
	public Vector<Borrow> selectAllBorrow();
	
	/**
	 * 按条件查询借阅信息校验功能
	 */
	public Vector<Borrow> selectBorrowByCondition(Borrow borrow);

	/**
	 * 还书校验功能
	 */
	public boolean returnBook(Borrow borrow);
}
