import java.sql.*;
import java.util.Scanner;

public class TransactionHandeling {
    private static final String url = "jdbc:mysql://localhost:3306/Bank";
    private static final String username = "root";
    private static final String password = "Raysi@2002";

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try{
            Connection connection = DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(false);
            Scanner scanner = new Scanner(System.in);
            String debitQuery = "UPDATE accounts SET balance = balance - ? WHERE acc_no = ?";
            String creditQuery = "UPDATE accounts SET balance = balance + ? WHERE acc_no = ?";
            PreparedStatement debitPreparedStatement = connection.prepareStatement(debitQuery);
            PreparedStatement creditPreparedStatement = connection.prepareStatement(creditQuery);
            System.out.print("Enter Sender Account number: ");
            int debitAcc = scanner.nextInt();
            System.out.print("Enter Beneficiary Account Number: ");
            int creditAcc = scanner.nextInt();
            if(debitAcc == creditAcc){
                System.out.println("Self transaction is not available !!");
                System.exit(1);
            }
            System.out.print("Enter Amount: ");
            double amount = scanner.nextDouble();
            if (amount <= 0){
                System.out.println("Please enter valid amount!");
                System.exit(1);
            }
            debitPreparedStatement.setDouble(1, amount);
            debitPreparedStatement.setInt(2, debitAcc);
            creditPreparedStatement.setDouble(1, amount);
            creditPreparedStatement.setInt(2, creditAcc);

            //Checking balance before transaction
            if (isSufficient(connection, debitAcc, amount)){
                debitPreparedStatement.executeUpdate();
                creditPreparedStatement.executeUpdate();
                connection.commit();
                System.out.println("Transaction Successful");
            }else {
                System.out.println("Transaction Unsuccessful & Balance not sufficient");
                connection.rollback();
            }



//            debitPreparedStatement.executeUpdate();
//            creditPreparedStatement.executeUpdate();
//            connection.commit();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    protected static boolean isSufficient(Connection connection, int acc_no, double amount) {
        try {
            String query = "SELECT balance FROM accounts WHERE acc_no = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDouble(1, acc_no);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                double balance = resultSet.getDouble("balance");
                if(balance >= amount)
                    return true;
                else
                    return false;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
