package controller.handler.polling;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import domain.model.User;
import domain.service.UserService;

public class CheckStatus extends PollingHandler {

	public CheckStatus(UserService service) {
		super(service);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handelRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			Collection<User> users = this.getModel().getUsers().values();
			JSONArray array = new JSONArray();
			for(User u : users){
				JSONObject obj = new JSONObject(u.toJSON());
				array.put(obj);
			}
			response.getWriter().write(array.toString());
		
	}

}
