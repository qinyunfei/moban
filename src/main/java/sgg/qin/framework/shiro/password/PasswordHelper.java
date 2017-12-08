package sgg.qin.framework.shiro.password;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import sgg.qin.domain.systems.SysUser;


@Component
public class PasswordHelper {
	// 随机数字生成器
	private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
	// 加密策略
	@Value("${password.algorithmName}")
	private String algorithmName;
	// 加密次数
	@Value("${password.hashIterations}")
	private int hashIterations;
	
	/**
	 * 
	 * Description :	为用户进行加密操作<br>
	 * ParamKeys :(TUser tUser)				<br>
	 * return : TUser
	 */
	public SysUser encryptPassword(SysUser sysUser) {
		// 生成16进制的随机数做为盐 使用Hex加密存储
		String salt = randomNumberGenerator.nextBytes().toHex();
		//为用户设置盐
		sysUser.setSalt(salt);
		//根据用户名 密码 盐 生成加密后的新密码
		String newpassword = new SimpleHash(algorithmName, sysUser.getPassword(), ByteSource.Util.bytes(sysUser.getCredentialsSalt()), hashIterations).toHex();
		//将加密后的密码放入user对象
		sysUser.setPassword(newpassword);
		return sysUser;
	}

}
