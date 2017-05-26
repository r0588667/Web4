package domain.model;

public class Comment {

	private String name,text;

	public Comment(String name,String text){
		this.setName(name);
		this.setText(text);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(name.equals("") || name.isEmpty() || name.length() > 60){
			throw new DomainException("Ongeldige Naam");
		}
		this.name = name;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		if(text.equals("") || text.isEmpty()){
			throw new DomainException("Ongeldige Text");
		}
		this.text = text;
	}
	
}
