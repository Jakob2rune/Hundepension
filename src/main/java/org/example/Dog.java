package org.example;

import java.util.Scanner;

/**
 * Made by Louise.
 * The class where the blueprint for the dog is made. Here the variables and methods are held.
 */
public class Dog {
    private int dogId;       // Identifier for the dog
    private int ownerId; // Identifier for the dog owner
    private String dogName;  // Name of the dog
    private String birthDate; //Birthday of the dog
    private String breed; //Defines the breed of the dog
    private String specialNeeds; //Possible special needs are written here
    private String vet; //The owners preferred vet
    private String vaccination; //Checks if the dog is vaccinated
    private String fleaTreatment; //Checks if the dog has a flea treatment
    private String insurance; //The dog's insurance company and policy number


    /**
     * Constructs a new object of the dog.
     * @param dogId The ID of the dog.
     * @param ownerId The ID of the owner of the dog.
     * @param dogName Name of the dog.
     * @param birthDate Birth year, month and day of the dog.
     * @param breed the breed of the dog. If mixed race, mixed is chosen.
     * @param specialNeeds Any special needs of the dog are written here.
     * @param vet the preferred vet for the dog.
     * @param vaccination The dog must be vaccinated.
     * @param fleaTreatment the dog must have had a flea treatment prior to the stay.
     * @param insurance Write the name of the insurance company and the policy no.
     */
    public Dog(int dogId, int ownerId, String dogName, String birthDate, String breed, String specialNeeds, String vet, String vaccination, String fleaTreatment, String insurance) {
        this.dogId = dogId;
        this.ownerId = ownerId;
        this.dogName = dogName;
        this.birthDate = birthDate;
        this.breed = breed;
        this.specialNeeds = specialNeeds;
        this.vet = vet;
        this.vaccination = vaccination;
        this.fleaTreatment = fleaTreatment;
        this.insurance = insurance;
    }

    public Dog() {

    }

    public int getDogId() {
        return dogId;
    }


    public void setDogId(int dogId) {
        this.dogId = dogId;
    }


    public String getDogName() {
        return dogName;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getSpecialNeeds() {
        return specialNeeds;
    }

    public void setSpecialNeeds(String specialNeeds) {
        this.specialNeeds = specialNeeds;
    }

    public String getVet() {
        return vet;
    }

    public void setVet(String vet) {
        this.vet = vet;
    }

    public String getVaccination() {
        return vaccination;
    }

    public void setVaccination(String vaccination) {
        this.vaccination = vaccination;
    }

    public String getFleaTreatment() {
        return fleaTreatment;
    }

    public void setFleaTreatment(String fleaTreatment) {
        this.fleaTreatment = fleaTreatment;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public static Dog createDogFromScanner (Scanner input) {
        System.out.println("Insert dog ID to upload new dog (Must be a new one for each new dog created): ");
        int dogID = input.nextInt();
        input.nextLine();

        System.out.println("Insert the owners ID: ");
        int ownerID = input.nextInt();
        input.nextLine();

        System.out.println("Insert the dog's name: ");
        String dogName = input.nextLine();

        System.out.println("Insert the birthdate of the dog (yyyy.mm.dd): ");
        String birthdate = input.nextLine();

        System.out.println("Insert the breed of the dog: ");
        String breed = input.nextLine();

        System.out.println("Does the dog have any special needs?: ");
        String specialNeeds = input.nextLine();

        System.out.println("Insert the name of the preferred vet: ");
        String preferredVet = input.nextLine();

        System.out.println("Is the dog vaccinated? Type yes or no: ");
        String vaccinated = input.nextLine();

        System.out.println("Has the dog has a fleat treatment? Type yes or no: ");
        String fleaTreatment = input.nextLine();

        System.out.println("What's the dog's insurance company and policy number?: ");
        String insuranceCompany = input.nextLine();

        return new Dog(dogID, ownerID, dogName, birthdate, breed, specialNeeds, preferredVet, vaccinated, fleaTreatment, insuranceCompany);
    }
}
