package model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * class that represent patient entity
 *
 * @author Kozunov Alexei
 * @version 1.0.0
 */
@Entity(name = "Patient")
@Table(name = Patient.tableName)
public class Patient implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String tableName = "patients";
	
	/**
     * id of patient
     */
	@Id
    @GeneratedValue
    private int id;

    /**
     * FIO of patient
     */
    private String fio;
	
    
    @OneToMany(cascade=CascadeType.MERGE, mappedBy = "patient")
    private List<Prescription> prescriptions = new ArrayList<Prescription>();
    
    @OneToMany(cascade=CascadeType.MERGE, mappedBy = "patient")
    private List<Record> records = new ArrayList<Record>();
    
    
    /**
     * Default constructor to create patient
     */
    public Patient() {
        setId(0);
        setFio("");
    }
    
    /**
     * constructor to create patient
     * @param id id of patient
     * @param FIO FIO of patient
     */
    public Patient(int id, String fio) {
        setId(id);
        setFio(fio);
    }
	
    /**
     * constructor to create patient
     * @param FIO FIO of patient
     */
    public Patient(String fio) {
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

    
    public void setPrescriptions(List<Prescription> prescriptions) {
    	this.prescriptions = prescriptions;
    }
    
    public List<Prescription> getPrescriptions() {
    	return prescriptions;
    }
    
    public void setRecords(List<Record> records) {
    	this.records = records;
    }
    
    public List<Record> getRecords() {
    	return records;
    }
   
    @Override
    public String toString() {
        return String.format("Patient:\n\tid - %d\n\tfio - %s", id, fio);
    }
    
}
