import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BatchAddForInsertion {
    private static final String url = "jdbc:mysql://localhost:3306/College";
    private static final String user = "root";
    private static final String password = "Raysi@2002";

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String query = "INSERT INTO students(name, age, marks) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            Scanner sc = new Scanner(System.in);
            while (true){
                System.out.print("Enter name: ");
                String name = sc.next();
                System.out.print("Enter age: ");
                int age = sc.nextInt();
                System.out.print("Enter marks: ");
                int marks = sc.nextInt();
                System.out.println("Do you want to add more data: (Y/N)");
                String choice = sc.next();
                preparedStatement.setString(1, name);
                preparedStatement.setInt(2, age);
                preparedStatement.setInt(3, marks);
                preparedStatement.addBatch();
                if(choice.toUpperCase().equals("N"))
                    break;

            }
            int[] arr = preparedStatement.executeBatch();
            for (int i=0; i < arr.length; i++){
                if (arr[i] == 0){
                    System.out.println("Data unsucessfull at " + i+1);
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
