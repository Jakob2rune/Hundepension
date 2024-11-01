package org.example;

import java.util.Scanner;

public class MenuMethods {
    Scanner input = new Scanner(System.in);
    public void MainMenuPrint() {
        System.out.println("┌────────────────────────────────────────┐");
        System.out.println("│                (U•ᴥ•U)                 │");
        System.out.println("│        ┌────────────────────┐          │");
        System.out.println("│        │     Welcome to     │          │");
        System.out.println("│        │ DogPension Manager │          │");
        System.out.println("│        └────────────────────┘          │");
        System.out.println("│                                        │");
        System.out.println("│  ┌────────────┐  ┌───────┐  ┌───────┐  │");
        System.out.println("│  │ Dog Owner  │  │  Dog  │  │  Stay │  │");
        System.out.println("│  └────────────┘  └───────┘  └───────┘  │");
        System.out.println("│                                        │");
        System.out.println("│              ┌────────┐                │");
        System.out.println("│              │  Exit  │                │");
        System.out.println("│              └────────┘                │");
        System.out.println("│                                        │");
        System.out.println("└────────────────────────────────────────┘");
        System.out.println("\nType the name of the button you want to press (Dog Owner, Dog, Stay, Exit): ");
    }
    public void DogOwnerMenuPrint(){
        System.out.println("┌───────────────────────────────────────────────────────────┐");
        System.out.println("│                                                           │");
        System.out.println("│                 ┌────────────────────────┐                │");
        System.out.println("│                 │   Welcome to the Dog   │                │");
        System.out.println("│                 │     Owner Section      │                │");
        System.out.println("│                 └────────────────────────┘                │");
        System.out.println("│                                                           │");
        System.out.println("│   ┌──────────┐   ┌──────────┐   ┌──────┐   ┌──────────┐   │");
        System.out.println("│   │  CREATE  │   │  DELETE  │   │  ALL │   │  SINGLE  │   │");
        System.out.println("│   └──────────┘   └──────────┘   └──────┘   └──────────┘   │");
        System.out.println("│                          ┌─────────┐                      │");
        System.out.println("│                          │  EXIT   │                      │");
        System.out.println("│                          └─────────┘                      │");
        System.out.println("└───────────────────────────────────────────────────────────┘");
        System.out.println("\nType the name of the action you want to perform (Create, Delete, All, Single, Exit):");
    }
    public void CreateOwnerMethod()throws Exception{
        System.out.println("Insert details to create a new dog owner.");

        // Prompt for DogOwner details
        System.out.println("Enter Owner ID (integer): ");
        int ownerID = input.nextInt();

        //input = new Scanner(System.in);

        System.out.println("Enter Owner Name: ");
        String name = input.nextLine();

        System.out.println("Enter Owner Address: ");
        String address = input.nextLine();

        System.out.println("Enter Owner phonenumber: ");
        String phoneNumber = input.nextLine();


        DogOwner dogOwner = new DogOwner(ownerID, name, address, phoneNumber);
        DogOwnerDao daoCreate = new DogOwnerDaoImpl();
        daoCreate.createDogOwner(dogOwner);
        daoCreate.readAllDogOwners();

        System.out.println("You are now back in the Dog Owner section. Write 'Menu' to see the Dog Owner Menu again.");
    }
    public void DeleteOwnerMethod() throws Exception{

        System.out.println("Please Type the ID of the owner you want to delete");
        DogOwnerDao daoDelete = new DogOwnerDaoImpl();
        daoDelete.deleteDogOwner(input.next());
        System.out.println("You are now back in the Dog Owner section. Write 'Menu' to see the Dog Owner Menu again.");
    }
    public void SeeAllOwnersMethod() throws Exception{
        System.out.println("All the owners in the database");
        DogOwnerDao daoAll = new DogOwnerDaoImpl();
        daoAll.readAllDogOwners();
        System.out.println("You are now back in the Dog Owner section. Write 'Menu' to see the Dog Owner Menu again.");
    }
    public void SeeSingleDogOwnerMethod() throws Exception{
        System.out.println("Please Type the ID of the owner you want to look up");
        DogOwnerDao daoSingle = new DogOwnerDaoImpl();
        String id = input.next();
        daoSingle.readDogOwner(id);
        daoSingle.dogsForDogOwners(id);
        System.out.println("You are now back in the Dog Owner section. Write 'Menu' to see the Dog Owner Menu again.");
    }
}

