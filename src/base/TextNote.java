package base;


public class TextNote extends Note{
	
	private String content;
	
	public TextNote(String title) {
		// TODO Auto-generated constructor stub
		super(title);
	}
	public TextNote(String title, String content) {
		// TODO Auto-generated constructor stub
		super(title);
		this.content = content;
		
	}
	
	//override contains function
	public boolean contain (String s) {
		String lowerTitle = this.getTitle().toLowerCase();
		String lowerContent = this.content.toLowerCase();
		
		if (lowerTitle.contains(s) || lowerContent.contains(s))
			return true;
		else
			return false;
	}
	

}
