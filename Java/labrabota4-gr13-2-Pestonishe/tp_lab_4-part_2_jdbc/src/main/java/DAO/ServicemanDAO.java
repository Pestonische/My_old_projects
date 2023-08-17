package DAO;

import DataSets.ServicemanData;
import JDBC.SQL_EXECUTOR.SqlExecutor;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.function.Predicate;

public class ServicemanDAO implements DAO<ServicemanData> {
    private SqlExecutor executor = null;

    public ServicemanDAO(Connection connection) throws SQLException {
        executor = new SqlExecutor(connection);
        createTable();
    }

    @Override
    public ServicemanData get(long id) {
        try {
            return executor.sqlQuery("select * from serviceman where id = " + id, resultSet -> {
                        ArrayList<ServicemanData> list = new ArrayList<>();
                        while (resultSet.next()) {
                            list.add(new ServicemanData(resultSet));
                        }
                        return list;
                    }
            ).get(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<ServicemanData> get(Predicate<ServicemanData> predicate) throws SQLException {
        return executor.sqlQuery("select * from serviceman", resultSet -> {
                    ArrayList<ServicemanData> list = new ArrayList<>();
                    while (resultSet.next()) {
                        ServicemanData servicemanData = new ServicemanData(resultSet);
                        if (predicate.test(servicemanData))
                            list.add(servicemanData);
                    }
                    return list;
                }
        );
    }

    @Override
    public void save(ServicemanData servicemanData) throws SQLException {
        executor.sqlUpdate(String.format("insert into serviceman (first, position, salary, " +
                        "departmentld) values ('%s', '%s', %d, '%s' )",
                servicemanData.getFirst(),
                servicemanData.getPosition(),
                servicemanData.getSalary(),
                servicemanData.getDepartmentId()
        ));
    }

    @Override
    public void update(ServicemanData servicemanData, String[] params) throws SQLException {
        executor.sqlUpdate(String.format( "update serviceman set first = '%s', position = '%s'" +
                        ", salary = %d, departmentld = %d where first = '%s' and position = '%s' and salary = %d and departmentld = %d",
                params[0],
                params[1],
                Integer.parseInt(params[2]),
                Integer.parseInt(params[3]),
                servicemanData.getFirst(),
                servicemanData.getPosition(),
                servicemanData.getSalary(),
                servicemanData.getDepartmentId()
        ));
    }

    @Override
    public void delete(ServicemanData servicemanData) throws SQLException {
        executor.sqlUpdate(String.format( "delete from serviceman where first = '%s' and position = '%s' and salary = %d and departmentld = %d",
                servicemanData.getFirst(), servicemanData.getPosition(), servicemanData.getSalary(), servicemanData.getDepartmentId()));

    }

    @Override
    public void createTable() throws SQLException {
        executor.sqlUpdate("""
    CREATE TABLE IF NOT EXISTS serviceman(
    id SERIAL NOT NULL PRIMARY KEY,
    first VARCHAR(20) NOT NULL,
    position VARCHAR(20) NOT NULL,
    salary INT DEFAULT 0,
    departmentld INT NOT NULL)""");
    }

    @Override
    public void dropTable() throws SQLException {
        executor.sqlUpdate("drop table if exists serviceman");
    }

    @Override
    public void clearTable() throws SQLException {
        executor.sqlUpdate("truncate serviceman");
    }
}
