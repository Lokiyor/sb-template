package com.ljy.sbtemplate.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * 类AuthRealm完成根据用户名去数据库的查询,并且将用户信息放入shiro中。
 * 供第二个类CredentialsMatcher调用，完成对于密码的校验。
 *
 * @author Lokiy
 */
public class AuthRealm extends AuthorizingRealm {

    /**
     * 认证信息.(身份验证) : AuthenticationToken 是用来验证用户身份
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        return null;
    }

    /**
     * 授权
     *
     * @param principal
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        return null;
    }

}
