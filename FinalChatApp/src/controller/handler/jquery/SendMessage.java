package controller.handler.jquery;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.handler.jquery.Conversation;
import controller.handler.jquery.Message;
import controller.handler.polling.PollingHandler;
import domain.service.UserService;

public class SendMessage extends PollingHandler {

	public SendMessage(UserService service) {
		super(service);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handelRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sender = request.getParameter("sender");
		String receiver = request.getParameter("receiver");
		String message = request.getParameter("message");
		Message m = new Message(sender, receiver, message);
		Conversation.addMessage(m);
		
	}
	

	
}
