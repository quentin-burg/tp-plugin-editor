package plugin;

public class FileListenerFinishByClass implements FileListener{

	
	public void fileAdded(FileEvent ev){
		System.out.println("nouveau : "+ev.getFileName() +"détecté");
	}
	
	public void fileRemoved(FileEvent ev){
		System.out.println(".class "+ev.getFileName() +" supprimé détecté");
	}
}
