package sgg.qin.service.systemt.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.permission.WildcardPermission;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sgg.qin.dao.systems.SysResourceMapper;
import sgg.qin.dao.systems.SysRolesResourceMapper;
import sgg.qin.domain.systems.SysResource;
import sgg.qin.domain.systems.SysRolesResource;
import sgg.qin.domain.systems.SysUser;
import sgg.qin.service.sub.BaseServiceImpl;
import sgg.qin.service.systemt.SysResourceService;
import sgg.qin.util.Tools;

@Service
public class SysResourceServiceImpl extends BaseServiceImpl<SysResource> implements SysResourceService{
	
	
	@Autowired
	private SysResourceMapper sysResourceMapper;

	@Autowired
	private SysRolesResourceMapper sysRolesResourceMapper;
	/**
	 * 根据角色名获取权限字符串集合
	 * 
	 * @param id
	 * 			角色id
	 */
	@Override
	public List<String> getResourceByRid(String rname) {
		List<String> list = sysResourceMapper.getResourceTostrByRname(rname);
		return list;
	}


	/**
	 * 根据通过资源ID获取其子级资源 进行权限处理（菜单）
	 * 
	 * @param username
	 * 			用户名
	 * @param id
	 * 			资源id
	 */
	@Override
	public List<SysResource> findMenus(String username,Integer rid){


		//获取用户权限集合
		List<String> list = sysResourceMapper.findPermissionsByUserName(username);
		
		//获取子级资源
		List<SysResource> list2 = sysResourceMapper.listSubResourceById(rid);
		return checkMenus(list,list2);
	}
	
	/**
	 * 根据权限处理资源集合 返回处理后的资源集合
	 * 
	 * @param Permissions
	 * 			用户权限集合
	 * @param listAllResource
	 * 			资源集合
	 */			
	private List<SysResource> checkMenus(List<String> Permissions, List<SysResource> listAllResource) {
		//创建一个空的资源集合用来存储处理中的资源
		List<SysResource> list = new ArrayList<SysResource>();
		for (SysResource sysResource : listAllResource) {
			//如何部署菜单类型直接跳过
			if (!sysResource.getType().equals("menu")) {
				continue;
			}
			//判断用户权限集合是否对该资源拥有权限 没有直接跳过
			if(!hasPermission(Permissions, sysResource.getPermission())) {
				continue;
			}
			//判断该资源是否拥有子级资源 有的话就处理子级资源
			if (sysResource.getChildren() != null) {
				sysResource.setChildren(checkMenus(Permissions, sysResource.getChildren()));
			}
			
			//以上判断都通过者添加到返回的list集合中
			list.add(sysResource);
		}
		
		return list;
	}
	
	/**
	 * 判断权限集合是否对该权限字符串拥有权限 没有直接跳过
	 * 
	 * @param
	 * 
	 * @param
	 */
	private boolean hasPermission(List<String> permissions, String permission_u) {
		if (Tools.isEmpty(permission_u)) {
			return true;
		}
		for (String permission : permissions) {
			WildcardPermission p1 = new WildcardPermission(permission);
			WildcardPermission p2 = new WildcardPermission(permission_u);
			if (p1.implies(p2)) {
				return true;
			}
		}
		return false;
	}


	@Override
	public List<Map<String, Object>> findTree(Integer id) {
		// TODO Auto-generated method stub
		
		//获取角色权限集合
		List<String> permissions = sysResourceMapper.getResourceTostrByRid(id);
		
		//获取子级资源
		List<SysResource> listAllResource = sysResourceMapper.listSubResourceById(0);
		return checkResource(permissions, listAllResource);
	}
	
	// 根据权限和资源获取有权限的菜单资源(递归处理)
	private List<Map<String, Object>> checkResource(List<String> permissions, List<SysResource> listAllResource) {
		List<Map<String, Object>> resourceList = new ArrayList<Map<String, Object>>();

		for (SysResource resource : listAllResource) {
			Map<String, Object> map = new HashMap<>();
			map.put("id", resource.getId());
			map.put("text", resource.getName());
			if (hasPermission(permissions, resource.getPermission())) {
				map.put("checked", true);
				map.put("ischecked", true);
			} else {
				map.put("checked", true);
				map.put("ischecked", false);
			}
			if (resource.getChildren() != null) {
				map.put("children", checkResource(permissions, resource.getChildren()));
			}
			resourceList.add(map);
		}

		return resourceList;
	}
	
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
	@Override
	public void updateRoleResourceByRoleId(int roleId, List<SysRolesResource> list) {
		// TODO Auto-generated method stub
		//先删除角色资源关联关系 
		SysRolesResource sysRolesResource = new SysRolesResource();
		sysRolesResource.setRoleId(roleId);
		sysRolesResourceMapper.delete(sysRolesResource);
		
		//添加角色资源关联关系
		if (list!=null&&list.size()>0) {
			sysRolesResourceMapper.insertList(list);
		}
		
		
	}


	@Override
	public List<SysResource> listSubResourceById(Integer id) {
		// TODO Auto-generated method stub
		//获取子级资源
		return sysResourceMapper.listSubResourceById(id);
	}


	@Override
	public void deleteResourceById(int id) {
		//删除角色资源关联关系
		SysRolesResource sysRolesResource = new SysRolesResource();
		sysRolesResource.setResourceId(id);
		sysRolesResourceMapper.delete(sysRolesResource);
		//删除资源
		sysResourceMapper.deleteByPrimaryKey(id);
	}

	

}
