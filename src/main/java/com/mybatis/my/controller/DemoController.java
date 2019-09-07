package com.mybatis.my.controller;
import com.mybatis.my.bean.UserDetailImp;
import com.mybatis.my.mapper.UserDetailImpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 17715
 */
@RestController
public class DemoController {
    @Autowired
   private UserDetailImpMapper mapper;

    /**
     * 增加权限
     * @return
     */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/roleAuth")
    public String role(){
        return "admin auth";
    }

}
