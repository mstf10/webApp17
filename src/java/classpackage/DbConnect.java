package classpackage;

import java.sql.*;

public class DbConnect {

    public Connection connection;

    public DbConnect() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/bash?user=root&password=1234");
    }

}
