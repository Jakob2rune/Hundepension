package org.example;

import java.sql.*;

/**
 * Made by Louise
 * This class makes sure that the user can create and store a new dog in the database and also read existing dog records.
 * It also implements methods to  connect to the database and insert or select new og existing dog records.
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
        String sql = "INSERT INTO tblHund (fldHundeId, fldEjerId, fldNavn, fldFoedselsdag, fldRace, fldSaerligeBehov, fldDyrelaege, fldVaccination, fldLoppeBehandling, fldPoliceOgSelskab) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
            System.out.println("Dog added successfully.");
        } else {
            System.out.println("Failed to add the dog.");
        }
    }

    /*@Override
    public void readDog(String no) throws Exception{
        String sql = "SELECT * FROM tblHund WHERE fldHundeId = ?";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, no);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            Dog dog = new Dog();
            dog.setDogId(rs.getString(1)); //- Hvilke koder skal vi have?
            dog.setDogName(rs.getString(2));
            dog.setOwnerId(rs.getString(3));
            System.out.println(dog.getDogId() + " "+ dog.getDogName()+ " "+ dog.getOwnerId());
        } else {
            System.out.println("No dog found with ID: " + no);
        }
    } */

    /**
     * Makes sure that the user can read all records for all dogs from the database.
     * @throws Exception if a database connection or SQL operation fails.
     */
    @Override
    public void readAllDogs() throws Exception{
        String sql = "SELECT fldHundeId, fldEjerId, fldNavn, fldFoedselsdag, fldRace, fldSaerligeBehov, fldDyrelaege, fldVaccination, fldLoppeBehandling, fldPoliceOgSelskab FROM tblHund";
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
            System.out.printf("%d %d %s %s %s %s %s %s %s %s\n", dog.getDogId(), dog.getOwnerId(), dog.getDogName(), dog.getBirthDate(), dog.getBreed(), dog.getSpecialNeeds(), dog.getVet(), dog.getVaccination(), dog.getFleaTreatment(), dog.getInsurance());
        }
        if (!hasDogs) {
            System.out.println("No dogs found.");
        }
    }
}