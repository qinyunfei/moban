package sgg.qin.dao.systems;

import java.util.List;

import sgg.qin.domain.systems.SysResource;
import sgg.qin.framework.mapper.MyMapper;
import tk.mybatis.mapper.common.Mapper;

public interface SysResourceMapper extends MyMapper<SysResource> {
	
	/**
	 * 根据角色名获取权限字符串集合
	 * 
	 * @param name
	 * 			角色名
	 */
	List<String> getResourceTostrByRname(String rname);
	
	/**
	 * 根据角色名获取权限字符串集合
	 * 
	 * @param name
	 * 			角色名
	 */
	List<String> getResourceTostrByRid(Integer id);
	
	/**
	 * 根据用户名获取权限字符串集合
	 * 
	 * @param username
	 * 				用户名
	 */
	List<String> findPermissionsByUserName(String username);
	
	
	/**
	 *  通过资源ID获取其子级资源
	 * @param id
	 * 			资源id
	 */
	List<SysResource> listSubResourceById(int id);
	

	
}