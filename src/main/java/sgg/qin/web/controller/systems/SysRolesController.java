package sgg.qin.web.controller.systems;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;

import sgg.qin.domain.systems.SysRoles;
import sgg.qin.domain.systems.SysRolesResource;
import sgg.qin.service.systemt.SysResourceService;
import sgg.qin.service.systemt.SysRolesService;
import sgg.qin.util.PageData;
import sgg.qin.web.controller.base.BaseController;
@Controller
@RequestMapping("/role")
public class SysRolesController extends BaseController{

	@Autowired
	private SysRolesService sysRolesService;
	
	@Autowired
	private SysResourceService SysResourceService;
	

	
	// 分页数据
	@RequestMapping("queryRolelistPage")
	@ResponseBody
	public PageData<String, Object> queryRolelistPage(@RequestParam("rows") Integer pageSize,@RequestParam("page") Integer pageNum) throws Exception {
		PageHelper.startPage(pageNum, pageSize);
		List<SysRoles> list = sysRolesService.selectAll();
		return this.getPageMsg(list);
	}
	
	
	//全部角色数据
	@RequestMapping("queryRoleAll")
	@ResponseBody
	public List<SysRoles> queryRoleAll()throws Exception{
		List<SysRoles> list = sysRolesService.selectAll();
		return  list;
	}
	
	//根据角色id获取角色资源树
	@RequestMapping("findResourceByRoleId")
	@ResponseBody
	public List<Map<String,Object>> findResourceByRoleId(int id) throws Exception {
		List<Map<String,Object>> list = SysResourceService.findTree(id);
		return list;
	}
	
	
	//修改角色资源关联关系
	@RequestMapping("updateRoleResourceByRoleId")
	@ResponseBody
	public PageData<String, Object> updateRoleResourceByRoleId(int roleId,String roleResourceIds) throws Exception {
		 List<SysRolesResource> list = JSON.parseArray(roleResourceIds, SysRolesResource.class);
		 SysResourceService.updateRoleResourceByRoleId(roleId,list);
		 return this.getMsgPageData(true, "修改成功");
	}
	
	
	// 添加角色
	@RequestMapping("insertRole")
	@ResponseBody
	public PageData<String, Object> insertRole(SysRoles sysRoles) throws Exception {
		sysRoles.setLocked(false);
		sysRoles.setId(null);
		sysRolesService.insert(sysRoles);
		return this.getMsgPageData(true, "添加成功");
	}
	
	
	// 修改数据
	@RequestMapping("updateRole")
	@ResponseBody
	public PageData<String, Object> updateRole(SysRoles sysRoles) throws Exception {
		sysRolesService.updateByPrimaryKeySelective(sysRoles);
		return this.getMsgPageData(true, "修改成功");
	}
	
	// 根据id删除数据
	@RequestMapping("deleteRoleById")
	@ResponseBody
	public PageData<String, Object> deleteRoleById(Integer id) throws Exception {
		sysRolesService.deleteRoleById(id);
		return this.getMsgPageData(true, "删除成功");
	}

}
