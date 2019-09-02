package todo1.hulk.store.constant;

public abstract class Constant {

	public static final String CLIENTE = "Select v From Client v Where v.code=?1"; 
	public static final String OBTENER_PRODUCTO = "SELECT p FROM Products p WHERE p.code=:code";
	public static final String OBTENER_FACTURA = "SELECT p FROM Invoice p WHERE p.code=:code";
	
}
