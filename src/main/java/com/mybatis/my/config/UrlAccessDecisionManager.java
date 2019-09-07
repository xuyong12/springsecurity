package com.mybatis.my.config;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Iterator;

/**
 * 鉴权
 * @author 17715
 */
@Component
public class UrlAccessDecisionManager implements AccessDecisionManager {
    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {
        Iterator<ConfigAttribute> iterator= collection.iterator();
        while (iterator.hasNext()){
            ConfigAttribute next = iterator.next();
            //当前请求所需要的权限
            String attribute = next.getAttribute();
            System.out.println("当前请求所需要的权限为"+attribute);
            if("login".equals(attribute)){
             /*   if(authentication instanceof AnonymousAuthenticationToken){
                    System.out.println("用户没有登陆");
                    throw new BadCredentialsException("/login");
                }else {
                    return;
                }*/
                return;
            }
            //当前用户所具有的权限
            Collection<? extends GrantedAuthority> authorities=authentication.getAuthorities();
            for(GrantedAuthority authority:authorities){
                System.out.println("当前用户所具有的权限"+authority.getAuthority());
                if(authority.getAuthority().equals(attribute)){
                    //当用户所具有的权限与所需权限相同时,放行
                    return;
                }
            }
        }
        throw new AccessDeniedException("权限不足");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
