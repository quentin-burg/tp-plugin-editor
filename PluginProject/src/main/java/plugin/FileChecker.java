package plugin;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

//classe non finie!

public class FileChecker {

	
	List<FileListener> listener = new ArrayList<FileListener>();
	
	
	public FileChecker(FilenameFilter filenameFilter){
		
	}
	
	
	public void addListener(FileListener fileListener){
		this.listener.add(fileListener);
	}
	
	public void removeListener(FileListener fileListener){
		this.listener.remove(fileListener);
	}
	
	public void fireFileAdded(File name){
		
	}
	
}
