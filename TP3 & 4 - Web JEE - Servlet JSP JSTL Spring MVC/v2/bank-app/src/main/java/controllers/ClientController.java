package controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.Controller;

public class ClientController extends Controller {

	public Object index(HttpServletRequest request,HttpServletResponse response) {
		Map<String ,Object> data = new HashMap<String ,Object>();
		data.put("name","mohamed");
		data.put("email","mohamed@gmail.com");
		data.put("age",22);
		return data;
	}

}
