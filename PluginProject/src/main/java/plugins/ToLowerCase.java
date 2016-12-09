package plugins;

import plugin.Plugin;

public class ToLowerCase implements Plugin{

	
	public ToLowerCase(){
	}
	
	
	public String transform(String text){
		return text.toLowerCase();
	}
	
	public String getLabel(){
		return "toLowerCase";
	}
	
	public String helpMessage(){
		return "text to lower case";
	}
	
}