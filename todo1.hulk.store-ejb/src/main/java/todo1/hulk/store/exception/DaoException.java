package todo1.hulk.store.exception;

/**
 *
 * @author fgallard
 */
public class DaoException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Constructor
     */
    public DaoException() {
    }

    /**
     * Constructor
     *
     * @param msg detalle del mensaje.
     */
    public DaoException(String msg) {
        super(msg);
    }
    
    /**
     * Constructor
     *
     * @param msg detalle del mensaje.
     */
    public DaoException(Exception ex) {
        super(ex);
    }

}
