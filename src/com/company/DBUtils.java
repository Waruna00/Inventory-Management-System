package com.company;

import java.sql.*;
import java.util.ArrayList;

public class DBUtils {

    public static ArrayList<String> view(String table,String ItemName,String[] col) {
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
            else if(table.equals("f")) {
                if (ItemName.equals("ALL")) {
                    preparedStatement = connection.prepareStatement("SELECT * FROM furniture");
                } else {
                    preparedStatement = connection.prepareStatement("SELECT * FROM furniture WHERE no = ?");
                    preparedStatement.setString(1, ItemName);
                }
            }
            else {
                if (ItemName.equals("ALL")) {
                    preparedStatement = connection.prepareStatement("SELECT * FROM electronic");
                } else {
                    preparedStatement = connection.prepareStatement("SELECT * FROM stationary WHERE no = ?");
                    preparedStatement.setString(1, ItemName);
                }
            }


            resultSet = preparedStatement.executeQuery();
            System.out.println("Executed");

        if(!resultSet.isBeforeFirst()){
            System.out.println("Item not found in the database");
        }else {
            while(resultSet.next()){
                for(String n : col){
                    if(n.equals("price")){
                        list.add(String.valueOf(resultSet.getBigDecimal(n)));
                    }
                    else {
                        list.add(resultSet.getNString(n));
                    }
                }
                //list.add(resultSet.getNString("no"));
                //list.add(resultSet.getNString("name"));
                //list.add(String.valueOf(resultSet.getBigDecimal("price")));
                //list.add(resultSet.getNString("subject"));
                //list.add(resultSet.getNString("color"));
                //list.add(resultSet.getNString("filetype"));
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

    public static void modify(String table, String ItemCode, ArrayList<String> data) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ArrayList<String> list = new ArrayList<>();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "Whoiam@123");
            if(table.equals("s")){
                preparedStatement = connection.prepareStatement("UPDATE stationary SET name=?, price=?, subject=?, color=?, filetype=? WHERE (`no` = ?);");
                preparedStatement.setString(1,data.get(0));
                preparedStatement.setInt(2,Integer.parseInt(data.get(1)));
                preparedStatement.setString(3,data.get(2));
                preparedStatement.setString(4,data.get(3));
                preparedStatement.setString(5,data.get(4));
                preparedStatement.setString(6,ItemCode);

            }
            else if(table.equals("f")){
                preparedStatement = connection.prepareStatement("UPDATE furniture SET name=?, material=?, color=?, shape=? WHERE (no= ?);");
                preparedStatement.setString(1,data.get(0));
                preparedStatement.setInt(2,Integer.parseInt(data.get(1)));
                preparedStatement.setString(3,data.get(2));
                preparedStatement.setString(4,data.get(3));
                preparedStatement.setString(5,data.get(4));

            }
            else {
                preparedStatement = connection.prepareStatement("SELECT * FROM electronic WHERE no = ?");
            }
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void remove(String ItemCode,String table){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ArrayList<String> list = new ArrayList<>();

        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "Whoiam@123");
            if(table.equals("s")){
                preparedStatement = connection.prepareStatement("delete from stationary where no=?;");
            }
            else if (table.equals("e")){
                preparedStatement = connection.prepareStatement("delete from electronic where no=?;");
            }
            else {
                preparedStatement = connection.prepareStatement("delete from furniture where no=?;");
            }
            preparedStatement.setString(1,ItemCode);
            preparedStatement.execute();
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    public static void enter(ArrayList<String> data, String table){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "Whoiam@123");
            if(table.equals("s")){
                preparedStatement = connection.prepareStatement("INSERT INTO stationary values(?,?,?,?,?,?)");
                preparedStatement.setString(1,data.get(0));
                preparedStatement.setString(2,data.get(1));
                preparedStatement.setInt(3,Integer.parseInt(data.get(2)));
                preparedStatement.setString(4,data.get(3));
                preparedStatement.setString(5,data.get(4));
                preparedStatement.setString(6,data.get(5));
            }
            else if (table.equals("e")){
                preparedStatement = connection.prepareStatement("INSERT INTO electronic values(?,?,?,?,?,?,?,?)");
                preparedStatement.setString(1,data.get(0));
                preparedStatement.setString(2,data.get(1));
                preparedStatement.setString(3,data.get(2));
                preparedStatement.setInt(4,Integer.parseInt(data.get(3)));
                preparedStatement.setString(5,data.get(4));
                preparedStatement.setString(6,data.get(5));
                preparedStatement.setString(7,data.get(6));
                preparedStatement.setString(8,data.get(7));
            }
            else {
                preparedStatement = connection.prepareStatement("INSERT INTO furniture values(?,?,?,?,?)");
                preparedStatement.setString(1,data.get(0));
                preparedStatement.setString(2,data.get(1));
                preparedStatement.setString(3,data.get(2));
                preparedStatement.setString(4,data.get(3));
                preparedStatement.setString(5,data.get(4));
            }
            preparedStatement.execute();
            System.out.print("Item Recorded with No : "+ data.get(0));
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static int rowcount(String table){
        int count = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ArrayList<String> list = new ArrayList<>();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "Whoiam@123");
            if(table.equals("s")){
                preparedStatement = connection.prepareStatement("select count(*) from stationary;");
            }
            else if (table.equals("e")){
                preparedStatement = connection.prepareStatement("select count(*) from electronic;");
            }
            else {
                preparedStatement = connection.prepareStatement("select count(*) from furniture;");
            }

            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                count=rs.getInt(1);
            }
            System.out.println(count);


        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return count;
    }

}
