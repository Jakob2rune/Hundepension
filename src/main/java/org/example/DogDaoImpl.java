package org.example;

import java.sql.*;

/**
 * Made by Louise
 * This class makes sure that the user can create and store a new dog in the database and also read existing dog records.
 * It also implements methods to  connect to the database and insert or select new og existing dog records.
 */

/**
 * This method allows this program to connect to our database in SQL. When connection is established we will be able to
 * perform SQL commands such as Insert into, Select, Select * and delete.
 */
public class DogDaoImpl implements DogDao {

    private static final String URL = "jdbc:sqlserver://localhost;instanceName=TH;portNumber=1433;databaseName=DBHundepension";
    private static final String USERNAME = "sa"; // replace with your username
    private static final String PASSWORD = "admin"; // replace with your password

    public static Connection getConnection() throws Exception {
        Connection conn = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        System.out.println("Connected to the database.");
        return conn;
    }

    /**
     * Stores and inserts the new object of the Dog in to the database
     * @param dog Holds all attributes of each Dog object and stores it in to the database.
     * @throws Exception if a database connection or SQL operation fails.
     */
    @Override
    public void createDog(Dog dog) throws Exception {
        String sql = "INSERT INTO tblHund (fldHundeID, fldEjerID, fldNavn, fldFoedselsdag, fldRace, fldSaerligeBehov, fldDyrelæge, fldVaccination, fldLoppeBehandling, fldPoliceOgSelskab) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, dog.getDogId());
        pstmt.setInt(2, dog.getOwnerId());
        pstmt.setString(3, dog.getDogName());
        pstmt.setString(4, dog.getBirthDate());
        pstmt.setString(5, dog.getBreed());
        pstmt.setString(6, dog.getSpecialNeeds());
        pstmt.setString(7, dog.getVet());
        pstmt.setString(8, dog.getVaccination());
        pstmt.setString(9,dog.getFleaTreatment());
        pstmt.setString(10, dog.getInsurance());
        int affectedRows = pstmt.executeUpdate();
        if (affectedRows > 0) {
            System.out.println("The dog is added to the system.");
        } else {
            System.out.println("The dog hasn't been added to the system.");
        }
    }

    /**
     * Makes sure that the user can read all the records for a specific dog from the database using the dog's IDNo.
     * @param dogID The ID of the dog that is used to get the information of that specific dog from the database.
     * @throws Exception if a database connection or SQL operation fails.
     */
    @Override
    public void readDog(int dogID) throws Exception{
        String sql = "SELECT * FROM tblHund WHERE fldHundeID = ?";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, dogID);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            Dog dog = new Dog();
            dog.setDogId(rs.getInt(1));
            dog.setOwnerId(rs.getInt(2));
            dog.setDogName(rs.getString(3));
            dog.setBirthDate(rs.getString(4));
            dog.setBreed(rs.getString(5));
            dog.setSpecialNeeds(rs.getString(6));
            dog.setVet(rs.getString(7));
            dog.setVaccination(rs.getString(8));
            dog.setFleaTreatment(rs.getString(9));
            dog.setInsurance(rs.getString(10));

            //Formatting the output to give a better overview of the tables and attributes from the database.
            System.out.printf("%-20s %-20s %-25s %-20s %-30s %-40s %-40s %-30s %-30s %-40s%n",
                    "Dog ID: " + dog.getDogId(), "Owner ID: " + dog.getOwnerId(), "Name: " + dog.getDogName().trim(),
                    "Birthdate: " + dog.getBirthDate().trim(), "Breed: " + dog.getBreed().trim(),
                    "Special needs: " + dog.getSpecialNeeds().trim(), "Preferred vet: " + dog.getVet().trim(),
                    "Vaccinated: " + dog.getVaccination().trim(), "Flea treatment: " + dog.getFleaTreatment().trim(),
                    "Insurance company + policy number: " + dog.getInsurance().trim());
        } else {
            System.out.println("No dog with that ID has been found: " + dogID);
        }
    }

    /**
     * Makes sure that the user can read all records for all dogs from the database.
     * @throws Exception if a database connection or SQL operation fails.
     */
    @Override
    public void readAllDogs() throws Exception{
        String sql = "SELECT fldHundeID, fldEjerID, fldNavn, fldFoedselsdag, fldRace, fldSaerligeBehov, fldDyrelæge, fldVaccination, fldLoppeBehandling, fldPoliceOgSelskab FROM tblHund";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        boolean hasDogs = false;
        while (rs.next()) {
            hasDogs = true;
            Dog dog = new Dog();
            dog.setDogId(rs.getInt(1));
            dog.setOwnerId(rs.getInt(2));
            dog.setDogName(rs.getString(3));
            dog.setBirthDate(rs.getString(4));
            dog.setBreed(rs.getString(5));
            dog.setSpecialNeeds(rs.getString(6));
            dog.setVet(rs.getString(7));
            dog.setVaccination(rs.getString(8));
            dog.setFleaTreatment(rs.getString(9));
            dog.setInsurance(rs.getString(10));

            System.out.printf("%-20s %-20s %-25s %-20s %-30s %-40s %-40s %-30s %-30s %-40s%n",
                    "Dog ID: " + dog.getDogId(), "Owner ID: " + dog.getOwnerId(), "Name: " + dog.getDogName().trim(),
                    "Birthdate: " + dog.getBirthDate().trim(), "Breed: " + dog.getBreed().trim(),
                    "Special needs: " + dog.getSpecialNeeds().trim(), "Preferred vet: " + dog.getVet().trim(),
                    "Vaccinated: " + dog.getVaccination().trim(), "Flea treatment: " + dog.getFleaTreatment().trim(),
                    "Insurance company + policy number: " + dog.getInsurance().trim());
        }
        if (!hasDogs) {
            System.out.println("No dogs found.");
        }
    }

    public void deleteDog(int dogID) throws Exception {
        String sql = "DELETE  FROM tblHund WHERE fldHundeID = ?";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, dogID);
        int affectedRows = pstmt.executeUpdate();

        if (affectedRows > 0) {
            System.out.println("The dog with ID No.:  " + dogID + " has been deleted from the system.");
        } else {
            System.out.println("The dog with ID No.:  " + dogID + " has not been deleted from the system.");
        }
    }
}