package com.company;

import java.util.ArrayList;

public class Stationary {
    String No;
    String name;
    String price;
    String subject;
    String color;
    String FileType;

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

    public void display(ArrayList<String> db, int TempUserInput){
        String ItemName;
        if (TempUserInput==0){
            ItemName="ALL";
        }
        else if (TempUserInput==1){
            ItemName="BK";
        }
        else if (TempUserInput==2){
            ItemName="PC";
        }
        else if (TempUserInput==3){
            ItemName="PE";
        }
        else {
            ItemName="FL";
        }
        ArrayList<String> TempList = new ArrayList<>();

        if (ItemName.equals("ALL")) {
            TempList.addAll(db);
        }
        else {
            for (int i=0; i< db.size(); i=i+5){
                if (db.get(i).equals(ItemName)){
                    for(int ii=i; ii<i+6; ii++){
                        TempList.add(db.get(ii));
                    }
                }
            }
        }

        System.out.print("No"+"\t"+"Name"+"\t"+"Price"+"\t"+"Subject"+"\t"+"Color"+"\t"+"File Type"+"\n");
        int i=1;
        for (String s : TempList) {
            System.out.print(s+"\t");
            if (i%6==0){
                System.out.print("\n");
            }
            i++;
        }
    }
}
