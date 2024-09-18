import java.sql.*;

public class DataRetrivel {
    private static final String url = "jdbc:mysql://localhost:3306/exam";
    private static final String user = "root";
    private static final  String password = "Raysi@2002";
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try{
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            String query = "select * from customer";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                int cid = resultSet.getInt("cid");
                String name = resultSet.getString("name");
                int salary = resultSet.getInt("salary");
                System.out.println("CID: " + cid);
                System.out.println("NAME: " + name);
                System.out.println("SALARY: " + salary);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}