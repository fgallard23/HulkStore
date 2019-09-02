/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package todo1.hulk.store.session;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;

/**
 *
 * @author Prime faces org
 */
public class ShowcaseExceptionHandlerFactory extends ExceptionHandlerFactory {

	private final ExceptionHandlerFactory base;

	public ShowcaseExceptionHandlerFactory(ExceptionHandlerFactory base) {
		this.base = base;
	}

	@Override
	public ExceptionHandler getExceptionHandler() {
		// return new ShowcaseExceptionHandler(base.getExceptionHandler());
		ExceptionHandler result = base.getExceptionHandler();
		result = new ShowcaseExceptionHandler(result);
		return result;
	}

}
