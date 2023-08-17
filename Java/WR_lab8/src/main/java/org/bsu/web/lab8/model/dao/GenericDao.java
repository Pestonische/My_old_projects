package org.bsu.web.lab8.model.dao;

import javax.ejb.Remote;
import java.io.Serializable;
import java.util.List;

/**
 * Унифицированный интерфейс управления персистентным состоянием объектов
 *
 * @param <T>  тип объекта персистенции
 * @param <PK> тип первичного ключа
 * @author Александра Малявко
 * @version 2021
 */
@Remote
public interface GenericDao<T, PK extends Serializable> {
    /**
     * Создает новую запись, соответствующую объекту object
     */
    T persist(T object) throws DAOException;

    /**
     * Возвращает объект, соответствующий записи с первичным ключом key
     */
    T getByPK(PK key) throws DAOException;

    /**
     * Сохраняет состояние объекта в базе данных
     */
    void update(T object) throws DAOException;

    /**
     * Удаляет запись об объекте из базы данных
     */
    void delete(T object) throws DAOException;

    /**
     * Возвращает список объектов, соответствующих всем записям в базе данных
     */
    List<T> getAll() throws DAOException;
}
