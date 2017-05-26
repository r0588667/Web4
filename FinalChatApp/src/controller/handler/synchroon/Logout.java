package controller.handler.synchroon;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.service.UserService;

public class Logout extends SynchroonRequestHandler {

	public Logout(UserService service) {
		super(service);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handelRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		String destination = "index.jsp";
		RequestDispatcher view = request.getRequestDispatcher(destination);
		view.forward(request, response);
		
	}

}
