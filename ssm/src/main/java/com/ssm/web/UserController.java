package com.ssm.web;

import com.ssm.bean.TUser;
import com.ssm.service.UserService;
import com.ssm.utils.MD5Utils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 登录
     *
     * @param user
     * @param usercode
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("login")
    public String login(TUser user, String usercode, HttpSession session, Model model) {
        System.out.println(user);

        //使用密文登陆
//        String pass = MD5Utils.MD5Encode(user.getUpass() + "monster", "UTF-8");
//        System.out.println("加密之后的密码是：" + pass);
//        user.setUpass(pass);

        TUser u = userService.login(user);
        System.out.println(u);
        System.out.println("用户输入的验证码是:" + usercode);
        System.out.println("输入的账号和密码是:" + user);
        String syscode = (String) session.getAttribute("syscode");
        if (syscode.equalsIgnoreCase(usercode)) {
            TUser t = userService.login(user);
            if (t != null) {
                session.setAttribute("name", user.getUno());
                return "redirect:/user/list";
            } else {
                model.addAttribute("msg", "账号或密码输入错误！");
                return "forward:/login.jsp";
            }
        } else {
            model.addAttribute("msg", "验证码输入错误!");
            return "forward:/login.jsp";
        }
    }

    /**
     * 表单
     *
     * @param model
     * @return
     */
    @RequestMapping("list")
    public String user_list(Model model) {
        List<TUser> users = userService.getUsers();
        System.out.println("集合内容：" + users);
        model.addAttribute("user", users);
        return "userList";
    }

    @RequestMapping("toupdate/{id}")
    public String toupdate(@PathVariable("id") int id, Model model) {
        TUser user = userService.getById(id);
        model.addAttribute("user", user);
        return "userUpdate";
    }

    /**
     * 更新
     *
     * @param user
     * @return
     */
    @RequestMapping("update")
    @ResponseBody
    public String update(TUser user) {
        System.out.println("id" + user.getId());
        System.out.println("name" + user.getUname());
        int i = userService.updateUser(user);
        return i > 0 ? "true" : "false";
    }

    /**
     * 新增
     *
     * @param user
     * @param photo
     * @param response
     * @param session
     * @throws IOException
     */
    @RequestMapping("add")
    public void addUer(TUser user, @RequestParam("photo") MultipartFile photo, HttpServletResponse response, HttpSession session) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        System.out.println("文件上传测试!!!");
        System.out.println("文件是否为空：" + photo.isEmpty());
        if (!photo.isEmpty()) {
            System.out.println("上传的原始的文件名是：" + photo.getOriginalFilename());
            String fileName = createName(photo.getOriginalFilename());
            System.out.println("服务器生成的文件名：" + fileName);
            //年月日文件夹
            File parent = createDir(session.getServletContext());
            File file = new File(parent, fileName);
            photo.transferTo(file);

            String absolutePath = file.getAbsolutePath();
            String webpath = absolutePath.substring(absolutePath.indexOf("static"));

            //给文件路径赋值
            user.setUimage(webpath);
        }

        String pass = MD5Utils.MD5Encode(user.getUpass() + "monster", "UTF-8");
        System.out.println("加密之后的密码是：" + pass);
        user.setUpass(pass);

        int count = userService.addUser(user);
        if (count > 0) {
            out.print("<script>alert('新增成功!');location.href='list';</script>");
        } else {
            out.print("<script>alert('新增失败!');location.href='/page/userAdd';</script>");
        }
    }

    /**
     * 创建文件夹
     *
     * @param context
     * @return
     */
    private File createDir(ServletContext context) {
        String realPath = context.getRealPath("/static/upload");
        String date = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        File file = new File(realPath, date);
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    /**
     * 创建文件名--区分同名文件 在文件名前加上当前时间
     *
     * @param name
     * @return
     */
    private String createName(String name) {
        return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(Calendar.getInstance().getTime()) + "_" + name;
    }

    /**
     * 单个删除
     *
     * @param id
     * @return
     */

    @RequestMapping("delete/{id}")
    @ResponseBody
    public String deleteUser(@PathVariable("id") int id) {
        int count = 0;
        count = userService.deleteuser(id);
        return count > 0 ? "true" : "false";
    }

    /**
     * 查看用户信息
     *
     * @param id
     * @param request
     * @return
     */
    @RequestMapping("getById/{id}")
    public String getById(@PathVariable("id") Integer id, HttpServletRequest request) {
        TUser user = userService.getById(id);
        request.setAttribute("user", user);
        return "userView";
    }

    /**
     * 批量删除
     *
     * @param ids
     * @param response
     * @param request
     * @throws IOException
     */
    @RequestMapping("deleteSome/{ids}")
    public void deleteSome(@PathVariable("ids") Integer[] ids, HttpServletResponse response, HttpServletRequest request) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        System.out.println("要删除的数组是：" + Arrays.toString(ids));
        int i = userService.deleteSome(ids);
        PrintWriter out = response.getWriter();
        if (i > 0) {
            out.write("<script>alert('删除成功');location.href='" + request.getContextPath() + "/user/list'</script>");
        } else {
            out.write("<script>alert('删除失败');location.href='list'</script>");
        }
    }

    /**
     * 创建文件名  区分同名文件  在文件名前加上当前时间
     *
     * @param name
     * @return
     */
    private String CreateName(String name) {
        return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(Calendar.getInstance().getTime()) + "_" + name;
    }

    /**
     * EXcel文件操作
     *
     * @param ids
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("exportExcel/{ids}")
    public void exportExcel(@PathVariable("ids") Integer[] ids, HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("要导入Excel的ID集合是：" + Arrays.toString(ids));
        //要导出Excel的集合
        List<TUser> users = userService.getUsersById(ids);

        //创建一工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();

        //工作簿创建一个sheet 给sheet 取个名字
        HSSFSheet sheet = workbook.createSheet("用户信息表");

        //生成标题
        HSSFRow titleRow = sheet.createRow(0);

        String[] titles = {"编号", "用户编号", "用户图片", "用户姓名", "用户密码", "用户性别", "用户生日", "用户电话", "用户地址", "用户角色"};
        for (int i = 0; i < titles.length; i++) {
            HSSFCell cell = titleRow.createCell(i);
            cell.setCellValue(titles[i]);
        }

        //循环集合
        for (int i = 0; i < users.size(); i++) {
            TUser user = users.get(i);
            //每一行
            HSSFRow row = sheet.createRow(i + 1);

            HSSFCell idCell = row.createCell(0);
            idCell.setCellValue(user.getId());

            HSSFCell uNocell = row.createCell(1);
            uNocell.setCellValue(user.getUno());

            HSSFCell uImagecell = row.createCell(2);
            uImagecell.setCellValue(user.getUimage());

            HSSFCell uNamecell = row.createCell(3);
            uNamecell.setCellValue(user.getUname());

            HSSFCell uPasscell = row.createCell(4);
            uPasscell.setCellValue(user.getUpass());

            HSSFCell uSexcell = row.createCell(5);
            String sex = "";
            if (user.getUsex() == 0) {
                sex = "女";
            } else {
                sex = "男";
            }
            uSexcell.setCellValue(sex);

            HSSFCell uBircell = row.createCell(6);
            uBircell.setCellValue(user.getUbirthday());

            HSSFCell uPhonecell = row.createCell(7);
            uPhonecell.setCellValue(user.getUphone());

            HSSFCell uAddresscell = row.createCell(8);
            uAddresscell.setCellValue(user.getUaddress());

            HSSFCell uTypecell = row.createCell(9);
            String type = "";
            if (user.getUtype() == 1) {
                type = "经理";
            } else if (user.getUtype() == 2) {
                type = "管理员";
            } else {
                type = "普通用户";
            }
            uTypecell.setCellValue(type);
        }

        String fileName = "用户信息表" + new SimpleDateFormat("yyyyMMddHHmmsssSSS").format(new Date()) + ".xls";
        //浏览器输出字节流
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);

        //生成Excel并提供下载
        String userAgent = request.getHeader("User-Agent");
        if (userAgent.contains("Safari")) {
            response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
        } else {
            //设置请求头  以附件的形式打开
            response.addHeader("Content-Disposition", "attachment;filename" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1"));
        }
        outputStream.close();
    }

    /**
     * 下载模版
     *
     * @param response
     * @param request
     * @throws Exception
     */
    @RequestMapping("downloadModel")
    public void downloadModel(HttpServletResponse response, HttpServletRequest request) throws Exception {
        //获取文件服务器真实路径
        String realPath = request.getServletContext().getRealPath("/static/model/user_model.xls");
        response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("user_model.xls", "UTF-8"));
        System.out.println("文件的服务器地址：" + realPath);

        File file = new File(realPath);
        FileInputStream fis = new FileInputStream(file);
        ServletOutputStream outputStream = response.getOutputStream();

        byte[] bytes = new byte[1024];
        int len;
        while ((len = fis.read(bytes)) != -1) {
            outputStream.write(bytes, 0, len);
        }
        outputStream.close();
        fis.close();
    }

    @RequestMapping("importExcel")
    public void importExcel(MultipartFile excel, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=utf-8");

        //获取文件服务器真实路径
        String realPath = request.getServletContext().getRealPath("/static/model/" + UUID.randomUUID() + ".xls");
        File f = new File(realPath);

        System.out.println("文件是否为空：" + excel.isEmpty());
        if (!excel.isEmpty()) {
            System.out.println("上传的原始文件名是：" + excel.getOriginalFilename());
            excel.transferTo(f);
        }

        //解析 Excel文件
        FileInputStream fis = new FileInputStream(f);
        HSSFWorkbook workbook = new HSSFWorkbook(fis);
        //取出第一个工作表 索引为0
        HSSFSheet sheet = workbook.getSheetAt(0);

        TUser u = null;
        String cellStr = "";
        ArrayList<TUser> users = new ArrayList<>();

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            u = new TUser();
            HSSFRow row = sheet.getRow(i);
            if (row == null) {
                //如果为空不处理
                continue;
            }
            for (int j = 0; j < row.getLastCellNum(); j++) {
                HSSFCell cell = row.getCell(j);
                if (cell == null) {
                    cellStr = "";
                } else if (cell.getCellType() == HSSFCell.CELL_TYPE_BOOLEAN) {
                    //对布尔值处理
                    cellStr = String.valueOf(cell.getBooleanCellValue());
                } else if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
                    //对 数字值的处理
                    cellStr = cell.getNumericCellValue() + "";
                } else {
                    //其余按照字符串处理
                    cellStr = cell.getStringCellValue();
                }
                if (j == 0) {
                    u.setUno(cellStr);
                }
                if (j == 1) {
                    u.setUname(cellStr);
                }
                if (j == 2) {
                    int sex = 2;
                    if (cellStr.equals("男")) {
                        sex = 1;
                    } else if (cellStr.equals("女")) {
                        sex = 0;
                    }
                    u.setUsex(sex);
                }
                if (j == 3) {
                    u.setUphone(cellStr);
                }
                if (j == 4) {
                    u.setUphone(cellStr);
                }
                if (j == 5) {
                    u.setUaddress(cellStr);
                }
                if (j == 6) {
                    int type = 3;
                    if (cellStr.equals("普通用户")) {
                        type = 3;
                    } else if (cellStr.equals("经理")) {
                        type = 1;
                    } else if (cellStr.equals("管理员")) {
                        type = 2;
                    }
                    u.setUtype(type);
                }
                u.setUpass("88886666");
            }
            users.add(u);
        }
        System.out.println("要导出的数据是："+users);

        for (TUser user : users) {
            int count = userService.addUser(user);
        }

        response.getWriter().write("<script>alert('导入成功！');location.href='/user/list'</script>");
    }
}
