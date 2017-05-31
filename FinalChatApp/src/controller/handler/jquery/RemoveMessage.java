package controller.handler.jquery;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.handler.polling.PollingHandler;
import domain.service.UserService;

public class RemoveMessage extends PollingHandler{

	public RemoveMessage(UserService service) {
		super(service);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handelRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String receiver = request.getParameter("receiver");
		Conversation.clearMessagesForReceiver(receiver);
		
		
	}

}
