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
import java.sql.SQLException;
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
                    loginArrayList.add("Provider");
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
                            System.out.println("Provider, you have loged in successfully!");
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
                    loginArrayList.add("saleman");
                    passwordArrayList.add("saleman1");

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
                            System.out.println("Saleman, you have loged in successfully!");
                            salemansAction();
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
                    System.out.println("(2)Show количество бытовой техники");
                    System.out.println("(3)Максимальное количество бытовой техники");
                    System.out.println("(4)Минимальное количество бытовой техники");
                    System.out.println("(5)Отчет по закупкам бытовой техники");
                    System.out.println("(0)Выход");
                    do {
                        System.out.print("Your choice: ");
                        String chooseAction = sc.nextLine();
                        switch (chooseAction) {
                            case "action1":
                            case "Action1":
                            case "1":
                                System.out.println("Action 1");
                                try {
                                    C.forDelivery();
                                } catch (IOException e) {
                                    System.out.println(e.getMessage());
                                } catch (SQLException e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case "action2":
                            case "Action2":
                            case "2":
                                System.out.println("Действие 2");
                                try {
                                    C.provided();
                                } catch (IOException e) {
                                    System.out.println(e.getMessage());
                                } catch (SQLException e) {
                                    System.out.println(e.getMessage());
                                };
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






                //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//----------------------------------------------------------------------------------------------------------------------
//         Salemans actions
                public static void salemansAction() throws IOException {
                    System.out.println("1. Show full list of textiles for sale");
                    System.out.println("2. Search for textile");
                    System.out.println("3. Show the report about sales");
                    System.out.println("4. Place an order for an out-of-stock textile");
                    System.out.println("5.  Complete the sale of textile");
                    //System.out.println("6. Показать отсутствующие на складе бытовые техники");
                    //System.out.println("7. Показать все бытовые техники, на которых действует скидка");
                    System.out.println("6. Delete an order");
                    System.out.println("7. Choose another user");
                    System.out.println("8. Exit");
                    ShowMenu();
                }
                public static void ShowMenu() throws IOException {
                    Scanner input = new Scanner(System.in);
                    while (true) {
                        String action = input.nextLine();
                        switch (action) {
                            case "0":
                                salemansAction();
                                break;
                            case "1":
                                C.listForSale();
                                break;
                            case "2":
                                System.out.println("Search by name[0] or date[1]");
                                if (input.nextInt() == 0) {
                                    System.out.println("Enter the name: ");
                                    C.searchName(input.nextLine());
                                } else if (input.nextInt() == 1) {
                                    System.out.println("Enter a date[yyyy:mm:dd");
                                    C.searchDate(input.nextLine());
                                } else {
                                    System.out.println("Unexpected input!");
                                }
                                break;
                            case "3":
                                C.soldOut();
                                break;
                            case "4":
                                System.out.println("Enter teh name of teh textile you want to sell: ");
                                C.sell(input.nextLine());
                                break;
                            case "5":
                                C.soldOut();
                                System.out.println("Enter a textiles name to order: ");
                                C.order(input.nextLine());
                                break;
                            case "6":
                                System.out.println("Which order you want to cancel?\nEnter a name of the textile: ");
                                C.cancel(input.nextLine());
                                break;
                            case "7":
                                try {
                                    chooseUsers();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            case "8":
                                exit();
                                break;
                            default:
                                System.out.print("Please, enter number from menu.");
                        }
                        System.out.print("(Type [0], for looking at the menu again) Enter-->");
                        if (input.nextInt() == 0) {
                            salemansAction();
                        } else {
                            try {
                                chooseUsers();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

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
                            try {
                                C.forDelivery();
                            } catch (IOException e) {
                                System.out.println(e.getMessage());
                            } catch (SQLException e) {
                                System.out.println(e.getMessage());
                            }
                            break;

                        case "action2":
                        case "Action2":
                        case "2":
                            try {
                                C.deliveredList();
                            } catch (IOException e) {
                                System.out.println(e.getMessage());
                            } catch (SQLException e) {
                                System.out.println(e.getMessage());
                            }
                            break;

                        case "action3":
                        case "Action3":
                        case "3":
                            System.out.println("Действие 3");
                            //--ДОСТАВИТЬ ЗАКАЗ--
                            System.out.println("Enter the name of the delivered textile: ");
                            C.deliver(sc.nextLine());
                            break;

                        case "action4":
                        case "Action4":
                        case "4":
                            //--Quantity of delivered textile--
                            try {
                                C.delivered();
                            } catch (IOException e) {
                                System.out.println(e.getMessage());
                            } catch (SQLException e) {
                                System.out.println(e.getMessage());
                            }
                            break;


                        case "action5":
                        case "Action5":
                        case "5":
                            //--КОЛ-ВО ЗАКАЗАННОЙ БЫТ.ТЕХНИКИ--
                            try {
                                C.provided();
                            } catch (IOException e) {
                                System.out.println(e.getMessage());
                            } catch (SQLException e) {
                                System.out.println(e.getMessage());
                            }
                            break;

                        case "action6":
                        case "Action6":
                        case "6":
                            try {
                                C.salary();
                            } catch (IOException e) {
                                System.out.println(e.getMessage());
                            } catch (SQLException e) {
                                System.out.println(e.getMessage());
                            }
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
