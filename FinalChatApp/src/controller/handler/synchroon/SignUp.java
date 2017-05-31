package controller.handler.synchroon;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.model.User;
import domain.service.UserService;

public class SignUp extends SynchroonRequestHandler {

	public SignUp(UserService service) {
		super(service);
	}

	@Override
	public void handelRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
		String id = request.getParameter("id");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String password = request.getParameter("password");
		int age = Integer.parseInt(request.getParameter("age"));
		User user = new User(id, firstName, lastName, password,age);
		getModel().addUser(user);
		setDestination("index.jsp");
		}
		catch(Exception e){
			getErrors().clear();
			setDestination("signUp.jsp");
			request.setAttribute("errors", getErrors());
		}
		finally {
			RequestDispatcher view = request.getRequestDispatcher(getDestination());
			view.forward(request, response);
		}
	}

}
