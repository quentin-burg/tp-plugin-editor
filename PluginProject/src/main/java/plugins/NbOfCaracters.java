package plugins;

import plugin.Plugin;

public class NbOfCaracters implements Plugin{
	
	public NbOfCaracters(){
	}
	
	
	public String transform(String text){
		return ""+text.length();
	}
	
	public String getLabel(){
		return "nbOfCaracters";
	}
	
	public String helpMessage(){
		return "number of caracters of the text";
	}

}
