package sgg.qin.web.controller.springmvc;


import java.util.Map;

import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import sgg.qin.framework.annotation.UserName;
import sgg.qin.util.PageData;
import sgg.qin.web.controller.base.BaseController;

/**
 * 
 * @Description: 自定义参数解析器
 * @author: Qin YunFei
 * @date: 2017年10月14日 上午9:26:52
 * @version V1.0
 */
@Controller
@RequestMapping("/targumentResolver")
public class DepTargumentResolverAction extends BaseController{
	
	/*
	 * 参数解析器就是解析参数值并绑定到参数上
	 * 
	 * 写一个类实现org.springframework.web.method.support.HandlerMethodArgumentResolver接口
	 * 
	 * 定义自己绑定逻辑
	 * 
	 * 将自己定义的类配置到ApplicationContext-mvc.xml的<mvc:annotation-driven>中
	 * 
	 * <mvc:annotation-driven conversion-service="conversionService">
		<!-- HandlerMethodArgumentResolver(自定义的参数解析器) -->
	   <mvc:argument-resolvers>
	   		 <bean class="sgg.qin.framework.springmvc.argumentresolvers.CurrentUserNameMethodArgumentResolver" />
	   </mvc:argument-resolvers>
	</mvc:annotation-driven>
	 * 
	 * 
	 */
	

	@RequestMapping(value="dept",method=RequestMethod.GET)
	public String queryDeptlist(@UserName String userName,Map<String,String> map){
		
		map.put("name", userName);
		
		return "others/argumentResolverIndext";
	}
	
	

}
