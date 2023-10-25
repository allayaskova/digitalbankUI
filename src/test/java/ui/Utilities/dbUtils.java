package ui.Utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ui.Utilities.ConfigReader.getPropertiesValue;

public class dbUtils {
    private static Connection connection = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;

    //method to establish connection with db
    public static void establishConnection() throws ClassNotFoundException {

//        String url = "jdbc:mysql://3.249.240.23:3306/alla";
//        String username = "alla";
//        String password = "m&MG[V7m";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(getPropertiesValue("digitalbank.db.url"),
                    getPropertiesValue("digitalbank.db.username"),
                    getPropertiesValue("digitalbank.db.password")); //env is taken from the property class
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        //method to insert into db and return number of rows updated or 0 when action is not taken
        //method to close
    }

    //method to send select stat. dynamically and return a list of map of all columns
    public static List<Map<String, Object>> runSQLSelectQuery(String sqlQuery) {
        List<Map<String, Object>> dbResultList = new ArrayList<>();

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlQuery);
            //resultSet has method column count
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();//return info about data
            int columnCount = resultSetMetaData.getColumnCount();//builds smth dynamic that populate map columnname key
            //value as value

            while (resultSet.next()) {//go to one row
                Map<String, Object> rowMap = new HashMap<>();//transform row into map
                for (int col = 1; col <= columnCount; col++) {
                    rowMap.put(resultSetMetaData.getColumnName(col), resultSet.getObject(col));//take all column
                    //names and map it with column values
                }
                dbResultList.add(rowMap);//add that map into a list. And we have multiple rows with into
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dbResultList;
    }

    public static int runSQLUpdateQuery(String sqlQuery) {
        int rowsUpdated = 0;
        try {
            statement = connection.createStatement();
            rowsUpdated = statement.executeUpdate(sqlQuery);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowsUpdated;
    }

    //close
    public static void closeConnection() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}


