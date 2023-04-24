/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ultis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Line's laptop
 */
public class JDBC {
     public static Connection Connection() throws SQLException{
        String username ="root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/QuanLyThuChi";
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }
}
