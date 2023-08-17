package org.bsu.web.lab8.model.dao;

import javax.ejb.ApplicationException;

/**
 * Класс исключения для классов AbstractJpaDao-модели
 *
 * @author Александра Малявко
 * @version 2021
 */
@ApplicationException(rollback=true)
public class DAOException extends Exception {
    public DAOException(String message) {
        super(message);
    }

    public DAOException(Throwable cause) {
        super(cause);
    }

    public DAOException() {
        super();
    }

    protected DAOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }
}
