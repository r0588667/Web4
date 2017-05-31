package controller.handler.angular;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.handler.polling.PollingHandler;
import domain.service.UserService;

public class GetUsers extends PollingHandler {

	public GetUsers(UserService service) {
		super(service);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handelRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json");
		response.getWriter().write(getModel().getUsersAsJSONArray().toString());
		
	}

}
