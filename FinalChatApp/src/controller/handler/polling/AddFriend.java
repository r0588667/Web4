package controller.handler.polling;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.service.UserService;

public class AddFriend extends PollingHandler {

	public AddFriend(UserService service) {
		super(service);
	
	}

	@Override
	public void handelRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
			String friendID = request.getParameter("id");
			String currentUserID = request.getParameter("myid");
			getModel().getUser(currentUserID).addFriend(getModel().getUser(friendID));
			getModel().getUser(friendID).addFriend(getModel().getUser(currentUserID));
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}

}
