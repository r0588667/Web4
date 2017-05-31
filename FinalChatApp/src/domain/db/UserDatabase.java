package domain.db;

import java.util.Map;

import org.json.JSONArray;

import domain.model.User;

public interface UserDatabase {

	void addUser(User user);
	void removeUser(String id);
	User getUser(String id);
	void updateUser(User user); 
	Map<String,User> getUsers();
	JSONArray getAllUsersAsJSONArray();
}
