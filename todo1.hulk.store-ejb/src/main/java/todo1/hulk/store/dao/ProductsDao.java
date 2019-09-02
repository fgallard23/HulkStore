package todo1.hulk.store.dao;

import java.util.List;

import javax.ejb.Local;

import todo1.hulk.store.exception.DaoException;
import todo1.hulk.store.manager.GenericoDao;
import todo1.hulk.store.model.Products;

/**
 * 
 * <b>
 * Interfaz que permite la consulta de productos
 * </b>
 *  
 * @author Franklin Gallardo
 */
@Local
public interface ProductsDao extends GenericoDao<Products> {

	List<Products> obtenerProductos(String code) throws DaoException;
}
