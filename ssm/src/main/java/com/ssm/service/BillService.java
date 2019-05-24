package com.ssm.service;

import com.ssm.bean.TBill;

import java.util.List;

public interface BillService {
    /**
     * 查询所有
     * @param bill
     * @return
     */
    public List<TBill> getBills(TBill bill);

    /**
     * 新增
     * @param bill
     * @return
     */
    public int addBill(TBill bill);

    /**
     * 单个查询
     * @param id
     * @return
     */
    public TBill findBill(int id);

    /**
     * 修改
     * @param bill
     * @return
     */
    public int updateBill(TBill bill);

    /**
     * 删除
     * @param bid
     * @return
     */
    public  int deleteBill(int bid);
}
