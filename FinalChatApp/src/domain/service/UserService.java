package domain.service;

import java.util.Map;

import domain.db.InternalUserDatabase;
import domain.db.UserDatabase;
import domain.model.User;

public class UserService {

	private UserDatabase db;
	
	public UserService(){
		db = new InternalUserDatabase();
	}
	public void addUser(User user){
		db.addUser(user);
	}
	public void removeUser(String id){
		db.removeUser(id);
	}
	public User isCorrectPassword(String id,String password){
		if(db.getUser(id).isCorrectPassword(password)){
			return db.getUser(id);
		}
		else {
			throw new IllegalArgumentException("Invalid Login");
		}
	}
	public User getUser(String id){
		return db.getUser(id);
	}
	public void updateUser(User user){
		db.updateUser(user);
	}
	public Map<String,User> getUsers(){
		return db.getUsers();
	}
}
