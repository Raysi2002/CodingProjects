import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TravelingAgenceyProject {
    private static final String url = "jdbc:mysql://localhost:3306/Traveling_Agencey";
    private static final String user = "root";
    private static final String password = "Raysi@2002";
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
            Connection connection = DriverManager.getConnection(url, user, password);
            
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
