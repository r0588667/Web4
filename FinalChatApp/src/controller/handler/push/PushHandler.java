package controller.handler.push;
import org.json.*;
public abstract class PushHandler {

	public  abstract void handleRequest(JSONObject information);
}
