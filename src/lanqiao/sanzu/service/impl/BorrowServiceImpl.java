package lanqiao.sanzu.service.impl;

import java.util.Vector;

import lanqiao.sanzu.dao.impl.BorrowDaoImpl;
import lanqiao.sanzu.entity.Borrow;
import lanqiao.sanzu.service.BorrowService;

public class BorrowServiceImpl implements BorrowService {

	@Override
	public boolean borrow(Borrow borrow) {
		int n=new BorrowDaoImpl().borrow(borrow);
		if(n>0) return true;
		return false;
	}

	@Override
	public Vector<Borrow> selectAllBorrow() {
		// TODO Auto-generated method stub
		return new BorrowDaoImpl().selectAllBorrow();
	}

	@Override
	public boolean updateBorrow(Borrow borrow) {
		int i = new BorrowDaoImpl().updateBorrow(borrow);
		if(i>0) return true;
		return false;
	}

	@Override
	public Vector<Borrow> selectBorrowByCondition(Borrow borrow) {
		// TODO Auto-generated method stub
		return new BorrowDaoImpl().selectBorrowByCondition(borrow);
	}

	@Override
	public boolean returnBook(Borrow borrow) {
		int i = new BorrowDaoImpl().returnBook(borrow);
		if(i>0) return true;
		return false;
	}

}
