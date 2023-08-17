package model.entity;

import java.io.Serializable;

import javax.persistence.*;

/**
 * class that represent prescription entity
 *
 * @author Kozunov Alexei
 * @version 1.0.0
 */
@Entity(name = "Prescription")
@Table(name = Prescription.tableName)
public class Prescription implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String tableName = "prescriptions";
	/**
     * id of prescription
     */
    @Id
    @GeneratedValue
    private int id;

    /**
     * name of prescription
     */
    private String name;
    
    /**
     * id of patient 
     */
    @ManyToOne(cascade=CascadeType.MERGE, fetch = FetchType.LAZY)
    private Patient patient;
    
    /*
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<Patient> patients;
    
    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }*/
    
    /**
     * Default constructor to create prescription
     */
    public Prescription() {
        setId(0);
        setName("");
        Patient p = new Patient();
        setPatient(p);
        setPatientId(0);
    }
    
    /**
     * constructor to create prescription
     * @param id id of prescription
     * @param name name of prescription
     * @param patient_id of id patient
     */
    public Prescription(int id, String name, Patient patient) {
        setId(id);
        setName(name);
        Patient p = new Patient();
        setPatient(p);
        setPatientId(p.getId());
    }
    
    /**
     * constructor to create prescription
     * @param name name of prescription
     * @param patient_id of id patient
     */
    public Prescription(String name, Patient patient) {
        setName(name);
        setPatient(patient);
        setPatientId(patient.getId());
    }
	
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
	
    public void setPatient(Patient patient) {
    	this.patient = patient;
    }
    
    public Patient getPatient() {
    	return patient;
    }
    
    public int getPatientId() {
    	return patient.getId();
    }
    
    public void setPatientId(int patient_id) {
    	this.patient.setId(patient_id);
    }
	
}
