package sgg.qin.service.systemt.impl;



import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sgg.qin.dao.systems.SysRolesMapper;
import sgg.qin.dao.systems.SysRolesResourceMapper;
import sgg.qin.dao.systems.SysUsersRolesMapper;
import sgg.qin.domain.systems.SysRoles;
import sgg.qin.domain.systems.SysRolesResource;
import sgg.qin.domain.systems.SysUsersRoles;
import sgg.qin.service.sub.BaseServiceImpl;
import sgg.qin.service.systemt.SysRolesService;
import tk.mybatis.mapper.entity.Example;
@Service
public class SysRolesServiceImpl extends BaseServiceImpl<SysRoles> implements SysRolesService {
	
	@Autowired
	private SysUsersRolesMapper sysUsersRolesMapper;
	
	@Autowired
	private SysRolesMapper sysRolesMapper;
	
	@Autowired
	private SysRolesResourceMapper sysRolesResourceMapper;
	
	@Override
	public List<String> getRolesByUid(Integer id) {
		// 根据用户id获取角色集合
		
		Example example = new Example(SysUsersRoles.class);
		example.selectProperties("roleId").or().andEqualTo("userId", id);
		List<String> list = sysUsersRolesMapper.selectByExampleToStr(example);
		//根据角色集合获取角色名集合
		Example example2 = this.getExample();
		example2.selectProperties("role").or().andIn("id", list);
		List<String> list2 = sysRolesMapper.selectByExampleToStr(example2);

	
		return list2;
	}


	@Override
	public void deleteRoleById(Integer id) {		
		//删除角色资源关联关系
		SysRolesResource sysRolesResource = new SysRolesResource();
		sysRolesResource.setRoleId(id);
		sysRolesResourceMapper.delete(sysRolesResource);
		
		//删除角色
		sysRolesMapper.deleteByPrimaryKey(id);
		
	}

	

}
