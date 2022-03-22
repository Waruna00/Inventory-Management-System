package com.company;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {

    /*
                     ||Group 02||

    Tharindu Sachintha          -   IM/2019/052
    Vishaka Bandara             -   IM/2019/046
    Tharindu Sankarshana        -   IM/2019/055
    Lashadya Vidumini           -   IM/2019/103
    Naveen Jayathilaka          -   IM/2019/044
    Mathurshi Vijayarajendran   -   IM/2019/037
    Waruna Sri Wickramasinghe   -   IM/2019/028
    Nipuni De Silva             -   IM/2019/093
    Nihim Abhayarathne          -   IM/2018/099
    Udara Suranimala            -   IM/2019/080
    Sandushi Weraduwa           -   IM/2019/112


    */

    DBUtils db = new DBUtils();

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
            System.out.print("Enter the item category : ");
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

    public static void view() throws SQLException {
        int category;
        String TempUserInput;
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
            System.out.println("=================================================================================");
            System.out.println("[ Press 0 for View All Items Or Enter the item no ]");
            System.out.print("Enter the Item No : ");
            TempUserInput = sc.next();

            Furniture fur = new Furniture();
            //fur.display(Fdb,TempUserInput);
        }
        else if (category==2){
            Electronic elc = new Electronic();
            System.out.println("=================================================================================");
            System.out.println("Press 0 for All Categories, Press 1 for Movable, Press 2 for Un-movable");
            System.out.print("Enter the item No :");
            choice = sc.nextInt();

            elc.display(Edb,1,choice);
        }

        else{
            System.out.println("=================================================================================");
            System.out.println("[ Press 0 for View All Items Or Enter the item no ]");
            System.out.print("Enter the Item No : ");
            TempUserInput = sc.next();

            Stationary sta = new Stationary();
            sta.display(TempUserInput);
        }

    }

    /*public static void modify(){
        while(true){
            System.out.println("=================================================================================");
            System.out.print("Enter the Item Code : ");
            String ItemCode=sc.next();
            String IN1 = Character.toString(ItemCode.charAt(0));
            String IN2 = Character.toString(ItemCode.charAt(1));
            String IN = IN1+IN2;
            if (!(IN.equals("CH") || IN.equals("TB") || IN.equals("BR") || IN.equals("CP") || IN.equals("LP") || IN.equals("RU") || IN.equals("TA") || IN.equals("FN") || IN.equals("PR") || IN.equals("AC") || IN.equals("BK") || IN.equals("PC") || IN.equals("PE") || IN.equals("FL"))){
                System.out.println("Invalid Item No. Please Re-Enter..");
                continue;
            }
            else if (IN.equals("CH") || IN.equals("TB") || IN.equals("BR") || IN.equals("CP")){
                Furniture fur =new Furniture();
                ArrayList<String> TempRec = fur.DisplayForView(Fdb,ItemCode);
                if (TempRec.size()<=5){
                    System.out.print("Invalid Item No. Please Re-Enter..");
                    continue;
                }
                switch (IN) {
                    case "CH" -> fur.Chair(TempRec.get(0), TempRec.get(1), TempRec.get(2), TempRec.get(3));
                    case "TB" -> fur.Table(TempRec.get(0), TempRec.get(1), TempRec.get(2), TempRec.get(3), TempRec.get(4));
                    case "BR" -> fur.BookRacks(TempRec.get(0), TempRec.get(1), TempRec.get(2), TempRec.get(3));
                    case "CP" -> fur.Cupboard(TempRec.get(0), TempRec.get(1), TempRec.get(2), TempRec.get(3));
                }

                System.out.print("Material : ");
                TempVal=sc.next();
                fur.setMaterial(TempVal);

                System.out.print("Color : ");
                TempVal=sc.next();
                fur.setColor(TempVal);

                if (IN.equals("TB")){
                    System.out.print("Shape : ");
                    TempVal=sc.next();
                    fur.setShape(TempVal);
                }

                String NO = ItemCode.substring(2);
                int n = Integer.parseInt(NO);
                n=n-1;
                Fdb.set(n+2,fur.getMaterial());
                Fdb.set(n+3,fur.getColor());
                Fdb.set(n+4,fur.getShape());

            }

            else if (IN.equals("LP") || IN.equals("RU") || IN.equals("TA") || IN.equals("FN") || IN.equals("PR") || IN.equals("AC")){
                Electronic.Movable m = new Electronic.Movable();
                Electronic.Unmovable um = new Electronic.Unmovable();
                Electronic elc = new Electronic();

                ArrayList<String> TempRec = elc.DisplayForView(Edb,ItemCode);
                if (TempRec==null){
                    System.out.print("Invalid Item No. Please Re-Enter..");
                    continue;
                }

                switch (IN) {
                    case "LP" -> m.Laptop(TempRec.get(0), TempRec.get(2), TempRec.get(3), TempRec.get(4));
                    case "RU" -> m.Router(TempRec.get(0), TempRec.get(2), TempRec.get(3), TempRec.get(5));
                    case "TA" -> m.Tablet(TempRec.get(0), TempRec.get(2), TempRec.get(3), TempRec.get(6));
                    case "FN" -> um.Fan(TempRec.get(0), TempRec.get(2), TempRec.get(3), TempRec.get(6));
                    case "PR" -> um.Printer(TempRec.get(0), TempRec.get(2), TempRec.get(3), TempRec.get(7));
                    case "AC" -> um.AC(TempRec.get(0), TempRec.get(2), TempRec.get(3), TempRec.get(6));
                }

                System.out.print("Price : ");
                TempVal=sc.next();
                elc.setPrice(TempVal);

                if(IN.equals("LP")){
                    System.out.print("Color : ");
                    TempVal=sc.next();
                    elc.setColor(TempVal);
                }

                if(IN.equals("RU")){
                    System.out.print("Internet Service Provider : ");
                    TempVal=sc.next();
                    elc.setISP(TempVal);
                }

                if(IN.equals("TA") || IN.equals("FN") || IN.equals("AC")){
                    System.out.print("Brand ");
                    TempVal=sc.next();
                    elc.setBrand(TempVal);
                }

                if (IN.equals("PR")){
                    System.out.print("Printer Type : ");
                    TempVal=sc.next();
                    elc.setPrinterType(TempVal);
                }

                String NO = ItemCode.substring(2);
                int n = Integer.parseInt(NO);


                Edb.set(n+3,elc.getColor());
                Edb.set(n+4,elc.getPrice());
                Edb.set(n+5,elc.getISP());
                Edb.set(n+6,elc.getBrand());
                Edb.set(n+7,elc.getPrinterType());
            }

            else {
                Stationary sta =new Stationary();
                ArrayList<String> TempRec = sta.DisplayForView(Fdb,ItemCode);
                if (TempRec==null){
                    System.out.print("Invalid Item No. Please Re-Enter..");
                    continue;
                }

                switch (IN) {
                    case "BK" -> sta.Book(TempRec.get(0), TempRec.get(1), TempRec.get(2), TempRec.get(3));
                    case "PC" -> sta.Pencil(TempRec.get(0), TempRec.get(1), TempRec.get(2), TempRec.get(4));
                    case "PE" -> sta.Pen(TempRec.get(0), TempRec.get(1), TempRec.get(2), TempRec.get(4));
                    case "FL" -> sta.File(TempRec.get(0), TempRec.get(1), TempRec.get(5));
                }

                System.out.print("Price : ");
                TempVal=sc.next();
                sta.setPrice(TempVal);

                if(IN.equals("FL")){
                    System.out.print("File Type : ");
                    TempVal=sc.next();
                    sta.setFileType(TempVal);
                }

                else if (IN.equals("BK")){
                    System.out.print("Subject : ");
                    TempVal=sc.next();
                    sta.setSubject(TempVal);
                }

                else {
                    System.out.print("Color : ");
                    TempVal=sc.next();
                    sta.setColor(TempVal);
                }

                String NO = ItemCode.substring(2);
                int n = Integer.parseInt(NO);

                Sdb.set(n+2,sta.getPrice());
                Sdb.set(n+3,sta.getSubject());
                Sdb.set(n+4,sta.getColor());
                Sdb.set(n+5,sta.getFileType());
            }
            break;
        }
    }

    public static void remove(){
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("=================================================================================");
            System.out.println("Enter the Item Code : ");
            String ItemCode=sc.next();
            String IN1 = Character.toString(ItemCode.charAt(0));
            String IN2 = Character.toString(ItemCode.charAt(1));
            String IN = IN1+IN2;
            if (!(IN.equals("CH") || IN.equals("TB") || IN.equals("BR") || IN.equals("CP") || IN.equals("LP") || IN.equals("RU") || IN.equals("TA") || IN.equals("FN") || IN.equals("PR") || IN.equals("AC") || IN.equals("BK") || IN.equals("PC") || IN.equals("PE") || IN.equals("FL"))) {
                System.out.print("Invalid Item No. Please Re-Enter..");
                continue;
            }

            else if (IN.equals("CH") || IN.equals("TB") || IN.equals("BR") || IN.equals("CP")){
                Furniture fur = new Furniture();
                ArrayList<String> TempRec = fur.DisplayForView(Fdb,ItemCode);
                if (TempRec==null){
                    System.out.print("Invalid Item No. Please Re-Enter..");
                    continue;
                }

                switch (IN) {
                    case "CH" -> fur.Chair(TempRec.get(0), TempRec.get(1), TempRec.get(2), TempRec.get(3));
                    case "TB" -> fur.Table(TempRec.get(0), TempRec.get(1), TempRec.get(2), TempRec.get(3), TempRec.get(4));
                    case "BR" -> fur.BookRacks(TempRec.get(0), TempRec.get(1), TempRec.get(2), TempRec.get(3));
                    case "CP" -> fur.Cupboard(TempRec.get(0), TempRec.get(1), TempRec.get(2), TempRec.get(3));
                }

                TempVal="---";
                fur.setMaterial(TempVal);
                fur.setColor(TempVal);
                fur.setShape(TempVal);
                fur.setNo(TempVal);
                fur.setName(TempVal);

                String NO = ItemCode.substring(2);
                int n = Integer.parseInt(NO);
                n=n-1;
                Fdb.set(n,fur.getNo());
                Fdb.set(n+1,fur.getName());
                Fdb.set(n+2,fur.getMaterial());
                Fdb.set(n+3,fur.getColor());
                Fdb.set(n+4,fur.getShape());
            }

            else if (IN.equals("LP") || IN.equals("RU") || IN.equals("TA") || IN.equals("FN") || IN.equals("PR") || IN.equals("AC")){
                Electronic.Movable m = new Electronic.Movable();
                Electronic.Unmovable um = new Electronic.Unmovable();
                Electronic elc = new Electronic();

                ArrayList<String> TempRec = new ArrayList<>(elc.DisplayForView(Edb, ItemCode));

                if (TempRec.size()<=5){
                    System.out.print("Invalid Item No. Please Re-Enter..");
                    continue;
                }
                switch (IN) {
                    case "LP" -> m.Laptop(TempRec.get(0), TempRec.get(2), TempRec.get(3), TempRec.get(4));
                    case "RU" -> m.Router(TempRec.get(0), TempRec.get(2), TempRec.get(3), TempRec.get(5));
                    case "TA" -> m.Tablet(TempRec.get(0), TempRec.get(2), TempRec.get(3), TempRec.get(6));
                    case "FN" -> um.Fan(TempRec.get(0), TempRec.get(2), TempRec.get(3), TempRec.get(6));
                    case "PR" -> um.Printer(TempRec.get(0), TempRec.get(2), TempRec.get(3), TempRec.get(7));
                    case "AC" -> um.AC(TempRec.get(0), TempRec.get(2), TempRec.get(3), TempRec.get(6));
                }

                TempVal="---";
                elc.setNo(TempVal);
                elc.setName(TempVal);
                elc.setType(TempVal);
                elc.setColor(TempVal);
                elc.setPrice(TempVal);
                elc.setISP(TempVal);
                elc.setBrand(TempVal);
                elc.setPrinterType(TempVal);

                String NO = ItemCode.substring(2);
                int n = Integer.parseInt(NO);

                Edb.set(n,elc.getNo());
                Edb.set(n+1,elc.getType());
                Edb.set(n+2,elc.getName());
                Edb.set(n+3,elc.getColor());
                Edb.set(n+4,elc.getPrice());
                Edb.set(n+5,elc.getISP());
                Edb.set(n+6,elc.getBrand());
                Edb.set(n+7,elc.getPrinterType());
            }

            else {
                Stationary sta =new Stationary();
                ArrayList<String> TempRec = sta.DisplayForView(Fdb,ItemCode);
                if (TempRec==null){
                    System.out.print("Invalid Item No. Please Re-Enter..");
                    continue;
                }

                switch (IN) {
                    case "BK" -> sta.Book(TempRec.get(0), TempRec.get(1), TempRec.get(2), TempRec.get(3));
                    case "PC" -> sta.Pencil(TempRec.get(0), TempRec.get(1), TempRec.get(2), TempRec.get(4));
                    case "PE" -> sta.Pen(TempRec.get(0), TempRec.get(1), TempRec.get(2), TempRec.get(4));
                    case "FL" -> sta.File(TempRec.get(0), TempRec.get(1), TempRec.get(5));
                }

                TempVal="---";
                sta.setNo(TempVal);
                sta.setName((TempVal));
                sta.setPrice(TempVal);
                sta.setFileType(TempVal);
                sta.setSubject(TempVal);
                sta.setColor(TempVal);

                String NO = ItemCode.substring(2);
                int n = Integer.parseInt(NO);

                Sdb.set(n,sta.getNo());
                Sdb.set(n+1,sta.getName());
                Sdb.set(n+2,sta.getPrice());
                Sdb.set(n+3,sta.getSubject());
                Sdb.set(n+4,sta.getColor());
                Sdb.set(n+5,sta.getFileType());
            }
            System.out.print("Successfully Removed the Record..!!");
            break;

        }
    }
*/
    public static void main(String[] args) throws SQLException {

        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("\n"+"=================================================================================");
            System.out.println("Press 1 for enter new items to inventory");
            System.out.println("Press 2 for modify existing item details");
            System.out.println("Press 3 for remove items from the inventory");
            System.out.println("Press 4 for view the items available in the inventory");
            System.out.println("Press 0 for Exit");
            System.out.print("User Input : ");
            int option = sc.nextInt();

            if (option==1){
                enter();
            }
            else if (option == 2){
                //modify();
            }
            else if (option == 3){
                //remove();
            }
            else if (option == 4){
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