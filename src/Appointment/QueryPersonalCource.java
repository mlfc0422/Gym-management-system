package Appointment;

import database.DatabaseConnector;

import java.sql.Connection;
import java.sql.SQLException;

public class QueryPersonalCource {
    private final String url = "jdbc:mysql://localhost:3306/gym?characterEncoding=utf-8&serverTimezone=UTC";
    private final String username = "root";
    private final String password = "liyu422321";

    public void querypersonalcource() throws SQLException {
        DatabaseConnector dc = new DatabaseConnector();
        Connection connection = dc.getConnection();
    }
}
