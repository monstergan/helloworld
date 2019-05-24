package com.ssm.web;

import com.ssm.bean.TBill;
import com.ssm.bean.TProvider;
import com.ssm.service.BillService;
import com.ssm.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("bill")
public class BillController {

    @Autowired
    BillService bs;

    @Autowired
    ProviderService providerService;

    /**
     * 查询所有
     *
     * @param b
     * @param model
     * @return
     */
    @RequestMapping("getBills")
    public String getBills(TBill b, Model model) {
        List<TBill> bills = bs.getBills(b);
        System.out.println("多表集合内容是" + bills);
        model.addAttribute("bills", bills);
        return "billList";
    }

    /**
     * 新增
     *
     * @param b
     * @return
     */
    @RequestMapping("add")
    @ResponseBody
    public String addBill(TBill b) {
        int count = bs.addBill(b);
        return count > 0 ? "true" : "false";
    }

    /**
     * 加载下拉框
     *
     * @return
     */
    @RequestMapping("pro")
    @ResponseBody
    public List<TProvider> getProvider() {
        List<TProvider> providers = providerService.getpro();
        System.out.println("provider" + providers);
        return providers;
    }

    /**
     * 查看单个信息
     *
     * @param pid
     * @param model
     * @return
     */
    @RequestMapping("view/{id}")
//    @ResponseBody
    public String findBill(@PathVariable("id") int pid, Model model) {
        TBill bi = bs.findBill(pid);
        System.out.println("要查看的内容是：" + bi);
        model.addAttribute("bill", bi);
        return "billView";
    }

    /**
     * 更新
     *
     * @param bill
     * @param model
     * @return
     */
    @RequestMapping("update")
    @ResponseBody
    public String update(TBill bill, Model model) {
        int i = bs.updateBill(bill);
        return i > 0 ? "true" : "false";
    }

    @RequestMapping("toupdate/{id}")
    public String toupdate(@PathVariable("id") int id, Model model) {
        TBill bill = bs.findBill(id);
        model.addAttribute("bill", bill);
        return "billUpdate";
    }

    @RequestMapping("delete/{id}")
    @ResponseBody
    public String delete(@PathVariable("id") int id, Model model) {
        System.out.println("要删除的ID是：" + id);
        int i = bs.deleteBill(id);
        System.out.println(i + "==========================");
        return i > 0 ? "true" : "false";
    }
}
