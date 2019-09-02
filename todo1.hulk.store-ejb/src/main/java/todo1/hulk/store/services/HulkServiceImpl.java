package todo1.hulk.store.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import todo1.hulk.store.dao.ClientDao;
import todo1.hulk.store.dao.InvoiceDao;
import todo1.hulk.store.dao.ProductsDao;
import todo1.hulk.store.exception.DaoException;
import todo1.hulk.store.model.Client;
import todo1.hulk.store.model.Invoice;
import todo1.hulk.store.model.Products;

@Stateless
public class HulkServiceImpl implements HulkService {

	@EJB
	private ClientDao clientDao;

	@EJB
	private InvoiceDao invoiceDao;

	@EJB
	private ProductsDao productsDao;

	@Override
	public Client obtenerByIdentificacion(String identificacion) throws DaoException {
		try {
			return clientDao.obtenerByIdentificacion(identificacion);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@Override
	public List<Invoice> obtenerFacturas(String code) throws DaoException {
		try {
			return invoiceDao.obtenerFacturas(code);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@Override
	public List<Products> obtenerProductos(String code) throws DaoException {
		try {
			return productsDao.obtenerProductos(code);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}
}
