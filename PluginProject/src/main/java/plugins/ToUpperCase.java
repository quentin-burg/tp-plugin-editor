package plugins;

import plugin.Plugin;

public class ToUpperCase implements Plugin{

	
	public ToUpperCase(){
		
	}
	
	
	public String transform(String text){
		return text.toUpperCase();
	}
	
	public String getLabel(){
		return "toUpperCase";
	}
	
	public String helpMessage(){
		return "text to upper case";
	}
	
}
