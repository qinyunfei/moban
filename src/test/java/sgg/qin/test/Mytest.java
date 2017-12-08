package sgg.qin.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import sgg.qin.dao.systems.SysResourceMapper;
import sgg.qin.dao.systems.SysRolesMapper;
import sgg.qin.dao.systems.SysUserMapper;
import sgg.qin.dao.systems.SysUsersRolesMapper;
import sgg.qin.domain.systems.SysResource;
import sgg.qin.domain.systems.SysRoles;
import sgg.qin.domain.systems.SysUser;
import sgg.qin.domain.systems.SysUsersRoles;
import sgg.qin.service.systemt.SysResourceService;
import sgg.qin.service.systemt.SysRolesService;
import tk.mybatis.mapper.entity.Example;
import sgg.qin.framework.mapper.MyMapper;

/**
 * 
 * @Description: spring4 泛型注入演示
 * @author: Qin YunFei
 * @date: 2017年11月24日 下午3:06:50
 * @version V1.0
 */
public class Mytest extends SupTest {

	@Autowired
	private SysUsersRolesMapper sysUsersRolesMapper;

	@Autowired
	private MyMapper<SysUsersRoles> mapper;

	@Test
	public void name3() {

		System.out.println(sysUsersRolesMapper == mapper);
	}

}
