package todo1.hulk.store.dao.impl;

import todo1.hulk.store.constant.Constant;
import todo1.hulk.store.dao.ProductsDao;
import todo1.hulk.store.exception.DaoException;
import todo1.hulk.store.manager.GenericoDaoImpl;
import todo1.hulk.store.model.Products;

import java.util.List;
import javax.persistence.Query;

public class ProductsDaoImpl extends GenericoDaoImpl<Products> implements ProductsDao {

    @SuppressWarnings("unchecked")
	public List<Products> obtenerProductos(String code) throws DaoException {
    	
		Query query = this.em.createNamedQuery(Constant.OBTENER_PRODUCTO);
		query.setParameter(1, code);

		return query.getResultList() == null || query.getResultList().isEmpty() ? null
    			: (List<Products>) query.getResultList();        
    }
}
