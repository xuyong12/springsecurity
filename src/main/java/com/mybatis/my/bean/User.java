package com.mybatis.my.bean;

public class User {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_user.id
     *
     * @mbggenerated Mon Sep 02 20:59:43 CST 2019
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_user.name
     *
     * @mbggenerated Mon Sep 02 20:59:43 CST 2019
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_user.password
     *
     * @mbggenerated Mon Sep 02 20:59:43 CST 2019
     */
    private String password;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column s_user.id
     *
     * @return the value of s_user.id
     *
     * @mbggenerated Mon Sep 02 20:59:43 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_user.id
     *
     * @param id the value for s_user.id
     *
     * @mbggenerated Mon Sep 02 20:59:43 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column s_user.name
     *
     * @return the value of s_user.name
     *
     * @mbggenerated Mon Sep 02 20:59:43 CST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_user.name
     *
     * @param name the value for s_user.name
     *
     * @mbggenerated Mon Sep 02 20:59:43 CST 2019
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column s_user.password
     *
     * @return the value of s_user.password
     *
     * @mbggenerated Mon Sep 02 20:59:43 CST 2019
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_user.password
     *
     * @param password the value for s_user.password
     *
     * @mbggenerated Mon Sep 02 20:59:43 CST 2019
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}