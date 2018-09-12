package org.asa.demo.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/9/12
 * @Time: 10:20
 * @Description: Session对象的原理在于，服务器可以为客户端创建并维护一个所谓的Session对象，用于存放数据。
 * 在创建Session对象的同时，服务器将会为该Session对象产生一个唯一编号，这个编号称之为SessionID，服务器以Cookie的方式将SessionID存放在客户端。
 * 当浏览器再次访问该服务器时，会将SessionID作为Cookie信息带到服务器，服务器可以通过该SessionID检索到以前的Session对象，并对其进行访问。需要注意的是，此时的Cookie中仅仅保存了一个SessionID，
 * 而相对较多的会话数据保存在服务器端对应的Session对象中，由服务器来统一维护，这样一定程度保证了会话数据安全性，但增加了服务器端的内存开销。
 * 存放在客户端的用于保存SessionID的Cookie会在浏览器关闭时清除。我们把用户打开一个浏览器访问某个应用开始，到关闭浏览器为止交互过程称为一个“会话”。
 * 在一个“会话”过程中，可能会向同一个应用发出了多次请求，这些请求将共享一个Session对象，因为这些请求携带了相同的SessionID信息。
 * @version: 1.0.0
 */
@WebServlet("/testSession")
public class SessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String option = req.getParameter("option");
        if ("create".equals(option)) {
            //获得HttpSession对象
            HttpSession session = req.getSession();
            //设置Session对象的最长不活动间隔
            session.setMaxInactiveInterval(30);
            //获取Session中的数据
            List list = (List) session.getAttribute("list");
            if (list == null) {
                list = new ArrayList();
                list.add("hey");
                list.add(session.getId());
                //向Session中添加数据
                session.setAttribute("list", list);
            } else {
                list.add("hey");
                list.add(session.getId());
            }
            out.println(list);
        } else if ("invalidate".equals(option)) {
            HttpSession session = req.getSession(false);
            if (session != null) {
                //使Session对象失效
                session.invalidate();
            }
        }
    }
}