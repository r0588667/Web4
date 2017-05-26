package domain.db;

import java.util.ArrayList;
import java.util.List;

import domain.model.Comment;
import domain.model.Discussion;

public class DiscussionPage {

	private static List<Discussion> discussions;
	
	public DiscussionPage(){
		discussions = new ArrayList<Discussion>();
		Comment c = new Comment("David Barend", "Testingg");
		Discussion first = new Discussion(0,"AvondMaal","Ik heb vandaag spaghetti gegeten");
		first.addComment(c);
		discussions.add(first);
		discussions.add(new Discussion(1,"MiddagMaal","Ik heb vandaag spaghetti gegeten"));
		discussions.add(new Discussion(2,"OchtendMaal","Ik heb vandaag spaghetti gegeten"));
	}
	public  void addDiscussion(Discussion discussion){
		discussions.add(discussion);
	}
	public void removeDiscussion(Discussion discussion){
		discussions.remove(discussion);
	}
	public static List<Discussion> getDiscussions(){
		return discussions;
	}
}
