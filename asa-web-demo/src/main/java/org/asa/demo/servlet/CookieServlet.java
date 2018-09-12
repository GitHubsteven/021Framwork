package org.asa.demo.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/9/12
 * @Time: 10:20
 * @Description: 参考网站： https://blog.csdn.net/Baple/article/details/24781653
 * Cookie的含义是“服务器送给浏览器的甜点”，即服务器在响应请求时可以将一些数据以“键-值”对的形式通过响应信息保存在客户端。
 * 当浏览器再次访问相同的应用时，会将原先的Cookie通过请求信息带到服务器端。
 * @version: 1.0.0
 */
@WebServlet("/testCookie")
public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String option = req.getParameter("option");
        if ("show".equals(option)) {
            //获得请求信息中的Cookie数据
            Cookie[] cookies = req.getCookies();
            if (cookies != null) {
                //找出名称（键）为“cool”的Cookie
                for (Cookie cooky : cookies) {
                    if ("cool".equals(cooky.getName())) {
                        out.println("<h2>" + cooky.getName() + ":"
                                + cooky.getValue() + "</h2>");
                    }
                }
            }
        } else if ("add".equals(option)) {
            //创建Cookie对象
            Cookie cookie = new Cookie("cool", "yeah!");
            //设置生命周期以秒为单位
            cookie.setMaxAge(20);
            //添加Cookie
            resp.addCookie(cookie);
        }
    }
}