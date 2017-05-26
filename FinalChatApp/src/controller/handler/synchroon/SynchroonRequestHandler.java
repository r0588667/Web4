package controller.handler.synchroon;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.handler.RequestHandler;
import domain.service.UserService;

public abstract class SynchroonRequestHandler extends RequestHandler {
	
	private String destination;
	
	public SynchroonRequestHandler(UserService service){
		super(service);
	}
	public String getDestination(){
		return destination;
	}
	public void setDestination(String destination){
		this.destination = destination;
	}
	public abstract void handelRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException ;
}
