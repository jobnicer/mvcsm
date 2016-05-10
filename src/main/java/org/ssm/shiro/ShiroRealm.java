package org.ssm.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class ShiroRealm extends AuthorizingRealm {

	/*
	 * 授权操作
	 * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
//		authorizationInfo.setStringPermissions(stringPermissions);
		principals.getPrimaryPrincipal();
		if (principals.getPrimaryPrincipal() != null) {
			System.out.println("OK");
		}
		System.out.println("---------------------AuthorizationInfo----------------------");
		return null;
	}

	/*
	 * 身份认证操作
	 * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		
		String username = (String)token.getPrincipal();  				//得到用户名 
	    String password = new String((char[])token.getCredentials()); 	//得到密码
	    if(null != username && null != password){
	    	return new SimpleAuthenticationInfo(username, password, getName());
	    }else{
	    	return null;
	    }
	}

}