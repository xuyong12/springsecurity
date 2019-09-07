package com.mybatis.my.config;

import com.mybatis.my.bean.Permission;
import com.mybatis.my.bean.PermissionExample;
import com.mybatis.my.bean.Role;
import com.mybatis.my.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * 鉴权，或取url所需的角色
 */
@Component
public class CustomMetadataSource implements FilterInvocationSecurityMetadataSource {
    @Autowired
    private PermissionMapper mapper;
    AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        System.out.println("当前请求的url为" + requestUrl);
        //得到所有的permission
        PermissionExample example = new PermissionExample();
        example.setOrderByClause("url desc");
        List<Permission> permissions = mapper.selectByExample(example);
        //遍历permissio
        for (Permission permission : permissions) {
            if (antPathMatcher.match(permission.getUrl(), requestUrl) && mapper.selectRole(permission.getId()).getRoles().size() > 0) {
                //url匹配，且有角色时
                List<Role> roles = mapper.selectRole(permission.getId()).getRoles();
                String[] values = new String[roles.size()];
                for (int i = 0; i < roles.size(); i++) {
                    //遍历角色
                    values[i] = roles.get(i).getRole();
                    System.out.print("所需的角色为" + values[i]);
                }
                return SecurityConfig.createList(values);
            }
        }
        //没有匹配上
        return SecurityConfig.createList("login");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return FilterInvocation.class.isAssignableFrom(aClass);
    }
}
