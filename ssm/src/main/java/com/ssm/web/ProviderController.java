package com.ssm.web;

import com.ssm.bean.TProvider;
import com.ssm.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@Controller
@RequestMapping("provider")
public class ProviderController {

    @Autowired
    ProviderService ps;

    /**
     * 全局查询
     *
     * @param model
     * @return
     */
    @RequestMapping("getProviders")
    public String getProviders(Model model) {
        List<TProvider> providers = ps.getProviders();
        System.out.println("集合内容：" + providers);
        model.addAttribute("provider", providers);
        return "providerList";
    }

    /**
     * 新增
     *
     * @param provider
     * @param response
     * @throws IOException
     */
    @RequestMapping("addp")
    public void addProvider(TProvider provider, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int count = 0;
        count = ps.addProviders(provider);
        if (count > 0) {
            out.write("<script>alert('新增成功!');location.href='getProviders';</script>");
        } else {
            out.write("<script>alert('新增失败!');location.href='/page/providerAdd';</script>");
        }
    }

    /**
     * 单个删除
     *
     * @param id
     * @return
     */
    @RequestMapping("deletep/{id}")
    @ResponseBody
    public String deleteProvider(@PathVariable("id") Integer id) {
        int i = 0;
        i = ps.deleteProvider(id);
        return i > 0 ? "true" : "false";
    }

    @RequestMapping("getByIdp/{pid}")
    public String getById(@PathVariable("pid") Integer pid, HttpServletRequest request) {
        TProvider provider = ps.getById(pid);
        request.setAttribute("provider", provider);
        return "providerView";
    }

    @RequestMapping("toupdatep/{pid}")
    public String toupdatep(@PathVariable("pid") Integer pid, Model model) {
        TProvider provider = ps.getById(pid);
        model.addAttribute("provider", provider);
        return "providerUpdate";
    }

    @RequestMapping("updatep")
    @ResponseBody
    public String updatep(TProvider provider) {
        System.out.println(provider+"---------");
        System.out.println("pid" + provider.getPid());
        System.out.println("pname" + provider.getPname());
        int i = ps.updateProvider(provider);
        return i > 0 ? "true" : "false";
    }

}
