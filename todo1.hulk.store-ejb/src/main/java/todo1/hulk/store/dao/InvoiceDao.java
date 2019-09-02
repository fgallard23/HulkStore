package todo1.hulk.store.dao;

import java.util.List;

import javax.ejb.Local;

import todo1.hulk.store.exception.DaoException;
import todo1.hulk.store.manager.GenericoDao;
import todo1.hulk.store.model.Invoice;

/**
 * 
 * <b>
 * Interfaz que permite la consultar Clientes
 * </b>
 *  
 * @author Franklin Gallardo
 */
@Local
public interface InvoiceDao extends GenericoDao<Invoice> {

	List<Invoice> obtenerFacturas(String code) throws DaoException;
}
