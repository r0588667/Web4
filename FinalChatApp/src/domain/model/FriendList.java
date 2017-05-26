package domain.model;

import java.util.HashMap;
import java.util.Map;

public class FriendList {

	private Map<String,User> friends;
	private User user;
	
	public FriendList(User user){
		friends = new HashMap<>();
		this.user = user;
	}
	
	public void addFriend(User user){
		friends.put(user.getId(), user);
	}
	public void deleteFriend(int id){
		friends.remove(id);
	}
	public Map<String,User> getFriendList(){
		return friends;
	}
}
