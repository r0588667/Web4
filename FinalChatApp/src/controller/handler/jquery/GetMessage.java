package controller.handler.jquery;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import controller.handler.polling.PollingHandler;
import domain.service.UserService;

public class GetMessage extends PollingHandler {

	public GetMessage(UserService service) {
		super(service);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handelRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String myid = request.getParameter("myid");
			JSONArray result = Conversation.getAllMessages();
			if(result.length() == 0){
				response.getWriter().write("[]");
			}
			else {
				response.getWriter().write(result.toString());
				// --> Gooit Exception Conversation.clearMessagesForReceiver(myid);
			}
			
	}

	
}
