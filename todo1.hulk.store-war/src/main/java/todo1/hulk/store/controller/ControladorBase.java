/*
 * Copyright 2017 Banco Internacional. 
 * Todos los derechos reservados.
 * Autor:		David Paucar
 * Objetivo:	[Ingresar aqui el nombre de la clase]
 * Fecha:		10 de mar. de 2017
 * Nro. Req:	[Ingresar aqui el numero de TFS del Requerimiento]
 * Version:		1.0
 */
package todo1.hulk.store.controller;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <b> Controlador base </b>
 * 
 * @author fgallard
 */
public class ControladorBase {

    /** The Constant BUNDLE_NAME. */
    private static final String BUNDLE_NAME = "todo1.hulk.store.config.application"; //$NON-NLS-1$

    private static final String BUNDLE_NAME_MENSAJE = "todo1.hulk.store.config.messages"; //$NON-NLS-1$

    /** The Constant RESOURCE_BUNDLE. */
    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

    private static final ResourceBundle RESOURCE_BUNDLE_MENSAJE = ResourceBundle.getBundle(BUNDLE_NAME_MENSAJE);

    /** The Constant SEPARADOR. */
    private static final String SEPARADOR = "&param";

    /**
     * Gets the string. Recupera la propiedad referente al key pasado
     * 
     * @param key
     *            the key
     * 
     * @return the string
     */
    public static String getString(String key) {
	try {
	    return RESOURCE_BUNDLE.getString(key);
	} catch (MissingResourceException e) {
	    return '!' + key + '!';
	}
    }

    /**
     * 
     * <b> Descripcion del metodo </b>
     * <p>
     * [Author: fgallard, Date: 17/11/2015]
     * </p>
     * 
     * @param key
     * @return
     */
    public static String getStringMensaje(String key) {
	try {
	    return RESOURCE_BUNDLE_MENSAJE.getString(key);
	} catch (MissingResourceException e) {
	    return '!' + key + '!';
	}
    }

    /**
     * Gets the string. Recupera la propiedad referente al key pasado
     * complmentada su perzonalizaci�n con los par�metros adicionales enviados.
     * 
     * @param key
     *            the key
     * @param parameters
     *            the parameters
     * 
     * @return the string
     */
    protected static String getString(String key, String... parameters) {
	try {
	    String message = "";
	    String[] partsMessage = RESOURCE_BUNDLE.getString(key).split(SEPARADOR);

	    for (String part : partsMessage) {
		try {
		    int indice = Integer.parseInt(part);

		    if (parameters.length > indice) {
			message = message.concat(parameters[indice]);
		    }
		} catch (NumberFormatException e) {
		    message = message.concat(part);
		}
	    }

	    return message;
	} catch (MissingResourceException e) {
	    return '!' + key + '!';
	}
    }

    /**
     * 
     * <b> Obtiene el http request </b>
     * <p>
     * [Author: fgallard, Date: 11/11/2015]
     * </p>
     * 
     * @return
     */
    protected HttpServletRequest getHttpRequest() {
	return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    }

    /**
     * 
     * <b> Descripcion del metodo </b>
     * <p>
     * [Author: fgallard, Date: 11/11/2015]
     * </p>
     * 
     * @return
     */
    protected HttpServletResponse getHttpResponse() {
	return (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
    }

    /**
     * 
     * <b> Descripcion del metodo </b>
     * <p>
     * [Author: fgallard, Date: 11/11/2015]
     * </p>
     * 
     * @return
     */
    protected HttpSession getHttpSession() {
	return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    }

    /**
     * 
     * <b> Descripcion del metodo </b>
     * <p>
     * [Author: fgallard, Date: 11/11/2015]
     * </p>
     * 
     * @return
     */
    protected ExternalContext getExternalContext() {
	return FacesContext.getCurrentInstance().getExternalContext();
    }

    /**
     * 
     * <b> Descripcion del metodo </b>
     * @return
     */
    protected FacesContext getFacesContext() {
	return FacesContext.getCurrentInstance();
    }

    /**
     * 
     * <b> Descripcion del metodo </b>
     * <p>
     * [Author: fgallard, Date: 11/11/2015]
     * </p>
     * 
     * @param summary
     * @param detail
     */
    protected void addErrorMessage(final String summary, final String detail) {
	FacesMessage errorMessage = new FacesMessage();
	errorMessage.setSummary(summary);
	errorMessage.setDetail(detail);
	errorMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
	FacesContext.getCurrentInstance().addMessage(null, errorMessage);
    }

    /**
     * 
     * <b> Descripcion del metodo </b>
     * <p>
     * [Author: fgallard, Date: 11/11/2015]
     * </p>
     * 
     * @param summary
     * @param detail
     */
    protected void addInfoMessage(final String summary, final String detail) {
	FacesMessage infoMessage = new FacesMessage();
	infoMessage.setSummary(summary);
	infoMessage.setDetail(detail);
	infoMessage.setSeverity(FacesMessage.SEVERITY_INFO);
	FacesContext.getCurrentInstance().addMessage(null, infoMessage);
    }

    /**
     * 
     * <b> Mensajes de advertenvia </b>
     * <p>
     * [Author: fgallard, Date: 11/11/2015]
     * </p>
     * 
     * @param summary
     * @param detail
     */
    protected void addWarningMessage(final String summary, final String detail) {
	FacesMessage warningMessage = new FacesMessage();
	warningMessage.setSummary(summary);
	warningMessage.setDetail(detail);
	warningMessage.setSeverity(FacesMessage.SEVERITY_WARN);
	FacesContext.getCurrentInstance().addMessage(null, warningMessage);
    }

    /**
     * Retorna la session http.
     *
     * @return session
     */
    public HttpSession getSession() {
	HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext()
		.getSession(Boolean.TRUE);
	return session;
    }

    /**
     * Set un atributo en la sesion.
     *
     * @param name
     *            - name
     * @param value
     *            value
     */
    public void setAttributeInSession(final String name, final Object value) {
	HttpSession session = getSession();
	session.setAttribute(name, value);
    }

    /**
     * Obtiene atributos de la sesion
     *
     * @param name
     *            - nombre del atributo
     * @return session.getAttribute(name)
     */
    public Object getAttributeInSession(String name) {
	HttpSession session = getSession();
	return session.getAttribute(name);
    }

    /**
     * 
     * <b> Obtien al ip del cliente</b>
     * 
     * @return
     */
    protected String obtenerIpCliente() {
	String remoteAddr = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest())
		.getRemoteAddr();
	return remoteAddr;
    }
}
