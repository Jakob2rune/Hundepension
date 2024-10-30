package org.example;


import java.sql.*;

public class DogOwnerDaoImpl implements DogOwnerDao {

    private static final String URL = "jdbc:sqlserver://localhost;instanceName=TH;portNumber=1433;databaseName=DBHundepension";
    private static final String USERNAME = "sa"; // replace with your username
    private static final String PASSWORD = "admin"; // replace with your password

    public static Connection getConnection() throws Exception {
        Connection conn = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        return conn;
    }

    @Override
    public void createDogOwner(DogOwner dogOwner) throws Exception {
        String sql = "INSERT INTO tblEjer VALUES (?, ?, ?,?)";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, dogOwner.getownerID()); //- Hvilke metoder skal laves?
        pstmt.setString(2, dogOwner.getName());
        pstmt.setString(3, dogOwner.getAddress());
        pstmt.setString(4, dogOwner.getPhonenumber());
        int affectedRows = pstmt.executeUpdate();
        if (affectedRows > 0) {
            System.out.println("Dog owner added successfully.");
        } else {
            System.out.println("Failed to add the dog owner.");
        }
    }

    @Override
    public void readDogOwner(String no) throws Exception {
        String sql = "SELECT * FROM tblEjer WHERE fldejerID = ?";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, no);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            DogOwner dogOwner = new DogOwner();
            dogOwner.setOwnerID(rs.getInt(1));
            dogOwner.setName(rs.getString(2));
            dogOwner.setAddress(rs.getString(3));
            dogOwner.setPhonenumber(rs.getString(4));
            System.out.println(dogOwner.getownerID() + " " + dogOwner.getName() + " " + dogOwner.getAddress() + " " + dogOwner.getPhonenumber());
        } else {
            System.out.println("No dog owner found with ID: " + no);
        }
    }

    @Override
    public void readAllDogOwners() throws Exception {
        String sql = "SELECT * FROM tblEjer";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        boolean hasDogOwners = false;
        while (rs.next()) {
            hasDogOwners = true;
            DogOwner dogOwner = new DogOwner();
            dogOwner.setOwnerID(rs.getInt(1));
            dogOwner.setName(rs.getString(2));
            dogOwner.setAddress(rs.getString(3));
            dogOwner.setPhonenumber(rs.getString(4));
            System.out.println(dogOwner.getownerID() + " " + dogOwner.getName() + dogOwner.getAddress() + dogOwner.getPhonenumber());
        }
        if (!hasDogOwners) {
            System.out.println("No dogowners found.");
        }
    }

    @Override
    public void deleteDogOwner(String no) throws Exception {
        String sql = "DELETE  FROM tblEjer WHERE fldejerID = ?";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, no);
        int affectedRows = pstmt.executeUpdate();

        if (affectedRows > 0) {
            System.out.println("The dog owner with the ID " + no + " deleted successfully.");
        } else {
            System.out.println("The dog owner with the ID " + no + " has not been deleted successfully.");
        }
    }

    @Override
    public void dogsForDogOwners(String no) throws Exception {
        String sql = "SELECT fldNavn FROM tblHund WHERE fldejerID = ?";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, no);
        ResultSet rs = pstmt.executeQuery();
        boolean hasDogOwners = false;
        while (rs.next()) {
            hasDogOwners = true;
            String dogName = rs.getString(1);
            System.out.println("This owner has a dog named: " + dogName);
        }

        if (!hasDogOwners) {
            System.out.println("No dogs found for the dog owner with ID: " + no);
        }
    }
}
