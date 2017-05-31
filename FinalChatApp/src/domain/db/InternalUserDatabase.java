package domain.db;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;

import domain.model.User;

public class InternalUserDatabase implements UserDatabase{

	private Map<String,User> users;
	
	public InternalUserDatabase(){
		users = new HashMap<>();
		User lw = new User("01", "Lennert", "Wieërs","abc",27);
		User db = new User("02","David","Barend","lol",33);
		User am = new User("03","Alisa","Mae","abc",13);
		User lj = new User("04","Leroy","Jenkins","abc",17);
		users.put(lw.getId(), lw);
		users.put(db.getId(),db);
		users.put(am.getId(), am);
		users.put(lj.getId(),lj);
	}
	
	public void addUser(User user){
		users.put(user.getId(),user);
	}
	public void removeUser(String id){
		users.remove(id);
	}
	public void updateUser(User user){
		users.put(user.getId(), user);
	}
	@Override
	public User getUser(String id) {
		return users.get(id);
	}
	@Override
	public Map<String,User> getUsers(){
		return users;
	}

	@Override
	public JSONArray getAllUsersAsJSONArray() {
		JSONArray result = new JSONArray();
		for(User u : users.values()){
			result.put(u.toJSON());
		}
		return result;
	}
}
