package lanqiao.sanzu.service;

import java.util.Vector;

import lanqiao.sanzu.entity.Manager;
import lanqiao.sanzu.entity.User;

public interface UserService {
	/**
	 * 登录校验功能
	 * @param manager
	 * @return
	 */
	public boolean login(User user);
	
	/**
	 * 注册账号校验功能
	 */
	public boolean registerUser(User user);
	
	/**
	 * 删除用户账号校验功能
	 */
	public boolean deleteUser(User user);
	
	/**
	 * 管理员修改用户账号校验功能
	 */
	public boolean updateUser(User user);
	
	/**
	 * 修改用户密码功能
	 */
	public boolean updateUserPwd(User user);
	
	
	/**
	 * 查询所有账号校验功能
	 */
	public Vector<User> selectAllUser();
	
	/**
	 * 根据用户账号查询用户账号信息校验功能
	 */
	public Vector<User> selectUserByUserName(User user);
	
}
