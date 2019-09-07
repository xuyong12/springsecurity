package com.mybatis.my.common;

import com.mybatis.my.bean.UserDetailImp;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserUtils {
    public static UserDetailImp getCurrentUser() {
        return (UserDetailImp) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
