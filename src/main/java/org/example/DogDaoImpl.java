package org.example;

import java.sql.*;

public class DogDaoImpl implements DogDao {

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
    public void createDog(Dog dog) throws Exception {
        String sql = "INSERT INTO tblHund VALUES (?, ?, ?)";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        //pstmt.setString(1, dog.getNo());
        //pstmt.setString(2, dog.getName()); - Hvilke metoder skal vi have?
        //pstmt.setString(3, dog.getLocation());
        int affectedRows = pstmt.executeUpdate();
        if (affectedRows > 0) {
            System.out.println("Dog added successfully.");
        } else {
            System.out.println("Failed to add the dog.");
        }
    }

    @Override
    public void readDog(String no) throws Exception{
        //String sql = "SELECT * FROM tblHund WHERE dept_no = ?"; - Hvad skal indsættes her?
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, no);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            Dog dog = new Dog();
            dog.setNo(rs.getString(1)); //- Hvilke koder skal vi have?
            dog.setName(rs.getString(2));
            dog.setLocation(rs.getString(3));
            System.out.println(dog.getNo() + " "+ dog.getName()+ " "+ dog.getLocation());
        } else {
            System.out.println("No dog found with ID: " + no);
        }
    }

    @Override
    public void readAllDogs() throws Exception{
        String sql = "SELECT * FROM tblHund";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        boolean hasDogs = false;
        while (rs.next()) {
            hasDogs = true;
            Dog dog = new Dog();
            dog.setNo(rs.getString(1));
            dog.setName(rs.getString(2));
            dog.setLocation(rs.getString(3));
            System.out.println(dog.getNo()+" "+ dog.getName()+dog.getLocation());
        }
        if (!hasDogs) {
            System.out.println("No dogs found.");
        }
    }
}