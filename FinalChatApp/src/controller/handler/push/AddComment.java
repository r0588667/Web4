package controller.handler.push;

import java.util.List;

import domain.db.DiscussionPage;
import domain.model.Comment;
import domain.model.Discussion;
import org.json.*;

public class AddComment extends PushHandler {

	@Override
	public void handleRequest(JSONObject information) {
		String commentor = information.getString("name");
		String comment = information.getString("text");
		int article = information.getInt("article");
		List<Discussion> discussions = DiscussionPage.getDiscussions();
		discussions.get(article).addComment(new Comment(commentor, comment));
	}
	

}
