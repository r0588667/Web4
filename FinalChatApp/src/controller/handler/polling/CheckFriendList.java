package controller.handler.polling;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;

import domain.model.User;
import domain.service.UserService;

public class CheckFriendList extends PollingHandler {

	public CheckFriendList(UserService service) {
		super(service);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handelRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userID = request.getParameter("myid");
		JSONArray array = new JSONArray();

		Collection<User> users = this.getModel().getUser(userID).getFriends().values();
		if(users.size() == 0){
			response.getWriter().write("[]");
		}
		else {
		for(User u : users){
			JSONObject obj = new JSONObject(u.toJSON());
			array.put(obj);
		}
		response.getWriter().write(array.toString());
		}
	}
}
