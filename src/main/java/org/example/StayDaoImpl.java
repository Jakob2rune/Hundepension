package org.example;


import java.sql.*;

public class StayDaoImpl implements StayDao {

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
    public void createStay(Stay stay) throws Exception {
        String sql = "INSERT INTO tblOphold VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, stay.getStayID()); //- Find metoder!!
        pstmt.setInt(2, stay.getDogID());
        pstmt.setString(3, stay.getStartDate());
        pstmt.setString(3, stay.getEndDate());
        pstmt.setInt(3, stay.getAmountOfStayDays());
        pstmt.setInt(3, stay.getFoodFrequencyPerDay());
        pstmt.setInt(3, stay.getFoodID());
        pstmt.setInt(3, stay.getWalkFrequencyPerDay());
        pstmt.setFloat(3, stay.getStartKmPerDay());
        pstmt.setFloat(3, stay.getFoodFrequencyPerDay());
        int affectedRows = pstmt.executeUpdate();
        if (affectedRows > 0) {
            System.out.println("Stay added successfully.");
        } else {
            System.out.println("Failed to add the stay.");
        }
    }

    @Override
    public void readStay(String no) throws Exception {
        String sql = "SELECT * FROM tblOphold WHERE dept_no = ?"; //Hvilke attributter?
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, no);
        ResultSet rs = pstmt.executeQuery();
        Stay stay = new Stay();
        if (rs.next()) {

            stay.setStayID(rs.getInt(1));
            stay.setAmountOfStayDays(rs.getInt(2));
            stay.setStartKmPerDay(rs.getInt(3));
            stay.setAmountOfStayDays(rs.getInt(4));
            stay.setFoodFrequencyPerDay(rs.getInt(5));
            stay.setFoodID(rs.getInt(6));
            stay.setWalkFrequencyPerDay(rs.getInt(7));
            stay.setStartDate(rs.getString(8));
            stay.setEndDate(rs.getString(9));
            stay.setDogID(rs.getInt(10));

            System.out.println( stay.getAmountOfStayDays  ()+ stay.getFoodFrequencyPerDay()+ stay.getFoodStartAmountGram()+ stay.getStartKmPerDay()+ stay.getDogID() + stay.getEndDate() + stay.getEndDate() + stay.getStayID() + stay.getWalkFrequencyPerDay() + stay.getFoodID());
        } else {
            System.out.println("No stay found with ID: " + no);
        }
    }
}
/*
   @Override
    public void readAllStays() throws Exception{
        String sql = "SELECT * FROM tblOphold";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        boolean hasStays = false;
        while (rs.next()) {
            hasStays = true;
            Stay stay = new Stay();
            stay.setNo(rs.getString(1));
            stay.setName(rs.getString(2));
            stay.setLocation(rs.getString(3));
            System.out.println(stay.getNo()+" "+ stay.getName()+stay.getLocation());
        }
        if (!hasStays) {
            System.out.println("No stays found.");
        }
    }*/
