package todo1.hulk.store.manager;

import todo1.hulk.store.exception.DaoException;

/**
 * <b> [Ingresar aqui la descripcion de la clase] </b>
 * 
 * @author fgallard
 */
public interface GenericoDao<T> {

    /**
     * 
     * <b> Descripcion del metodo </b>
     * 
     * @param entity
     */
    T create(T entity) throws DaoException;

    /**
     * 
     * <b> Descripcion del metodo </b>
     * 
     * @param entity
     */
    void edit(T entity) throws DaoException;

    /**
     * 
     * <b> Descripcion del metodo </b>
     * 
     * @param paramE
     */
    void refrescar(T paramE) throws DaoException;

    /**
     * 
     * <b> Descripcion del metodo </b>
     * 
     * @param entity
     */
    void remove(T entity) throws DaoException;

    /**
     * 
     * <b> Descripcion del metodo </b>
     * 
     * @param id
     * @return
     */
    T find(Object id) throws DaoException;
}
