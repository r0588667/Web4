package controller.handler.jquery;

import org.json.JSONObject;

public class Message {

	private String sender,receiver,message;
	
	public Message(String sender,String receiver,String message){
		this.setSender(sender);
		this.setReceiver(receiver);
		this.setMessage(message);
		
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public JSONObject toJSON(){
		JSONObject result = new JSONObject();
		result.put("sender", getSender());
		result.put("receiver",getReceiver());
		result.put("message",getMessage());
		return result;
	}
	
}
