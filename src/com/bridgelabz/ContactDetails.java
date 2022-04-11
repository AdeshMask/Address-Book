package com.bridgelabz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ContactDetails {

    public static int booksCount;
    public static ArrayList<PersonsInfo> persons; ;
    HashMap<Integer,String> map = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);
    int i = 1;
    int n = i;
    public static ContactDetails contact = new ContactDetails();

    public void newBooks(){

        System.out.println("Enter how many AddressBooks you wants to create:");
        booksCount = scanner.nextInt();
        for (; i <= booksCount; i++){
            System.out.println("Selected book is Book "+i);
            persons = new ArrayList<>();
            map.put(i,contact.book());
        }
        System.out.println("Lists of Books: "+booksCount);
        System.out.println("Enter your choice to select your book:");
        System.out.println("Size:"+persons.size());
        int ch = scanner.nextInt();
        if (ch==1){
            System.out.println("Selected book is: "+(i-booksCount));
            System.out.println(persons.get(0));
        }
        else {
            System.out.println("Selected book is: "+booksCount);
            System.out.println(persons.get(1));
        }
        searchbyOptions();
    }

    private void searchbyOptions() {
        System.out.println("select choice for search data by given options\n1 By Name\n2 by city\n3 By State");
        int ch = scanner.nextInt();
        switch (ch){
            case 1:
                System.out.println("Enter name");
                String name = scanner.nextLine();
                searchByName(name);
                break;
            case 2:
                System.out.println("Enter city");
                String cityname = scanner.nextLine();
                searchByCity(cityname);
                break;
            case 3:
                System.out.println("Enter State");
                String stateName = scanner.nextLine();
                searchByState(stateName);
        }
    }


    //*-*-*-*-*-*-*-*-*-*-*-Search-*-*-*-*-*-*-*-*-*-*-*
    public List<PersonsInfo> searchByName(String name){
        return persons.stream().filter(searchPerson -> searchPerson.firstName.equalsIgnoreCase(name)).
                collect(Collectors.toList());
    }
    public List<PersonsInfo> searchByCity(String cityName){
        return persons.stream().filter(searchCity -> searchCity.city.equalsIgnoreCase(cityName)).
                collect(Collectors.toList());
    }
    public List<PersonsInfo> searchByState(String searchState){
        return persons.stream().filter(stateName -> stateName.state.equalsIgnoreCase(searchState)).
                collect(Collectors.toList());
    }

//*-*-*-*-*-*-*-*-*-*-*-*- Menu -*-*-*-*-*-*-*-*-*-*-*-*-*-*
    public String book(){
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
                case 5 :
                    break;
            }
            break;
        }
        return null;
    }

//*-*-*-*-*-*-*-*-*-*-*-*- Taking Inputs -*-*-*-*-*-*-*-*-*-*-*-*-*-*


    public String addPerson(){
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
        System.out.println("press 1 if you want to add multiple person to Address Book");
        int n = scanner.nextInt();
        if (n==1){
            map.put(i,contact.addPerson());
        }
        else
            map.put(i,contact.book());
        return null;
    }

//*-*-*-*-*-*-*-*-*-*-*-*- Show -*-*-*-*-*-*-*-*-*-*-*-*-*-*

    public void show(){
        System.out.println(persons.size());
        if (persons.size()==0){
            System.out.println("No Records Found...Empty Address Book");
            map.put(i,contact.book());
        }
        else {
            for (int j = 0; j < persons.size(); j++) {
                PersonsInfo p = (PersonsInfo) persons.get(j);
                System.out.println(persons.get(j));
                System.out.println("");
            }
            map.put(i,contact.book());
        }
    }

//*-*-*-*-*-*-*-*-*-*-*-*- Delete -*-*-*-*-*-*-*-*-*-*-*-*-*-*


    public void delete(){
        if (persons.size()==0){
            System.out.println("No Record Found...Empty Address Book");
            map.put(i,contact.book());
        }
        else {
            System.out.println("Enter First Name to delete contact:");
            String name = scanner.nextLine();
            for (int j = 0; j < persons.size(); j++) {
                PersonsInfo p = persons.get(i);
                if (name.equals(p.firstName)) {
                    persons.remove(j);
                    System.out.println("Delete Successfully..");
                }
            }
            map.put(i,contact.book());
        }
    }

//*-*-*-*-*-*-*-*-*-*-*-*- Update -*-*-*-*-*-*-*-*-*-*-*-*-*-*


    public void update(){
        System.out.println("Enter First and last name to update details");
        String name1 = scanner.nextLine();
        String name2 = scanner.nextLine();
        for(int j = 0; j < persons.size(); j++) {
            PersonsInfo p = persons.get(i);
            if (name1.equals(p.firstName) && name2.equals(p.lastName)) {
                map.put(i,p.print());
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
                map.put(i,contact.book());
            }
            else {
                System.out.println("No record found");
                map.put(i,contact.book());
            }
        }
    }
}