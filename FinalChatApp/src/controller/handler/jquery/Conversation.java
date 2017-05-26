package controller.handler.jquery;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;

public class Conversation {

	public static List<Message> messages = new ArrayList<Message>();
	
	public Conversation(){
	}
	
	public static void addMessage(Message m){
		messages.add(m);
	}
	public static void delete(Message m){
		messages.remove(m);
	}
	public static JSONArray getAllMessages(){
		JSONArray result = new JSONArray();
		for(Message m : messages){
			result.put(m.toJSON());
		}
		return result;
	}
	public static JSONArray getMessageForReceiver(String receiver){
		JSONArray result = new JSONArray();
		for(Message m : messages){
			if(m.getReceiver().equals(receiver)){
				result.put(m.toJSON());
			}
		}
		return result;
	}
	public static void clearMessagesForReceiver(String receiver){
		for(Message m: messages){
			if(m.getReceiver().equals(receiver)){
				messages.remove(m);
			}
		}
	}
}
