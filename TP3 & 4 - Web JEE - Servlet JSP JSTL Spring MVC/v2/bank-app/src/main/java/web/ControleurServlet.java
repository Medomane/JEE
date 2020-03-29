package web;

import java.lang.reflect.Method;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;


@WebServlet(name="cs",urlPatterns = {"/controleur","*.do"})
public class ControleurServlet extends HttpServlet {

	private String pathViews ;
	private Controller controller ;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		pathViews = config.getInitParameter("pathViews");
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)  {
		try {
			String path = request.getServletPath();
			String pathName = path.substring(1,path.indexOf(".do"));
			String controllerName = pathName.split("/")[0],actionName = pathName.split("/")[1];
			
			Class<?> c = Class.forName("controllers."+controllerName+"Controller");
			controller = (Controller)c.newInstance();
			Method method = c.getMethod(actionName,HttpServletRequest.class,HttpServletResponse.class);
			Object o = method.invoke(controller, request,response);
			System.out.println("/"+pathViews+"/"+o);
			if(o instanceof String) request.getRequestDispatcher("/"+pathViews+"/"+o).forward(request, response);
			else {
				ObjectMapper om = new ObjectMapper();
				response.setContentType("application/json");
				om.writeValue(response.getOutputStream(), o);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		/*
		String[] paths = {"/products.do","/clients.do","/billing.do"};
		List<String> list = Arrays.asList(paths);
		if(list.contains(path)) request.getRequestDispatcher("views"+path.replace("do", "jsp")).forward(request, response);
		else response.sendError(HttpServletResponse.SC_NOT_FOUND);*/
	}
}
