package todo1.hulk.store.dao.impl;

import java.util.List;
import javax.persistence.Query;

import todo1.hulk.store.constant.Constant;
import todo1.hulk.store.dao.InvoiceDao;
import todo1.hulk.store.exception.DaoException;
import todo1.hulk.store.manager.GenericoDaoImpl;
import todo1.hulk.store.model.Invoice;

public class InvoiceDaoImpl extends GenericoDaoImpl<Invoice> implements InvoiceDao {


    @SuppressWarnings("unchecked")
	public List<Invoice> obtenerFacturas(String code) throws DaoException {
    	
		Query query = this.em.createNamedQuery(Constant.OBTENER_PRODUCTO);
		query.setParameter(1, code);

		return query.getResultList() == null || query.getResultList().isEmpty() ? null
    			: (List<Invoice>) query.getResultList();        
    }
}
