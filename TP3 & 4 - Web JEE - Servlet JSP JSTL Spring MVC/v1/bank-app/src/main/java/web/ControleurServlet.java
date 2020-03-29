package web;

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
			String controllerName = path.substring(1,path.indexOf(".do"))+"Controller";
			controller = (Controller)Class.forName("controllers."+controllerName).newInstance();
			Object o = controller.execute(request, response);
			if(o instanceof String) request.getRequestDispatcher(pathViews+"/"+o).forward(request, response);
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
