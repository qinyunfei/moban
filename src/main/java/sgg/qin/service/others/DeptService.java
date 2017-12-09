package sgg.qin.service.others;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import sgg.qin.domain.others.Dept;
import sgg.qin.service.sub.BaseService;
@Validated  
public interface DeptService extends BaseService<Dept>{
	
	
	/**
	 * 测试方法级别验证
	 * @param
	 */
	@NotNull Dept getDeptByid(@NotNull @Min(value = 2,message="service我擦擦 错了吧") Integer i);

}
