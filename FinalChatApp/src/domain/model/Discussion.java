package domain.model;

import java.util.ArrayList;
import java.util.List;

public class Discussion {

	private int counter;
	private String title,text;
	private List<Comment> comments;
	
	public Discussion(){
		comments = new ArrayList<Comment>();
	}
	public Discussion(int counter,String title,String text){
		this.setCounter(counter);
		this.setTitle(title);
		this.setText(text);
		comments = new ArrayList<Comment>();
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	public void addComment(Comment comment){
		comments.add(comment);
	}
	public List<Comment> getComments(){
		return comments;
	}
	public int getCounter(){
		return counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}
}
