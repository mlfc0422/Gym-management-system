package User;
import java.sql.*;
import database.DatabaseConnector;

public class Personal_Data
{
    private final String url = "jdbc:mysql://localhost:3306/gym?characterEncoding=utf-8&serverTimezone=UTC";
    private final String username = "root";
    private final String password = "liyu422321";
    public void personal_data() throws SQLException {
        DatabaseConnector dc = new DatabaseConnector(url,username,password);
        try
        {
            Connection connection = dc.getConnection();
            if (connection != null && !connection.isClosed()) {
                System.out.println("数据库连接成功！");
            } else {
                System.out.println("数据库连接失败！");
            }
        }catch(SQLException e)
        {
            System.out.println("查询个人信息出错：" + e.getMessage());
        }
    }
}
