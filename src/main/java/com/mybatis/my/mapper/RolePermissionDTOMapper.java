package com.mybatis.my.mapper;

import com.mybatis.my.bean.Role;

/**
 * @author 17715
 */
public interface RolePermissionDTOMapper {
    /**
     * 根据url的id来查询对应的角色
     * @param id
     * @return
     */
    Role selectRole(int id);
}
