package plugin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.Timer;

/**
 * @author Alan Menit - Alexia Omietanski - Quentin Burg
 * This class implements a file checker 
 */

public class FileChecker implements ActionListener {

	
	private List<FileListener> listener = new ArrayList<FileListener>();
	private Timer timer;
	private List<String> knownFileNames;
	private File dir;
	private FilenameFilter filenameFilter;
	private static List<String> knownFilesNamesAtBeginning;
	
	/**
	 * The constructor of FileChecker's class
	 * @param dirName the name of directory where the plugins are
	 * @param filenameFilterArg the filter for the plugins
	 */
	public FileChecker(File dirName, FilenameFilter filenameFilterArg){
		this.dir = dirName;
		this.timer = new Timer(1000,this);
		this.filenameFilter = filenameFilterArg;
		this.updateKnownFileName();
		knownFilesNamesAtBeginning = this.knownFileNames;
		this.print();
	}
	
	/**
	 * Update the known files in directory (update the list of knownFileNames)
	 */
	public void updateKnownFileName() {
		this.knownFileNames = Arrays.asList(dir.list(filenameFilter));
	}
	
	/**
	 * Add a listener in the list.
	 * @param fileListener the listener we want to add
	 */
	public void addListener(FileListener fileListener){
		this.listener.add(fileListener);
	}
	
	
	public static List<String> getKnownFilesNamesAtBeginning(){
		return knownFilesNamesAtBeginning;
	}
	
	
	/**
	 * Remove a listener in the list
	 * @param fileListener the listener we want to remove
	 */
	public void removeListener(FileListener fileListener){
		this.listener.remove(fileListener);
	}
	
	/**
	 * Warns listeners that a file has been added
	 * @param fileName the name of the file
	 */
	public void fireFileAdded(String fileName){
		for (FileListener fileListener : this.listener){
			fileListener.fileAdded(new FileEvent(fileName));
		}
	}
	
	/**
	 * Warns listeners that a file has been removed
	 * @param fileName the name of the file
	 */
	public void fireFileRemoved (String fileName){
		for (FileListener fileListener : this.listener){
			fileListener.fileRemoved(new FileEvent(fileName));
		}
	}
	
	/**
	 * Check in the directory dir, if a file has been added
	 */
	public void checkDirectoryFileAdded(){
		List<String> tempList = new ArrayList<String>();
		tempList = Arrays.asList(dir.list(filenameFilter));
		for (String fileName : tempList){
			if (!this.knownFileNames.contains(fileName)){
				fireFileAdded(fileName);
			}
		}
	}
	
	/**
	 * Check in the directory dir, if a file has been removed
	 */
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
	
	
	/**
	 * Start the timer
	 */
	public void start(){
		this.timer.start();
	}
	
	
	/**
	 * Check in directory if files has been added or removed and update the list of known files
	 */
	public void checkFiles(){
		this.checkDirectoryFileAdded();
		this.checkDirectoryFileRemoved();
		this.updateKnownFileName();
		this.print();
	}
	

	/**
	 * Check directory every second (with the timer)
	 */
	public void actionPerformed(ActionEvent e) {
		this.checkFiles();
	}
	
	
}
