package Facility;

import Common.DatabaseConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManFeedBack {
    public void manfeedback() throws SQLException {
        DatabaseConnector dc = new DatabaseConnector();

        try (Connection connection = dc.getConnection();
             PreparedStatement ppst = connection.prepareStatement("SELECT text, fd_id FROM feedback");
             ResultSet re = ppst.executeQuery()) {

            while (re.next()) {
                String feedbackText = re.getString("text");
                int feedbackId = re.getInt("fd_id");
                // Do something with the feedback data
                System.out.print("Feedback ID: " + feedbackId);
                System.out.println(" Feedback Text: " + feedbackText);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
