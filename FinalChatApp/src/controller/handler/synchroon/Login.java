package controller.handler.synchroon;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.model.User;
import domain.service.UserService;

public class Login extends SynchroonRequestHandler {

	public Login(UserService service){
		super(service);
	}
	@Override
	public void handelRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User p = null;
		try{
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		p = getModel().isCorrectPassword(id, password);
		session.setAttribute("id",p.getId());
		session.setAttribute("firstName",p.getFirstName());
		session.setAttribute("lastName",p.getLastName());
		session.setAttribute("status",p.getStatus());
		session.setAttribute("friends", p.getFriends().values());
		setDestination("profile.jsp");
		}
		catch(Exception e){
			getErrors().clear();
			setDestination("index.jsp");
			getErrors().add(e.getMessage());
			request.setAttribute("errors", getErrors());
		}
		RequestDispatcher view = request.getRequestDispatcher(getDestination());
		view.forward(request, response);
		
	}
	
	
}
