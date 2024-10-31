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

        System.out.println("Velkommen til Rosa's hundepension");
        System.out.println("Hvor ønsker du at foretage en ændring?\nIndtast:\nEjer, Hund, Foder, Ophold eller Exit for at lukke programmet.");

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

            case "Hund","hund": //Made by Louise
                System.out.println("Velkommen til hundesektionen.");
                System.out.println("Hvad vil du foretage dig?\nIndtast:\n1 = Opret ny hund\n2 = Få vist alle eksisterende hunde i systemet\n3 = Se detaljer for en specifik hund\n4 = Slet en hund i systemet\n5 = Exit og vend tilbage til hovedmenuen: ");
                //creates a loop when the dog section is picked, and lets you create or read dogs.
                while (input.hasNext()) {
                    interfaceDogID = input.next();
                    switch (interfaceDogID) {
                        case "1": //Uses the user inputs for the parameters and creates a new dog in the database using the Dog constructor.
                            Dog dog = Dog.createDogFromScanner(input); //Uses the method from the Dog class to
                            if (dog != null) {
                                DogDao daoCreate = new DogDaoImpl();
                                daoCreate.createDog(dog);
                                daoCreate.readAllDogs();
                            }
                            System.out.println("Hvad vil du foretage dig?\nIndtast:\n1 = Opret ny hund\n2 = Få vist alle eksisterende hunde i systemet\n3 = Se detaljer for en specifik hund\n4 = Slet en hund i systemet\n5 = Exit og vend tilbage til hovedmenuen: ");
                            break;

                        case "2":
                            System.out.println("Her er alle informationer på de eksisterende hunde : ");
                            DogDao daoReadAll = new DogDaoImpl();
                            daoReadAll.readAllDogs();
                            System.out.println("Hvad vil du foretage dig?\nIndtast:\n1 = Opret ny hund\n2 = Få vist alle eksisterende hunde i systemet\n3 = Se detaljer for en specifik hund\n4 = Slet en hund i systemet\n5 = Exit og vend tilbage til hovedmenuen: ");
                            break;

                        case "3":
                            System.out.println("Skriv ID Nr. på den hund du ønsker at se specifikationer på: ");
                            DogDao daoReadDog = new DogDaoImpl();
                            daoReadDog.readDog(input.nextInt());
                            System.out.println("Hvad vil du foretage dig?\nIndtast:\n1 = Opret ny hund\n2 = Få vist alle eksisterende hunde i systemet\n3 = Se detaljer for en specifik hund\n4 = Slet en hund i systemet\n5 = Exit og vend tilbage til hovedmenuen: ");
                            break;


                        case "4":
                            DogDao daoDelete = new DogDaoImpl();
                            daoDelete.readAllDogs();
                            System.out.println("Skriv ID Nr. på den hund du ønsker at slette i databasen: ");
                            daoDelete.deleteDog(input.nextInt());
                            daoDelete.readAllDogs();
                            System.out.println("Hvad vil du foretage dig?\nIndtast:\n1 = Opret ny hund\n2 = Få vist alle eksisterende hunde i systemet\n3 = Se detaljer for en specifik hund\n4 = Slet en hund i systemet\n5 = Exit og vend tilbage til hovedmenuen: ");
                            break;

                        case "5":
                            System.out.println("Du sendes nu retur til hovedmenuen.");
                            System.out.println("Hvor ønsker du at foretage en ændring?\nIndtast:\nEjer, Hund, Foder, Ophold eller Exit for at lukke programmet.");
                            continue mainMenuLoop;

                        /*case "Dogfood","dogfood":
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
                            break;*/

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