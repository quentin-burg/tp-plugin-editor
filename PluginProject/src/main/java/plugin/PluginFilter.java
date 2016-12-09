package plugin;

import java.io.File;
import java.io.FilenameFilter;

public class PluginFilter implements FilenameFilter{

	File file;
	
	public boolean accept(File dir, String name){
		return name.endsWith(".class");
	}
	
	public Class uploadPlugin(String className) throws ClassNotFoundException{
		className = className.split(".class")[0];
		return Class.forName(className);
	}
	
}
