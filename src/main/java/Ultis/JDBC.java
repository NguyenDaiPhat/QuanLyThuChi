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
    public static Connection Connection() throws SQLException {
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/QuanLyThuChi"; 
        String user = "root"; 
        String password = ""; 
    
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Ket noi thanh cong toi csdl!");
        } catch (SQLException e) {
            System.out.println("Khong the ket noi toi csdl!");
            e.printStackTrace();
        }
        return conn;
    }
}
