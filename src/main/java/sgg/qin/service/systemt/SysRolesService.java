package sgg.qin.service.systemt;

import java.util.List;

import sgg.qin.domain.systems.SysRoles;
import sgg.qin.service.sub.BaseService;

public interface SysRolesService extends BaseService<SysRoles>{
	
	/**
	 * 根据用户id获取角色字符串
	 * 
	 * @param uid
	 * 			用户id
	 */
    List<String> getRolesByUid(Integer uid);

	/**
	 * 根据角色id删除角色 同时删除角色资源关联关系
	 * 
	 * @param uid
	 * 			用户id
	 */
	void deleteRoleById(Integer id);

}
