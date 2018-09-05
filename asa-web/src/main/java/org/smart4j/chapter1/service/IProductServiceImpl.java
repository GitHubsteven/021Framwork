package org.smart4j.chapter1.service;

import org.smart4j.chapter1.util.DBUtilV2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/8/27
 * @Time: 21:43
 * @Description:
 * @version: 1.0.0
 */
public class IProductServiceImpl implements IProductService {
    //define run sql template
    private static final String UPDATE_PRODUCT_PRICE = "UPDATE product set price = ? where id  = ?";
    private static final String INSERT_LOG_SQL = "insert log(created, description) values (?,?)";

    @Override
    public void updateProductPrice(Long productId, int price) {
        //get connection
        Connection connection = DBUtilV2.getConnection();
        try {
            //start a transaction
            connection.setAutoCommit(false);
//            updateProduct(connection, UPDATE_PRODUCT_PRICE, productId, price);
            insertLog(connection, INSERT_LOG_SQL, "update product(id: " + productId + ")" + " price to: " + Math.random() * 100);
//            commit the transaction
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtilV2.closeConnection();
        }
    }

    public int updateProduct(Connection conn, String sql, Long productId, int price) throws Exception {
        //get preparedStatement, an object that represents a precompiled SQL statement.
        // You can treat it as a simple wrapper of jdbc operations
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        //set params, detail see the official docment.
        preparedStatement.setInt(1, price);
        preparedStatement.setLong(2, productId);
        //execute the preparedStatement
        int row = preparedStatement.executeUpdate();
        if (row != 0) {
            System.out.println("update successfully!");
        } else {
            throw new RuntimeException("update product error");
        }
        return row;
    }

    public int insertLog(Connection conn, String sql, String description) throws Exception {
        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        preparedStatement.setString(1, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        preparedStatement.setString(2, description);
        int row = preparedStatement.executeUpdate();
        if (row != 0) {
            System.out.println("insert log success!");
        } else {
            throw new RuntimeException("insert log error");
        }
        return row;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 200; i++) {
            IProductServiceImpl iProductService = new IProductServiceImpl();
            ClientThread thread = new ClientThread(iProductService);
            thread.start();
        }
    }

}