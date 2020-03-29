package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.Controller;

public class BillingController extends Controller {

	@Override
	public Object execute(HttpServletRequest request,HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "billing.jsp";
	}

}
