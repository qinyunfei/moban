package sgg.qin.service.others.impl;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import sgg.qin.dao.others.DeptMapper;
import sgg.qin.domain.others.Dept;
import sgg.qin.service.others.DeptService;
import sgg.qin.service.sub.BaseServiceImpl;

@Service
public class DeptServiceImpl extends BaseServiceImpl<Dept> implements DeptService {

	@Autowired
	private DeptMapper deptMapper;
	/**
	 * 验证 参数i不能等于null且i的最小值要大与1
	 * 		返回值不能为空
	 */
	@Override
	public Dept getDeptByid(Integer i) {
		// TODO Auto-generated method stub
		
		return deptMapper.selectByPrimaryKey(i);
	}



}
