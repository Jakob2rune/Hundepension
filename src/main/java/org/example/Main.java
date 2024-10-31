package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;
import java.util.Scanner;

public class Main {

    private static final String URL = "jdbc:sqlserver://localhost;portNumber=1433;databaseName=DBHundepension";
    private static final String USERNAME = "sa"; // replace with your username
    private static final String PASSWORD = "admin"; // replace with your password


    public static Connection getConnection() throws Exception {
        Connection conn = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        System.out.println("Connected to the database.");
        return conn;
    }


    public static void main(String args []) throws Exception{
        System.out.println("Connecting to server.");
        Connection conn = getConnection();
        Scanner input = new Scanner(System.in);
        String interfaceID = null;
        String interfaceOwnerID = null;
        String interfaceDogID = null;
        String interfaceDogfoodID = null;
        String interfaceStayID = null;
        String dogfoodChosen  = null;

        System.out.println("Welcome to Rosa's Dog Daycare pension");
        System.out.println("Where do you want to go? Type Owner, Dog, Dogfood or Stay to go there.");

        mainMenuLoop:
        while (input.hasNext()) {
            interfaceID = input.next();
        switch (interfaceID){
            case "Owner","owner":
                System.out.println("Welcome to the dog owner section.");
                System.out.println("Would you like to do Create og Delete an owner, or Exit this section?");

                while (input.hasNext()){
                    interfaceOwnerID = input.next();
                    switch (interfaceOwnerID){
                        case "Create","create":
                            System.out.println("insert Code to Create owner");
                            System.out.println("You are now back in the main menu.");
                            continue mainMenuLoop;

                        case "Delete","delete":
                            System.out.println("insert Code to Delete owner");
                            continue mainMenuLoop;

                        case "Exit","exit":
                            System.out.println("Return back to main interface");
                            System.out.println("Where do you want to go, Owner, Dog, Dogfood, Stay?");
                            continue mainMenuLoop;

                        default:
                            //Writes an "invalid choice" And lets you try again.
                            System.out.println("Invalid choice, please try again");
                            System.out.println("Would you like to do Create og Delete an owner, or exit this section?");
                            continue;
                    }
                }
                break;

            case "Dog","dog": //Made by Louise
                System.out.println("Welcome to the dog section.");
                System.out.println("What would you like to do? Type: Create = create new dog, All = display all records on all dogs, read = read a specific dog: ");
                //creates a loop when the dog section is picked, and lets you create or read dogs.
                while (input.hasNext()) {
                    interfaceDogID = input.next();
                    switch (interfaceDogID) {
                        case "Create", "create": //Uses the user inputs for the parameters and creates a new dog in the database using the Dog constructor.

                            Dog dog = Dog.createDogFromScanner(input); //Uses the method from the Dog class to
                            DogDao daoCreate = new DogDaoImpl();
                            daoCreate.createDog(dog);
                            daoCreate.readAllDogs();
                            break;

                        case "All","all":
                            System.out.println("Here are all the records on all dogs: ");
                            DogDao daoReadAll = new DogDaoImpl();
                            daoReadAll.readAllDogs();
                            break;

                        case "Read","read":
                            System.out.println("What dog do you want to see specifics on? Type in the dog's ID: ");


                        case "Delete", "delete":
                            System.out.println("insert Code to Delete a dog");
                            continue mainMenuLoop;

                        case "Dogfood","dogfood":
                            System.out.println("Welcome to the Dogfood section.");
                            System.out.println("What would kind of dogfood would you like to chose?");
                            System.out.println("Standard tørfoder[1]\nTørfoder til unge hunde[2]\nTørfoder til gamle hunde[3]\nLuksusfoder[4]\nDiæt foder[5]");
                            System.out.println("Or type exit to exit this section");
                            //creates a loop for picking a type of dogfood inside the "Dog" section,
                            while (input.hasNext()) {
                                interfaceDogfoodID = input.next();
                                switch (interfaceDogfoodID) {
                                    case "1":
                                        dogfoodChosen = "Standard tørfoder";
                                        System.out.println("You have chosen " + dogfoodChosen);
                                        continue mainMenuLoop;
                                    case "2":
                                        dogfoodChosen = "Tørfoder til unge hunde";
                                        System.out.println("You have chosen " + dogfoodChosen);
                                        continue mainMenuLoop;
                                    case "3":
                                        dogfoodChosen = "Tørfoder til gamle hunde";
                                        System.out.println("You have chosen " + dogfoodChosen);
                                        continue mainMenuLoop;
                                    case "4":
                                        dogfoodChosen = "Luksusfoder";
                                        System.out.println("You have chosen " + dogfoodChosen);
                                        continue mainMenuLoop;
                                    case "5":
                                        dogfoodChosen = "Diæt foder";
                                        System.out.println("You have chosen " + dogfoodChosen);
                                        continue mainMenuLoop;

                                    case "Exit", "exit":
                                        System.out.println("Return back to main interface");
                                        System.out.println("Where do you want to go, Owner, Dog, Dogfood, Stay?");
                                        continue mainMenuLoop;

                                    default:
                                        //Writes an "invalid choice" And lets you try again.
                                        System.out.println("Invalid choice, please try again");
                                        System.out.println("Standard tørfoder[1]\nTørfoder til unge hunde[2]\nTørfoder til gamle hunde[3]\nLuksusfoder[4]\nDiæt foder[5]");
                                        System.out.println("Or type exit to exit this section");
                                        continue;
                                }
                            }
                            break;

                        case "Exit", "exit":
                            System.out.println("Return back to main interface");
                            System.out.println("Where do you want to go, Owner, Dog, Dogfood, Stay?");
                            continue mainMenuLoop;

                        default:
                            //Writes an "invalid choice" And lets you try again.
                            System.out.println("Invalid choice, please try again");
                            System.out.println("Would you like to do Create og Delete a dog?");
                            continue;
                    }
                }
                break;


            case "Stay","stay":
                System.out.println("Welcome to the stay section.");
                System.out.println("Would you like to do Create og Delete a stay, or Exit this section?");

                while (input.hasNext()){
                    interfaceStayID = input.next();
                    switch (interfaceStayID){
                        case "Create","create":
                            System.out.println("insert Code to Create a stay");
                            continue mainMenuLoop;

                        case "Delete","delete":
                            System.out.println("insert Code to Delete a stay");
                            continue mainMenuLoop;

                        case "Exit","exit":
                            System.out.println("Return back to main interface");
                            System.out.println("Where do you want to go, Owner, Dog, Dogfood, Stay?");
                            continue mainMenuLoop;

                        default:
                            //Writes an "invalid choice" And lets you try again.
                            System.out.println("Invalid choice, please try again");
                            System.out.println("Would you like to do Create og Delete a stay, or exit this section?");
                            continue;
                    }
                }
                break;

            case "Exit","exit":
                System.out.println("You have choosen to close the program");
                System.out.println("Gooodbye (U•ᴥ•U) *woof woof*");

                break mainMenuLoop;


            default:
                //Writes an "invalid choice" And lets you try again.
                System.out.println("Invalid choice, please try again");
                continue mainMenuLoop;
        }

    }
}
}