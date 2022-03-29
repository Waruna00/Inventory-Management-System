package com.company;
import java.sql.SQLException;
import java.util.ArrayList;

public class Furniture {
    String No;
    String name;
    String material;
    String color;
    String shape;
    String[] cols = {"no","name","material","color","shape"};

    public void Chair(String No,String name, String mat, String col){
        this.No=No;
        this.name = name;
        this.material = mat;
        this.color = col;
        //this.shape=shp;

    }

    public void Table(String No,String name,String mat, String col, String shp){
        this.No=No;
        this.name = name;
        this.material = mat;
        this.color = col;
        this.shape = shp;
    }

    public void BookRacks(String No,String name,String mat, String col) {
        this.No=No;
        this.name =name;
        this.material = mat;
        this.color = col;
    }

    public void Cupboard(String No,String name,String mat, String col) {
        this.No=No;
        this.name =name;
        this.material = mat;
        this.color = col;
    }

    public String getShape() {
        return shape;
    }

    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public String getMaterial() {
        return material;
    }

    public String getNo() {
        return No;
    }

    public void display(String TempUserInput) throws SQLException {
        String ItemName;
        ArrayList<String> list=null;
        if (TempUserInput.equals("0")){
            ItemName="ALL";
        }
        else {
            ItemName = TempUserInput;
        }
        DBUtils data = new DBUtils();
        list = DBUtils.view("f",ItemName,cols);
        System.out.println(list);
    }

    public void setNo(String no) {
        No = no;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public ArrayList<String> DisplayForView(ArrayList<String> db,String ItemCode){
        ArrayList<String> Temp = new ArrayList<>();
        int i=0;
        Temp = DBUtils.view("f",ItemCode,cols);
        for (String s : db){
            if (ItemCode.equals(s)){
                Temp.add(db.get(i));
                Temp.add(db.get(i+1));
                Temp.add(db.get(i+2));
                Temp.add(db.get(i+3));
                Temp.add(db.get(i+4));
            }
            i++;
        }
        return Temp;
    }
}

