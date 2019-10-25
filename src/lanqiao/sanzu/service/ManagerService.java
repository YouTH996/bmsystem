package lanqiao.sanzu.service;

import lanqiao.sanzu.entity.Manager;

public interface ManagerService {
	/**
	 * 登录校验功能
	 * @param manager
	 * @return
	 */
	public boolean login(Manager manager);
	

	/**
	 * 修改密码校验功能
	 */
	public boolean UpdateMpwd(Manager manager);
}
