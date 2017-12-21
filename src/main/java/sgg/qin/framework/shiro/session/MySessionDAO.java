package sgg.qin.framework.shiro.session;

import java.io.Serializable;
import java.util.Collection;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.ValidatingSession;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;

import sgg.qin.framework.redis.RedisClientTemplate;
import sgg.qin.util.SerializeUtil;

/**
 * 
 * @Description: 
 * @author: Qin YunFei
 * @date: 2017年12月12日 下午8:23:59
 * @version V1.0
 */
/*
 * AbstractSessionDAO 不带缓存功能  redis本身就是缓存
 */
public class MySessionDAO extends AbstractSessionDAO{
	
	@Autowired
	private RedisClientTemplate redisClientTemplate;
	//创建session
	@Override
	protected Serializable doCreate(Session session) {
		//获取sessionId
		Serializable sessionId = generateSessionId(session);
		//设置session的sessionId
		 assignSessionId(session, sessionId);  
		redisClientTemplate.setex(SerializeUtil.serialize(sessionId), 60*30, SerializeUtil.serialize(session));
		
		return sessionId;
	}
	//读取session
	@Override
	protected Session doReadSession(Serializable sessionId) {
		// TODO Auto-generated method stub
		if (redisClientTemplate.exists(SerializeUtil.serialize(sessionId))) {
			System.out.println(sessionId);
			byte[] bs = redisClientTemplate.get(SerializeUtil.serialize(sessionId));
			return (Session) SerializeUtil.deserialize(bs);
		}
		
		return null;
	}
	@Override
	public void update(Session session) throws UnknownSessionException {
		// TODO Auto-generated method stub
		 if(session instanceof ValidatingSession && !((ValidatingSession)session).isValid()) {  
		        return; //如果会话过期/停止 没必要再更新了  
		    }  
			redisClientTemplate.setex(SerializeUtil.serialize(session.getId()), 60*30, SerializeUtil.serialize(session));
		
	}
	@Override
	public void delete(Session session) {
		// TODO Auto-generated method stub
		redisClientTemplate.del(SerializeUtil.serialize(session.getId()));
	}
	
	//获取所有缓存
	/**
	 * 以后用到了在实现
	 */
	@Override
	public Collection<Session> getActiveSessions() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
