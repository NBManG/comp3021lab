package base;

import java.util.ArrayList;

public class Folder {
	private ArrayList<Note> notes;
	private String name;
	
	public Folder(String name) {
		this.name = name;
		notes = new ArrayList<Note>();
				
	}
	
	public void addNote (Note note) {
		notes.add(note);		
	}
	
	public String getName () {
		return name;
	}
	
	public ArrayList<Note> getNotes() {
		return notes;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Folder other = (Folder) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		int nText = 0;
		int nImage = 0;
		
		for (int i = 0;i < notes.size();++i) {
			if (notes.get(i) instanceof TextNote)
				nText++;
			else
				nImage++;
			
		}
		return name + ":" + nText + ":" + nImage;
	}
	
	
}
