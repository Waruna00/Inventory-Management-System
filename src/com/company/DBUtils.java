package com.company;

import java.sql.*;

//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;

public class DBUtils {
    public static String view(String ItemName) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String list = null;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory","root","Whoiam@123");
            preparedStatement = connection.prepareStatement("SELECT * FROM stationary WHERE no = ?");
            preparedStatement.setString(1,ItemName);
            resultSet = preparedStatement.executeQuery();

        if(!resultSet.isBeforeFirst()){
            System.out.println("Item not found in the database");
        }else {
            while(resultSet.next()){
                list = resultSet.getNString("name");
            }
        }
        }catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            if (resultSet != null){
                try{
                    resultSet.close();
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null){
                try{
                    preparedStatement.close();
                }
                catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if (connection != null){
                try{
                    connection.close();
                }
                catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }

        return list;
    }
}
