package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class Main {
    //initializes variables for the getConnection method.
    private static final String URL = "jdbc:sqlserver://localhost;portNumber=1433;databaseName=DBHundepension";
    private static final String USERNAME = "sa"; // replace with your username
    private static final String PASSWORD = "admin"; // replace with your password

    //connects us to the SQL server named DBHundepension
    public static Connection getConnection() throws Exception {
        Connection conn = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        return conn;
    }


    public static void main(String args[]) throws Exception {
        //Connects us to the SQL server, when we start the program.
        System.out.println("Connecting to server.");
        Connection conn = getConnection();
        Scanner input = new Scanner(System.in);
        MenuMethods menu = new MenuMethods();
        String dogfoodChosen = null;
        //prints the main menu in the console. This method are in the MenuMethods class, with the othe methods used in main.
        menu.MainMenuPrint();
        //creates out main loop, and gives it the name mainMenuLoop.
        mainMenuLoop:
        while (input.hasNextLine()) {
            //takes an input that is a string, that can have spaces, and converts the input to all lowercase.
            String lowerCase = input.nextLine().toLowerCase();
            //we create a Switch Case, for our mainMenuloop.
            switch (lowerCase) {
                // The cases are called "dog owner", "dog", "stay", "exit" and default.
                case "dog owner","owner","dogowner":
                    //Prints our DogOwnerMenu. The method is in MenuMethods class.
                    menu.DogOwnerMenuPrint();
                    //creates a MenuMethods object with the name of OwnerMenu, for late use.
                    MenuMethods OwnerMenu = new MenuMethods();

                    while (true) {
                        //creates our Owner Section Loop, also with a Switch Case.
                        switch (input.nextLine().toLowerCase()) {
                            //we use the object OwnerMenu(the name), so that we are able to use the other methods from MenuMethods.
                            case "create":
                                OwnerMenu.SeeAllOwnersMethod();
                                OwnerMenu.CreateOwnerMethod();
                                break;

                            case "delete":
                                OwnerMenu.DeleteOwnerMethod();
                                break;

                            case "all":
                                OwnerMenu.SeeAllOwnersMethod();
                                System.out.println("You are now back in the Dog Owner section. Write 'Menu' to see the Dog Owner Menu again.");
                                break;

                            case "single":
                                OwnerMenu.SeeSingleDogOwnerMethod();
                                break;

                            case "exit":
                                OwnerMenu.MainMenuPrint();
                                continue mainMenuLoop;

                            case "menu":
                                OwnerMenu.DogOwnerMenuPrint();

                            default:
                                //Writes an "invalid choice" And lets you try again.
                                System.out.println("Invalid choice, please try again");
                                OwnerMenu.DogOwnerMenuPrint();
                                continue; //is obsolete, but I like it :-)
                        }
                    }

            case "dog": //Made by Louise
                System.out.println("Welcome to the dog section.");
                System.out.println("What do you want to do?\nEnter:\n1 = Create new dog\n2 = Show all existing dogs in the system\n3 = See details for one specific dog\n4 = Delete a dog in the system\n5 = Exit and return to the main menu: ");
                //creates a loop when the dog section is picked, and lets you create, read or delete dogs or exit the program and return to the Main menu.
                while (input.hasNextLine()) {
                    switch (input.nextLine()) {
                        case "1": //Uses the user inputs for the parameters and creates a new dog in the database using the Dog constructor.
                            Dog dog = Dog.createDogFromScanner(input);//Calls the method from the Dog class.
                            DogDao daoCreate = new DogDaoImpl();
                            if (dog != null) { //Checks to see if we have the correct requirements for the dog to stay at the pension - Vaccination and flea treatment.
                                daoCreate.createDog(dog); //Saves the newly created dog in to the database.
                                daoCreate.readAllDogs(); //Displays an updated list of all the records of all the dogs in the database.
                            }
                            System.out.println("What do you want to do?\nEnter:\n1 = Create new dog\n2 = Show all existing dogs in the system\n3 = See details for one specific dog\n4 = Delete a dog in the system\n5 = Exit and return to the main menu: ");
                            break;

                        case "2":
                            System.out.println("Here are all the information on the existing dogs in your system: ");
                            DogDao daoReadAll = new DogDaoImpl();
                            daoReadAll.readAllDogs(); //Displays the list of all records of all dogs in the database.
                            System.out.println("What do you want to do?\nEnter:\n1 = Create new dog\n2 = Show all existing dogs in the system\n3 = See details for one specific dog\n4 = Delete a dog in the system\n5 = Exit and return to the main menu: ");
                            break;

                        case "3":
                            System.out.println("Write the ID No on the dog you wish to see specifics on: ");
                            DogDao daoReadDog = new DogDaoImpl();
                            daoReadDog.readDog(input.nextInt()); //Displays the record from the database for a specific dog.
                            System.out.println("What do you want to do?\nEnter:\n1 = Create new dog\n2 = Show all existing dogs in the system\n3 = See details for one specific dog\n4 = Delete a dog in the system\n5 = Exit and return to the main menu: ");
                            break;


                        case "4":
                            DogDao daoDelete = new DogDaoImpl();
                            daoDelete.readAllDogs(); //Displays the list of all the dogs in the database.
                            System.out.println("Write the ID No. og the dog you wish to delete fra your system: ");
                            daoDelete.deleteDog(input.nextInt()); //Deletes the record for the specific dog chosen.
                            daoDelete.readAllDogs();//Displays the list of all records of all dogs in the database.
                            System.out.println("What do you want to do?\nEnter:\n1 = Create new dog\n2 = Show all existing dogs in the system\n3 = See details for one specific dog\n4 = Delete a dog in the system\n5 = Exit and return to the main menu: ");
                            break;

                        case "5":
                            System.out.println("You will now return to the main menu.");
                            menu.MainMenuPrint();
                            continue mainMenuLoop; //Lets the user back to the Main menu to either start anew or exit the program completely.

                        default:
                            //If an invalid choice is typed in the program warns you and lets you try again.
                            System.out.println("Not a valid entry. Try again");
                            System.out.println("What do you want to do?\nEnter:\n1 = Create new dog\n2 = Show all existing dogs in the system\n3 = See details for one specific dog\n4 = Delete a dog in the system\n5 = Exit and return to the main menu: ");
                            continue;
                        }
                    }
                    break;


                case "Stay", "stay":
                    System.out.println("Welcome to the stay section.");
                    System.out.println("Would you like to do Create og Delete a stay, or Exit this section?");

                    while (input.hasNext()) {
                        switch (input.next()) {
                            case "Create", "create":
                                System.out.println("insert Code to Create a stay");
                                continue mainMenuLoop;

                            case "Delete", "delete":
                                System.out.println("insert Code to Delete a stay");
                                continue mainMenuLoop;

                            case "Exit", "exit":
                                System.out.println("Return back to main interface");
                                System.out.println("Where do you want to go, Owner, Dog, Dogfood, Stay?");
                                continue mainMenuLoop;

                            case "Dogfood", "dogfood":
                                System.out.println("Welcome to the Dogfood section.");
                                System.out.println("What would kind of dogfood would you like to chose?");
                                System.out.println("Standard tørfoder[1]\nTørfoder til unge hunde[2]\nTørfoder til gamle hunde[3]\nLuksusfoder[4]\nDiæt foder[5]");
                                System.out.println("Or type exit to exit this section");
                                //creates a loop for picking a type of dogfood inside the "Dog" section,
                                while (input.hasNext()) {
                                    switch (input.next()) {
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
                                    }
                                }
                            default:
                                //Writes an "invalid choice" And lets you try again.
                                System.out.println("Invalid choice, please try again");
                                System.out.println("Would you like to do Create og Delete a stay, or exit this section?");
                                continue;
                        }
                    }
                    break;

                case "Exit", "exit":
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