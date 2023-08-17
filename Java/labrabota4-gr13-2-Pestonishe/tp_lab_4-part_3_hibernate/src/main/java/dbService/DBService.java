package dbService;

import dbService.dao.ServicemanDAO;
import dbService.dataSets.ServicemanDataSet;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.ArrayList;

public class DBService {
    private final SessionFactory sessionFactory;

    public DBService(String workMode) {
        Configuration configuration = getPostgreSQLConfiguration();
        configuration.setProperty("hibernate.hbm2ddl.auto", workMode);
        sessionFactory = createSessionFactory(configuration);
    }

    public void close() {
        sessionFactory.close();
    }

    private Configuration getPostgreSQLConfiguration() {
        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(ServicemanDataSet.class);
        return configuration;
    }

    public ServicemanDataSet getServiceman(long id) throws DBException {
        try {
            Session session = sessionFactory.openSession();
            ServicemanDAO dao = new ServicemanDAO(session);
            ServicemanDataSet dataSet = dao.get(id);
            session.close();
            return dataSet;
        } catch (HibernateException e) {
            throw new DBException(e);
        }
    }

    public ServicemanDataSet getServicemanByName(String name) throws DBException {
        try {
            Session session = sessionFactory.openSession();
            ServicemanDAO dao = new ServicemanDAO(session);
            ServicemanDataSet dataSet = dao.getByName(name);
            session.close();
            return dataSet;
        } catch (HibernateException e) {
            throw new DBException(e);
        }
    }

    public ArrayList<ServicemanDataSet> getAll() throws DBException {
        try {
            Session session = sessionFactory.openSession();
            ServicemanDAO dao = new ServicemanDAO(session);
            ArrayList<ServicemanDataSet> dataSet = dao.getAll();
            session.close();
            return dataSet;
        } catch (HibernateException e) {
            throw new DBException(e);
        }
    }

    public long addServiceman(String name) throws DBException {
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            ServicemanDAO dao = new ServicemanDAO(session);
            long id = dao.insertUser(name);
            transaction.commit();
            session.close();
            return id;
        } catch (HibernateException e) {
            throw new DBException(e);
        }
    }

    public long addServiceman(long id, String name, String position, int salary, long departmentId) throws DBException {
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            ServicemanDAO dao = new ServicemanDAO(session);
            long returnId = dao.insertUser(id, name, position, salary, departmentId);
            transaction.commit();
            session.close();
            return returnId;
        } catch (HibernateException e) {
            throw new DBException(e);
        }
    }

    private static SessionFactory createSessionFactory(Configuration configuration) {
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }
}
