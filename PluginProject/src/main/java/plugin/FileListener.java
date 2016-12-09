package plugin;


/**
 * @author Alan Menit - Alexia Omietanski - Quentin Burg
 * This interface implements FileListener
 */
public interface FileListener {

	/**
	 * Do an action when a file has been added
	 * @param ev An event (file added)
	 */
	public void fileAdded(FileEvent ev);
	
	/**
	 * Do an action when a file has been removed
	 * @param ev An event (file removed)
	 */
	public void fileRemoved(FileEvent ev);
}
