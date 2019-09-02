package todo1.hulk.store.dao;

import javax.ejb.Local;

import todo1.hulk.store.exception.DaoException;
import todo1.hulk.store.manager.GenericoDao;
import todo1.hulk.store.model.Client;

/**
 * 
 * <b>
 * Interfaz que permite la consultar Clientes
 * </b>
 *  
 * @author Franklin Gallardo
 */
@Local
public interface ClientDao extends GenericoDao<Client> {

	Client obtenerByIdentificacion(final String identificacion) throws DaoException;
}
