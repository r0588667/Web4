package controller.handler.jquery;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import controller.handler.polling.PollingHandler;
import domain.service.UserService;

public class StartChat extends PollingHandler{

	public StartChat(UserService service) {
		super(service);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handelRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String myid = request.getParameter("myid");
		String chatmate = request.getParameter("chatmate");
		JSONObject result = new JSONObject();
		result.put("starter", myid);
		result.put("receiver",chatmate);
		if(result.isNull("starter")){
		response.getWriter().write("");
		}
		else {
			response.getWriter().write(result.toString());
		}
	}
	

}
