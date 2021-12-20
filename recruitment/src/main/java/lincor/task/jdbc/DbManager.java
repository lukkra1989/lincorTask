package lincor.task.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DbManager {
    private Connection connection;
    private static DbManager dbManagerInstance;

    private DbManager()throws SQLException{
        Properties connectionProps=new Properties();
    }
}
