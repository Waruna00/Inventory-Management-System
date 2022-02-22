package com.company;

import java.util.ArrayList;

public class Electronic {
    String No;
    String type;
    String name;
    String price;
    String color;
    String ISP;
    String brand;
    String PrinterType;


    public static class Movable extends Electronic{


        public void Laptop(String No,String name,String price, String color) {
            this.No=No;
            this.type="Unmovable";
            this.name=name;
            this.price=price;
            this.color=color;
            this.ISP="---";
            this.brand="---";
            this.PrinterType="---";
        }

        public void Router(String No,String name,String price, String ISP) {
            this.No=No;
            this.type="Unmovable";
            this.name=name;
            this.price=price;
            this.color="---";
            this.ISP=ISP;
            this.brand="---";
            this.PrinterType="---";
        }

        public void Tablet(String No,String name,String price, String brand) {
            this.No=No;
            this.type="Unmovable";
            this.name=name;
            this.price=price;
            this.color="---";
            this.ISP="---";
            this.brand=brand;
            this.PrinterType="---";
        }
    }

    public static class Unmovable extends Electronic{

        public void Fan(String No,String name,String price, String brand) {
            this.No=No;
            this.type="Movable";
            this.name=name;
            this.price=price;
            this.color="---";
            this.ISP="---";
            this.brand=brand;
            this.PrinterType="---";
        }

        public void Printer(String No,String name,String price, String PrinterType) {
            this.No=No;
            this.type="Movable";
            this.name=name;
            this.price=price;
            this.color="---";
            this.ISP="---";
            this.brand="---";
            this.PrinterType=PrinterType;
        }

        public void AC(String No,String name,String price, String brand) {
            this.No=No;
            this.type="Movable";
            this.name=name;
            this.price=price;
            this.color="---";
            this.ISP="---";
            this.brand=brand;
            this.PrinterType="---";
        }
    }

    public String getNo() {
        return No;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getPrice() {
        return price;
    }

    public String getISP() {
        return ISP;
    }

    public String getBrand() {
        return brand;
    }

    public String getPrinterType() {
        return PrinterType;
    }


    public void display(ArrayList<String> db, int TempUserInput, int choice){
        String ItemName;
        if (TempUserInput==-1){
            ItemName="ALL";
        }
        else if (TempUserInput==1 && choice==1){
            ItemName="LP";
        }
        else if (TempUserInput==2 && choice==1){
            ItemName="RU";
        }
        else if (TempUserInput==3 && choice==1){
            ItemName="TB";
        }
        else if (TempUserInput==1 && choice==2){
            ItemName="FN";
        }
        else if (TempUserInput==2 && choice==2){
            ItemName="FPR";
        }
        else if (TempUserInput==3 && choice==2){
            ItemName="AC";
        }
        else if (TempUserInput==0 && choice==1){
            ItemName="M";
        }
        else{
            ItemName="UM";
        }

        ArrayList<String> TempList = new ArrayList<>();

        switch (ItemName) {
            case "ALL":
                TempList.addAll(db);
                break;
            case "M":
                for (int i = 0; i < db.size(); i = i + 8){
                    String No = db.get(i);
                    String IN1 = Character.toString(No.charAt(0));
                    String IN2 = Character.toString(No.charAt(1));
                    String IN = IN1 + IN2;
                    if (IN.equals("LP")||IN.equals("RU")||IN.equals("TA")) {
                        for (int ii = i; ii < i + 8; ii++) {
                            TempList.add(db.get(ii));
                        }
                    }
                }
                break;
            case "UM":
                for (int i = 0; i < db.size(); i = i + 8){
                    String No = db.get(i);
                    String IN1 = Character.toString(No.charAt(0));
                    String IN2 = Character.toString(No.charAt(1));
                    String IN = IN1 + IN2;
                    if (IN.equals("FN")||IN.equals("PR")||IN.equals("AC")) {
                        for (int ii = i; ii < i + 8; ii++) {
                            TempList.add(db.get(ii));
                        }
                    }
                }

                break;
            default:
                for (int i = 0; i < db.size(); i = i + 8) {
                    String No = db.get(i);
                    String IN1 = Character.toString(No.charAt(0));
                    String IN2 = Character.toString(No.charAt(1));
                    String IN = IN1 + IN2;
                    if (IN.equals(ItemName)) {
                        for (int ii = i; ii < i + 8; ii++) {
                            TempList.add(db.get(ii));
                        }
                    }
                }
                break;
        }

        System.out.print("No"+"\t"+"Name"+"\t"+"Color"+"\t"+"Price"+"\t"+"ISP"+"\t"+"Brand"+"\t"+"Printer Type"+"\n");
        int i=1;
        for (String s : TempList) {
            System.out.print(s+"\t");
            if (i%8==0){
                System.out.print("\n");
            }
            i++;
        }
    }
}
