package sgg.qin.service.systemt.impl;






import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sgg.qin.dao.systems.SysRolesMapper;
import sgg.qin.dao.systems.SysUserMapper;
import sgg.qin.dao.systems.SysUsersRolesMapper;
import sgg.qin.domain.systems.SysRoles;
import sgg.qin.domain.systems.SysUser;
import sgg.qin.domain.systems.SysUsersRoles;
import sgg.qin.framework.shiro.password.PasswordHelper;
import sgg.qin.service.sub.BaseServiceImpl;
import sgg.qin.service.systemt.SysUserService;
import tk.mybatis.mapper.entity.Example;

@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUser> implements SysUserService{
	
	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Autowired
	private SysUsersRolesMapper sysUsersRolesMapper;
	
	@Autowired
	private SysRolesMapper sysRolesMapper;
	
	@Autowired
	private PasswordHelper passwordHelper;

	@Override
	public List<Map<String,Object>> queryUserlistPage() {
		List<Map<String,Object>> listdata = sysUserMapper.selectAllToMap();
		
		
		for (Map<String, Object> map : listdata) {
			Integer id = (Integer) map.get("id");
			
			
			// 根据用户id获取角色id集合
			
			Example example = new Example(SysUsersRoles.class);
			example.selectProperties("roleId").or().andEqualTo("userId", id);
			List<String> sysRolesIdsList = sysUsersRolesMapper.selectByExampleToStr(example);
			
			List<String>  sysRolesNamesList=null;
			
			if (sysRolesIdsList!=null&&sysRolesIdsList.size()>0) {
				//根据角色id集合获取角色名集合
				Example example2 = new Example(SysRoles.class);
				example2.selectProperties("description").or().andIn("id", sysRolesIdsList);
				 sysRolesNamesList= sysRolesMapper.selectByExampleToStr(example2);
			}
			
			
			String sysRolesNamesStr="";
			String sysRolesidsStr="";

			for (int i = 0; i < sysRolesIdsList.size(); i++) {
				sysRolesNamesStr+=sysRolesNamesList.get(i)+",";
				sysRolesidsStr+=sysRolesIdsList.get(i)+",";
			}
			
			if (!sysRolesNamesStr.equals("")) {
				sysRolesNamesStr=sysRolesNamesStr.substring(0, sysRolesNamesStr.length()-1);
				sysRolesidsStr=sysRolesidsStr.substring(0, sysRolesidsStr.length()-1);
			}
			
			map.put("sysRolesNamesStr", sysRolesNamesStr);
			map.put("sysRolesidsStr", sysRolesidsStr);
			
		}
		return listdata;
	
	}
	
	/**
	 *  修改用户角色
	 *  
	 *  @param sysRolesids
	 *  					角色id数组
	 *  
	 *  @param userId
	 *  				用户id
	 */
	@Override
	public void updateUserRoleByUserId(Integer[] sysRolesids, Integer userId) {

		//首先删除用户所有角色
		Example example = new Example(SysUsersRoles.class);
		example.or().andEqualTo("userId", userId);
		sysUsersRolesMapper.deleteByExample(example);
		
		ArrayList<SysUsersRoles> list = new ArrayList<SysUsersRoles>();
		//在为用户添加角色
		for (Integer roleId : sysRolesids) {
			SysUsersRoles usersRoles = new SysUsersRoles();
			usersRoles.setUserId(userId);
			usersRoles.setRoleId(roleId);
			list.add(usersRoles);
		}
		
		sysUsersRolesMapper.insertList(list);
	}

	/**
	 * 删除用户
	 * 
	 * @param id
	 * 			用户id
	 */
	@Override
	public void deleteUserByid(Integer id) {
		//删除用户时先删除用户角色关联关系
		SysUsersRoles sysUsersRoles = new SysUsersRoles();
		sysUsersRoles.setUserId(id);
		sysUsersRolesMapper.delete(sysUsersRoles);
		
		//删除用户
		sysUserMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void insertUserAndRole(SysUser user, Integer[] sysRolesids) {
		//加密操作
		passwordHelper.encryptPassword(user);
		Example example = this.getExample();
		example.or().andEqualTo("username", user.getUsername());
		
		if (sysUserMapper.selectByExample(example).size()>=1) {
			throw new RuntimeException("#用户名已存在");
		}
		//添加用户
		sysUserMapper.insert(user);
		

		//添加用户角色
		ArrayList<SysUsersRoles> list = new ArrayList<SysUsersRoles>();
		//在为用户添加角色
		for (Integer roleId : sysRolesids) {
			SysUsersRoles usersRoles = new SysUsersRoles();
			usersRoles.setUserId(user.getId());
			usersRoles.setRoleId(roleId);
			list.add(usersRoles);
		}
		sysUsersRolesMapper.insertList(list);
		
	}


}
