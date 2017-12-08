package sgg.qin.service.systemt;



import java.util.List;
import java.util.Map;

import sgg.qin.domain.systems.SysUser;
import sgg.qin.service.sub.BaseService;


public interface SysUserService extends BaseService<SysUser>{

	List<Map<String,Object>> queryUserlistPage();

	void updateUserRoleByUserId(Integer[] sysRolesids, Integer userId);

	void deleteUserByid(Integer id);

	void insertUserAndRole(SysUser user, Integer[] roleIds);
	
}
