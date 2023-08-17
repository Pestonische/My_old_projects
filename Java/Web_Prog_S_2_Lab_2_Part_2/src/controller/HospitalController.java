package controller;

import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import model.dao.DoctorDAO;
import model.dao.HospitalDAO;
import model.dao.PatientDAO;
import model.entity.Doctor;
import model.entity.Patient;
import model.entity.Prescription;
import model.entity.Record;
import model.exception.DAOException;
import model.exception.HospitalControllerException;

/**
 * controller
 *
 * @author Kozunov Alexei
 * @version 1.0.0
 */
public class HospitalController {

	private Logger logger = LogManager.getLogger("controller_layer");
	
	public Doctor GetDoctorById(int id) throws HospitalControllerException {
		Doctor doctor = null;
		try {
            DoctorDAO tmp = new DoctorDAO();
            doctor = tmp.readDoctorById(id);
            logger.info("read doctor by id");
        } catch (DAOException e) {
            throw new HospitalControllerException("Failed to read doctor", e);
        }
		return doctor;
	}
	
	public Record RegisterPatient(Patient patient, Doctor doctor) throws HospitalControllerException {
		Record record;
		try {
            PatientDAO tmp = new PatientDAO();
            HospitalDAO htmp = new HospitalDAO();
            tmp.insertPatinet(patient);
            record = htmp.insertRecord(patient, doctor);
            logger.info("patient was registrated");
        } catch (DAOException e) {
            throw new HospitalControllerException("Failed to registrate patient", e);
        }
		return record;
	}
	
	public void DeterminDiagnosis(Record record, Patient patient) throws HospitalControllerException {
		Scanner in = new Scanner(System.in);
		System.out.println("Input diagnosis: ");
		String diagnosis = in.nextLine();
		try {
            HospitalDAO tmp = new HospitalDAO();
            tmp.setPatientDiagnosis(record, patient, diagnosis);
            logger.info("determin diagnosis");
        } catch (DAOException e) {
            throw new HospitalControllerException("Failed to update record", e);
        }
	}
	
	public Prescription DoPrescription(Patient patient) throws HospitalControllerException {
		Prescription prescription;
		Scanner in = new Scanner(System.in);
		System.out.println("Input prescription: ");
		String name = in.nextLine();
		try {
            HospitalDAO tmp = new HospitalDAO();
            prescription = tmp.insertPrescription(name, patient);
            logger.info("insert prescription");
        } catch (DAOException e) {
            throw new HospitalControllerException("Failed to insert prescription", e);
        }
		return prescription;
	}
	
	public void ViewPrescription(Prescription prescription, Patient patient) throws HospitalControllerException  {
		try {
            HospitalDAO tmp = new HospitalDAO();
            ArrayList<Prescription> prescriptions = tmp.readPrescriptionsByPatient(prescription, patient);
            for(Prescription i : prescriptions) {
            	System.out.println(i.getName());
            }
            logger.info("read prescriptions");
        } catch (DAOException e) {
            throw new HospitalControllerException("Failed to read prescription", e);
        }
	}
	
	public void DishargePatient(Patient patient) throws HospitalControllerException {
		try {
            HospitalDAO tmp = new HospitalDAO();
            tmp.setPatientDischarge(patient, true);
            logger.info("patient was disharged");
        } catch (DAOException e) {
            throw new HospitalControllerException("Failed to update record", e);
        }
	}
}
