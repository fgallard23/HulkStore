package todo1.hulk.store.services;

import java.util.List;

import javax.ejb.Local;

import todo1.hulk.store.exception.DaoException;
import todo1.hulk.store.model.Client;
import todo1.hulk.store.model.Invoice;
import todo1.hulk.store.model.Products;

@Local
public interface HulkService {

	Client obtenerByIdentificacion(final String identificacion) throws DaoException;
	
	List<Invoice> obtenerFacturas(String code) throws DaoException;
	
	List<Products> obtenerProductos(String code) throws DaoException;
}
