package org.bsu.web.lab8.model.dao.domain;

import org.bsu.web.lab8.model.dao.AbstractJpaDao;
import org.bsu.web.lab8.model.dao.DAOException;
import org.bsu.web.lab8.model.entity.User;

import javax.persistence.EntityManager;

/**
 * Класс-реализация DAO-модели для таблицы User
 *
 * @author Александра Малявко
 * @version 2021
 */
public class UserDao extends AbstractJpaDao<User, Integer> {

    public UserDao() {
        super(User.class);
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }


    public User getUserByUsernameAndPassword(String username, String password) throws DAOException {
        User u;
        try {
            u = entityManager.createQuery("SELECT u FROM User u WHERE u.nickname=:nickname" +
                            " AND u.password=:password", User.class)
                    .setParameter("nickname", username)
                    .setParameter("password", password)
                    .getSingleResult();

//            u = entityManager
//                    .createNamedQuery("User.getByUsernameAndPassword", User.class)
//                    .setParameter("username", username)
//                    .setParameter("password", password)
//                    .getSingleResult();
        } catch (Exception e) {
            throw new DAOException("User not found!");
        }
        return u;
    }
}
