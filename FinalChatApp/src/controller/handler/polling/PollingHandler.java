package controller.handler.polling;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import controller.handler.RequestHandler;
import domain.service.UserService;

public abstract class PollingHandler extends RequestHandler {

	
	public PollingHandler(UserService service) {
		super(service);
	}
	protected String toJSON (String status) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(status);
	}
	public abstract void handelRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException ;

}
