import java.sql.*;
import java.util.Scanner;

public class LoginHandeling {
    private static final String url = "jdbc:mysql://localhost:3306/User";
    private static final String username = "root";
    private static final String password = "Raysi@2002";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
            Scanner scanner = new Scanner(System.in);
            Connection connection = DriverManager.getConnection(url, username, password);
            String query = "Select * from login where username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            System.out.print("Enter username: ");
            String username = scanner.next();
            System.out.print("Enter password: ");
            String password = scanner.next();
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                String dbUser = resultSet.getString("username");
                String dbPassword = resultSet.getString("password");
                if(dbUser.equals(username) && dbPassword.equals(password)){
                    System.out.println("Login Successful");
                }
                else
                    System.out.println("Please check your username & password!");
            }else{
                System.out.println("No such user found!");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
