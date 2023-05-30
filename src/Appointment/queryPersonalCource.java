package Appointment;

import Common.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class queryPersonalCource {
    public void querypersonalcource(String cus_id) throws SQLException {
        Printdatabase pt = new Printdatabase();
        String query_sql = "SELECT * FROM personal_timetable WHERE cus_id = ?";

        try (DatabaseConnector dc = new DatabaseConnector();
             Connection connection = dc.getConnection();
             PreparedStatement ppst = connection.prepareStatement(query_sql)) {

            ppst.setString(1, cus_id);
            try (ResultSet re = ppst.executeQuery()) {
                pt.printQueryResult(re);
            }
        }
    }



}
