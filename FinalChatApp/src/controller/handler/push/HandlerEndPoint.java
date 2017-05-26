package controller.handler.push;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.json.JSONObject;

/**
 * Servlet implementation class HandlerEndPoint
 */
@ServerEndpoint("/HandlerEndPoint")
public class HandlerEndPoint {
	private static final Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());

    public HandlerEndPoint() {
        super();
    }
		@OnOpen
	    public void onOpen(Session session){
	        System.out.println(session.getId() + " has opened a connection"); 
	        sessions.add(session);
	    }
	    @OnClose
	    public void onClose(Session session){
	        System.out.println(session.getId()+" has ended the Connection");
	        sessions.remove(session);
	    }
		@OnMessage
		public void onMessage(String message, Session session){
		try{
			JSONObject obj = new JSONObject(message);
			String action = obj.getString("action");
			PushHandler request = PushHandlerFactory.handleAction(action);
			request.handleRequest(obj);
		    sendMessageToAll(message);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		}
		
	    private void sendMessageToAll(String message){
	        for(Session s : sessions){
	            try {
	                s.getBasicRemote().sendText(message);
	            } catch (IOException ex) {
	                ex.printStackTrace();
	            }
	        }
	    }
	}
