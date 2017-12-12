package sgg.qin.test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;

import sgg.qin.domain.others.Dept;
import sgg.qin.service.others.DeptService;
import sgg.qin.util.HttpClientUtil;

/**
 * 
 * @Description: spring4 泛型注入演示
 * @author: Qin YunFei
 * @date: 2017年11月24日 下午3:06:50
 * @version V1.0
 */
public class Mytest extends SupTest {

	@Autowired
	HttpClientUtil wcc;

	@Test
	public void name3() throws ClientProtocolException, URISyntaxException, IOException {

		Map<String, String> parameter = new HashMap<>();
		parameter.put("city", "深圳");
		Map<String, String> headers = new HashMap<>();
		headers.put("Authorization", "APPCODE 50c0e17fb2284312a8a4d44aa33d75fd");

		Map<String, Object> map = wcc.doHttp(RequestMethod.GET, "http", "jisutqybmf.market.alicloudapi.com", 80,
				"/weather/query", parameter, headers, new ResponseHandler<Map<String, Object>>() {
					@Override
					public Map<String, Object> handleResponse(HttpResponse response)
							throws ClientProtocolException, IOException {
						StatusLine statusLine = response.getStatusLine();
						HttpEntity entity = response.getEntity();
						if (statusLine.getStatusCode() >= 300) {
							throw new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase());
						}
						if (entity == null) {
							throw new ClientProtocolException("Response contains no content");
						}
						return JSON.parseObject(entity.getContent(), Map.class);
					}

				});
		System.out.println(map);

	}

}
