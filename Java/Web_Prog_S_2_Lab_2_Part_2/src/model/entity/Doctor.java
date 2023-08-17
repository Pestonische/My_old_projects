package model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * class that represent doctor entity
 *
 * @author Kozunov Alexei
 * @version 1.0.0
 */

@Entity(name = "Doctor")
@Table(name = Doctor.tableName)
public class Doctor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String tableName = "doctors";
	
	/**
     * id of doctor
     */
    @Id
    @GeneratedValue
    private int id;

    /**
     * FIO of doctor
     */
    private String fio;
    
    @OneToMany(cascade=CascadeType.MERGE, mappedBy = "doctor")
    private List<Record> record = new ArrayList<Record>();
    
    /**
     * Default constructor
     */
    public Doctor() {
        setId(0);
        setFio("");
    }
    
    /**
     * constructor to create doctor
     * @param id id of doctor
     * @param FIO FIO of doctor
     */
    public Doctor(int id, String fio) {
        setId(id);
        setFio(fio);
    }
	
    public Doctor(String fio) {
        setFio(fio);
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    @Override
    public String toString() {
        return String.format("Doctor:\n\tid - %d\n\tfio - %s", id, fio);
    }
	
}
