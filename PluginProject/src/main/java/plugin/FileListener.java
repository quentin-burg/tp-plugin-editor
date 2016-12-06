package plugin;

public interface FileListener {

	
	public void fileAdded(FileEvent ev);
	
	public void fileRemoved(FileEvent ev);
}
