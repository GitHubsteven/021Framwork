package org.smart4j.chapter1.service;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/8/27
 * @Time: 21:41
 * @Description:
 * @version: 1.0.0
 */
public interface IProductService {
    void updateProductPrice(Long productId, int price);
}