package com.bridgelabz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {
    public static Scanner scanner = new Scanner(System.in);
    public static int count;
    public static List<ArrayList<PersonsInfo>> list =  new ArrayList<ArrayList<PersonsInfo>>();
    public static ArrayList<PersonsInfo> persons = new ArrayList<PersonsInfo>();

    public static void main(String[] args) {
        System.out.println("*_*_*_*_*_*_*_*_*_*_Welcome to Address Book_*_*_*_*_*_*_*_*_*_*");
        AddressBook addressBook = new AddressBook();
        System.out.println("Enter how many AddressBooks you wants to create:");
        count = scanner.nextInt();
        if (count >= 1) {
            addressBook.newBook();
        }
        addressBook.book();
    }
        public static void book(){
            ContactDetails contact = new ContactDetails();
            int ch;
            while (true) {
                System.out.println(" Enter 1 to add\n Enter 2 to Update\n Enter 3 to Delete\n Enter 4 for Show Contacts\n Enter 5 for main menu");
                ch = scanner.nextInt();
                switch (ch) {
                    case 1:
                        contact.addPerson();
                        System.out.println("Added Successfully...");
                        break;
                    case 2:
                        contact.update();
                        break;
                    case 3:
                        contact.delete();
                        break;
                    case 4:
                        System.out.println("");
                        System.out.println("               " + "First Name " + " Last Name" + " Address" + " City" + " State" + " Zip" + " Number" + " E-mail");
                        contact.show();
                        break;
                    case 5:
                        newBook();
                        break;

                }
            }
        }

    private static void newBook() {
        AddressBook addressBook = new AddressBook();
        for (int i = 0;i < count;i++){
            System.out.println("select the option from the given below:\n1 Update dictionary \n2 sow list of dictionaries \n3 delete \n4 exit");
            int number =scanner.nextInt();
            if (number == 1){
                System.out.println("Enter the name of address book:"+ list);
                String name = scanner.nextLine();
                list.add(persons);
//                ContactDetails contactDetails = new ContactDetails();
//                list.add(p);
            }
            else if (number == 2){
            showList();
            }
        }
    }

    private static void showList() {
        System.out.println(list.size());
        if (list.size()==0){
            System.out.println("No Records Found...Empty Address Book");
        }
        else {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
                System.out.println("");
            }
        }
    }

}