package plugin;

import java.io.File;

public class FileEvent {
	
	File file;
	
	public FileEvent(String file){
		this.file = new File(file);
	}
	
	public String getFileName(){
		return this.file.toString();
	}
}
