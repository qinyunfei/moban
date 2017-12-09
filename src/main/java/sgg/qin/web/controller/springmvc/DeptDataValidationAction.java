package sgg.qin.web.controller.springmvc;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import sgg.qin.domain.others.Dept;
import sgg.qin.service.others.DeptService;
import sgg.qin.util.PageData;
import sgg.qin.web.controller.base.BaseController;

/**
 * 
 * @Description: 部门管理Action
 * @author: Qin YunFei
 * @date: 2017年10月14日 上午9:26:52
 * @version V1.0
 */
@Controller
@Validated  
@RequestMapping("/deptDataValidation")
public class DeptDataValidationAction extends BaseController {
	/*
	 * Spring 4.0 拥有自己独立的数据校验框架，同时支持 JSR 303 标准的校验框架。 Spring
	 * 在进行数据绑定时，可同时调用校验框架完成数据校验工作。在 Spring MVC 中，可直接通过注解驱动的方式进行数据校验 Spring 的
	 * LocalValidatorFactroyBean 既实现了 Spring 的 Validator 接口，也实现了 JSR 303 的 Validator
	 * 接口。只要在 Spring 容器中定义了一个 LocalValidatorFactoryBean，即可将其注入到需要数据校验的 Bean 中。
	 * Spring 本身并没有提供 JSR303 的实现，所以必须将 JSR303 的实现者的 jar
	 * 包放到类路径下（建议使用hibernate-validator）。 <mvc:annotation-driven/> 会默认装配好一个
	 * LocalValidatorFactoryBean，通过在处理方法的入参上标注 @Valid 注解即可让 Spring MVC
	 * 在完成数据绑定后执行数据校验的工作 在已经标注了 JSR303 注解的表单/命令对象前标注一个 @Valid，Spring MVC
	 * 框架在将请求参数绑定到该入参对象后，就会调用校验框架根据注解声明的校验规则实施校验
	 */


	
	/*
	 * maven
	 * <dependency>
	 * 		 <groupId>org.hibernate</groupId>
	 * 		<artifactId>hibernate-validator</artifactId> 
	 * 		<version>5.0.2.Final</version>
	 * </dependency>
	 */
	
	/*spring-mvc.xml
	 *     <!-- 指定自己定义的validator -->  
    <mvc:annotation-driven validator="validator"/>  
      
    <!-- 以下 validator  ConversionService 在使用 mvc:annotation-driven 会 自动注册-->  
    <bean id="validator" class="org.springframework.validation.beanvalidation.LocalValidatorFactoryBean">  
        <property name="providerClass" value="org.hibernate.validator.HibernateValidator"/>  
        <!-- 如果不加默认到 使用classpath下的 ValidationMessages.properties -->  
        <property name="validationMessageSource" ref="messageSource"/>  
    </bean>  
      
    <!-- 国际化的消息资源文件（本系统中主要用于显示/错误消息定制） -->  
	<bean id="messageSource"
		class="org.springframework.context.support.ReloadableResourceBundleMessageSource">
		<property name="basenames">
			<list>
				<!-- 在web环境中一定要定位到classpath 否则默认到当前web应用下找 -->
				
				<value>classpath:i18n</value>
				<!-- 如果有地域信息首先会找messages_Local.properties例如messages_zh_CN.properties  如果没有地域信息就找messages.properties 精确优先-->
				<value>classpath:messages</value>  
			</list>
		</property>
		<!-- 找不到消息key时false抛出异常 true不抛异常 -->
		<property name="useCodeAsDefaultMessage" value="false" />
		<!-- 指定编码 -->
		<property name="defaultEncoding" value="UTF-8" />
		<!-- 置用于缓存加载的属性文件的秒数。 -->
		<property name="cacheSeconds" value="60" />
	</bean>
	 */

	// 完整检验步骤
	/*
	 * ①使用JSR 303验证标准
	 * ②加入hibernate validator验证框架
	 * ③在SpringMVC配置文件配置验证框架
	 * ④需要在bean的属性上增加对应验证的注解
	 * ⑤在目标方法bean类型的前面增加@Valid注解 
	 */

	@Autowired
	private DeptService deptService;
	
	@RequestMapping(value = "dept/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Dept name(@PathVariable("id")  @Min(value = 2,message="action我擦擦 错")Integer id) {
		Dept dept= deptService.getDeptByid(id);
		return dept;
	}

	/**
	 * 
	 * Description : 添加部门 <br>
	 * PageDataKeys : <br>
	 * return : void
	 */
	/*
	 * @Valid 启用验证 后面是要验证的对象数据 如果不对验证结果进行处理会有异常 在验证对象后面 紧根一个BindingResult 或 Errors
	 * 对象 它们是对当前数据验证的结果（包含错误信息）的封装 这俩对象的详细使用方法请百度 下面只是简单的演示
	 * 或者通过@Validate注解标识要验证的分组
	 */
	@RequestMapping(value = "dept", method = RequestMethod.POST)
	@ResponseBody
	public PageData<String, Object> saveDept(@Valid Dept dept, BindingResult result, ModelMap map) {
		// 验证是否有错误
		boolean hasErrors = result.hasErrors();
		// 判断验证结果
		if (hasErrors) {
			System.out.println("校验发省错误了。");
			List<FieldError> errors = result.getFieldErrors();
			for (FieldError fieldError : errors) {
				System.out.println("错误的字段：" + fieldError.getField() + "，错误原因：" + fieldError.getDefaultMessage());
				// 注意这里可以使用错误代码来实现自定义错误信息国际化 有4个级别的错误代码 精确度越来越低 会以精确度的高低来匹配精确度最高的国际化
				// 国际化请参考springmvc国际化
				System.out.println("错误代码：" + Arrays.asList(fieldError.getCodes()));
			}
			// 这里最好回显错误信息 应为是json 我就不回显了 如果是转发页面可以使用spring的标签自动回显
			return this.getMsgPageData(false, "添加失败");
		} else {
			deptService.insertSelective(dept);

			return this.getMsgPageData(true, "添加成功");
		}

	};

}
