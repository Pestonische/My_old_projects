package org.bsu.web.lab8.model.dao.domain;

import org.bsu.web.lab8.model.dao.AbstractJpaDao;
import org.bsu.web.lab8.model.dao.DAOException;
import org.bsu.web.lab8.model.entity.Order;
import org.bsu.web.lab8.model.entity.OrderPosition;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

/**
 * Класс-реализация DAO-модели для таблицы Order
 *
 * @author Александра Малявко
 * @version 2021
 */
public class OrderDao extends AbstractJpaDao<Order, Integer> {

    public OrderDao() {
        super(Order.class);
    }

    /**
     * Возвращает заказы в соответствии с их статусом подтверждения
     *
     * @param confirmed статус (подтвержден/не подтвержден)
     * @return список заказов
     */

    public List<Order> getOrders(boolean confirmed) throws DAOException {
        return entityManager
                .createNamedQuery("Order.findByConfirmedStatus", Order.class)
                .setParameter("isConfirmed", confirmed)
                .getResultList();
    }

    /**
     * Возвращает список позиций в заказе
     *
     * @param orderId идентификатор заказа, для которого надо получить список
     * @return список пар вида (позиция, кол-во)
     */

    public List<OrderPosition> getOrderPositions(Integer orderId) throws DAOException {
        return getByPK(orderId).getPositions();
    }

    /**
     * Устанавливает статус заказа в подтвержденный
     *
     * @param orderId идентификатор заказа
     */

    public void confirmOrder(Integer orderId) throws DAOException {
        entityManager
                .createNamedQuery("Order.confirmOrder")
                .setParameter("id", orderId)
                .executeUpdate();
    }

    /**
     * Возвращает список заказов определенного клиента
     *
     * @param clientId идентификатор клиента
     * @return список заказов
     */

    public List<Order> getAll(Integer clientId) throws DAOException {
        return entityManager
                .createNamedQuery("Order.findByClient", Order.class)
                .setParameter("id", clientId)
                .getResultList();
        //return new UserDao().getByPK(clientId).getClientOrders();
    }

    /**
     * Вычисляет стоимость заказа
     *
     * @param orderId идентификатор заказа
     * @return стоимость
     */

    public BigDecimal getOrderCost(Integer orderId) throws DAOException {
        return entityManager
                .createNamedQuery("Order.getCost", BigDecimal.class)
                .setParameter("id", orderId)
                .getSingleResult();
    }


    protected EntityManager getEntityManager() {
        return entityManager;
    }
}
