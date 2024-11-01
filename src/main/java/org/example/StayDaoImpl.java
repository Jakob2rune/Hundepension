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
        String sql = "INSERT INTO tblOphold VALUES (?, ?, ?)";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, stay.stayID()); //- Find metoder!!
        pstmt.setInt(2, stay.dogID());
        pstmt.setString(3, stay.startDate());
        pstmt.setString(3, stay.endDate());
        pstmt.setInt(3, stay.amountOfStayDays());
        pstmt.setInt(3, stay.foodFrequencyPerDay());
        pstmt.setInt(3, stay.FoodID());
        pstmt.setInt(3, stay.walkFrequencyPerDay());
        pstmt.setFloat(3, stay.startKmPerDay());
        pstmt.setFloat(3, stay.foodStartAmountGram());
        int affectedRows = pstmt.executeUpdate();
        if (affectedRows > 0) {
            System.out.println("Stay added successfully.");
        } else {
            System.out.println("Failed to add the stay.");
        }
    }
    /*
    @Override
    public void readStay(String no) throws Exception {
        String sql = "SELECT * FROM tblOphold WHERE dept_no = ?"; //Hvilke attributter?
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, no);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            Stay stay = new Stay();
            stay.setNo(rs.getString(1));
            stay.setName(rs.getString(2));
            stay.setLocation(rs.getString(3));
            System.out.println(stay.getNo() + " " + stay.getName() + " " + stay.getLocation());
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
}
