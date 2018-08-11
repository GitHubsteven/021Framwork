package org.smart4j.chapter1.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/8/11
 * @Time: 19:43
 * @Description:
 * @version: 1.0.0
 */
@WebServlet("/customer_create")
public class CustomerCreateServlet extends HttpServlet {
    /**
     * enter page to create customer
     *
     * @param req  request
     * @param resp response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO: 2018/8/11  
        super.doGet(req, resp);
    }

    /**
     * handle create customer request
     *
     * @param req  request
     * @param resp response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO: 2018/8/11  
        super.doPost(req, resp);
    }
}