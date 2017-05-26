package controller.handler.push;

public class PushHandlerFactory {

	
	public static PushHandler handleAction(String action){
		PushHandler result = null;
		if(action.equals("addComment")){
			result = new AddComment();
		}
		return result;
	}
}
