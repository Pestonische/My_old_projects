package model.entity;

import java.io.Serializable;

import javax.persistence.*;

/**
 * class that represent record entity
 *
 * @author Kozunov Alexei
 * @version 1.0.0
 */

@Entity(name = "Record")
@Table(name = Record.tableName)
public class Record implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String tableName = "records";
	
	/**
     * id of record
     */
    @Id
    @GeneratedValue
    private int id;

    /**
     * diagnosis of patient
     */
    private String diagnosis;
    
    /**
     * discharge patient or not
     */
    private boolean discharged;
    
    //private int patient_id;
    
    //private int doctor_id;
    
    /**
     * patient of record
     */
    @ManyToOne(cascade=CascadeType.MERGE, fetch = FetchType.LAZY)
    private Patient patient;
    
    /**
     * doctor_id of record
     */
    @ManyToOne(cascade=CascadeType.MERGE, fetch = FetchType.LAZY)
    private Doctor doctor;
    
    /*
    @ManyToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<Patient> patients;
    
    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<Doctor> doctors;
    
    public Set<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(Set<Doctor> doctors) {
        this.doctors = doctors;
    }
    */
    
    /**
     * Default constructor to create record
     */
    public Record() {
        setId(0);
        setDiagnosis("");
        setDischarged(false);
        Patient p = new Patient();
        setPatient(p);
        Doctor d = new Doctor();
        setDoctor(d);
        setPatientId(0);
        setDoctorId(0);
    }
    
    /**
     * constructor to create record
     * @param id id of record
     * @param diagnosis of patient
     * @param discharged of patient
     * @param patient_id of patient
     * @param doctor_id of doctor
     */
    public Record(int id, String diagnosis, boolean discharged, Patient patient, Doctor doctor) {
        setId(id);
        setDiagnosis(diagnosis);
        setDischarged(discharged);
        setPatient(patient);
        setPatientId(patient.getId());
        setDoctor(doctor);
        setDoctorId(doctor.getId());
        //patient_id = getPatientId();
        //doctor_id = getDoctorId();
    }
	
    /**
     * constructor to create record
     * @param diagnosis of patient
     * @param discharged of patient
     * @param patient_id of patient
     * @param doctor_id of doctor
     */
    public Record(String diagnosis, boolean discharged, Patient patient, Doctor doctor) {
        //setId(0);
        setDiagnosis(diagnosis);
        setDischarged(discharged);
        setPatient(patient);
        setPatientId(patient.getId());
        setDoctor(doctor);
        setDoctorId(doctor.getId());
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDiagnosis() {
        return diagnosis;
    }
    
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
	
    public boolean getDischarged() {
    	return discharged;
    }
    
    public void setDischarged(boolean discharged) {
    	this.discharged = discharged;
    }
    
    public int getPatientId() {
    	return patient.getId();
    }
    
    public void setPatient(Patient patient) {
    	this.patient = patient;
    }
    
    public Patient getPatient() {
    	return patient;
    }
    
    public void setDoctor(Doctor doctor) {
    	this.doctor = doctor;
    }
    
    public Doctor getDoctor() {
    	return doctor;
    }
    
    public void setPatientId(int patient_id) {
    	this.patient.setId(patient_id);
    }
    
    public int getDoctorId() {
    	return doctor.getId();
    }
    
    public void setDoctorId(int doctor_id) {
    	this.doctor.setId(doctor_id);
    }
    
}
