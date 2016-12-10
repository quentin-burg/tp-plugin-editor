package plugin;

import org.junit.Before;

import java.io.File;

public abstract class EditClassTest {
	File directory;
	String nameFileClass;
	
	/**
	 * This test method initialize the directory and the name file
	 */
	@Before
	public void before(){
		this.directory = new File("./extensions");
		this.nameFileClass = "ToUpperCase.class";
	}
	
}
