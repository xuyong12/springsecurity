package com.mybatis.my.server;

import com.mybatis.my.bean.UserDetailImp;
import com.mybatis.my.mapper.UserDetailImpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * 用户认证
 */
@Service
public class UserServer implements UserDetailsService {
    @Autowired
    UserDetailImpMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserDetailImp userDetailImp = mapper.selectDetailByUserName(s);

        if (userDetailImp == null) {
            throw new UsernameNotFoundException("用户名不正确");
        }
        //将用户的密码进行编码
        userDetailImp.getUser().setPassword(new BCryptPasswordEncoder().encode(userDetailImp.getUser().getPassword()));
        return userDetailImp;
    }
}
