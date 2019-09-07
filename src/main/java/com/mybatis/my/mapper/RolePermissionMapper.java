package com.mybatis.my.mapper;

import com.mybatis.my.bean.RolePermission;
import com.mybatis.my.bean.RolePermissionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RolePermissionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_role_permission
     *
     * @mbggenerated Mon Sep 02 20:59:43 CST 2019
     */
    int countByExample(RolePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_role_permission
     *
     * @mbggenerated Mon Sep 02 20:59:43 CST 2019
     */
    int deleteByExample(RolePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_role_permission
     *
     * @mbggenerated Mon Sep 02 20:59:43 CST 2019
     */
    int insert(RolePermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_role_permission
     *
     * @mbggenerated Mon Sep 02 20:59:43 CST 2019
     */
    int insertSelective(RolePermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_role_permission
     *
     * @mbggenerated Mon Sep 02 20:59:43 CST 2019
     */
    List<RolePermission> selectByExample(RolePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_role_permission
     *
     * @mbggenerated Mon Sep 02 20:59:43 CST 2019
     */
    int updateByExampleSelective(@Param("record") RolePermission record, @Param("example") RolePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_role_permission
     *
     * @mbggenerated Mon Sep 02 20:59:43 CST 2019
     */
    int updateByExample(@Param("record") RolePermission record, @Param("example") RolePermissionExample example);
}