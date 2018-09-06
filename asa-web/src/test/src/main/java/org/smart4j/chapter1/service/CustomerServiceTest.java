package src.main.java.org.smart4j.chapter1.service;

import org.junit.Assert;
import org.smart4j.chapter1.model.Customer;
import org.smart4j.chapter1.service.CustomerService;

import java.util.List;

public class CustomerServiceTest {
    private CustomerService customerService;

    public CustomerServiceTest(){
        customerService = new CustomerService();
    }

    @org.junit.Test
    public void getCustomerList() throws Exception {
        List<Customer> list = customerService.getCustomerList();
        Assert.assertEquals(2, list.size());
    }

    @org.junit.Test
    public void getCustomer() throws Exception {
    }

    @org.junit.Test
    public void createCustomer() throws Exception {
    }

    @org.junit.Test
    public void updateCustomer() throws Exception {
    }

    @org.junit.Test
    public void deleteCustomer() throws Exception {
    }

}
