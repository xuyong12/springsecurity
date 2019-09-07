package com.mybatis.my.bean;

import java.util.List;

/**
 * url与对应的资源
 */
public class RolePermissionDTO {
    private String url;
    private List<Role> roles;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
