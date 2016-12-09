package plugin;

import java.io.File;
import java.io.FilenameFilter;

public class PluginMain {

	public static void main(String[] args) {
		FilenameFilter filter = new FileFinishByClass();
		FileChecker check = new FileChecker(new File("./extensions"),filter);
		FileListenerFinishByClass fileListenerTemp = new FileListenerFinishByClass();
		check.addListener(fileListenerTemp);
		check.start();
		while(true);
	}

}
