package Appointment;

import Common.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryPersonalCource {
    private final String url = "jdbc:mysql://localhost:3306/gym?characterEncoding=utf-8&serverTimezone=UTC";
    private final String username = "root";
    private final String password = "liyu422321";

    public void querypersonalcource(String cus_id) throws SQLException {
        DatabaseConnector dc = new DatabaseConnector();
        Printdatabase pt = new Printdatabase();
        Connection connection = dc.getConnection();
        String query_sql = "SELECT * FROM personal_timetable WHERE cus_id = ?";
        PreparedStatement ppst = connection.prepareStatement(query_sql);
        ppst.setString(1,cus_id);
        ResultSet re = ppst.executeQuery();
        pt.printQueryResult(re);
    }
}
