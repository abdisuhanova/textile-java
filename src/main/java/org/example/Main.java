package org.example;


import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
                public static void main(String args[]) throws IOException {
                    System.out.println("Please, login!");
                    chooseUsers();
                }

                // Account choice
                public static String chooseUsers() throws IOException {
                    Scanner sc = new Scanner(System.in);

                    System.out.println("Choose your speciality :");
                    System.out.println("(1) Provider");
                    System.out.println("(2) Saleman");
                    System.out.println("(3) Delivery");
                    do {
                        System.out.print("Ваш выбор: ");
                        String choose = sc.nextLine();
                        switch (choose) {
                            case "Provider":
                            case "provider":
                            case "1":
                                System.out.println("Welcome, Provider!");
                                System.out.println("Enter your login and password");
                                providerInputLgPw();
                                break;
                            case "saleman":
                            case "Saleman":
                            case "2":
                                System.out.println("Welcome, Saleman");
                                System.out.println("Enter your login and password");
                                salemanInputLgPw();
                                break;
                            case "deliveryman":
                            case "Deliveryman":
                            case "3":
                                System.out.println("Welcome, Deliveryman");
                                System.out.println("Enter your login and password");
                                deliverymanInputLgPw();
                                break;
                            default:
                                System.out.println("Who are you?");
                                System.out.print("Do you want to logout[1] or repeat[0]? ");
                                int ex = sc.nextInt();
                                if (ex == 0) {
                                    chooseUsers();
                                } else if (ex == 1) {
                                    System.exit(0);
                                }
                        }
                        break;
                    } while (true);
                    return "";
                }

                // Providers autorization
                public static void providerInputLgPw() {
                    Scanner sc = new Scanner(System.in);

                    ArrayList<String> loginArrayList = new ArrayList<String>();
                    ArrayList<String> passwordArrayList = new ArrayList<String>();
                    loginArrayList.add("Saleman");
                    loginArrayList.add("Provider");
                    loginArrayList.add("Del");
                    passwordArrayList.add("Saleman1");
                    passwordArrayList.add("Provider1");
                    passwordArrayList.add("Del1");
                    loginArrayList.add("Saleman1");
                    passwordArrayList.add("Saleman1");
                    loginArrayList.add("Provider1");
                    passwordArrayList.add("Provider1");

                    do {
                        System.out.print("Enter login: ");
                        String input_lg = sc.next();
                        sc.nextLine();
                        System.out.print("Enter password: ");
                        String input_pw = sc.next();
                        sc.nextLine();
                        int indexArray = 0;
                        boolean haveInArray = false;
                        while (indexArray < loginArrayList.size()) {
                            if (input_lg.equals(loginArrayList.get(indexArray)) &&
                                    input_pw.equals(passwordArrayList.get(indexArray))) {
                                haveInArray = true;
                                break;
                            } else {
                                haveInArray = false;
                            }
                            indexArray++;
                        }
                        ;
                        if (haveInArray == true) {
                            System.out.println("Saleman, you have loged in successfully!");
                            providerActions();
                            break;
                        } else {
                            System.out.println("Try again");
                        }
                    } while (true);
                }

                // Salemans authorization
                public static void salemanInputLgPw() throws IOException {
                    Scanner sc = new Scanner(System.in);

                    ArrayList<String> loginArrayList = new ArrayList<String>();
                    ArrayList<String> passwordArrayList = new ArrayList<String>();
                    loginArrayList.add("provider");
                    passwordArrayList.add("provider1");

                    do {
                        System.out.print("Enter your login: ");
                        String input_lg = sc.next();
                        sc.nextLine();
                        System.out.print("Enter password: ");
                        String input_pw = sc.next();
                        sc.nextLine();
                        int indexArray = 0;
                        boolean haveInArray = false;
                        while (indexArray < loginArrayList.size()) {
                            if (input_lg.equals(loginArrayList.get(indexArray)) &&
                                    input_pw.equals(passwordArrayList.get(indexArray))) {
                                haveInArray = true;
                                break;
                            } else {
                                haveInArray = false;
                            }
                            indexArray++;
                        }
                        ;
                        if (haveInArray == true) {
                            System.out.println("Provider, you have loged in successfully!");
                            Menu();
                            break;
                        } else {
                            System.out.println("Try again");
                        }
                    } while (true);
                }

                // Deliverymans autorization
                public static void deliverymanInputLgPw() throws IOException {
                    Scanner sc = new Scanner(System.in);

                    ArrayList<String> loginArrayList = new ArrayList<String>();
                    ArrayList<String> passwordArrayList = new ArrayList<String>();
                    loginArrayList.add("Del");

                    passwordArrayList.add("Del1");

                    do {
                        System.out.print("Enter your login: ");
                        String input_lg = sc.next();
                        sc.nextLine();
                        System.out.print("Enter your password: ");
                        String input_pw = sc.next();
                        sc.nextLine();
                        int indexArray = 0;
                        boolean haveInArray = false;
                        while (indexArray < loginArrayList.size()) {
                            if (input_lg.equals(loginArrayList.get(indexArray)) &&
                                    input_pw.equals(passwordArrayList.get(indexArray))) {
                                haveInArray = true;
                                break;
                            } else {
                                haveInArray = false;
                            }
                            indexArray++;
                        }
                        ;
                        if (haveInArray == true) {
                            System.out.println("Welcome deliveryman!");
                            deliverymanActions();
                            break;
                        } else {
                            System.out.println("Try again.");
                        }
                    } while (true);
                }

                ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                // Providers action
                public static void providerActions() {
                    Scanner sc = new Scanner(System.in);

                    System.out.println("Menu:");
                    System.out.println("(1)Show list of textiles for sale");
                    System.out.println("(2)Показать количество бытовой техники");
                    System.out.println("(3)Максимальное количество бытовой техники");
                    System.out.println("(4)Минимальное количество бытовой техники");
                    System.out.println("(5)Отчет по закупкам бытовой техники");
                    System.out.println("(0)Выход");
                    do {
                        System.out.print("Ваш выбор: ");
                        String chooseAction = sc.nextLine();
                        switch (chooseAction) {
                            case "action1":
                            case "Action1":
                            case "1":
                                System.out.println("Действие 1");
                                action1();
                                providerActions();
                                break;
                            case "action2":
                            case "Action2":
                            case "2":
                                System.out.println("Действие 2");
                                action2();
                                providerActions();
                                break;
                            case "action3":
                            case "Action3":
                            case "3":
                                System.out.println("Действие 3");
                                action3();
                                providerActions();
                                break;
                            case "action4":
                            case "Action4":
                            case "4":
                                System.out.println("Действие 4");
                                action4();
                                providerActions();
                                break;
                            case "action5":
                            case "Action5":
                            case "5":
                                System.out.println("Действие 5");
                                action5();
                                providerActions();
                                break;
                            default:
                                System.out.println("Такого действия нет в программе!");
                                providerActions();
                                break;
                            case "n":
                                try {
                                    chooseUsers();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            case "action0":
                            case "Action0":
                            case "0":
                                System.out.println("Выход");
                                break;
                        }
                        break;
                    } while (true);
                }

                public static void action1() {
                    try {
                        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\ainura_inai\\IdeaProjects\\Sample\\src\\dos.txt"));
                        while (br.ready()) {
                            System.out.print(br.readLine() + " ");
                        }
                        System.out.println();
                        br.close();
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                }

                public static void action2() {
                    try {
                        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\ainura_inai\\IdeaProjects\\Sample\\src\\dos.txt"));
                        int count = 0;
                        while (br.ready()) {
                            br.readLine();
                            count++;
                        }
                        BufferedReader br1 = new BufferedReader(new FileReader("C:\\Users\\ainura_inai\\IdeaProjects\\Sample\\src\\zak.txt"));
                        int count1 = 0;
                        while (br1.ready()) {
                            br1.readLine();
                            count1++;
                        }
                        System.out.println("Всего товаров = " + (int) (count + count1));
                        br1.close();
                        br.close();
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                }

                public static void action3() {
                    try {
                        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\ainura_inai\\IdeaProjects\\Sample\\src\\dos.txt"));
                        HashMap<String, Integer> d = new HashMap<>();
                        while (br.ready()) {
                            String line = br.readLine();
                            if (d.containsKey(line)) {
                                d.put(line, (int) (d.get(line) + 1));
                            } else {
                                d.put(line, 1);
                            }
                        }

                        System.out.println(d);
                        String s = "dsd";
                        int m = 0;
                        for (String i : d.keySet()) {
                            if (d.get(i) > m) {
                                m = d.get(i);
                                s = i;
                            }
                        }
                        System.out.println("Максимальное количество бытовой техники " + s);
                        br.close();
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                }

                public static void action4() {
                    try {
                        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\ainura_inai\\IdeaProjects\\Sample\\src\\dos.txt"));
                        HashMap<String, Integer> d = new HashMap<>();
                        while (br.ready()) {
                            String line = br.readLine();
                            if (d.containsKey(line)) {
                                d.put(line, (int) (d.get(line) + 1));
                            } else {
                                d.put(line, 1);
                            }
                        }
                        System.out.println(d);
                        String s = "dsd";
                        int m = 100;
                        for (String i : d.keySet()) {
                            if (d.get(i) < m) {
                                m = d.get(i);
                                s = i;
                            }
                        }
                        System.out.println("Минимальное количество бытовой техники:" + s);
                        br.close();
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                }

                public static void action5() {
                    try {
                        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\ainura_inai\\IdeaProjects\\Sample\\src\\dos.txt"));
                        System.out.print("Доставленная бытовая техника ");
                        int countLine = 0;
                        while (br.ready()) {
                            System.out.print(br.readLine() + ", ");
                            countLine++;
                        }
                        System.out.println("Количество = " + countLine);
                        BufferedReader br1 = new BufferedReader(new FileReader("C:\\Users\\ainura_inai\\IdeaProjects\\Sample\\src\\zak.txt"));
                        System.out.print("Заказанная бытовая техника ");
                        int countline = 0;
                        while (br1.ready()) {
                            System.out.print(br1.readLine() + ", ");
                            countline++;
                        }
                        System.out.println("Количество = " + countline);
                        br1.close();
                        br.close();
                    } catch (FileNotFoundException e) {
                        System.out.println(e);
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                }

                //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//----------------------------------------------------------------------------------------------------------------------
//         Salemans actions
                public static void Menu() throws IOException {
                    System.out.println("1. Show full list of textiles for sale");
                    System.out.println("2. Search for textile");
                    System.out.println("3. Show the report about sales");
                    System.out.println("4. Place an order for an out-of-stock textile");
                    System.out.println("5.  Complete the sale of textile");
                    //System.out.println("6. Показать отсутствующие на складе бытовые техники");
                    //System.out.println("7. Показать все бытовые техники, на которых действует скидка");
                    System.out.println("6. Delete an order");
                    System.out.println("7. Exit");
                    ShowMenu();
                }

                public static void ShowMenu() throws IOException {
                    Scanner input = new Scanner(System.in);
                    while (true) {
                        System.out.print("(Type [0], for looking at the menu again) Enter-->");
                        var action = input.nextLine();
                        switch (action) {
                            case "0":
                                Menu();
                                break;
                            case "1":
                                ShowFullList();
                                break;
                            case "2":
                                Search();
                                break;
                            case "3":
                                ShowReport();
                                break;
                            case "4":
                                Order();
                                break;
                            case "5":
                                OrderList();
                                break;
                            //case "6":
                              //  Lack();
                                //break;
                            //case "7":
                              //  Discount();
                                //break;
                            case "6":
                                Delete();
                                break;
                            case "n":
                                try {
                                    chooseUsers();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            case "7":
                                exit();
                                break;
                            default:
                                System.out.print("Please, enter number from menu.");
                        }
                    }
                }

                private static void ShowFullList() throws FileNotFoundException, IOException {
                    try {
                        FileInputStream file = new FileInputStream(new File("C:\\Users\\ainura_inai\\IdeaProjects\\Sample\\src\\БытоваяТехника.xlsx"));
                        XSSFWorkbook workbook = new XSSFWorkbook(file);
                        XSSFSheet sheet = workbook.getSheetAt(0);
                        Iterator<Row> rowIterator = sheet.iterator();

                        while (rowIterator.hasNext()) {
                            Row row = rowIterator.next();
                            for (var colIndex = 0; colIndex < 3; colIndex += 2) {
                                Cell cell = row.getCell(colIndex);
                                switch (cell.getCellType()) {
                                    case Cell.CELL_TYPE_NUMERIC:
                                        System.out.printf("%.0f", cell.getNumericCellValue());
                                        break;
                                    case Cell.CELL_TYPE_STRING:
                                        System.out.print(cell.getStringCellValue() + "\t\t");
                                        break;
                                }
                            }
                            System.out.println();
                        }
                        file.close();
                    } catch (Exception e) {
                        System.out.println("Smth is wrong!");
                    }
                }

                private static void Search() throws FileNotFoundException, IOException {
                    Scanner input = new Scanner(System.in);
                    FileInputStream file = new FileInputStream(new File("C:\\Users\\ainura_inai\\IdeaProjects\\Sample\\src\\БытоваяТехника.xlsx"));
                    XSSFWorkbook workbook = new XSSFWorkbook(file);
                    XSSFSheet sheet = workbook.getSheetAt(0);
                    System.out.print("Enter the name of textile or id-->");
                    String search = input.nextLine();
                    Iterator<Row> rowIterator = sheet.iterator();
                    while (rowIterator.hasNext()) {
                        Row row = rowIterator.next();
                        var name = row.getCell(0);
                        var sernum = row.getCell(1);
                        if (name.getStringCellValue().trim().equals(search) || sernum.getStringCellValue().trim().equals(search)) {
                            Iterator<Cell> cellIterator = row.cellIterator();
                            while (cellIterator.hasNext()) {
                                Cell cell = cellIterator.next();
                                switch (cell.getCellType()) {
                                    case Cell.CELL_TYPE_NUMERIC:
                                        System.out.printf("%.0f", cell.getNumericCellValue());
                                        System.out.print("\t\t");
                                        break;
                                    case Cell.CELL_TYPE_STRING:
                                        System.out.print(cell.getStringCellValue() + "\t\t");
                                        break;
                                }
                            }
                            System.out.println();
                        }

                    }
                    file.close();
                }

                private static void ShowReport() {
                    try {
                        FileInputStream file = new FileInputStream(new File("C:\\Users\\ainura_inai\\IdeaProjects\\Sample\\src\\БытоваяТехника.xlsx"));
                        XSSFWorkbook workbook = new XSSFWorkbook(file);
                        XSSFSheet sheet = workbook.getSheetAt(0);
                        Iterator<Row> rowIterator = sheet.iterator();

                        while (rowIterator.hasNext()) {
                            Row row = rowIterator.next();
                            for (var colIndex = 0; colIndex < 5; colIndex += 2) {
                                Cell cell = row.getCell(colIndex);
                                switch (cell.getCellType()) {
                                    case Cell.CELL_TYPE_NUMERIC:
                                        System.out.printf("%.0f", cell.getNumericCellValue());
                                        System.out.print("\t\t");
                                        break;
                                    case Cell.CELL_TYPE_STRING:
                                        System.out.print(cell.getStringCellValue() + "\t\t");
                                        break;
                                }
                            }
                            System.out.println();
                        }
                        file.close();
                    } catch (Exception e) {
                        System.out.println("Smth is wrong!");
                    }
                }

                private static void Order() {
                    String path = "C:\\Users\\ainura_inai\\IdeaProjects\\Sample\\src\\zak.txt";
                    try {
                        BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));
                        Scanner input = new Scanner(System.in);

                        do {
                            System.out.print("Enter name of the textile, which you want to order-->");
                            String thing = input.nextLine();
                            if (thing == null || StringUtils.isEmpty(thing.trim())) {
                                break;
                            } else {
                                writer.newLine();
                                writer.write(thing);
                            }

                        } while (true);
                        writer.close();
                    } catch (IOException e) {
                        System.out.println(e);
                    } finally {
                        System.out.println("Order is placed.");
                    }
                }

                private static void OrderList() {
                    String path = "C:\\Users\\ainura_inai\\IdeaProjects\\Sample\\src\\zak.txt";
                    try {
                        BufferedReader reader = new BufferedReader(new FileReader(path));
                        while (reader.ready()) {
                            System.out.println(reader.readLine());
                        }
                        reader.close();
                    } catch (IOException e) {
                        System.out.println(e);
                    } finally {
                        System.out.println("Ordered textile was shown for current time.");
                    }
                }

                private static void Lack() throws FileNotFoundException, IOException {
                    FileInputStream file = new FileInputStream(new File("C:\\Users\\ainura_inai\\IdeaProjects\\Sample\\src\\БытоваяТехника.xlsx"));
                    XSSFWorkbook workbook = new XSSFWorkbook(file);
                    XSSFSheet sheet = workbook.getSheetAt(0);
                    Iterator<Row> rowIterator = sheet.iterator();
                    while (rowIterator.hasNext()) {
                        Row row = rowIterator.next();
                        var amount = row.getCell(2);
                        amount.setCellType(Cell.CELL_TYPE_STRING);
                        if (amount.getStringCellValue().equals("0")) {
                            for (var colIndex = 0; colIndex < 3; colIndex += 2) {
                                Cell cell = row.getCell(colIndex);
                                switch (cell.getCellType()) {
                                    case Cell.CELL_TYPE_NUMERIC:
                                        System.out.printf("%.0f", cell.getNumericCellValue());
                                        System.out.print("\t\t");
                                        break;
                                    case Cell.CELL_TYPE_STRING:
                                        System.out.print(cell.getStringCellValue() + "\t\t");
                                        break;
                                }
                            }
                            System.out.println();
                        }
                    }
                    file.close();
                }

                private static void Discount() throws FileNotFoundException, IOException {
                    FileInputStream file = new FileInputStream(new File("C:\\Users\\ainura_inai\\IdeaProjects\\Sample\\src\\БытоваяТехника.xlsx"));
                    XSSFWorkbook workbook = new XSSFWorkbook(file);
                    XSSFSheet sheet = workbook.getSheetAt(0);
                    Iterator<Row> rowIterator = sheet.iterator();
                    while (rowIterator.hasNext()) {
                        Row row = rowIterator.next();
                        var amount = row.getCell(3);
                        amount.setCellType(Cell.CELL_TYPE_STRING);
                        if (amount.getStringCellValue().equals("0%")) {
                            continue;
                        } else {
                            for (var colIndex = 0; colIndex < 4; colIndex++) {
                                if (colIndex == 1) {
                                    continue;
                                }
                                Cell cell = row.getCell(colIndex);
                                switch (cell.getCellType()) {
                                    case Cell.CELL_TYPE_NUMERIC:
                                        System.out.printf("%.0f", cell.getNumericCellValue());
                                        System.out.print("\t\t");
                                        break;
                                    case Cell.CELL_TYPE_STRING:
                                        System.out.print(cell.getStringCellValue() + "\t\t");
                                        break;
                                }
                            }
                            System.out.println();
                        }
                    }
                    file.close();
                }

                private static void Delete() {
                    String path = "C:\\Users\\ainura_inai\\IdeaProjects\\Sample\\src\\zak.txt";
                    try {
                        BufferedReader reader = new BufferedReader(new FileReader(path));
                        int count = 0;
                        String letter = "";
                        Scanner input = new Scanner(System.in);
                        System.out.print("Enter-->");
                        String delThing = input.next();
                        Scanner scanner = new Scanner(new File("C:\\Users\\ainura_inai\\IdeaProjects\\Sample\\src\\zak.txt"));
                        boolean haveIt = false;
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            count++;
                            if (line.contains(delThing)) {
                                haveIt = true;
                                break;
                            }
                        }
                        if (haveIt == false) {
                            System.out.println("There's no textile like this in a file");
                            System.out.print("Do you want to exit[0] or try again[1]?-->");
                            int ask = input.nextInt();
                            if (ask == 1) {
                                Delete();
                            } else if (ask == 0) {
                                Menu();
                            }
                        }
                        var skipIndex = 0;
                        while (reader.ready()) {
                            skipIndex++;
                            if (skipIndex != count) {
                                letter += reader.readLine() + "\n";
                            } else {
                                reader.readLine();
                            }
                        }
                        System.out.println(letter);
                        reader.close();
                    } catch (IOException e) {
                        System.out.println(e);
                    } finally {
                        System.out.println("Updated version of list of ordered textiles was shown.");
                    }
                }

                private static void exit() {
                    System.exit(0);
                }

//----------------------------------------------------------------------------------------------------------------------

            // Deliverymans actions
            public static void deliverymanActions() throws IOException {
                Scanner sc = new Scanner(System.in);
                System.out.println("Menu:");
                System.out.println("(1)List of textiles for delivery.");
                System.out.println("(2)Доставленная бытовая техника.");
                System.out.println("(3)Доставить бытовую технику.");
                System.out.println("(4)Количество доставленной бытовой.");
                System.out.println("(5)Количество заказанной бытовой техники.");
                System.out.println("(6)Мой заработок.");
                System.out.println("(0)Выход");
                do {
                    System.out.print("Ваш выбор: ");
                    String chooseAction = sc.nextLine();
                    switch (chooseAction) {
                        case "n":
                            try {
                                chooseUsers();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        case "action1":
                        case "Action1":
                        case "1":
                            //LIST OF ORDERED TEXTILES.
                            try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\ainura_inai\\IdeaProjects\\Sample\\src\\zak.txt"))) {
                                String line = null;
                                while ((line = br.readLine()) != null) {
                                    System.out.println(line);
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            deliverymanActions();
                            break;

                        case "action2":
                        case "Action2":
                        case "2":
                            //СПИСОК ДОСТАВЛЕННОЙ ТЕХНИКИ.
                            try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\ainura_inai\\IdeaProjects\\Sample\\src\\dos.txt"))) {
                                String line = null;
                                while ((line = br.readLine()) != null) {
                                    System.out.println(line);
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            deliverymanActions();
                            break;

                        case "action3":
                        case "Action3":
                        case "3":
                            System.out.println("Действие 3");
                            //--ДОСТАВИТЬ ЗАКАЗ--
                            ArrayList<String> appliances = new ArrayList<String>(); // Для доставки
                            try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\ainura_inai\\IdeaProjects\\Sample\\src\\zak.txt"))) {
                                String line = null;
                                while ((line = br.readLine()) != null) {
                                    appliances.add(line);
                                }
                                System.out.println(appliances);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                            try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\ainura_inai\\IdeaProjects\\Sample\\src\\zak.txt", true))) {
                                String i = "";
                                bw.write(i);
                                if (i.equals(i)) {
                                    bw.close();
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\ainura_inai\\IdeaProjects\\Sample\\src\\dos.txt", true))) {
                                int i = 0;
                                while (i <= appliances.size()) {
                                    if (i == appliances.size()) {
                                        bw.close();
                                        System.out.println("Delivered!");
                                        break;
                                    } else {
                                        bw.newLine();
                                        bw.write(appliances.get(i));
                                        i++;
                                    }
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            deliverymanActions();
                            break;

                        case "action4":
                        case "Action4":
                        case "4":
                            //--Quantity of delivered textile--
                            try {

                                File myFile = new File("C:\\Users\\ainura_inai\\IdeaProjects\\Sample\\src\\dos.txt");
                                FileReader fileReader = new FileReader(myFile);
                                LineNumberReader lineNumberReader = new LineNumberReader(fileReader);

                                int lineNumber = 0;

                                while (lineNumberReader.readLine() != null) {
                                    lineNumber++;
                                }

                                System.out.println(lineNumber);

                                lineNumberReader.close();

                                String lineNumber1 = String.valueOf(lineNumber);
                                File newFile = new File("C:\\Users\\ainura_inai\\IdeaProjects\\Sample\\src\\kol.txt");
                                FileWriter fileWriter = new FileWriter(newFile);
                                fileWriter.write(lineNumber1 + " Lines in a file: " + "C:\\Users\\ainura_inai\\IdeaProjects\\Sample\\src\\dos.txt");
                                fileWriter.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            deliverymanActions();
                            break;


                        case "action5":
                        case "Action5":
                        case "5":
                            //--КОЛ-ВО ЗАКАЗАННОЙ БЫТ.ТЕХНИКИ--
                            try {

                                File myFile = new File("C:\\Users\\ainura_inai\\IdeaProjects\\Sample\\src\\zak.txt");
                                FileReader fileReader = new FileReader(myFile);
                                LineNumberReader lineNumberReader = new LineNumberReader(fileReader);

                                int lineNumber = 0;

                                while (lineNumberReader.readLine() != null) {
                                    lineNumber++;
                                }

                                System.out.println(lineNumber);

                                lineNumberReader.close();

                                String lineNumber1 = String.valueOf(lineNumber);
                                File newFile = new File("C:\\Users\\ainura_inai\\IdeaProjects\\Sample\\src\\kol.txt");
                                FileWriter fileWriter = new FileWriter(newFile);
                                fileWriter.write(lineNumber1 + " Lines in file: " + "C:\\Users\\ainura_inai\\IdeaProjects\\Sample\\src\\zak.txt");
                                fileWriter.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            deliverymanActions();
                            break;

                        case "action6":
                        case "Action6":
                        case "6":
                            int count = 0;

                            try {
                                // create a new file object
                                File file = new File("C:\\Users\\ainura_inai\\IdeaProjects\\Sample\\src\\dos.txt");

                                // create an object of Scanner
                                // associated with the file
                                Scanner mn = new Scanner(file);

                                // read each line and
                                // count number of lines
                                while (mn.hasNextLine()) {
                                    mn.nextLine();
                                    count++;
                                }
                                System.out.println("Total Number of Delivered techniques: " + count);
                                System.out.println("Your Earnings: " + count * 2000);
                                // close scanner
                                mn.close();
                            } catch (Exception e) {
                                e.getStackTrace();
                            }

                            deliverymanActions();
                            break;

                        default:
                            System.out.println("There's such action in the program!");
                            deliverymanActions();
                            break;

                        case "action0":
                        case "Action0":
                        case "0":
                            System.out.println("Exit");
                            break;

                    }
                    break;
                } while (true);
            }
}
