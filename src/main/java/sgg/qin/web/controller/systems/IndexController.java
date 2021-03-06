package sgg.qin.web.controller.systems;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baidu.ueditor.ActionEnter;
import com.baidu.ueditor.define.ActionMap;

@Controller
public class IndexController {
	

	// 访问系统首页
	@RequestMapping("/")
	public String Index() throws Exception {
		return "index2";
	}
	
	// 访问系统首页
	@RequestMapping("/2")
	public String Index2() throws Exception {
		return "index1";
	}
	
	// 资源管理首页
	@RequiresPermissions("menu:menu")
	@RequestMapping("/resourceIndext")
	public String resourceIndext() {
		return "sys/resourceIndext";
	}

	// 角色管理首页
	@RequiresPermissions("role:menu")
	@RequestMapping("/roleIndext")
	public String roleIndext() {
		//return "sys/roleIndext";
		return "sys/indext";
	}

	// 用户管理管理首页
	@RequiresPermissions("user:menu")
	@RequestMapping("/userIndext")
	public String userIndext() {
		return "sys/userIndext";
	}
	

	//数据校验
	@RequiresPermissions("dataValidation:menu")
	@RequestMapping("/dataValidationIndext")
	public String dataValidationIndex() {
		return "others/dataValidationIndext";
	}
	
	//自定义类型转换器
	@RequiresPermissions("conversionService:menu")
	@RequestMapping("/conversionServiceIndext")
	public String conversionServiceIndext() {
		return "others/conversionServiceIndext";
	}
	
	
	//数据格式化
	@RequiresPermissions("formatting:menu")
	@RequestMapping("/formattingIndex")
	public String formattingIndex() {
		return "others/formattingIndex";
	}
	
	//自定义视图解析器与视图
	@RequiresPermissions("view:menu")
	@RequestMapping("/viewIndext")
	public String viewIndext() {
		//重定向到/view/img
		return "redirect:/views/img/wanglikun";
	}
	
	//自定义参数解析器
	@RequiresPermissions("argumentResolver:menu")
	@RequestMapping("/argumentResolverIndext")
	public String argumentResolverIndext() {
		return "redirect:/targumentResolver/dept";
	}
	
	
	//国际化
	@RequiresPermissions("i18n:menu")
	@RequestMapping("/i18nIndext")
	public String i18nIndext() {
		//重定向到/i18n/show
		return "redirect:/i18n/show";
	}
	
	//消息转换器
	@RequiresPermissions("messageConverter:menu")
	@RequestMapping("/messageConverterIndex")
	public String messageConverterIndex() {
		return "others/messageConverterIndex";
	}

	

}
