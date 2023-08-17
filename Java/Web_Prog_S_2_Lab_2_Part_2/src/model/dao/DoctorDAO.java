package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import model.entity.Doctor;
import model.entity.Doctor_;
import model.exception.DAOException;
import model.exception.DBConnectionException;

/**
 * doctor dao class
 *
 * @author Kozunov Alexei
 * @version 1.0.0
 */
public class DoctorDAO extends DAO {

	/*
	private static final String INSERT_DOCTOR_SQL = "insert into doctors (FIO) values(?)";
    private static final String DELETE_DOCTOR_SQL = "delete from doctors where id = ?";
    private static final String SELECT_ALL_DOCTORS_SQL = "select * from doctors";
    private static final String SELECT_DOCTOR_BY_ID_SQL = "select * from doctors where id = ?";
    */
    
    /**
     * constructor
     *
     * @throws DAOException if Can't create connection
     */
    public DoctorDAO() {
        super();
    }
	
    /**
     * read doctor
     *
     * @return list of doctors
     * @throws DAOException if Can't execute query or problems with connection
     */
    public ArrayList<Doctor> readDoctors() throws DAOException {
    	ArrayList<Doctor> doctors = new ArrayList<Doctor>();
    	EntityManager entityManager = null;
        try {
        	entityManager = getEntityManagerFactory().createEntityManager();

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Doctor.class);
            Root client = criteriaQuery.from(Doctor.class);

            doctors = (ArrayList<Doctor>) entityManager.createQuery(criteriaQuery)
                    .getResultList();
        	
            logger.info("read doctors");
        } catch (Exception e) {
            throw new DAOException("Read doctors exception ", e);
        } finally {
        	if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
        return doctors;
    }

    /**
     * read doctor by id
     *
     * @return doctor
     * @throws DAOException if Can't execute query or problems with connection
     */
    public Doctor readDoctorById(int id) throws DAOException {
    	Doctor doctor = null;
    	EntityManager entityManager = null;
        try {
        	entityManager = getEntityManagerFactory().createEntityManager();

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Doctor.class);
            Root rootDoctor = criteriaQuery.from(Doctor.class);
            Predicate condition = criteriaBuilder.equal(rootDoctor.get(Doctor_.id), id);
            criteriaQuery.where(condition);

            doctor = (Doctor) entityManager.createQuery(criteriaQuery)
                    .getSingleResult();
        	
            logger.info("read doctor by id");
        } catch (Exception e) {
            throw new DAOException("Read doctors exception ", e);
        } finally {
        	if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
        return doctor;
    }

    /**
     * insert doctor
     *
     * @throws DAOException if Can't execute query or problems with connection
     */
    public void insertDoctor(Doctor doctor) throws DAOException {
    	EntityManager entityManager = null;
    	EntityTransaction transaction = null;
        try {
        	entityManager = getEntityManagerFactory().createEntityManager();
            transaction = entityManager.getTransaction();

            transaction.begin();
            entityManager.persist(doctor);
            transaction.commit();
            logger.info("inserted doctor");
        } catch (Exception e) {
        	if (transaction != null && transaction.isActive())
                transaction.rollback();
        	throw new DAOException("Read doctors exception ", e);
        } finally {
        	if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
    }

    /**
     * deleter doctor
     *
     * @throws DAOException if Can't execute query or problems with connection
     */
    public void deleteDoctor(Doctor doctor) throws DAOException {
    	EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
        	entityManager = getEntityManagerFactory().createEntityManager();
            transaction = entityManager.getTransaction();

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaDelete criteriaDelete = criteriaBuilder.createCriteriaDelete(Doctor.class);
            Root rootDoctor = criteriaDelete.from(Doctor.class);
            Predicate condition = criteriaBuilder.equal(rootDoctor.get(Doctor_.id), doctor.getId());
            criteriaDelete.where(condition);

            transaction.begin();
            entityManager.createQuery(criteriaDelete)
                    .executeUpdate();
            transaction.commit();
        	
            logger.info("deleted doctor");
        } catch (Exception e) {
        	if (transaction != null && transaction.isActive())
                transaction.rollback();
            throw new DAOException("Read doctors exception ", e);
        } finally {
        	if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
    }
	
}
