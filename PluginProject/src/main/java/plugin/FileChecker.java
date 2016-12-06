package plugin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.Timer;

// classe non finie

public class FileChecker implements ActionListener {

	
	List<FileListener> listener = new ArrayList<FileListener>();
	Timer timer;
	List<String> knownFileNames;
	File dir;
	FilenameFilter filenameFilter;
	
	
	
	public FileChecker(File dirName, FilenameFilter filenameFilterArg){
		this.dir = dirName;
		this.timer = new Timer(1000,this);
		this.filenameFilter = filenameFilterArg;
		this.updateKnownFileName();
		this.print();
	}
	
	public void updateKnownFileName() {
		this.knownFileNames = Arrays.asList(dir.list(filenameFilter));
	}
	
	
	public void addListener(FileListener fileListener){
		this.listener.add(fileListener);
	}
	
	public void removeListener(FileListener fileListener){
		this.listener.remove(fileListener);
	}
	
	public void fireFileAdded(String fileName){
		for (FileListener fileListener : this.listener){
			fileListener.fileAdded(new FileEvent(fileName));
		}
	}
	
	public void fireFileRemoved (String fileName){
		for (FileListener fileListener : this.listener){
			fileListener.fileRemoved(new FileEvent(fileName));
		}
	}
	
	public void checkDirectoryFileAdded(){
		List<String> tempList = new ArrayList<String>();
		tempList = Arrays.asList(dir.list(filenameFilter));
		for (String fileName : tempList){
			if (!this.knownFileNames.contains(fileName)){
				fireFileAdded(fileName);
			}
		}
	}
	
	public void checkDirectoryFileRemoved(){
		List<String> tempList = new ArrayList<String>();
		tempList = Arrays.asList(dir.list(filenameFilter));
		for(String fileName : this.knownFileNames){
			if(!tempList.contains(fileName)){
				fireFileRemoved(fileName);
			}
		}
	}
	
	public void print(){
		System.out.println(this.knownFileNames.toString());
	}
	
	//demarre le timer
	public void start(){
		this.timer.start();
	}
	
	public void checkFiles(){
		this.checkDirectoryFileAdded();
		this.checkDirectoryFileRemoved();
		this.updateKnownFileName();
		this.print();
	}


	public void actionPerformed(ActionEvent e) {
		this.checkFiles();
		
	}
	
	
}
