package lanqiao.sanzu.dao;

import lanqiao.sanzu.entity.Manager;

public interface ManagerDao {
	/**
	 * 登录功能
	 * @param manager
	 * @return
	 */
	public Manager login(Manager manager);
	
	/**
	 * 修改密码功能
	 */
	public int UpdateMpwd(Manager manager);
}
