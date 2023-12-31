package JDBC.SQL_EXECUTOR;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SqlExecutor {
    private final Connection connection;

    public SqlExecutor(Connection connection) {
        this.connection = connection;
    }

    public void sqlUpdate(String sql) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        statement.close();
    }

    public <T> ArrayList<T> sqlQuery(String sql, DataSetAction<T> action) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeQuery(sql);

        ResultSet result = statement.getResultSet();
        ArrayList<T> values = action.handle(result);

        statement.close();
        result.close();
        return values;
    }
}
