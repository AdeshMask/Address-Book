package com.bridgelabz;

import java.util.ArrayList;
import java.util.Scanner;

import static com.bridgelabz.AddressBook.persons;

public class ContactDetails {

    Scanner scanner = new Scanner(System.in);
    public ContactDetails(){
//        persons = new ArrayList<PersonsInfo>();
    }
    public void addPerson(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter First Name");
        String name = scanner.nextLine();
        System.out.println("Enter Last Name");
        String lName = scanner.nextLine();
        System.out.println("Enter Address: ");
        String address = scanner.nextLine();
        System.out.println("Enter City Name: ");
        String city = scanner.nextLine();
        System.out.println("Enter State: ");
        String state = scanner.nextLine();
        System.out.println("Enetr Zip Code:");
        int zip = scanner.nextInt();
        System.out.println("Enter contact Number:");
        long number = scanner.nextLong();
        System.out.println("Enter Email: ");
        String email = scanner.nextLine();
        PersonsInfo p = new PersonsInfo(name,lName,address,city,state,zip,number,email);
        persons.add(p);
        System.out.println("if you want to add multiple person to Address Book");
        System.out.println("If yes press 1");
        int n = scanner.nextInt();
        if (n==1){
            addPerson();
        }
        else
            System.out.println("");
    }
    public void show(){
        System.out.println(persons.size());
        if (persons.size()==0){
            System.out.println("No Records Found...Empty Address Book");
        }
        else {
            for (int i = 0; i < persons.size(); i++) {
                PersonsInfo p = (PersonsInfo) persons.get(i);
                System.out.println(persons.get(i));
                System.out.println("");
            }
        }
    }
    //*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-
    public void delete(){
        if (persons.size()==0){
            System.out.println("No Record Found...Empty Address Book");
        }
        else {
            System.out.println("Enter First Name to delete contact:");
            String name = scanner.nextLine();
            for (int i = 0; i < persons.size(); i++) {
                PersonsInfo p = persons.get(i);
                if (name.equals(p.firstName)) {
                    persons.remove(i);
                    System.out.println("Delete Successfully..");
                }
            }
        }
    }
    public void update(){
        System.out.println("Enter First and last name to update details");
        String name1 = scanner.nextLine();
        String name2 = scanner.nextLine();
        for(int i = 0; i < persons.size(); i++) {
            PersonsInfo p = persons.get(i);
            if (name1.equals(p.firstName) && name2.equals(p.lastName)) {
                p.print();
                System.out.println("Enter Choice to Update\nEnter 1 for Update Address\n Enter 2 for Contact \n " +
                        "Enter 3 for Email address");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Enter Address: ");
                        String address = scanner.nextLine();
                        System.out.println("Enter City Name: ");
                        String city = scanner.nextLine();
                        System.out.println("Enter State: ");
                        String state = scanner.nextLine();
                        System.out.println("Enetr Zip Code:");
                        int zip = scanner.nextInt();
                        break;
                    case 2:
                        System.out.println("Enter contact Number:");
                        long number = scanner.nextLong();
                        break;
                    case 3:
                        System.out.println("Enter Email: ");
                        String email = scanner.nextLine();
                        break;
                }
            }
            else
                System.out.println("No record found");
        }
    }
}