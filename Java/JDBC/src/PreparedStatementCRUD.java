import java.sql.*;

public class PreparedStatementCRUD {
    private static final String url = "jdbc:mysql://localhost:3306/College";
    private static final String username = "root";
    private static final String password = "Raysi@2002";
        // INSERTION OPERATION
//    public static void main(String[] args) {
//        try{
//            Class.forName("com.mysql.cj.jdbc.Driver");
//        }catch (ClassNotFoundException e){
//            e.printStackTrace();
//        }
//        try{
//            Connection con = DriverManager.getConnection(url, username, password);
//            String query = "INSERT INTO students(name, age, marks) VALUES (?, ?, ?)";
//            PreparedStatement preparedStatement = con.prepareStatement(query);
//            preparedStatement.setString(1, "Aarav");
//            preparedStatement.setInt(2, 5);
//            preparedStatement.setInt(3, 100);
//            int rowsAffected = preparedStatement.executeUpdate();
//            if (rowsAffected > 0)
//                System.out.println("Insertion Successful");
//            else
//                System.out.println("Insertion unsuccessful");
//        }catch (SQLException e){
//            e.printStackTrace();
//        }
//    }
    //DELETION OPERATION
//    public static void main(String[] args) {
//        try{
//            Class.forName("com.mysql.cj.jdbc.Driver");
//        }catch (ClassNotFoundException e){
//            e.printStackTrace();
//        }
//        try {
//            Connection con = DriverManager.getConnection(url, username, password);
//            String query = "DELETE FROM students WHERE pin = 6";
//            PreparedStatement preparedStatement = con.prepareStatement(query);
//            int rowsAffected = preparedStatement.executeUpdate();
//            if(rowsAffected > 0)
//                System.out.println("Deletion Successful");
//            else
//                System.out.println("Deletion Unsuccessful");
//        }catch (SQLException e){
//            e.printStackTrace();
//        }
//    }
                //UPDATE
//        public static void main(String[] args) {
//            try{
//                Class.forName("com.mysql.cj.jdbc.Driver");
//            }catch (ClassNotFoundException e){
//                e.printStackTrace();
//            }
//            try {
//                Connection connection = DriverManager.getConnection(url, username, password);
//                String query = "UPDATE students SET pin = 6 WHERE pin = 7";
//                PreparedStatement preparedStatement = connection.prepareStatement(query);
//                int rowsAffected = preparedStatement.executeUpdate();
//                if(rowsAffected > 0)
//                    System.out.println("Update Successful");
//                else
//                    System.out.println("Update Unsuccessful");
//            }catch (SQLException e){
//                e.printStackTrace();
//            }
//        }
        public static void main(String[] args) {
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
            }catch (ClassNotFoundException e){
                e.printStackTrace();
            }
            try {
                Connection connection = DriverManager.getConnection(url, username, password);
                String query = "SELECT * FROM students";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery();
                while(resultSet.next()){
                    int pin = resultSet.getInt("pin");
                    String name = resultSet.getString("name");
                    int age = resultSet.getInt("age");
                    int marks = resultSet.getInt("marks");
                    System.out.println("PIN: " + pin);
                    System.out.println("NAME: " + name);
                    System.out.println("AGE: " + age);
                    System.out.println("MARKS: " + marks);
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
}
