package com.xx.meirenyu.utill.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/12/8.
 */

public class User implements Serializable {
    private String code;
    private String password;
    public User(String code,String password){
        super();
        this.code=code;
        this.password=password;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return this.code+","+this.password;
    }
}
