/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Entity.Term;
import Ultis.JDBC;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    
    public Term findByTermId(int id) {
        Term term = new Term();
        String SQL = "SELECT * FROM `Term` WHERE 'id` = ?";
        try {
            Connection connection = JDBC.Connection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                term.setId(resultSet.getInt("id"));
                term.setDate(LocalDate.parse(resultSet.getString("date")));
                term.setTitle(resultSet.getString("id"));
                term.setPrice(resultSet.getInt("price"));
                term.setDescription(resultSet.getString("description"));
                term.setType(resultSet.getString("type"));
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return term;
    }
    public List<Term> search(LocalDate starDate, LocalDate endDate){
        List<Term> listTerm = new ArrayList<>();
        String where = "";
        if(starDate != null && endDate != null) {
            where += "WHERE `date` BETWEEN '"+ Date.valueOf(starDate).toString()+ "' AND '" + Date.valueOf(endDate).toString()+"'";     
        }
//        else if(Date.valueOf(starDate).toString() == null || Date.valueOf(endDate).toString() == null){
//            where ="";
//        }
        String SQL = "SELECT * FROM `Term` " + where ;
        try {
            Connection connection = JDBC.Connection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Term term = new Term();
                term.setId(resultSet.getInt("id"));
                term.setDate(LocalDate.parse(resultSet.getString("date")));
                term.setTitle(resultSet.getString("title"));
                term.setPrice(resultSet.getInt("price"));
                term.setDescription(resultSet.getString("description"));
                term.setType(resultSet.getString("type"));
                listTerm.add(term);
            }

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listTerm;
    }
    
    public List<Term> search(LocalDate date){
        List<Term> listTerm = new ArrayList<>();
        String SQL = "SELECT * FROM `Term` where `date` = `?`" ;
        try {
            Connection connection = JDBC.Connection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
//            preparedStatement.setString(1, date.toString());
//            System.out.println(Date.valueOf(date).toString()+ "cc");
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                Term term = new Term();
                term.setId(resultSet.getInt("id"));
                term.setDate(LocalDate.parse(resultSet.getString("date")));
                term.setTitle(resultSet.getString("id"));
                term.setPrice(resultSet.getInt("price"));
                term.setDescription(resultSet.getString("description"));
                term.setType(resultSet.getString("type"));
                listTerm.add(term);
            }

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listTerm;
    }
    
}
