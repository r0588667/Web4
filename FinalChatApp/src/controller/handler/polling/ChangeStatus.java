package controller.handler.polling;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.model.User;
import domain.service.UserService;

public class ChangeStatus extends PollingHandler {

	public ChangeStatus(UserService service) {
		super(service);
	}

	@Override
	public void handelRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String status = request.getParameter("status");
		User user = getModel().getUser(request.getParameter("myid"));
		user.setStatus(status);
		getModel().updateUser(user);
		String stat = this.toJSON(status);
		response.getWriter().write(stat);
	}
	
}
