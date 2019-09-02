package todo1.hulk.store.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpServletRequest;

/**
 * <b> [Ingresar aqui la descripcion de la clase] </b>
 * 
 * @author fgallard
 */
@SessionScoped
@ManagedBean
public class LoginControlador extends ControladorBase {

	/**
	 * Cierra la sesion del usuario logueado.
	 *
	 * @return direccionamiento a la pagina de login.
	 */
	public void cerrarSesion() {
		try {
			HttpServletRequest request = (HttpServletRequest) getExternalContext().getRequest();
			request.logout();
			request.getSession().invalidate();
			this.getExternalContext().redirect(this.getExternalContext().getRequestContextPath() + "/pages/login.jsf");
		} catch (Exception e) {
		}
	}
}
