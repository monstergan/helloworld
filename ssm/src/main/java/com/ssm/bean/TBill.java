package com.ssm.bean;

public class TBill {

    private Integer bid;
    private String bname;
    private Integer bnumber;
    private Double bmoney;
    private Integer bpay;
    private Integer providerId;
    private TProvider provider;

    public TBill() {
    }

    public TBill(Integer bid, String bname, Integer bnumber, Double bmoney, Integer bpay, Integer providerId, TProvider provider) {
        this.bid = bid;
        this.bname = bname;
        this.bnumber = bnumber;
        this.bmoney = bmoney;
        this.bpay = bpay;
        this.providerId = providerId;
        this.provider = provider;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public Integer getBnumber() {
        return bnumber;
    }

    public void setBnumber(Integer bnumber) {
        this.bnumber = bnumber;
    }

    public Double getBmoney() {
        return bmoney;
    }

    public void setBmoney(Double bmoney) {
        this.bmoney = bmoney;
    }

    public Integer getBpay() {
        return bpay;
    }

    public void setBpay(Integer bpay) {
        this.bpay = bpay;
    }

    public Integer getProviderId() {
        return providerId;
    }

    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
    }

    public TProvider getProvider() {
        return provider;
    }

    public void setProvider(TProvider provider) {
        this.provider = provider;
    }

    @Override
    public String toString() {
        return "TBill{" +
                "bid=" + bid +
                ", bname='" + bname + '\'' +
                ", bnumber=" + bnumber +
                ", bmoney=" + bmoney +
                ", bpay=" + bpay +
                ", providerId=" + providerId +
                ", provider=" + provider +
                '}';
    }
}
