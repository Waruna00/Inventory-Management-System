package com.company;

import java.awt.event.ItemEvent;
import java.sql.*;
import java.util.ArrayList;

public class DBUtils {

    public static ArrayList<String> view(String table,String ItemName) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<String> list = new ArrayList<>();
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory","root","Whoiam@123");
            if (table.equals("s")){
                if (ItemName.equals("ALL")){
                    preparedStatement = connection.prepareStatement("SELECT * FROM stationary");
                }
                else {
                    preparedStatement = connection.prepareStatement("SELECT * FROM stationary WHERE no = ?");
                    preparedStatement.setString(1,ItemName);
                }
            }
            else if(table.equals("f")){

            }


            resultSet = preparedStatement.executeQuery();
            System.out.println("Executed");

        if(!resultSet.isBeforeFirst()){
            System.out.println("Item not found in the database");
        }else {
            while(resultSet.next()){
                list.add(resultSet.getNString("no"));
                list.add(resultSet.getNString("name"));
                list.add(String.valueOf(resultSet.getBigDecimal("price")));
                list.add(resultSet.getNString("subject"));
                list.add(resultSet.getNString("color"));
                list.add(resultSet.getNString("filetype"));
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
