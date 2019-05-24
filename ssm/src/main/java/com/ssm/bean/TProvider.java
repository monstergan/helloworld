package com.ssm.bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class TProvider {

    private Integer pid;

    private Integer pno;

    private String pname;

    private String plinkman;

    private String pphone;

    private String pfax;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date pcreatedate;

    public TProvider() {
    }

    public TProvider(Integer pid, Integer pno, String pname, String plinkman, String pphone, String pfax, Date pcreatedate) {
        this.pid = pid;
        this.pno = pno;
        this.pname = pname;
        this.plinkman = plinkman;
        this.pphone = pphone;
        this.pfax = pfax;
        this.pcreatedate = pcreatedate;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getPno() {
        return pno;
    }

    public void setPno(Integer pno) {
        this.pno = pno;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPlinkman() {
        return plinkman;
    }

    public void setPlinkman(String plinkman) {
        this.plinkman = plinkman;
    }

    public String getPphone() {
        return pphone;
    }

    public void setPphone(String pphone) {
        this.pphone = pphone;
    }

    public String getPfax() {
        return pfax;
    }

    public void setPfax(String pfax) {
        this.pfax = pfax;
    }

    public Date getPcreatedate() {
        return pcreatedate;
    }

    public void setPcreatedate(Date pcreatedate) {
        this.pcreatedate = pcreatedate;
    }

    @Override
    public String toString() {
        return "TProvider{" +
                "pid=" + pid +
                ", pno=" + pno +
                ", pname='" + pname + '\'' +
                ", plinkman='" + plinkman + '\'' +
                ", pphone='" + pphone + '\'' +
                ", pfax='" + pfax + '\'' +
                ", pcreatedate=" + pcreatedate +
                '}';
    }
}

