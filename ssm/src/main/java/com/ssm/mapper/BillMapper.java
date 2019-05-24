package com.ssm.mapper;

import com.ssm.bean.TBill;

import java.util.List;

public interface BillMapper {
    /**
     * 查询所有
     * @param bill
     * @return
     */
    public List<TBill> getBills(TBill bill);

    /**
     * 添加
     * @param bill
     * @return
     */
    public int addBill(TBill bill);

    /**
     * 按照id查询
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
     * @param id
     * @return
     */
    public int deleteBill(int id);
}
