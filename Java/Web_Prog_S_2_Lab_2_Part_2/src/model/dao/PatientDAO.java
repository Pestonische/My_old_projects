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
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import model.entity.Patient;
import model.entity.Patient_;
import model.exception.DAOException;
import model.exception.DBConnectionException;

/**
 * patient dao class
 *
 * @author Kozunov Alexei
 * @version 1.0.0
 */
public class PatientDAO extends DAO {
	
	/*
	private static final String INSERT_PATIENT_SQL = "insert into patients (FIO) values(?)";

    private static final String DELETE_PATIENT_SQL = "delete from patients where id = ?";

    private static final String SELECT_ALL_PATIENTS_SQL = "select * from patients";

    private static final String SELECT_PATIENT_BY_ID_SQL = "select * from patients where id = ?";
    */
    
    /**
     * constructor
     *
     * @throws DAOException if Can't create connection
     */
    public PatientDAO() throws DAOException {
        super();
    }
	
    /**
     * read patient
     *
     * @return list of patients
     * @throws DAOException if Can't execute query or problems with connection
     */
    public ArrayList<Patient> readPatients() throws DAOException {
    	ArrayList<Patient> patients = new ArrayList<Patient>();
    	EntityManager entityManager = null;
        try {
        	entityManager = getEntityManagerFactory().createEntityManager();

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Patient.class);
            Root patient = criteriaQuery.from(Patient.class);

            patients = (ArrayList<Patient>) entityManager.createQuery(criteriaQuery)
                    .getResultList();
            
            logger.info("read patients");
        } catch (Exception e) {
            throw new DAOException("failed to read patients", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
        return patients;
    }

    /**
     * read patient by id
     *
     * @return patient
     * @throws DAOException if Can't execute query or problems with connection
     */
    public Patient readPatientById(int id) throws DAOException {
    	Patient patient = null;
    	EntityManager entityManager = null;
        try {
        	entityManager = getEntityManagerFactory().createEntityManager();

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Patient.class);
            Root rootPatient = criteriaQuery.from(Patient.class);
            Predicate condition = criteriaBuilder.equal(rootPatient.get(Patient_.id), id);
            criteriaQuery.where(condition);

            patient = (Patient) entityManager.createQuery(criteriaQuery)
                    .getSingleResult();
        	        	
            logger.info("read patient by id");
        } catch (Exception e) {
            throw new DAOException("failed to read patient", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
        return patient;
    }

    /**
     * insert patient
     *
     * @throws DAOException if Can't execute query or problems with connection
     */
    public void insertPatinet(Patient patient) throws DAOException {
    	EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
        	entityManager = getEntityManagerFactory().createEntityManager();
            transaction = entityManager.getTransaction();

            transaction.begin();
            entityManager.persist(patient);
            transaction.commit();
            logger.info("inserted patient");
        } catch (Exception e) {
            if (transaction != null && transaction.isActive())
                transaction.rollback();
            throw new DAOException("failed to insert patient", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
    }

    /**
     * deleter patient
     *
     * @throws DAOException if Can't execute query or problems with connection
     */
    public void deletePatinet(Patient patient) throws DAOException {
    	EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
        	entityManager = getEntityManagerFactory().createEntityManager();
            transaction = entityManager.getTransaction();

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaDelete criteriaDelete = criteriaBuilder.createCriteriaDelete(Patient.class);
            Root rootCPatient = criteriaDelete.from(Patient.class);
            Predicate condition = criteriaBuilder.equal(rootCPatient.get(Patient_.id), patient.getId());
            criteriaDelete.where(condition);

            transaction.begin();
            entityManager.createQuery(criteriaDelete)
                    .executeUpdate();
            transaction.commit();
        	
            logger.info("deleted patient");
        } catch (Exception e) {
            if (transaction != null && transaction.isActive())
                transaction.rollback();
            throw new DAOException("failed to delete client", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
    }
    
}
