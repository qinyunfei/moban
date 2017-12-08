package sgg.qin.framework.shiro.realm;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import sgg.qin.domain.systems.SysUser;
import sgg.qin.service.systemt.SysRolesService;
import sgg.qin.service.systemt.SysUserService;



public class UserRealm extends AuthorizingRealm {
	
	@Autowired
	private SysUserService sysUserService;

	@Autowired
	private SysRolesService sysRolesService;
	//授权 设置用户角色或者权限  权限建议和角色分开使用RolePermissionResolver来做
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//获取当前系统用户
		SysUser sysUser=(SysUser) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		//设置角色
		List<String> list = sysRolesService.getRolesByUid(sysUser.getId());
		authorizationInfo.setRoles(new HashSet<String>(list));

		return authorizationInfo;
	}
	
	//认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 获取页面提交的用户帐号
		String username = (String) token.getPrincipal();
		SysUser sysUser = new SysUser();
		sysUser.setUsername(username);
		//根据用户帐号获取用户对象
		sysUser = sysUserService.selectOne(sysUser);
		if (sysUser == null) {
			throw new UnknownAccountException();// 没找到帐号异常
		} else if (sysUser.getLocked()) {
			throw new LockedAccountException(); // 帐号锁定异常
		}
		//密码的比对由SimpleAuthenticationInfo对象完成
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(sysUser, sysUser.getPassword(),
				ByteSource.Util.bytes(sysUser.getCredentialsSalt()), getName());
		
		return authenticationInfo;
	}

	

}
