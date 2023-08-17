package dbService.dao;

import dbService.dataSets.ServicemanDataSet;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;

public class ServicemanDAO {

    private final Session session;

    public ServicemanDAO(Session session) {
        this.session = session;
    }

    public ServicemanDataSet get(long id) throws HibernateException {
        return (ServicemanDataSet) session.get(ServicemanDataSet.class, id);
    }

    public ArrayList<ServicemanDataSet> getAll() {
        Criteria criteria = session.createCriteria(ServicemanDataSet.class);
        return new ArrayList<ServicemanDataSet>(criteria.add(Restrictions.isNotNull("firstName")).list());
    }

    public ServicemanDataSet getByName(String name) throws HibernateException {
        Criteria criteria = session.createCriteria(ServicemanDataSet.class);
        return ((ServicemanDataSet) criteria.add(Restrictions.eq("firstName", name)).uniqueResult());
    }

    public long insertUser(String name) throws HibernateException {
        return (Long) session.save(new ServicemanDataSet(name));
    }

    public long insertUser(long id, String name, String position, int salary, long departmentId)
            throws HibernateException {
        return (Long) session.save(new ServicemanDataSet(id, name, position, salary, departmentId));
    }
}