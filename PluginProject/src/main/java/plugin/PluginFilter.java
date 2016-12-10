package plugin;

import java.io.File;
import java.io.FilenameFilter;

/**
 * @author PCAudreyQuentin
 * This class implements a filter for plugins
 */
public class PluginFilter implements FilenameFilter{

	File file;
	
	/**
	 * Return true if the file is accepted as a plugin, else return false
	 * @return true if the file is accepted as a plugin, else return false
	 */
	public boolean accept(File dir, String name){
		return name.endsWith(".class");
	}
	
	/**
	 * Upload the plugin
	 * @param className the name of the class
	 * @return an instance of class of plugin
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings("rawtypes")
	public Class uploadPlugin(String className) throws ClassNotFoundException{
		className = className.split(".class")[0];
		return Class.forName(className);
	}
	
}
