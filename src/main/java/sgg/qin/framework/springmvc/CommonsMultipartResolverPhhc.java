package sgg.qin.framework.springmvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.commons.CommonsMultipartResolver;

public class CommonsMultipartResolverPhhc extends CommonsMultipartResolver
{
	@Override
	public boolean isMultipart(HttpServletRequest request)
	{
		
		//UEditor有自己的上传方式 和springmvc 冲突啦  这里要判断地址放过UEditor的上传
		String url = request.getRequestURI();
		if (url != null && url.contains("static/ueditor/config"))
		{
			return false;
		}
		else
		{
			return super.isMultipart(request);
		}
	}
}
