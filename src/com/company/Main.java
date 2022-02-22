package com.company;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {


    public static String[] TempData = new String[10];
    public static String TempVal;
    public static Scanner sc = new Scanner(System.in);

    public static ArrayList<String> Fdb = new ArrayList<>();
    public static ArrayList<String> Sdb = new ArrayList<>();
    public static ArrayList<String> Edb = new ArrayList<>();

    public static void enter(){
        while (true){
            System.out.println("=================================================================================");
            System.out.println("Press 1 for Furniture, Press 2 for Electronic Equipment, Press 3 for Stationary");
            System.out.print("Enter the item category :");
            int category = sc.nextInt();

            if(category == 1) { //when user need to enter new Furniture item

                while (true) {
                    System.out.println("=================================================================================");
                    System.out.println("[Press 1 for Chair, Press 2 for Table, Press 3 for Book Rack, Press 4 for Cupboard]");
                    System.out.print("Select the item name : ");
                    int name = sc.nextInt();

                    if(!(name==1 || name==2 || name==3 || name==4)){
                        System.out.println("Invalid Input. Please Re-Enter..");
                        continue;
                    }


                    System.out.print("Material : ");
                    TempVal = sc.next();
                    TempData[0] = TempVal;

                    System.out.print("Color : ");
                    TempVal = sc.next();
                    TempData[1] = TempVal;

                    Furniture fur = new Furniture();

                    if (name == 1) {

                        fur.Chair("CH"+(Fdb.size()/5+1),"Chair",TempData[0], TempData[1]);
                        Fdb.add(fur.getNo());
                        Fdb.add(fur.getName());
                        Fdb.add(fur.getMaterial());
                        Fdb.add(fur.getColor());
                        Fdb.add("---");
                        System.out.print("Item Recorded with No : "+ fur.getNo());
                        //System.out.print(Fdb.size());

                        break;
                    }
                    else if (name == 2) {

                        System.out.print("Shape : ");
                        TempVal = sc.next();
                        TempData[2] = TempVal;
                        fur.Table("TB"+(Fdb.size()/5+1),"Table",TempData[0], TempData[1], TempData[2]);
                        Fdb.add(fur.getNo());
                        Fdb.add(fur.getName());
                        Fdb.add(fur.getMaterial());
                        Fdb.add(fur.getColor());
                        Fdb.add(fur.getShape());
                        System.out.print("Item Recorded with No : "+ fur.getNo());
                        break;
                    }
                    else if (name == 3) {
                        fur.BookRacks("BR"+(Fdb.size()/5+1),"Book Rack",TempData[0], TempData[1]);
                        Fdb.add(fur.getNo());
                        Fdb.add(fur.getName());
                        Fdb.add(fur.getMaterial());
                        Fdb.add(fur.getColor());
                        Fdb.add("---");
                        System.out.print("Item Successfully Recorded with, Item No : "+ fur.getNo());
                        break;
                    }
                    else{
                        fur.Cupboard("CP"+(Fdb.size()/5+1),"Cupboard",TempData[0], TempData[1]);
                        Fdb.add(fur.getNo());
                        Fdb.add(fur.getName());
                        Fdb.add(fur.getMaterial());
                        Fdb.add(fur.getColor());
                        Fdb.add("---");
                        System.out.print("Item Recorded with No : "+ fur.getNo());
                        break;
                    }

                }
                //System.out.println(name);
            }
            else if(category == 2){
                while(true){
                    System.out.println("=================================================================================");
                    System.out.println("Press 1 for Movable, Press 2 for Un-movable");
                    System.out.print("Enter the item category :");
                    int choice = sc.nextInt();

                    if (choice==1){
                        while(true){
                            System.out.println("=================================================================================");
                            System.out.println("[Press 1 for LapTop, Press 2 for Router, Press 3 for Tablet PC]");
                            System.out.print("Select th item name : ");
                            int name = sc.nextInt();

                            if(!(name==1 || name==2 || name==3)){
                                System.out.println("Invalid Input. Please Re-Enter..");
                                continue;
                            }

                            System.out.print("Price : ");
                            TempVal = sc.next();
                            TempData[0]=TempVal;

                            Electronic.Movable m = new Electronic.Movable();


                            if (name == 1){
                                System.out.print("Color : ");
                                TempVal = sc.next();
                                TempData[1]=TempVal;

                                m.Laptop("LP"+(Edb.size()/8+1),"LapTop",TempData[0],TempData[1]);
                                Edb.add(m.getNo());
                                Edb.add(m.getType());
                                Edb.add(m.getName());
                                Edb.add(m.getColor());
                                Edb.add(m.getPrice());
                                Edb.add("---");
                                Edb.add("---");
                                Edb.add("---");
                                break;
                            }

                            else if (name==2){

                                System.out.print("Internet Service Provider : ");
                                TempVal = sc.next();
                                TempData[1]=TempVal;

                                m.Router("RU"+(Edb.size()/8+1),"Router",TempData[0],TempData[1]);
                                Edb.add(m.getNo());
                                Edb.add(m.getType());
                                Edb.add(m.getName());
                                Edb.add("---");
                                Edb.add(m.getPrice());
                                Edb.add(m.getISP());
                                Edb.add("---");
                                Edb.add("---");
                                break;
                            }

                            else{
                                System.out.print("Enter the tablet brand : ");
                                TempVal = sc.next();
                                TempData[1]=TempVal;

                                m.Tablet("TA"+(Edb.size()/8+1),"Tablet PC",TempData[0],TempData[1]);
                                Edb.add(m.getNo());
                                Edb.add(m.getType());
                                Edb.add(m.getName());
                                Edb.add("---");
                                Edb.add(m.getPrice());
                                Edb.add("---");
                                Edb.add(m.getBrand());
                                Edb.add("---");
                                break;
                            }
                        }
                        break;
                    }
                    else if (choice==2){

                        while(true){
                            System.out.println("=================================================================================");
                            System.out.println("[Press 1 for Fan, Press 2 for Router, Press 3 for Air Conditioner]");
                            System.out.print("Select the item name : ");
                            int name = sc.nextInt();

                            if(!(name==1 || name==2 || name==3)){
                                System.out.println("Invalid Input. Please Re-Enter..");
                                continue;
                            }

                            System.out.print("Price : ");
                            TempVal = sc.next();
                            TempData[0]=TempVal;
                            Electronic.Unmovable um = new Electronic.Unmovable();


                            if (name == 1){
                                System.out.print("Brand : ");
                                TempVal = sc.next();
                                TempData[1]=TempVal;
                                um.Fan("FN"+(Edb.size()/8+1),"Fan",TempData[0],TempData[1]);
                                Edb.add(um.getNo());
                                Edb.add(um.getType());
                                Edb.add(um.getName());
                                Edb.add("---");
                                Edb.add(um.getPrice());
                                Edb.add("---");
                                Edb.add(um.getBrand());
                                Edb.add("---");
                                break;
                            }

                            else if (name==2){

                                System.out.print("Printer Type : ");
                                TempVal = sc.next();
                                TempData[1]=TempVal;
                                um.Printer("PR"+(Edb.size()/8+1),"Printer",TempData[0],TempData[1]);
                                Edb.add(um.getNo());
                                Edb.add(um.getType());
                                Edb.add(um.getName());
                                Edb.add("---");
                                Edb.add(um.getPrice());
                                Edb.add("---");
                                Edb.add("---");
                                Edb.add(um.getPrinterType());
                                break;
                            }

                            else{
                                System.out.print("Enter the Air Conditioner brand : ");
                                TempVal = sc.next();
                                TempData[1]=TempVal;
                                um.AC("AC"+(Edb.size()/8+1),"Air Conditioner",TempData[0],TempData[1]);
                                Edb.add(um.getNo());
                                Edb.add(um.getType());
                                Edb.add(um.getName());
                                Edb.add("---");
                                Edb.add(um.getPrice());
                                Edb.add("---");
                                Edb.add(um.getBrand());
                                Edb.add("---");
                                break;
                            }
                        }
                        break;

                    }

                    else{
                        System.out.println("Invalid Input. Please Re-enter..");
                    }
                }

            }
            else if(category == 3){
                while (true) {
                    System.out.println("=================================================================================");
                    System.out.println("[Press 1 for Book, Press 2 for Pencil, Press 3 for Pen, Press 4 for File]");
                    System.out.print("Select the item name : ");
                    int name = sc.nextInt();

                    if(!(name==1 || name==2 || name==3 || name==4)){
                        System.out.println("Invalid Input. Please Re-Enter..");
                        continue;
                    }

                    Stationary sta = new Stationary();

                    if (name == 1) {
                        System.out.print("Price : ");
                        TempVal = sc.next();
                        TempData[0] = TempVal;

                        System.out.print("Subject : ");
                        TempVal = sc.next();
                        TempData[1] = TempVal;
                        sta.Book("BK"+(Sdb.size()/6+1),"Book",TempData[0], TempData[1]);
                        Sdb.add(sta.getNo());
                        Sdb.add(sta.getName());
                        Sdb.add(sta.getPrice());
                        Sdb.add(sta.getSubject());
                        Sdb.add("---");
                        Sdb.add("---");
                        break;
                    }
                    else if (name == 2) {
                        System.out.print("Price : ");
                        TempVal = sc.next();
                        TempData[0] = TempVal;

                        System.out.print("Color : ");
                        TempVal = sc.next();
                        TempData[1] = TempVal;

                        sta.Pencil("PC"+(Sdb.size()/6+1),"Pencil",TempData[0], TempData[1]);
                        Sdb.add(sta.getNo());
                        Sdb.add(sta.getName());
                        Sdb.add(sta.getPrice());
                        Sdb.add("---");
                        Sdb.add(sta.getColor());
                        Sdb.add("---");
                        break;
                    }
                    else if (name == 3) {
                        System.out.print("Price : ");
                        TempVal = sc.next();
                        TempData[0] = TempVal;

                        System.out.print("Color : ");
                        TempVal = sc.next();
                        TempData[1] = TempVal;

                        sta.Pen("PE"+(Sdb.size()/6+1),"Pen",TempData[0], TempData[1]);
                        Sdb.add(sta.getNo());
                        Sdb.add(sta.getName());
                        Sdb.add(sta.getPrice());
                        Sdb.add("---");
                        Sdb.add(sta.getColor());
                        Sdb.add("---");

                        break;
                    }
                    else{
                        System.out.print("File Type : ");
                        TempVal = sc.next();
                        TempData[0] = TempVal;

                        sta.File("FL"+(Sdb.size()/6+1),"File",TempData[0]);
                        Sdb.add(sta.getNo());
                        Sdb.add(sta.getName());
                        Sdb.add("---");
                        Sdb.add("---");
                        Sdb.add("---");
                        Sdb.add(sta.getFileType());
                        break;
                    }

                }
            }
            else{
                System.out.println("Error input");
                continue;
            }
            break;
        }
    }

    public static void view(){
        int category;
        int TempUserInput;
        int choice;
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("=================================================================================");
            System.out.println("Press 1 for Furniture, Press 2 for Electronic Equipment, Press 3 for Stationary");
            System.out.print("Enter the item category :");
            category = sc.nextInt();

            if (!(category==1 || category==2 || category==3)){
                System.out.println("Invalid Input. Please Re-Enter..");
                continue;
            }
            break;
        }

        if (category==1){
            while (true){
                System.out.println("=================================================================================");
                System.out.println("[ Press 0 for View All Items Press 1 for Chair, Press 2 for Tables, Press 3 for Book Racks, Press 4 for Cupboards ]");
                System.out.print("Enter the Item name :");
                TempUserInput = sc.nextInt();

                if (!(TempUserInput==0 || TempUserInput==1 || TempUserInput==2 || TempUserInput==3 || TempUserInput==4)){
                    System.out.println("Invalid Input. Please Re-Enter..");
                    continue;
                }
                break;
            }
            Furniture fur = new Furniture();
            fur.display(Fdb,TempUserInput);
        }
        else if (category==2){
            Electronic elc = new Electronic();
            while (true){
                System.out.println("=================================================================================");
                System.out.println("Press 0 for All Categories, Press 1 for Movable, Press 2 for Un-movable");
                System.out.print("Enter the item category :");
                choice = sc.nextInt();

                if (!(choice==0 || choice==1 || choice==2)){
                    System.out.println("Invalid Input. Please Re-Enter..");
                    continue;
                }
                break;
            }

            if (choice==0){
                while (true){
                    System.out.println("=================================================================================");
                    System.out.println("[ Press 0 for View All Items Press 1 for LapTop, Press 2 for Routers, Press 3 for Tablet PC ]");
                    System.out.print("Enter the Item name :");
                    TempUserInput = sc.nextInt();

                    if (!(TempUserInput==0 || TempUserInput==1 || TempUserInput==2 || TempUserInput==3 || TempUserInput==-1)){
                        System.out.println("Invalid Input. Please Re-Enter..");
                        continue;
                    }
                    break;
                }
            }

            else if (choice==2){
                while (true){
                    System.out.println("=================================================================================");
                    System.out.println("[ Press 0 for View All Items Press 1 for Fans, Press 2 for Printers, Press 3 for Air Conditioners ]");
                    System.out.print("Enter the Item name :");
                    TempUserInput = sc.nextInt();

                    if (!(TempUserInput==0 || TempUserInput==1 || TempUserInput==2 || TempUserInput==3 || TempUserInput==-1)){
                        System.out.println("Invalid Input. Please Re-Enter..");
                        continue;
                    }
                    break;
                }
            }

            else {
                TempUserInput=-1;
            }

            elc.display(Edb,TempUserInput,choice);
        }

        else{
            while (true){
                System.out.println("=================================================================================");
                System.out.println("[ Press 0 for View All Items, Press 1 for Books, Press 2 for Pencils, Press 3 Pens, Press 4 for File ]");
                System.out.print("Enter the Item name :");
                TempUserInput = sc.nextInt();

                if (!(TempUserInput==0 || TempUserInput==1 || TempUserInput==2 || TempUserInput==3 || TempUserInput==4)){
                    System.out.println("Invalid Input. Please Re-Enter..");
                    continue;
                }
                break;
            }
            Stationary sta = new Stationary();
            sta.display(Sdb,TempUserInput);
        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("\n"+"=================================================================================");
            System.out.println("Press 1 for enter new items to inventory");
            System.out.println("Press 2 for modify existing item details");
            System.out.println("Press 3 for remove items from the inventory");
            System.out.println("Press 4 for view the items available in the inventory");
            System.out.println("Press 0 for Exit");
            int option = sc.nextInt();

            if (option==1){
                //Enter en = new Enter();
                enter();
            }
            else if (option == 2){
                //Modify mod = new Modify();
                //modify();
            }
            else if (option == 3){
                //Remove rem = new Remove();
                //remove();
            }
            else if (option == 4){
                //View vie = new View();
                view();
            }
            else if (option==0){
                break;
            }
            else{
                System.out.println("Error input");
            }
        }
    }
}
