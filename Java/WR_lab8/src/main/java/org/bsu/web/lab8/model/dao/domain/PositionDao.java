package org.bsu.web.lab8.model.dao.domain;

import org.bsu.web.lab8.model.dao.AbstractJpaDao;
import org.bsu.web.lab8.model.entity.Position;

import javax.persistence.EntityManager;

/**
 * Класс-реализация DAO-модели для таблицы Position
 *
 * @author Александра Малявко
 * @version 2021
 */
public class PositionDao extends AbstractJpaDao<Position, Integer> {

    public PositionDao() {
        super(Position.class);
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }
}
