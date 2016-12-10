package plugin;

import org.junit.Before;
import org.junit.Test;

import graphicPlugin.PluginFrame;
import plugin.FileChecker;
import plugin.FileListener;
import plugin.PluginFilter;

import static org.junit.Assert.*;


import java.io.FilenameFilter;


public class FileCheckerTest extends EditClassTest{
	FileChecker filechecker;
	FilenameFilter filenameFilter;
	FileListener fileListener;
	
	@Before
	public void before(){
		super.before();
		this.filenameFilter = new PluginFilter();
		this.filechecker = new FileChecker(this.directory, this.filenameFilter);
		this.fileListener = new PluginFrame();
	}
	
	@Test
	public void updateKnowFileNameEqualsTest(){
		FileChecker fileCheckerBis = this.filechecker;
		
		assertEquals(fileCheckerBis.getKnownFileNames().size(), this.filechecker.getKnownFileNames().size());
		assertTrue(this.filechecker.getKnownFileNames().containsAll(fileCheckerBis.getKnownFileNames()));
	}
	
	
	@Test
	public void addListenerTest(){
		int expectedSize = this.filechecker.getListener().size();
		assertEquals(expectedSize, this.filechecker.getListener().size());
		
		this.filechecker.addListener(this.fileListener);
		
		assertEquals(expectedSize+1, this.filechecker.getListener().size());
		assertTrue(this.filechecker.getListener().contains(this.fileListener));
	}
	
	@Test
	public void removeListenerTest(){
		this.filechecker.addListener(this.fileListener);
		
		int expectedSize = this.filechecker.getListener().size();
		assertEquals(expectedSize, this.filechecker.getListener().size());
		
		this.filechecker.removeListener(this.fileListener);
		
		assertEquals(expectedSize-1, this.filechecker.getListener().size());
		assertFalse(this.filechecker.getListener().contains(this.fileListener));
	}
	
	
	
}
