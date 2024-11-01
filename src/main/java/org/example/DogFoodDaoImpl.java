/*package org.example;

import java.sql.*;

/*public class DogFoodDaoImpl implements DogFoodDao {

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
    /*public void createDogFood(DogFood dogFood) throws Exception {
        String sql = "INSERT INTO tblFoder VALUES (?, ?, ?)";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, dogFood.getNo()); //- Hvilke metoder skal laves?
        pstmt.setString(2, dogFood.getName());
        pstmt.setString(3, dogFood.getLocation());
        int affectedRows = pstmt.executeUpdate();
        if (affectedRows > 0) {
            System.out.println("Dog food added successfully.");
        } else {
            System.out.println("Failed to add the dog food.");
        }
    }

    @Override
    public void readDogFood(String no) throws Exception{
        //String sql = "SELECT * FROM tblFoder WHERE dept_no = ?"; - Hvad skal udsøges her?
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, no);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            DogFood dogFood = new DogFood();
            dogFood.setNo(rs.getString(1));
            dogFood.setName(rs.getString(2));
            dogFood.setLocation(rs.getString(3));
            System.out.println(dogFood.getNo() + " "+ dogFood.getName()+ " "+ dogFood.getLocation());
        } else {
            System.out.println("No dog food found with ID: " + no);
        }
    }

    @Override
    public void readAllDogFoods() throws Exception{
        String sql = "SELECT * FROM tblFoder";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        boolean hasDogFoods = false;
        while (rs.next()) {
            hasDogFoodss = true;
            DogFood dogFood = new DogFood();
            dogFood.setNo(rs.getString(1));
            dogFood.setName(rs.getString(2));
            dogFood.setLocation(rs.getString(3));
            System.out.println(dogFood.getNo()+" "+ dogFood.getName()+dogFood.getLocation());
        }
        if (!hasDogFoods) {
            System.out.println("No dog foods found.");
        }
    }
}*/

*/