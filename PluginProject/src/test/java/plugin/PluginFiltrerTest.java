package plugin;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import plugin.PluginFilter;

public class PluginFiltrerTest extends EditClassTest{
	PluginFilter pluginFilter;
	
	@Before
	public void before(){
		super.before();
		this.pluginFilter = new PluginFilter();
	}
	
	@Test
	public void acceptTrueTest(){	
		assertTrue(this.pluginFilter.accept(this.directory, this.nameFileClass));	
	}
	
	@Test
	public void acceptFalseTest(){	
		assertFalse(this.pluginFilter.accept(this.directory, "annexe.txt"));	
	}
	
	@Test(expected = ClassNotFoundException.class)
	public void uploadPluginNotThrwosExceptionTest() throws ClassNotFoundException{
		assertSame(this.pluginFilter.uploadPlugin(this.nameFileClass), this.pluginFilter.uploadPlugin(this.nameFileClass));
	}
	
	@Test(expected = ClassNotFoundException.class)
	public void uploadPluginThrowsException() throws ClassNotFoundException{
		assertSame(this.pluginFilter.uploadPlugin("AnnexeBis.class"), this.pluginFilter.uploadPlugin(this.nameFileClass));
	}
	
}
