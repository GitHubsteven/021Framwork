package org.asa.demo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/8/28
 * @Time: 9:58
 * @Description:
 * @version: 1.0.0
 */
public class DBUtilV2 {
    private static final String driverName = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/chapter1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String userName = "root";
    private static final String password = "123456";

    private static ThreadLocal<Connection> conContainer = new ThreadLocal<>();

    public static Connection getConnection() {
        Connection connection = conContainer.get();
        if (connection == null) {
            try {
                Class.forName(driverName);
                connection = DriverManager.getConnection(url, userName, password);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            } finally {
                conContainer.set(connection);
            }
        }
        return connection;

    }

    public static void closeConnection() {
        Connection connection = conContainer.get();
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conContainer.remove();
        }
    }
}