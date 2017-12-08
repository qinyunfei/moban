package sgg.qin.web.controller.systems;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;

import sgg.qin.domain.systems.SysUser;
import sgg.qin.service.systemt.SysUserService;
import sgg.qin.util.DateUtil;
import sgg.qin.util.PageData;
import sgg.qin.web.controller.base.BaseController;

@Controller
@RequestMapping("/user")
public class SysUserContriller extends BaseController{
	
	@Autowired
	private SysUserService sysUserService;

	//分页获取用户数据
	// 分页数据
	@RequiresPermissions("user:menu")
	@RequestMapping("queryUserlistPage")
	@ResponseBody
	public PageData<String, Object> queryUserlistPage(@RequestParam(value="rows",defaultValue="10") Integer pageSize,@RequestParam(value="page",defaultValue="10") Integer pageNum) throws Exception {
		
		PageHelper.startPage(pageNum, pageSize);
		 
		List<Map<String,Object>> list = sysUserService.queryUserlistPage();
		
		return this.getPageMsg(list);
	}
	
	
	//修改用户角色
	@RequiresPermissions("user:update")
	@RequestMapping("updateUserRolePageData")
	@ResponseBody
	public PageData<String, Object> updateUserRolePageData(@RequestParam("sysRolesidsStr")Integer[] sysRolesids,@RequestParam("id")Integer userId)throws Exception{
		
		sysUserService.updateUserRoleByUserId(sysRolesids,userId);
		
		return this.getMsgPageData(true, "修改成功");
	}
	
	
	//根据用户id删除用户
	@RequiresPermissions("user:delete")
	@RequestMapping("deleteUserById")
	@ResponseBody
	public PageData<String, Object> deleteUserById(Integer id)throws Exception{
		sysUserService.deleteUserByid(id);
		return this.getMsgPageData(true, "删除成功");
	}
	
	
	//添加用户
	@RequiresPermissions("user:create")
	@RequestMapping("insertUserPageData")
	@ResponseBody
	public PageData<String, Object> insertUserPageData(@RequestParam("rolesid")Integer[] roleIds,String username,String password)throws Exception{
		SysUser user = new SysUser();
		user.setLocked(false);
		user.setUsername(username);
		user.setPassword(password);
		
		sysUserService.insertUserAndRole(user,roleIds);
		return this.getMsgPageData(true, "添加成功");
	}
	

}
