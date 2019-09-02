package todo1.hulk.store.manager;

import java.lang.reflect.ParameterizedType;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import todo1.hulk.store.exception.DaoException;


/**
 * <b> [Ingresar aqui la descripcion de la clase] </b>
 * 
 * @author fgallard
 */
public abstract class GenericoDaoImpl<T> implements GenericoDao<T> {

    @PersistenceContext(unitName = "sruPU")
    protected EntityManager em;

    private Class<T> entityClass;

    @SuppressWarnings("unchecked")
    public GenericoDaoImpl() {
	ParameterizedType genericSuperClass = (ParameterizedType) getClass().getGenericSuperclass();
	this.entityClass = (Class<T>) genericSuperClass.getActualTypeArguments()[0];
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * ec.com.bancointernacional.seguridades.dao.interfaces.GenericoDao#create(
     * java.lang.Object)
     */
    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public T create(T entity) throws DaoException {
	em.persist(entity);
	em.flush();
	return entity;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * ec.com.bancointernacional.seguridades.dao.interfaces.GenericoDao#edit(
     * java.lang.Object)
     */
    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public void edit(T entity) throws DaoException {
	em.merge(entity);

    }

    /*
     * (non-Javadoc)
     * 
     * @see ec.com.bancointernacional.seguridades.dao.interfaces.GenericoDao#
     * refrescar(java.lang.Object)
     */
    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public void refrescar(T paramE) throws DaoException {
	// TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * ec.com.bancointernacional.seguridades.dao.interfaces.GenericoDao#remove(
     * java.lang.Object)
     */
    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public void remove(T entity) throws DaoException {
	em.remove(entity);
	em.flush();

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * ec.com.bancointernacional.seguridades.dao.interfaces.GenericoDao#find(
     * java.lang.Object)
     */
    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public T find(Object id) throws DaoException {
	return em.find(entityClass, id);
    }
}
