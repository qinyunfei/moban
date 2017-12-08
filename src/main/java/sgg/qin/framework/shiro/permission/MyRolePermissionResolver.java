package sgg.qin.framework.shiro.permission;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.RolePermissionResolver;
import org.apache.shiro.authz.permission.WildcardPermission;
import org.springframework.beans.factory.annotation.Autowired;

import sgg.qin.service.systemt.SysResourceService;

import java.util.ArrayList;

import java.util.Collection;
import java.util.List;

/**
 * 
 * @Description: 根据角色获取对应的权限
 * @author: Qin YunFei
 * @date: 2017年10月9日 下午7:42:19
 * @version V1.0
 */
public class MyRolePermissionResolver implements RolePermissionResolver {

	@Autowired
	private SysResourceService sysResourceService;
	
	
	@Override
	public Collection<Permission> resolvePermissionsInRole(String roleString) {
		Collection<Permission> coll = new ArrayList();
		List<String> list = sysResourceService.getResourceByRid(roleString);
		for (String string : list) {
			coll.add(new WildcardPermission(string));
		}
		return coll;
	}
}
