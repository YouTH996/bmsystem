package lanqiao.sanzu.service.impl;

import java.util.Vector;

import lanqiao.sanzu.dao.UserDao;
import lanqiao.sanzu.dao.impl.UserDaoImpl;
import lanqiao.sanzu.entity.User;
import lanqiao.sanzu.service.UserService;

public class UserServiceImpl implements UserService{
	UserDao userdao=new UserDaoImpl();
	@Override
	public boolean login(User user) {
		User user1=userdao.login(user);
		if(user1.getUsername()==null)
			return false;
		return true;
	}
	@Override
	public boolean registerUser(User user) {
		int n=userdao.registerUser(user);
		if(n>0) return true;
		return false;
	}
	@Override
	public boolean deleteUser(User user) {
		int n=userdao.deleteUser(user);
		if(n>0) return true;
		return false;
	}
	@Override
	public boolean updateUser(User user) {
		int n=userdao.updateUser(user);
		if(n>0) return true;
		return false;
	}
	@Override
	public Vector<User> selectAllUser() {
		// TODO Auto-generated method stub
		return new UserDaoImpl().selectAllUser();
	}
	@Override
	public Vector<User> selectUserByUserName(User user) {
		// TODO Auto-generated method stub
		return new UserDaoImpl().selectUserByUserName(user);
	}
	@Override
	public boolean updateUserPwd(User user) {
		int n=userdao.updateUserPwd(user);
		if(n>0) return true;
		return false;
	}

}
