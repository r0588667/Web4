package domain.model;

import java.util.Map;

import org.json.JSONObject;

public class User {

	private String firstName,lastName;
	private String password;
	private byte[] salt = new byte[20];
	private String id;
	private String status;
	private int age;
	private FriendList friendlist;
	
	public User(String id,String firstName,String lastName,String password,int age){
		this.setId(id);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setStatus("Offline");
		this.generateSalt();
		this.setPassword(password);
		this.setAge(age);
		friendlist = new FriendList(this);
		
	}
	
	public int getAge(){
		return age;
	}
	public void setAge(int age){
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if(firstName.isEmpty() && firstName.equals("")){
			throw new DomainException("Invalid LastName");
		}
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if(lastName.isEmpty() && lastName.equals("")){
			throw new DomainException("Invalid LastName");
		}
		this.lastName = lastName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		if(id == null || id.equals("")){
			throw new DomainException("Invalid ID");
		}
		this.id = id;
	}


	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public byte[] getSalt(){
		return salt;
	}
	public void generateSalt(){
		this.salt = Hasher.createSalt();
	}
	public String getPassword() {
		return password;
	}
	
	public boolean isCorrectPassword(String password) {
		if(password.isEmpty()){
			throw new IllegalArgumentException("No password given");
		}
		String hasher = Hasher.hashString(password, this.getSalt());
		return getPassword().equals(hasher);
	}

	public void setAlreadyHashed(String hashed){
		this.password = hashed;
	}
	public void setPassword(String password) {
		if(password.isEmpty()){
			throw new IllegalArgumentException("No password given");
		}
		try{
		
		this.password = Hasher.hashString(password,this.salt);
		}
		catch(Exception e){
			throw new RuntimeException(e.getMessage());
		}
	}
	public Map<String,User> getFriends(){
		return friendlist.getFriendList();
	}
	public void addFriend(User user){
		friendlist.addFriend(user);
	}
	@Override
	public String toString(){
		return getId()+","+getFirstName()+","+getStatus();
	}
	public JSONObject toJSON(){
		JSONObject result = new JSONObject();
		result.put("id", getId());
		result.put("status",getStatus());
		result.put("firstName", getFirstName());
		result.put("lastName", getLastName());
		result.put("age", getAge());
		return result;
		//return "{id:"+getId()+",status:"+getStatus()+",firstName:"+getFirstName()+",lastName:"+getLastName()+"}";
	}
}
