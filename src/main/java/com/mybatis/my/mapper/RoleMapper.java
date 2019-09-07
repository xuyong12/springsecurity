package com.mybatis.my.mapper;

import com.mybatis.my.bean.Role;
import com.mybatis.my.bean.RoleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_role
     *
     * @mbggenerated Mon Sep 02 20:59:43 CST 2019
     */
    int countByExample(RoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_role
     *
     * @mbggenerated Mon Sep 02 20:59:43 CST 2019
     */
    int deleteByExample(RoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_role
     *
     * @mbggenerated Mon Sep 02 20:59:43 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_role
     *
     * @mbggenerated Mon Sep 02 20:59:43 CST 2019
     */
    int insert(Role record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_role
     *
     * @mbggenerated Mon Sep 02 20:59:43 CST 2019
     */
    int insertSelective(Role record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_role
     *
     * @mbggenerated Mon Sep 02 20:59:43 CST 2019
     */
    List<Role> selectByExample(RoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_role
     *
     * @mbggenerated Mon Sep 02 20:59:43 CST 2019
     */
    Role selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_role
     *
     * @mbggenerated Mon Sep 02 20:59:43 CST 2019
     */
    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_role
     *
     * @mbggenerated Mon Sep 02 20:59:43 CST 2019
     */
    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_role
     *
     * @mbggenerated Mon Sep 02 20:59:43 CST 2019
     */
    int updateByPrimaryKeySelective(Role record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_role
     *
     * @mbggenerated Mon Sep 02 20:59:43 CST 2019
     */
    int updateByPrimaryKey(Role record);
}