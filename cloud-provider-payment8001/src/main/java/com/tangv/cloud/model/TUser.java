package com.tangv.cloud.model;

import java.io.Serializable;

/**
 * author:   tangwei
 * Date:     2021/12/3 20:44
 * Description:
 */
public class TUser implements Serializable {

    private static final long serialVersionUID = 3161776816510117624L;

    private Integer userId;

    private String userName;

    public TUser(Integer userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}