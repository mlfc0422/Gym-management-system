package Finance;

import Common.*;
import java.sql.*;
public class QuerySpend {
    public void queryspend() throws SQLException {
        DatabaseConnector dc = new DatabaseConnector();
        Printdatabase pt = new Printdatabase();

        try (Connection connection = dc.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM finance")) {
             pt.printQueryResult(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
