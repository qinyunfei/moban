package sgg.qin.web.controller.springmvc;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sgg.qin.domain.others.Dept;
import sgg.qin.service.others.DeptService;

@Controller
@RequestMapping("/restful")
public class DeptAction {

	@Autowired
	private DeptService deptService;
	
	@RequestMapping(value="dept",method=RequestMethod.GET)
	@ResponseBody
	public List<Map<String,Object>> deptList() {
		List<Map<String,Object>> list = deptService.selectAllToMap();
		return list;
	}


}
