import java.sql.*;

public class InsertingDataIntoDatabase {
    private static final String url = "jdbc:mysql://localhost:3306/College";
    private static final String username = "root";
    private static final String password = "Raysi@2002";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            Statement statement = con.createStatement();
            String query = String.format("INSERT INTO students (name, age, marks) VALUES ('%s', %d, %d), ('%s', %d, %d), ('%s', %d, %d)", "Raysi", 22, 94, "Sonu", 20, 90, "Kanxu", 20, 98);
            int rowsAffected = statement.executeUpdate(query);
            if (rowsAffected > 0)
                System.out.println("Data Inserted Successfully");
            else
                System.out.println("Data not inserted");
        }catch (SQLException e){
            System.out.println(e.getMessage());;
        }
    }
}
