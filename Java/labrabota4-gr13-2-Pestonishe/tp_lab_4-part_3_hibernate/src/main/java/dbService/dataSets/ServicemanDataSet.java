package dbService.dataSets;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "serviceman")
public class ServicemanDataSet implements Serializable {
    private static final long serialVersionUID = -8706689714326132798L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "position")
    private String position;

    @Column(name = "salary")
    private int salary;

    @Column(name = "department_id")
    private long departmentId;

    @SuppressWarnings("UnusedDeclaration")
    public ServicemanDataSet() { }

    @SuppressWarnings("UnusedDeclaration")
    public ServicemanDataSet(String first_name, String position, int salary, long departmentId) {
        this.setFirstName(first_name);
        this.setPosition(position);
        this.setSalary(salary);
        this.setDepartmentId(departmentId);
    }
    public ServicemanDataSet(long id, String first_name, String position, int salary, long departmentId) {
        this.setId(id);
        this.setFirstName(first_name);
        this.setPosition(position);
        this.setSalary(salary);
        this.setDepartmentId(departmentId);
    }

    public ServicemanDataSet(String name) {
        this.setId(-1);
        this.setFirstName(name);
        this.setPosition("NULL");
        this.setSalary(0);
        this.setDepartmentId(0);
    }

    @Override
    public String toString() {
        return "UserDataSet{" +
                "id=" + id +
                ", first_name='" + firstName + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                ", department_id=" + departmentId +
                '}';
    }
}