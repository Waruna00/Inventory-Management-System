package com.company;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Stationary {
    String No;
    String name;
    String price;
    String subject;
    String color;
    String FileType;
    String[] cols = {"no","name","price","subject","color","filetype"};

    public void Book(String No,String name, String price,String sub) {
        this.No=No;
        this.name=name;
        this.price=price;
        this.subject=sub;
    }

    public void Pencil(String No,String name, String price,String col) {
        this.No=No;
        this.name=name;
        this.price=price;
        this.color=col;
    }

    public void Pen(String No,String name, String price,String col) {
        this.No=No;
        this.name=name;
        this.price=price;
        this.color=col;
    }

    public void File(String No,String name, String FileType) {
        this.No=No;
        this.name=name;
        this.FileType=FileType;
    }

    public String getNo() {
        return No;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getSubject() {
        return subject;
    }

    public String getColor() {
        return color;
    }

    public String getFileType() {
        return FileType;
    }

    public void setNo(String no) {
        No = no;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setFileType(String fileType) {
        FileType = fileType;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void display(String TempUserInput) throws SQLException {
        String ItemName;
        String sql;
        ArrayList<String> list=null;
        if (TempUserInput.equals("0")){
            ItemName="ALL";
        }
        else {
            ItemName = TempUserInput;
        }
        DBUtils data = new DBUtils();
        list = DBUtils.view("s",ItemName,cols);
        System.out.println(list);
    }

    public ArrayList<String> DisplayForView(ArrayList<String> db,String ItemCode){
        ArrayList<String> Temp = new ArrayList<>();
        int i=0;
        for (String s : db){
            if (ItemCode.equals(s)){
                Temp.add(db.get(i));
                Temp.add(db.get(i+1));
                Temp.add(db.get(i+2));
                Temp.add(db.get(i+3));
                Temp.add(db.get(i+4));
                Temp.add(db.get(i+5));
            }
            i++;
        }
        return Temp;
    }
}
