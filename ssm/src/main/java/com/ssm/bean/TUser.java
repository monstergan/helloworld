package com.ssm.bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class TUser {

    private long id;
    private String uno;
    private String uname;
    private String upass;
    private long usex;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ubirthday;
    private String uphone;
    private String uaddress;
    private long utype;

    private String uimage;

    public TUser() {
    }

    public TUser(long id, String uno, String uname, String upass, long usex, Date ubirthday, String uphone, String uaddress, long utype, String uimage) {
        this.id = id;
        this.uno = uno;
        this.uname = uname;
        this.upass = upass;
        this.usex = usex;
        this.ubirthday = ubirthday;
        this.uphone = uphone;
        this.uaddress = uaddress;
        this.utype = utype;
        this.uimage = uimage;
    }

    public String getUimage() {
        return uimage;
    }

    public void setUimage(String uimage) {
        this.uimage = uimage;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getUno() {
        return uno;
    }

    public void setUno(String uno) {
        this.uno = uno;
    }


    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }


    public String getUpass() {
        return upass;
    }

    public void setUpass(String upass) {
        this.upass = upass;
    }


    public long getUsex() {
        return usex;
    }

    public void setUsex(long usex) {
        this.usex = usex;
    }


    public Date getUbirthday() {
        return ubirthday;
    }

    public void setUbirthday(Date ubirthday) {
        this.ubirthday = ubirthday;
    }


    public String getUphone() {
        return uphone;
    }

    public void setUphone(String uphone) {
        this.uphone = uphone;
    }


    public String getUaddress() {
        return uaddress;
    }

    public void setUaddress(String uaddress) {
        this.uaddress = uaddress;
    }


    public long getUtype() {
        return utype;
    }

    public void setUtype(long utype) {
        this.utype = utype;
    }

    @Override
    public String toString() {
        return "TUser{" +
                "id=" + id +
                ", uno='" + uno + '\'' +
                ", uname='" + uname + '\'' +
                ", upass='" + upass + '\'' +
                ", usex=" + usex +
                ", ubirthday=" + ubirthday +
                ", uphone='" + uphone + '\'' +
                ", uaddress='" + uaddress + '\'' +
                ", utype=" + utype +
                ", uimage='" + uimage + '\'' +
                '}';
    }
}
