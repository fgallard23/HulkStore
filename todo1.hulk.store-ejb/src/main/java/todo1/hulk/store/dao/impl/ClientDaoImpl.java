package todo1.hulk.store.dao.impl;

import javax.persistence.Query;

import todo1.hulk.store.constant.Constant;
import todo1.hulk.store.dao.ClientDao;
import todo1.hulk.store.exception.DaoException;
import todo1.hulk.store.manager.GenericoDaoImpl;
import todo1.hulk.store.model.Client;

public class ClientDaoImpl extends GenericoDaoImpl<Client> implements ClientDao {

	@Override
	public Client obtenerByIdentificacion(String identificacion) throws DaoException {
		
		Query query = this.em.createNamedQuery(Constant.CLIENTE);
		query.setParameter(1, identificacion);
		return query.getResultList() == null || query.getResultList().isEmpty() ? null
			: (Client) query.getResultList().get(0);
	}
}
