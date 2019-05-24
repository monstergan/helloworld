package com.ssm.service.impl;

import com.ssm.bean.TBill;
import com.ssm.mapper.BillMapper;
import com.ssm.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    BillMapper bm;

    @Override
    public List<TBill> getBills(TBill bill) {
        return bm.getBills(bill);
    }

    @Override
    public int addBill(TBill bill) {
        return bm.addBill(bill);
    }

    @Override
    public TBill findBill(int id) {
        return bm.findBill(id);
    }

    @Override
    public int updateBill(TBill bill) {
        return bm.updateBill(bill);
    }

    @Override
    public int deleteBill(int bid) {
        return bm.deleteBill(bid);
    }
}
