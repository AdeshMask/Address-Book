package com.bridgelabz;

import java.util.*;

public class AddressBook {
    public static Scanner scanner = new Scanner(System.in);
    public static int booksCount;
    public static List<ArrayList<PersonsInfo>> list =  new ArrayList<ArrayList<PersonsInfo>>();
    public static ArrayList<PersonsInfo> persons = new ArrayList<PersonsInfo>();
    HashMap<Integer,String> map = new HashMap<>();

    public static void main(String[] args) {
        HashMap<Integer,String> map = new HashMap<>();
        System.out.println("*_*_*_*_*_*_*_*_*_*_Welcome to Address Book_*_*_*_*_*_*_*_*_*_*");
        ContactDetails contactDetails = new ContactDetails();
        contactDetails.newBooks();
    }
}
