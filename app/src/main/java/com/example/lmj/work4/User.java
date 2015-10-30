package com.example.lmj.work4;

/**
 * Created by Administrator on 2015/10/28.
 */
public class User {

    private String name;//用户名
    public final static String NAME ="name";
    private String mobile;//手机号码
    public final static String MOBILE ="mobile";
    private String danwei;//单位
    public final static String DANWEI ="danwei";
    private String qq;//QQ
    public final static String QQ ="qq";
    private String address;//地址
    public final static String ADDRESS ="id_DB";

    private int id_DB=-1;//表主键ID

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDanwei() {
        return danwei;
    }

    public void setDanwei(String danwei) {
        this.danwei = danwei;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId_DB() {
        return id_DB;
    }

    public void setId_DB(int id_DB) {
        this.id_DB = id_DB;
    }




}
