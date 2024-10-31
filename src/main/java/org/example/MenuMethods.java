package org.example;
import java.util.Scanner;

public class MenuMethods {
    Scanner input = new Scanner(System.in);

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

        System.out.println("You are now back in the Owner section.");
    }
    public void DeleteOwnerMethod() throws Exception{

        System.out.println("Please Type the ID of the owner you want to delete");
        DogOwnerDao daoDelete = new DogOwnerDaoImpl();
        daoDelete.deleteDogOwner(input.next());
        System.out.println("You are now back in the Owner section.");
    }
    public void SeeAllOwnersMethod() throws Exception{
        System.out.println("All the owners in the database");
        DogOwnerDao daoAll = new DogOwnerDaoImpl();
        daoAll.readAllDogOwners();
        System.out.println("You are now back in the Owner section.");
    }
    public void SeeASingleDogOwnerMethod() throws Exception{
        System.out.println("Please Type the ID of the owner you want to look up");
        DogOwnerDao daoSingle = new DogOwnerDaoImpl();
        String id = input.next();
        daoSingle.readDogOwner(id);
        daoSingle.dogsForDogOwners(id);
        System.out.println("You are now back in the Owner section.");
    }
    public void ExitMethod(){}
    public void CreateDogMethod() throws Exception{

    }




}
