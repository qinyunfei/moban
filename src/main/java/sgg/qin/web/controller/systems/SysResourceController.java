package sgg.qin.web.controller.systems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sgg.qin.domain.systems.SysResource;
import sgg.qin.domain.systems.SysUser;
import sgg.qin.framework.annotation.CacheEvict;
import sgg.qin.framework.annotation.Cacheable;
import sgg.qin.service.systemt.SysResourceService;
import sgg.qin.util.PageData;
import sgg.qin.web.controller.base.BaseController;
import tk.mybatis.mapper.entity.Example;

@Controller
@RequestMapping("/sysresource")
public class SysResourceController extends BaseController {

	@Autowired
	private SysResourceService sysResourceService;
	
	@RequestMapping(value ="/windou/{id}")
	public String windou(@PathVariable("id")Integer id,Model model) {
		
		model.addAttribute("id", id);

		
		return "windou";
	}

	// 获取桌面图标 就是资源父id等于0的资源
	@RequestMapping("/cons")
	@ResponseBody
	public List<List<Object>> cons() {
		// 获取当前登陆用户
		Subject subject = this.getSubject();
		SysUser sysUser = (SysUser) subject.getPrincipal();
		List<SysResource> list = sysResourceService.findMenus(sysUser.getUsername(), 0);
		
		List<List<Object>> resourceList = new ArrayList<List<Object>>();
		int i=0;
		for (SysResource sysResource : list) {
			List<Object> conslist=new ArrayList<>();
			conslist.add(i);
			conslist.add(sysResource.getName());
			conslist.add("windou/images/icos/emy.png");
			conslist.add(sysResource.getUrl());
			conslist.add(1250);
			conslist.add(700);
			resourceList.add(conslist);
			i++;
		}


		return resourceList;
	}

	// 获取菜单模式1
	@RequestMapping("/menus1/{id}")
	@ResponseBody
	public List<Map<String, Object>> menus1(@PathVariable("id") Integer id) {
		// 获取当前登陆用户
		Subject subject = this.getSubject();
		SysUser sysUser = (SysUser) subject.getPrincipal();
		List<SysResource> list = sysResourceService.findMenus(sysUser.getUsername(), id);
		// 因为这里使用easyui树形 所以改下数据结构
		List<Map<String, Object>> dataTree = DataTree(list);
		return dataTree;
	}

	// 获取菜单模式2
	@RequestMapping("/menus2")
	@ResponseBody
	public List<SysResource> menus2() {
		// 获取当前登陆用户
		Subject subject = this.getSubject();
		SysUser sysUser = (SysUser) subject.getPrincipal();

		List<SysResource> list = sysResourceService.findMenus(sysUser.getUsername(), 0);
		return list;
	}

	// 将数据改为easyui Tree的数据结构
	public List<Map<String, Object>> DataTree(List<SysResource> list) {
		List<Map<String, Object>> resourceList = new ArrayList<Map<String, Object>>();
		for (SysResource sysResource : list) {
			Map<String, Object> map = new HashMap<>();
			//自定义属性
			Map<String, Object> attributes = new HashMap<>();
			map.put("id", sysResource.getId());
			map.put("text", sysResource.getName());
			map.put("children", DataTree(sysResource.getChildren()));
			
			attributes.put("url", sysResource.getUrl());
			map.put("attributes", attributes);
			resourceList.add(map);
		}
		return resourceList;
	}
	
	// 获取所有资源
	@RequestMapping("/allresource")
	@ResponseBody
	//缓存资源
	@Cacheable(fieldKey = "0")
	public List<SysResource> allresource() throws Exception {
		
		List<SysResource> list=sysResourceService.listSubResourceById(0);
		return list;
	}
	
	
	//修改资源
	@RequestMapping("/updateResource")
	@ResponseBody
	//清空缓存
	@CacheEvict(key ="sgg.qin.web.controller.systems.SysResourceController.allresource",fun=true)
	public PageData<String, Object> updateResource(SysResource sysResource) throws Exception {
		sysResource.setIcon("menu-icon glyphicon glyphicon-leaf");
		sysResource.setAvailable(false);
		sysResourceService.updateByPrimaryKeySelective(sysResource);
		return this.getMsgPageData(true, "修改成功");
	}
	
	// 添加资源
	@RequestMapping("/insertResource")
	@ResponseBody
	//清空缓存
	@CacheEvict(key ="sgg.qin.web.controller.systems.SysResourceController.allresource",fun=true)
	public PageData<String, Object> insertResource(SysResource sysResource) throws Exception {
		sysResource.setIcon("menu-icon glyphicon glyphicon-leaf");
		sysResource.setAvailable(false);
		sysResource.setId(null);
		sysResourceService.insertSelective(sysResource);
		return this.getMsgPageData(true, "添加成功");
	}
	
	//删除资源
	@RequestMapping("/deleteResourceById")
	@ResponseBody
	//清空缓存
	@CacheEvict(key ="sgg.qin.web.controller.systems.SysResourceController.allresource",fun=true)
	public PageData<String, Object> deleteResourceById(int id) throws Exception {
		sysResourceService.deleteResourceById(id);
		return this.getMsgPageData(true, "删除成功");
	}

}
