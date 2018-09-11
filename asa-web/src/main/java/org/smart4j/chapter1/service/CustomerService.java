package org.smart4j.chapter1.service;

import org.asa.framewrok.annotation.Service;
import org.asa.framewrok.annotation.Transaction;
import org.asa.framewrok.bean.FileParam;
import org.asa.framewrok.helper.DatabaseHelper;
import org.asa.framewrok.helper.UploadHelper;
import org.smart4j.chapter1.model.Customer;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class CustomerService {
    /**
     * 获取客户列表
     */
    public List<Customer> getCustomerList() {
        String sql = "SELECT * FROM customer";
        return DatabaseHelper.queryEntityList(Customer.class, sql);
//        return createBean(2);
    }

    /**
     * 获取客户
     */
    public Customer getCustomer(long id) {
        String sql = "SELECT * FROM customer WHERE id = ?";
        return DatabaseHelper.queryEntity(Customer.class, sql, id);
//        return createBean(1).get(0);
//        return new Customer().setId(1L);
    }

    /**
     * 创建客户
     */
    @Transaction
    public boolean createCustomer(Map<String, Object> fieldMap) {
        return DatabaseHelper.insertEntity(Customer.class, fieldMap);
//        return true;
    }


    /**
     * 创建客户
     */
    @Transaction
    public boolean createCustomer(Map<String, Object> fieldMap, FileParam fileParam) {
        boolean result = DatabaseHelper.insertEntity(Customer.class, fieldMap);
        if (result) {
            UploadHelper.uploadFile("/tmp/upload/", fileParam);
        }
        return result;
    }


    /**
     * 更新客户
     */
    @Transaction
    public boolean updateCustomer(long id, Map<String, Object> fieldMap) {
//        return true;
        return DatabaseHelper.updateEntity(Customer.class, id, fieldMap);
    }

    /**
     * 删除客户
     */
    @Transaction
    public boolean deleteCustomer(long id) {
//        return true;
        return DatabaseHelper.deleteEntity(Customer.class, id);
    }

    @Deprecated
    private List<Customer> createBean(int number) {
        return IntStream.range(0, number).mapToObj(i -> {
            Customer bean = new Customer();
            bean.setId(i);
            bean.setName("name" + i);
            bean.setRemark("created by code");
            bean.setContact("contact" + i);
            bean.setEmail(i + "@gmail.cn");
            bean.setTelephone("tel" + i);
            return bean;
        }).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        CustomerService customerService = new CustomerService();
        Customer customer = customerService.getCustomer(1L);
        System.out.println(customer.getName());
    }
}
