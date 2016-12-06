package plugin;

import java.io.File;
import java.io.FilenameFilter;

public class PluginMain {

	public static void main(String[] args) {
		FilenameFilter filter = new FileFinishByClass();
		FileChecker check = new FileChecker(new File("/home/l3/burg/Documents/S5/COO/Donjon"),filter);
		check.start();
		while(true);
	}

}
