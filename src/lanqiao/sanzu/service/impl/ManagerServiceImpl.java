package lanqiao.sanzu.service.impl;

import lanqiao.sanzu.dao.ManagerDao;
import lanqiao.sanzu.dao.impl.ManagerDaoImpl;
import lanqiao.sanzu.entity.Manager;
import lanqiao.sanzu.service.ManagerService;

public class ManagerServiceImpl implements ManagerService {
	ManagerDao managerDao=new ManagerDaoImpl();
	@Override
	public boolean login(Manager manager) {
		
		Manager manager2=managerDao.login(manager);
		if(manager2.getMname()==null) return false;
		else 
			return true;
	}
	@Override
	public boolean UpdateMpwd(Manager manager) {
		int n=managerDao.UpdateMpwd(manager);
		if(n>0) return true;
		return false;
	}

}

