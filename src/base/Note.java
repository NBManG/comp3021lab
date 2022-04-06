package base;

import java.util.Date;
import java.util.Objects;


public class Note implements Comparable<Note>,java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date date;
	private String title;
	
	public Note(String title) {
		this.title = title;
		date = new Date(System.currentTimeMillis());
		
	}
			

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		
		Note other = (Note) obj;
		return Objects.equals(title, other.title);
		
	}
	
	public String getTitle() {
		return title;
	}

	@Override
	public int compareTo(Note o) {
		// TODO Auto-generated method stub
		
		if (this.date.compareTo(o.date) > 0)
			return -1;
		else if (this.date.compareTo(o.date) < 0)
			return 1;
		else
			return 0;
	}
	public String toString() {
		return date.toString() + "\t" + title;
	}
	
	public boolean contain (String s) {
		String lowerTitle = this.getTitle().toLowerCase();
		
		if (lowerTitle.contains(s))
			return true;
		else
			return false;
	}

}




