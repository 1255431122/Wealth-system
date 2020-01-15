package com.qf.entity;


import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name="w_user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "Mysql")
    private Integer wid;
    private String wname;
    private String wpass;
    private Integer wphone;

    public UserEntity(String wname, String wpass, Integer wphone) {
        this.wname = wname;
        this.wpass = wpass;
        this.wphone = wphone;
    }

    public UserEntity() {
    }

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public String getWname() {
        return wname;
    }

    public void setWname(String wname) {
        this.wname = wname;
    }

    public String getWpass() {
        return wpass;
    }

    public void setWpass(String wpass) {
        this.wpass = wpass;
    }

    public Integer getWphone() {
        return wphone;
    }

    public void setWphone(Integer wphone) {
        this.wphone = wphone;
    }
}
