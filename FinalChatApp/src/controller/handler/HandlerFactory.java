package controller.handler;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import domain.service.UserService;

public class HandlerFactory {

	private Map<String,RequestHandler> handlers;
	
	public HandlerFactory(Properties properties, UserService service){
		handlers = new HashMap<>();
		for(Object key : properties.keySet()){
			RequestHandler handler = null;
			String handlerName = properties.getProperty((String) key);
			try{
				Constructor c = Class.forName(handlerName).getConstructor(UserService.class);
				handler  = (RequestHandler) c.newInstance(service);
				handler.setModel(service);
				handlers.put((String) key,handler);
			} catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public RequestHandler getHandler(String key){
		return handlers.get(key);
	}
}
