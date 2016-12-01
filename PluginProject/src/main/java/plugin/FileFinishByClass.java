package plugin;

import java.io.File;
import java.io.FilenameFilter;

public class FileFinishByClass implements FilenameFilter{

	File file;
	
	public boolean accept(File dir, String name){
		return name.endsWith(".class");
	}
	
	
	
}
