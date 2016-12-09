package plugin;

import java.io.File;


/**
 * @author Alan Menit - Alexia Omietanski - Quentin Burg
 * This class implements FileEvent class
 */


public class FileEvent {
	
	File file;
	
	/**
	 * The constructor of FileEvent's class
	 * @param file the name of the file
	 */
	public FileEvent(String file){
		this.file = new File(file);
	}
	
	/**
	 * Get the name of the file
	 * @return the name of the file
	 */
	public String getFileName(){
		return this.file.toString();
	}
}
