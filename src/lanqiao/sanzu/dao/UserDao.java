package lanqiao.sanzu.dao;

import java.util.Vector;

import lanqiao.sanzu.entity.User;

public interface UserDao {
	/**
	 * 登录功能
	 * @param manager
	 * @return
	 */
	public User login(User user);
	
	/**
	 * 注册账号功能
	 */
	public int registerUser(User user);
	
	/**
	 * 删除用户账号功能
	 */
	public int deleteUser(User user);
	
	/**
	 * 修改用户密码功能
	 */
	public int updateUserPwd(User user);
	
	/**
	 * 管理员修改用户账号功能
	 */
	public int updateUser(User user);
	
	/**
	 * 查询所有账号功能
	 */
	public Vector<User> selectAllUser();
	
	/**
	 * 根据用户账号查询用户账号信息功能
	 */
	public Vector<User> selectUserByUserName(User user);
	
}
