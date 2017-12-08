package sgg.qin.service.systemt;

import java.util.List;
import java.util.Map;

import sgg.qin.domain.systems.SysResource;
import sgg.qin.domain.systems.SysRolesResource;
import sgg.qin.service.sub.BaseService;

public interface SysResourceService extends BaseService<SysResource> {
	/**
	 * 根据角色名获取权限字符串集合
	 * 
	 * @param rname
	 *            角色名
	 */
	List<String> getResourceByRid(String rname);



	
	/**
	 * 根据通过资源ID获取其子级资源 进行权限处理（菜单）
	 * 
	 * @param username
	 * 			用户id
	 * @param rid
	 * 			资源id
	 */
	List<SysResource> findMenus(String username, Integer rid);
	
	
	/**
	 * 根据角色id获取角色资源树
	 * 
	 * @param id
	 * 			角色id
	 */
	List<Map<String, Object>> findTree(Integer id);



	/**
	 * 修改角色资源关联关系
	 * 
	 * @param roleId
	 * 			角色id
	 * 
	 * @@param list
	 * 			角色资源关联对象
	 * 
	 */
	void updateRoleResourceByRoleId(int roleId, List<SysRolesResource> list);



	/**
	 * 获取子级资源
	 * 
	 * @param id
	 * 			资源id
	 */
	List<SysResource> listSubResourceById(Integer id);



	/**
	 * 删除资源
	 * 
	 * @param id
	 * 			资源id
	 */
	void deleteResourceById(int id);
}
