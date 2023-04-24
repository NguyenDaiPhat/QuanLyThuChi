/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Entity.Term;
import Ultis.JDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Line's laptop
 */
public class TermDao {
    public boolean save(Term term) {
        String SQL = "INSERT INTO `term`(`date`,`title`,`price`,`description`,`type`)VALUES(?,?,?,?,?)";
        try {
            Connection connection = JDBC.Connection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, term.getDate().toString());
            preparedStatement.setString(2, term.getTitle());
            preparedStatement.setInt(3, term.getPrice());
            preparedStatement.setString(4, term.getDescription());
            preparedStatement.setString(5, term.getType());
            int result = preparedStatement.executeUpdate();
            connection.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(Term term) {
        String SQL = "UPDATE `Term` SET `date`=?,`title`=?,`price`=?,`description`=?,`type`=?  WHERE `id`=?";
        try {
            Connection connection = JDBC.Connection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, term.getDate().toString());
            preparedStatement.setString(2, term.getTitle());
            preparedStatement.setInt(3, term.getPrice());
            preparedStatement.setString(4, term.getDescription());
            preparedStatement.setString(5, term.getType());
            preparedStatement.setInt(6, term.getId());
            int result = preparedStatement.executeUpdate();
            connection.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public void delete(int id){
        String SQL = "DELETE FROM `Term` WHERE `id` = ?" ;  
        try {
            Connection connection = JDBC.Connection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1,id);
            int result = preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}
