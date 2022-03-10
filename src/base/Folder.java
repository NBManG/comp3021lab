package base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Folder implements Comparable<Folder>{
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

	@Override
	public int compareTo(Folder o) {
		// TODO Auto-generated method stub
		
		return this.name.compareTo(o.name);
	}
	
	public void sortNotes() {
		Collections.sort(notes);
	}
	
	public List<Note> searchNotes(String keywords) {
		ArrayList<Note> ls = new ArrayList<Note>();
		boolean test = false;
		String[] kwd = keywords.toLowerCase().split(" ");
				
		for (Note n:notes) {
	
			for (int i=1;i<kwd.length;i++) {
				if (i == kwd.length-1)
					test = n.contain(kwd[i]);
				
				if (!kwd[i].equals("or")) 
					test = n.contain(kwd[i-1]);
				
				else {
					test = (n.contain(kwd[i-1]) || n.contain(kwd[i+1]));
					i+=2;
					if (i == kwd.length-1) 
						test = n.contain(kwd[i]);
				}
				
				if (!test)
					break;					
			}
			
			if (test)
				ls.add(n);			
		}
		return ls;		
	}
	
}
