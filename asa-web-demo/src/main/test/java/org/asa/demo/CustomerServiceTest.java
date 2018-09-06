package java.org.asa.demo;

import org.asa.demo.model.Customer;
import org.asa.demo.service.CustomerService;
import org.junit.Assert;

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
