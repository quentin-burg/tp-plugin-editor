package plugin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;

// classe non finie

public class FileChecker {

	
	List<FileListener> listener = new ArrayList<FileListener>();
	Timer timer;
	List<String> knownFileNames;
	File dir;
	
	
	
	public FileChecker(File dirName, FilenameFilter filenameFilter){
		this.dir = dirName;
		ActionListener action = new ActionListenerTime();
		this.timer = new Timer(1000,action);
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
	
	public void fileFileRemoved (String fileName){
		for (FileListener fileListener : this.listener){
			fileListener.fileRemoved(new FileEvent(fileName));
		}
	}
	
	
	
	//demarre le timer
	public void start(){
		this.timer.start();
	}
	
	public void checkFiles(){
		for (String fileName : this.knownFileNames){
			this.fireFileAdded(fileName);
		}
	}
	
	
	//classe privée pour checker les fichiers toutes les secondes
	private class ActionListenerTime implements ActionListener{
		public void actionPerformed(ActionEvent event){
			checkFiles();
		}
	}
}
