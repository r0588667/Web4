package controller.handler;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import domain.service.UserService;

public abstract class RequestHandler {

	private ArrayList<String> errors;
	private UserService service;
	
	public RequestHandler(UserService service){
		this.setModel(service);
		errors = new ArrayList<>();
		errors.clear();
	}
	
	public void setModel(UserService service){
		this.service = service;
	}
	public UserService getModel(){
		return service;
	}
	public ArrayList<String> getErrors(){
		return errors;
	}
	public abstract void handelRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException;
}
