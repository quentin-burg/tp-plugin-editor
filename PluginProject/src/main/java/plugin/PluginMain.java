package plugin;

import java.io.File;
import java.io.FilenameFilter;

import graphicPlugin.PluginFrame;

public class PluginMain {

	public static void main(String[] args) {
		FilenameFilter filter = new PluginFilter();
		FileChecker check = new FileChecker(new File("./src/main/java/plugins"),filter);
		PluginFrame fileListenerTemp = new PluginFrame();
		check.addListener(fileListenerTemp);
		check.start();
		while(true);
	}

}
