package controller.handler.synchroon;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.db.DiscussionPage;
import domain.service.UserService;

public class ToDiscussion extends SynchroonRequestHandler {

	private DiscussionPage dp;
	
	public ToDiscussion(UserService service) {
		super(service);
		dp = new DiscussionPage();
	}

	@Override
	public void handelRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		setDestination("discussion.jsp");
		request.setAttribute("discussions",dp.getDiscussions());
		RequestDispatcher view = request.getRequestDispatcher(getDestination());
		view.forward(request, response);
	}

}
