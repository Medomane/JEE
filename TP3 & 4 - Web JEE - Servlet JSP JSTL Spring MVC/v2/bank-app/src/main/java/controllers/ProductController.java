package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.Controller;

public class ProductController extends Controller {

	public Object List(HttpServletRequest request,HttpServletResponse response) throws Exception {
		return "products.jsp";
	}

}
