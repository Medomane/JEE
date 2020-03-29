package web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Controller {

	public abstract Object execute(HttpServletRequest request,HttpServletResponse response) throws Exception;
	
}
