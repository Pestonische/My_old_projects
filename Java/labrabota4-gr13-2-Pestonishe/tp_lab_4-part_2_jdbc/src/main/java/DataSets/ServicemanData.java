package DataSets;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ServicemanData {
    int id;
    String first;
    String position;
    int salary;
    int departmentId;

    public ServicemanData(int id, String first, String position, int salary, int departmentId) {
        this.id = id;
        this.first = first;
        this.position = position;
        this.salary = salary;
        this.departmentId = departmentId;
    }
    public ServicemanData(String first, String position, int salary, int departmentId) {
        this.id = 0;
        this.first = first;
        this.position = position;
        this.salary = salary;
        this.departmentId = departmentId;
    }
    public ServicemanData(ResultSet set) throws SQLException {
        this(
                set.getInt(1),
                set.getString(2),
                set.getString(3),
                set.getInt(4),
                set.getInt(5)
        );
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    @Override
    public String toString() {
        return "ServicemanData object {" +
                "id=" + id +
                ", first=" + first +
                ", position=" + position +
                ", salary=" + salary +
                ", departmentId=" + departmentId +
                '}';
    }
}