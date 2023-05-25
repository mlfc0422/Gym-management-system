package Common;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Printdatabase {
    public void printQueryResult(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        // 打印表头
        for (int i = 1; i <= columnCount; i++) {
            System.out.printf("%-15s",metaData.getColumnName(i));
        }
        System.out.println();

        // 打印每行数据
        while (resultSet.next()) {
            for (int i = 1; i <= columnCount; i++) {
                System.out.printf("%-15s",resultSet.getString(i));
            }
            System.out.println();
        }
    }
}
