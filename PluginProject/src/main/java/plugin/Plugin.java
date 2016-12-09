package plugin;


/**
 * This interface implements Plugin
 * @author Alan Menit - Alexia Omietanski - Quentin Burg
 */
public interface Plugin {
	
	public String transform(String s) ;
	public String getLabel() ;
	public String helpMessage() ;
	
}
