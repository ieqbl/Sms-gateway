package gateway;

import java.sql.*;

public class DbServices
{
    private Connection connection;
    public void Connect() throws SQLException
    {
        String url = "jdbc:postgresql://"
                + "127.0.0.1" + ":"
                + "5432" + "/"
                + "mydb";
        connection = DriverManager.getConnection(url,System.getenv("DB_USER"),System.getenv("DB_PASSWORD"));
    }
    public void saveMessage(String number,String message) throws SQLException
    {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO Messages (phone,content) (?, ?)");
        statement.setString(1, number);
        statement.setString(2, message);
        statement.executeUpdate();
        statement.close();
    }
    public void close() throws SQLException
    {
        if (connection != null) connection.close();
    }

}
