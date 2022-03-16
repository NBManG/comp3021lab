package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class TextNote extends Note{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	
	public TextNote(File f) {
		super(f.getName());
		this.content = getTextFromFile(f.getAbsolutePath());
		}
	
	private String getTextFromFile(String absolutePath) {
		String result = "";
		// TODO
		try (FileInputStream fis = new FileInputStream(absolutePath);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);)
		{
			result += br.readLine();
			
			
		}
		catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
		return result;
		
	}
	
	public void exportTextToFile(String pathFolder) {
		//TODO 
		if (pathFolder == "")
			pathFolder = ".";
		
		File file = new File( pathFolder + File.separator + this.getTitle().replaceAll(" ", "_") + ".txt");
		// TODO
		try (FileWriter fw = new FileWriter(file);
				BufferedWriter bf = new BufferedWriter(fw);)
				
			{
				bf.write(content);
				
				
			}
			catch (FileNotFoundException ex) {
				ex.printStackTrace();
			}
			catch (IOException ex) {
				ex.printStackTrace();
			}
		
		}
}
