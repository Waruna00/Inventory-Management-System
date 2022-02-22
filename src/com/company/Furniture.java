package com.company;

import java.util.ArrayList;

public class Furniture {
    String No;
    String name;
    String material;
    String color;
    String shape;

    public void Chair(String No,String name, String mat, String col){
        this.No=No;
        this.name = name;
        this.material = mat;
        this.color = col;

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

    public void display(ArrayList<String> db, int TempUserInput){
        String ItemName;
        if (TempUserInput==0){
            ItemName="ALL";
        }
        else if (TempUserInput==1){
            ItemName="CH";
        }
        else if (TempUserInput==2){
            ItemName="TB";
        }
        else if (TempUserInput==3){
            ItemName="BR";
        }
        else {
            ItemName="CP";
        }
        ArrayList<String> TempList = new ArrayList<>();

        if (ItemName.equals("ALL")) {
            TempList.addAll(db);
        }
        else {
            for (int i=0; i< db.size(); i=i+5){
                String No=db.get(i);
                String IN1 = Character.toString(No.charAt(0));
                String IN2 = Character.toString(No.charAt(1));
                String IN = IN1+IN2;
                if (IN.equals(ItemName)){
                    for(int ii=i; ii<i+5; ii++){
                        TempList.add(db.get(ii));
                    }
                }
            }
        }

        System.out.print("No"+"\t"+"Name"+"\t"+"Material "+" Color"+"\t"+"Shape"+"\n");
        int i=1;
        for (String s : TempList) {
            System.out.print(s+"\t");
            if (i%5==0){
                System.out.print("\n");
            }
            i++;
        }
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
        for (String s : db){
            if (ItemCode==s){
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

