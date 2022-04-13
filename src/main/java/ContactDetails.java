import com.opencsv.CSVReader;

import java.io.*;
import java.util.*;

public class ContactDetails {

    public static int booksCount;
    public static ArrayList<PersonsInfo> persons;
    HashMap<Integer,String> map = new HashMap<>();
    //    Dictionary<String,PersonsInfo> dictionary = new Hashtable<>();
    static Scanner scanner = new Scanner(System.in);
    static File file = new File("AddressBook.csv");
    int i = 1;
    int currentBook;
    public static ContactDetails contact = new ContactDetails();
    String bookName;
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void newBooks() throws IOException {

        System.out.println("Enter how many AddressBooks you wants to create:");
        booksCount = scanner.nextInt();
        for (; i <= booksCount; i++){
//            System.out.println("Enter Book Name:");
//            bookName = scanner.next();
            persons =  new ArrayList<>();
            System.out.println("Selected book is Book "+i);
            map.put(i,contact.book());
        }
        System.out.println("Lists of Books: "+booksCount);
        System.out.println("books availables :"+map);
        for(Map.Entry m:map.entrySet()){
            System.out.println(m.getKey()+" "+m.getValue());
        }


        FileReader fileReader = new FileReader(file);
        CSVReader csvReader = new CSVReader(fileReader);
        String[] nextRecord;
        while ((nextRecord = csvReader.readNext()) != null) {
            for (String cell : nextRecord) {
                System.out.print(cell + "\t");
            }
            System.out.println();
        }

    
        System.out.println("Enter your choice to select your book(0 for 1st book and so on): ");
        int ch = scanner.nextInt();
        if (ch==0){
            System.out.println("Selected book is: "+(i-booksCount));
            //System.out.println(map.get(persons.contains(0)));
            System.out.println("Select option to perform options: ");
            map.get(persons.contains(0));
            book();
        }
        else if (ch == 1){
            System.out.println("Selected BOook is: "+booksCount);
            System.out.println(map.get(persons.contains(1)));
            map.get(persons.contains(1));
            book();
        }
        else System.out.println("Wrong input");
        searchbyOptions();
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void searchbyOptions() {
        System.out.println("select choice for search data by given options\n1 By Name\n2 by city\n3 By State");
        int ch = scanner.nextInt();
        switch (ch){
            case 1:
                System.out.println("Enter name");
                String name = scanner.next();
                searchByName(map.get(name));
                searchbyOptions();
                break;
            case 2:
                System.out.println("Enter city");
                String cityname = scanner.next();
                searchByCity(cityname);
                break;
            case 3:
                System.out.println("Enter State");
                String stateName = scanner.next();
                searchByState(stateName);
        }
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //*-*-*-*-*-*-*-*-*-*-*-Search-*-*-*-*-*-*-*-*-*-*-*
    public List<PersonsInfo> searchByName(String name){
        for (PersonsInfo element : persons){
            if (persons.contains(name)){
                System.out.println("found:::"+persons.contains(element));
            }
        }System.out.printf("No record found:");
        return null;
    }
    public List<PersonsInfo> searchByCity(String cityName){

        boolean result = persons.contains(cityName);
        if (result){
            System.out.printf("Found");
        }
        else System.out.printf("Not Found");

//        for (PersonsInfo element : persons){
//            if (persons.contains(cityName)){
//                System.out.println("found:::"+persons.contains(element));
//            }
//        }System.out.printf("No record found:");
//        return null;
        return null;
    }
    public List<PersonsInfo> searchByState(String searchState){
        for (PersonsInfo element : persons){
            if (persons.contains(searchState)){
                System.out.println("found:::"+persons.contains(element));
            }
        }System.out.printf("No record found:");
        return null;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
//*-*-*-*-*-*-*-*-*-*-*-*- Menu -*-*-*-*-*-*-*-*-*-*-*-*-*-*
    public String book(){
        currentBook = i;
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
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
        addToFile(p);
        persons.add(p);
        System.out.println("press 1 if you want to add multiple person to Address Book");
        int n = scanner.nextInt();
        if (n==1){
            map.put(n,contact.addPerson());
        }
        else
            map.put(n,contact.book());
        return null;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////FIle Operations///////////////////
    private void addToFile(PersonsInfo p) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(p.getFirstName()+"\r\n" + p.getLastName() + "\r\n" + p.getAddress() + "\r\n" + p.getCitye() +
                    "\r\n" + p.getState() + "\r\n" + p.getZip() + "\r\n" + p.getNumber() + "\r\n" + p.getEmail() + "\r\n\r\n");
        } catch(IOException e) {
            System.out.println(e);
        }
    }

    public  boolean readPeopleFromFile() throws IOException {
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String name = null;
            while((name = reader.readLine()) != null) {
                PersonsInfo person = new PersonsInfo(name, reader.readLine(), reader.readLine(), reader.readLine(), reader.readLine(),reader.read(),reader.read(),reader.readLine());
                persons.add(person);        //adds person to the list
                reader.readLine();
            }
            return true;
        }
        catch ( IOException e) {
            System.out.println(e);
        }
        return false;
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//*-*-*-*-*-*-*-*-*-*-*-*- Show -*-*-*-*-*-*-*-*-*-*-*-*-*-*
    public void show(){
        System.out.println(persons.size());
        if (persons.size()==0){
            System.out.println("No Records Found...Empty Address Book");
            map.put(currentBook,contact.book());
        }
        else {
            for (int j = 0; j < persons.size(); j++) {
                PersonsInfo p = (PersonsInfo) persons.get(j);
                System.out.println(persons.get(j));
                System.out.println("");
            }
            map.put(currentBook,contact.book());
        }
    }
    //*-*-*-*-*-*-*-*-*-*-*-*- Delete -*-*-*-*-*-*-*-*-*-*-*-*-*-*
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void delete(){
        if (persons.size()==0){
            System.out.println("No Record Found...Empty Address Book");
            map.put(currentBook,contact.book());
        }
        else {
            System.out.println("Enter First Name to delete contact:");
            String name = scanner.nextLine();
            for (int j = 0; j < persons.size(); j++) {
                PersonsInfo p = persons.get(currentBook);
                if (name.equals(p.firstName)) {
                    persons.remove(j);
                    System.out.println("Delete Successfully..");
                }
            }
            map.put(currentBook,contact.book());
        }
    }
    //*-*-*-*-*-*-*-*-*-*-*-*- Update -*-*-*-*-*-*-*-*-*-*-*-*-*-*
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void update(){
        System.out.println("Enter First and last name to update details");
        String name1 = scanner.nextLine();
        String name2 = scanner.nextLine();
        for(int j = 0; j < persons.size(); j++) {
            PersonsInfo p = persons.get(currentBook);
            if (name1.equals(p.firstName) && name2.equals(p.lastName)) {
                map.put(currentBook,p.print());
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
                map.put(currentBook,contact.book());
            }
            else {
                System.out.println("No record found");
                map.put(currentBook,contact.book());
            }
        }
    }
}
