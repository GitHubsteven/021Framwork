package org.asa.demo.service;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/8/28
 * @Time: 10:18
 * @Description:
 * @version: 1.0.0
 */
public class ClientThread extends Thread {
    private IProductServiceImpl iProductService;

    public ClientThread(IProductServiceImpl iProductService) {
        this.iProductService = iProductService;
    }

    @Override
    public void run() {
        System.out.println("==============thread name: " + currentThread().getName());
        iProductService.updateProductPrice(1L, 320);
    }
}