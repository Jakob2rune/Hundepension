package org.example;

import java.util.Scanner;

/**
 * Made by Louise.
 * The class where the blueprint for the dog is made. Here the variables and methods are held. They are all encapsulated.
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

    /**
     * Another constructor with no parameters.
     **/
    public Dog() {

    }

    //Below a get and set method for each instance variable to make sure other methods and classes are able to read and change the variables safely.
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

    /**
     * A method to create a new record in the database of the Dog class.
     * @param input Reads the user input which will be used for each attribute in the database.
     * @return
     */
    public static Dog createDogFromScanner (Scanner input) {
        System.out.println("Indtast Hundens ID for at tilføje en ny hund. (Det skal være et nyt nummer for hver ny hund, der tilføjes).\nIndtil videre eksisterer disse: ");
        int dogID = input.nextInt();
        input.nextLine();

        System.out.println("Indtast Ejerens ID Nr.: ");
        int ownerID = input.nextInt();
        input.nextLine();

        System.out.println("Indtast hundens navn: ");
        String dogName = input.nextLine();

        String birthdate;
        while (true){
            System.out.println("Indtast hundens foedselsdag (yyyy-mm-dd): ");
            birthdate = input.nextLine();
            if (birthdate.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
                break;
            }
            else {
                System.out.println("Dette er ikke et gyldigt format. Du skal indtaste: yyyy-mm-dd");
            }
        }

        System.out.println("Indtast hunderace: ");
        String breed = input.nextLine();

        System.out.println("Har hunden nogle saerlige behov?: ");
        String specialNeeds = input.nextLine();

        System.out.println("Indtast foretrukne dyrlaege: ");
        String preferredVet = input.nextLine();

        //Makes sure to write only "ja" or "nej" to the database and checks whether the dog has met the requirement of vaccination. If not, the user is sent back to the menu of the dog.
        String vaccinated;
        do {
            System.out.println("Er hunden vaccineret? Skriv ja eller nej: ");
            vaccinated = input.nextLine();
            if (!vaccinated.equalsIgnoreCase("ja") && !vaccinated.equalsIgnoreCase("nej")) {
                System.out.println("Ikke gyldig indtastning. Skriv ja eller nej: ");
            }
        } while (!vaccinated.equalsIgnoreCase("ja") && !vaccinated.equalsIgnoreCase("nej"));
        if (vaccinated.equalsIgnoreCase("nej")) {
            System.out.println("Hunden skal være vaccineret for at kunne blive passet her!\nDu sendes tilbage til hundemenuen.");
            return null;
        }

        //Makes sure to write only "ja" or "nej" to the database and checks whether the dog has met the requirement of flea treatment. If not, the user is sent back to the menu of the dog.
        String fleaTreatment;
        do {
            System.out.println("Har hunden fået loppebehandling? Skriv ja eller nej: ");
            fleaTreatment = input.nextLine();
            if (!fleaTreatment.equalsIgnoreCase("ja") && !fleaTreatment.equalsIgnoreCase("nej")) {
                System.out.println("Ikke gyldig indtastning. Skriv ja eller nej: ");
            }
        } while (!fleaTreatment.equalsIgnoreCase("ja") && !fleaTreatment.equalsIgnoreCase("nej"));
        if (fleaTreatment.equalsIgnoreCase("nej")) {
            System.out.println("Hunden skal være loppebehandlet for at kunne blive passet her!\nDu sendes tilbage til hundemenuen.");
            return null;
        }

        System.out.println("Indtast hundens forsikringsselskab og policenummer: ");
        String insuranceCompany = input.nextLine();

        return new Dog(dogID, ownerID, dogName, birthdate, breed, specialNeeds, preferredVet, vaccinated, fleaTreatment, insuranceCompany);
    }
}
