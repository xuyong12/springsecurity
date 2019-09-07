package com.mybatis.my.mapper;


import com.mybatis.my.bean.UserDetailImp;

/**
 * @author 17715
 */

public interface UserDetailImpMapper {
    UserDetailImp selectDetailByUserName(String name);
}
