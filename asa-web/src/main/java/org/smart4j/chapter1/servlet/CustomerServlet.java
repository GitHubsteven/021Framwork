package org.smart4j.chapter1.servlet;

import org.smart4j.chapter1.model.Customer;
import org.smart4j.chapter1.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * to be frank, one request 2 one servlet, while the strangest thing is servlet hide the detail
 * of the transfer between the jsp and servlet. Maybe the jsp just is realized by servlet. And for this,
 * servlet can build the jsp to the html page totally different from the ajax/ xmlHttp technology.
 */
//@WebServlet("/customer")
public class CustomerServlet extends HttpServlet {
    private CustomerService customerService;

    @Override
    public void init() throws ServletException {
        customerService = new CustomerService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Customer> list = customerService.getCustomerList();
        req.setAttribute("customerList", list);
        req.getRequestDispatcher("/WEB-INF/view/customer.jsp").forward(req, resp);
    }
}
