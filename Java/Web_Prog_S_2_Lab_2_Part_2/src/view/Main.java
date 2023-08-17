package view;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import controller.HospitalController;
import model.entity.Doctor;
import model.entity.Patient;
import model.entity.Prescription;
import model.entity.Record;
import model.exception.HospitalControllerException;

public class Main {

	private static Logger logger = LogManager.getRootLogger();
	
	public static void main(String[] args) {
		HospitalController controller = new HospitalController();
        try {
            Patient patient = new Patient("A");
            Doctor doctor = controller.GetDoctorById(1);
            System.out.println(doctor.toString());
            Record record = controller.RegisterPatient(patient, doctor);
            controller.DeterminDiagnosis(record, patient);
            Prescription prescription = controller.DoPrescription(patient);
            controller.ViewPrescription(prescription, patient);
            controller.DishargePatient(patient);
        } catch (HospitalControllerException e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
	}

}
