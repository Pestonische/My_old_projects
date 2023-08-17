package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import model.entity.Doctor;
import model.entity.Doctor_;
import model.entity.Patient;
import model.entity.Patient_;
import model.entity.Prescription;
import model.entity.Prescription_;
import model.entity.Record;
import model.entity.Record_;
import model.exception.DAOException;
import model.exception.DBConnectionException;

/**
 * hospital dao class
 *
 * @author Kozunov Alexei
 * @version 1.0.0
 */
public class HospitalDAO extends DAO {
	
    /**
     * constructor
     *
     * @throws DAOException if Can't create connection
     */
    public HospitalDAO() throws DAOException {
        super();
    }

    /**
     * read records
     *
     * @return list of record
     * @throws DAOException if Can't execute query or problems with connection
     */
    public ArrayList<Record> readRecords() throws DAOException {
        ArrayList<Record> records = new ArrayList<Record>();
        EntityManager entityManager = null;
        try {
        	entityManager = getEntityManagerFactory().createEntityManager();

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Record.class);
            
            records = (ArrayList<Record>) entityManager.createQuery(criteriaQuery)
                    .getResultList();
        	
            logger.info("read records");
        } catch (Exception e) {
            throw new DAOException("failed to read records", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
        return records;
    }

    /**
     * read record by patient id
     *
     * @return record
     * @throws DAOException if Can't execute query or problems with connection
     */
    public Record selectRecordByPatinetId(int _id) throws DAOException {
        Record record = null;
        EntityManager entityManager = null;
        try {
        	entityManager = getEntityManagerFactory().createEntityManager();

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Record.class);
            Root rootRecord = criteriaQuery.from(Record.class);
            Join patientsJoin = rootRecord.join(Patient_.records);
            Predicate condition = criteriaBuilder.equal(patientsJoin.get(Patient_.id), _id);
            patientsJoin.on(condition);


            record = (Record) entityManager.createQuery(criteriaQuery)
                    .getSingleResult();
        	        	        
            logger.info("read record by patient id");
        } catch (Exception e) {
            throw new DAOException("failed to read record by patient id", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
        return record;
    }

    /**
     * insert record
     *
     * @throws DAOException if Can't execute query or problems with connection
     */
    public Record insertRecord(Patient patient, Doctor doctor) throws DAOException {
    	EntityManager entityManager = null;
        EntityTransaction transaction = null;
        Record record;
        try {
        	entityManager = getEntityManagerFactory().createEntityManager();
            transaction = entityManager.getTransaction();

            transaction.begin();
            record = new Record("", false, patient, doctor);
            entityManager.persist(record);
            transaction.commit();
            logger.info("inserted record");
        } catch (Exception e) {
            if (transaction != null && transaction.isActive())
                transaction.rollback();
            throw new DAOException("failed to insert record", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
        return record;
    }

    /**
     * insert prescription
     *
     * @throws DAOException if Can't execute query or problems with connection
     */
    public Prescription insertPrescription(String name, Patient patient) throws DAOException {
    	Prescription prescription;
    	EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
        	entityManager = getEntityManagerFactory().createEntityManager();
            transaction = entityManager.getTransaction();
            prescription = new Prescription(name, patient);
            transaction.begin();
            
            entityManager.persist(prescription);
            transaction.commit();
            logger.info("inserted prescription");
        } catch (Exception e) {
            if (transaction != null && transaction.isActive())
                transaction.rollback();
            throw new DAOException("failed to insert prescription", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
        return prescription;
    }
    
    /**
     * delete record
     *
     * @throws DAOException if Can't execute query or problems with connection
     */
    public void deleteRecord(Record record) throws DAOException {
    	EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
        	entityManager = getEntityManagerFactory().createEntityManager();
            transaction = entityManager.getTransaction();

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaDelete criteriaDelete = criteriaBuilder.createCriteriaDelete(Record.class);
            Root rootRecord = criteriaDelete.from(Record.class);
            Predicate condition = criteriaBuilder.equal(rootRecord.get(Record_.id), record.getId());
            criteriaDelete.where(condition);

            transaction.begin();
            entityManager.createQuery(criteriaDelete)
                    .executeUpdate();
            transaction.commit();
        	                    	
            logger.info("deleted record");
        } catch (Exception e) {
            if (transaction != null && transaction.isActive())
                transaction.rollback();
            throw new DAOException("failed to delete record", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
    }

    /**
     * read records by doctor
     *
     * @throws DAOException if Can't execute query or problems with connection
     */
    public ArrayList<Record> readRecordsByDoctor(Doctor doctor) throws DAOException {
    	ArrayList<Record> records = new ArrayList<Record>();
    	EntityManager entityManager = null;
        try {
        	entityManager = getEntityManagerFactory().createEntityManager();

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Record.class);
            Root rootRecord = criteriaQuery.from(Record.class);
            Join doctorJoin = rootRecord.join(Doctor_.record);
            Predicate condition = criteriaBuilder.equal(doctorJoin.get(Doctor_.id), doctor.getId());
            doctorJoin.on(condition);


            records = (ArrayList<Record>) entityManager.createQuery(criteriaQuery)
                    .getResultList();
        	
            logger.info("read records by doctor");
        } catch (Exception e) {
            throw new DAOException("failed to read records by doctor id", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
        return records;
    }

    /**
     * read prescriptions by patient
     *
     * @throws DAOException if Can't execute query or problems with connection
     */
    public ArrayList<Prescription> readPrescriptionsByPatient(Prescription prescription, Patient patient) throws DAOException {
    	ArrayList<Prescription> prescriptions = new ArrayList<Prescription>();
        EntityManager entityManager = null;
        try {
        	entityManager = getEntityManagerFactory().createEntityManager();

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Prescription.class);
            Root rootPrescription = criteriaQuery.from(Prescription.class);
            Predicate condition = criteriaBuilder.equal(rootPrescription.get(Prescription_.id), prescription.getId());

            prescriptions = (ArrayList<Prescription>) entityManager.createQuery(criteriaQuery)
                    .getResultList();
        	
            logger.info("read prescriptions by patient");
        } catch (Exception e) {
            throw new DAOException("failed to read prescriptions by patient id", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
        return prescriptions;
    }

    /**
     * update record 
     * @param patient patient
     * @param diagnosis diagnosis of patient
     * @throws DAOException if Can't execute query or problems with connection
     */
    public void setPatientDiagnosis(Record record, Patient patient, String diagnosis) throws DAOException {
    	EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
        	entityManager = getEntityManagerFactory().createEntityManager();
            transaction = entityManager.getTransaction();

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaUpdate update = criteriaBuilder.createCriteriaUpdate(Record.class);
            Root rootRecord = update.from(Record.class);
            update.set(rootRecord.get(Record_.diagnosis), diagnosis);
            Predicate condition = criteriaBuilder.equal(rootRecord.get(Record_.id), record.getId());
            update.where(condition);

            transaction.begin();
            entityManager.createQuery(update)
                    .executeUpdate();
            transaction.commit();
        	
        	
            logger.info("set diagnosis of patient");
        } catch (Exception e) {
            if (transaction != null && transaction.isActive())
                transaction.rollback();
            throw new DAOException("failed to update diagnosis of patient", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
    }

    /**
     * update record 
     * @param patient patient
     * @param discharge discharge of patient
     * @throws DAOException if Can't execute query or problems with connection
     */
    public void setPatientDischarge(Patient patient, boolean discharge) throws DAOException {
    	EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
        	entityManager = getEntityManagerFactory().createEntityManager();
            transaction = entityManager.getTransaction();

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaUpdate update = criteriaBuilder.createCriteriaUpdate(Record.class);
            Root rootRecord = update.from(Record.class);
            update.set(rootRecord.get(Record_.discharged), discharge);
            Predicate condition = criteriaBuilder.equal(rootRecord.get(Record_.id), patient.getId());
            update.where(condition);

            transaction.begin();
            entityManager.createQuery(update)
                    .executeUpdate();
            transaction.commit();
        	
            logger.info("set discharge");
        } catch (Exception e) {
            if (transaction != null && transaction.isActive())
                transaction.rollback();
            throw new DAOException("failed to update discharge of patient", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
    }

	
}
