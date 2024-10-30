package org.example;


import java.sql.*;

public class DogOwnerDaoImpl implements DogOwnerDao {

    private static final String URL = "jdbc:sqlserver://localhost;instanceName=TH;portNumber=1433;databaseName=DBHundepension";
    private static final String USERNAME = "sa"; // replace with your username
    private static final String PASSWORD = "123456"; // replace with your password

    public static Connection getConnection() throws Exception {
        Connection conn = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        System.out.println("Connected to the database.");
        return conn;
    }

    @Override
    public void createDogOwner(DogOwner dogOwner) throws Exception {
        String sql = "INSERT INTO tblEjer VALUES (?, ?, ?)";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, dogOwner.getNo()); //- Hvilke metoder skal laves?
        pstmt.setString(2, dogOwner.getName());
        pstmt.setString(3, dogOwner.getLocation());
        int affectedRows = pstmt.executeUpdate();
        if (affectedRows > 0) {
            System.out.println("Dog owner added successfully.");
        } else {
            System.out.println("Failed to add the dog owner.");
        }
    }

    @Override
    public void readDogOwner(String no) throws Exception{
        String sql = "SELECT * FROM tblEjer WHERE dept_no = ?"; // - Igen hvilke attributter skal der henvises til i databasen?
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, no);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            DogOwner dogOwner = new DogOwner();
            dogOwner.setNo(rs.getString(1));
            dogOwner.setName(rs.getString(2));
            dogOwner.setLocation(rs.getString(3));
            System.out.println(dogOwner.getNo() + " "+ dogOwner.getName()+ " "+ dogOwner.getLocation());
        } else {
            System.out.println("No dog owner found with ID: " + no);
        }
    }

    @Override
    public void readAllDogOwners() throws Exception{
        String sql = "SELECT * FROM tblEjer";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        boolean hasDogOwners = false;
        while (rs.next()) {
            hasDogOwners = true;
            DogOwner dogOwner = new DogOwner();
            dogOwner.setNo(rs.getString(1));
            dogOwner.setName(rs.getString(2));
            dogOwner.setLocation(rs.getString(3));
            System.out.println(dogOwner.getNo()+" "+ dogOwner.getName()+dogOwner.getLocation());
        }
        if (!hasDogOwners) {
            System.out.println("No dog owner found.");
        }
    }
}

