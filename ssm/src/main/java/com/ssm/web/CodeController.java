package com.ssm.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;


@Controller
@RequestMapping("code")
public class CodeController {

    /*
     *生成验证码
     */
    @RequestMapping("createCode")
    public void createCode(HttpServletRequest request, HttpServletResponse response) throws Exception{

        // 1.图片宽
        int width = 60;
        // 2.图片高度
        int height = 24;

        // 3.获取一个画布对象,撤一个 RGB颜色画布 可以填充颜色画布
        BufferedImage b = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        // 4.获取一个画笔
        Graphics g = b.getGraphics();
        // 5.画笔染色 白色
        g.setColor(Color.WHITE);
        // 用白色填充一个矩形
        g.fillRect(0, 0, width, height);
        // 画笔黑色
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, width - 1, height - 1);

        // 随机的图片生成数字+字母
        // 生成随机验证码 大小字母和数字 62 0-61
        char[] array = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8',
                '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' }; // 62


        //String str ="\u7684\u4e00\u4e86\u662f\u6211\u4e0d\u5728\u4eba\u4eec\u6709\u6765\u4ed6\u8fd9\u4e0a\u7740\u4e2a\u5730\u5230\u5927\u91cc\u8bf4\u5c31\u53bb\u5b50\u5f97\u4e5f\u548c\u90a3\u8981\u4e0b\u770b\u5929\u65f6\u8fc7\u51fa\u5c0f\u4e48\u8d77\u4f60\u90fd\u628a\u597d\u8fd8\u591a\u6ca1\u4e3a\u53c8\u53ef\u5bb6\u5b66";
        //char[] words = str.toCharArray();  // 0-words.length-1

        // 随机获取4个
        Random r = new Random();

        // 绘制8条干扰线
        for (int i = 1; i <= 4; i++) {

            int red = r.nextInt(256);
            int green = r.nextInt(256);
            int blue = r.nextInt(256);
            Color color = new Color(red, green, blue); // 随机色
            g.setColor(color); //设置线的随机色

            //生成线的坐标1
            int x1 = r.nextInt(width);
            int y1 = r.nextInt(height);

            //生成线的坐标2
            int x2 = r.nextInt(width);
            int y2 = r.nextInt(height);

            //绘制线
            g.drawLine(x1, y1, x2, y2);
        }

        StringBuffer sb=new StringBuffer();

        for (int i = 1; i <= 4; i++) {
            int index = r.nextInt(array.length); // 0-61
            String s = array[index] + "";

            // 字体类型并加粗
            Font f = new Font("Arial", Font.BOLD, 16);
            g.setFont(f);

            // 0-255
            int red = r.nextInt(256); // 0-255
            int green = r.nextInt(256);
            int blue = r.nextInt(256);
            Color color = new Color(red, green, blue); // 随机色
            g.setColor(color);// 随机色给画笔

            g.drawString(s, 10 * i, 18);
            sb.append(s);
        }

        System.out.println("系统生成验证码是:"+sb.toString());

        //把系统生成的验证码存入Session中
        HttpSession session = request.getSession();
        session.setAttribute("syscode", sb.toString());


        // 第N步 输出图形
        response.setContentType("image/jpeg"); // 设置输出内容类型 是一张图片
        ServletOutputStream out = response.getOutputStream(); // 获取浏览器字节输出流
        ImageIO.write(b, "jpeg", out);

    }


}
