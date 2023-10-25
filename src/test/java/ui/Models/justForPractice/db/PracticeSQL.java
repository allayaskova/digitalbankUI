package ui.Models.justForPractice.db;

import java.sql.*;

public class PracticeSQL {
    public static void main(String[] args) throws SQLException {
        //database url(ip or host name), username, password
        //jdbc - mandatory regardless what database we use
        //mysql or oracle or sqlserver
        //String url = "jdbc:mysql://hostname:port/defaultschemaname";
        String url = "jdbc:mysql://3.249.240.23:3306/alla";
        String username = "alla";
        String password = "m&MG[V7m";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//tell jdbc which driver (mysql) to user
            //establish connection
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from users");//execute select query,
            // saves in sql custom object
            //returns a list of all rows. Next is a pointer.
            //when we run a query, highlighted row will be pointning one by one
            //when we run a class - we expect the username of a 1st row
            resultSet.next();
            System.out.println(resultSet.getString("password"));
            resultSet.next();
            System.out.println(resultSet.getInt("profile_id"));
            System.out.println("============================");
//to make it dynamic. Go add all the info
            while(resultSet.next()){
                System.out.print(resultSet.getInt("id")+ " |");
                System.out.print(resultSet.getInt("account_non_expired")+ " |");
                System.out.print(resultSet.getInt("account_non_locked")+ " |");
                System.out.print(resultSet.getInt("credentials_non_expired")+ " |");
                System.out.print(resultSet.getInt("enabled")+ " |");
                System.out.print(resultSet.getString("username")+ " |");
                System.out.print(resultSet.getInt("profile_id")+ " |");
            }
            int rowsAffected = statement.executeUpdate("UPDATE user_profile SET address = 'Canggu Bali' WHERE email_address = 'jsmith@demo.io'");
            System.out.println(rowsAffected);
            resultSet = statement.executeQuery("select * from user_profile");
            while(resultSet.next()){
                System.out.print(resultSet.getString("address")+ " |");
                System.out.print(resultSet.getString("email_address")+ " |");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                statement.close();
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
