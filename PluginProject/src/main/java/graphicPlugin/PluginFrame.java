package graphicPlugin;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import plugin.Plugin;
import plugin.PluginFilter;
import plugin.FileEvent;
import plugin.FileListener;
import plugin.FileChecker;

/**
 * 
 * @author Burg Quentin - Menit Alan - Omietanski Alexia
 * 
 * Create the graphical part for the plugin project
 *
 */
public class PluginFrame extends JFrame implements ActionListener, FileListener{
	
	private JTextArea textArea = new JTextArea();
	private JScrollPane scroll = new JScrollPane(textArea);
	private JFileChooser fileChooser = new JFileChooser();
	
	private JMenuBar menuBar = new JMenuBar();
	private JMenu file = new JMenu("File");
	private JMenu tools = new JMenu("Tools");
	private JMenu help = new JMenu("Help");
	
	private JMenuItem newFile = new JMenuItem("New");
	private JMenuItem open = new JMenuItem("Open");
	private JMenuItem exit = new JMenuItem("Exit");
	
	private List<Plugin> plugins;
	private List<JMenuItem> pluginsButtons;

	/**
	 * Constructor for the PluginFrame class
	 */
	public PluginFrame(){
		this.setLocation(400,100);
	    this.setTitle("Plugin Project");
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setSize(600, 600);
	    
	    this.getContentPane().add(scroll, BorderLayout.CENTER);
	    
	    newFile.addActionListener(this);
	    this.file.add(newFile);
	    open.addActionListener(this);
		this.file.add(open);
		this.file.addSeparator();
		exit.addActionListener(this);
		this.file.add(exit);
		
		this.menuBar.add(file);
		this.menuBar.add(tools);
		this.menuBar.add(help);
		this.setJMenuBar(menuBar);
		
		this.plugins = new ArrayList<Plugin>();
		this.pluginsButtons = new ArrayList<JMenuItem>();
		
		this.addPluginAtBeginning();
		
	    this.setVisible(true);
	}
	
	
	public void addPluginAtBeginning(){
		List<String> namesOfFiles = FileChecker.getKnownFilesNamesAtBeginning();
		for (String file : namesOfFiles){
			this.fileAdded(new FileEvent(file));
		}
	}
	
	
	/**
	 * Define which action for the different events
	 * @param event an ActionEvent that define which action we have to do
	 */
	public void actionPerformed(ActionEvent event){
		if (event.getSource().equals(open)){
			int returnVal = fileChooser.showOpenDialog(PluginFrame.this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();
				this.textArea.setText(this.readFile(file.toString()));
			}
		}
		if (event.getSource().equals(newFile)){
			this.textArea.setText("");
		}
		
		if(event.getSource().equals(exit)){
			System.exit(0);
		}
		
		for (Plugin plugin : plugins){
			for(JMenuItem item : pluginsButtons){
				int k = 0;
				if(event.getSource().equals(item)){
					this.textArea.setText(plugin.transform(this.textArea.getText()));
				}
				else if (event.getSource().equals(help.getItem(k))){
					JOptionPane.showMessageDialog(this,plugin.helpMessage());
				}
				k++;
			}
		}
	}
	
	/**
	 * Read an input file and return the string which correspond
	 * to the content of the file
	 * @param file the pathname of the file we want to read
	 * @return the content of the file
	 */
    public String readFile(String file)
    {
        String lines = "";
        String line;
        try
        {
           BufferedReader reader = new BufferedReader(new FileReader(file));
           while((line = reader.readLine()) != null)
                lines += line+"\n";
        }
        catch(Exception e)
        {
           lines = "Reading fail : "+e.getMessage();
        }  
        return lines;
    }
    
    public Plugin getPluginFromEvent(FileEvent event) {
        String name = event.getFileName();
        name = "plugins."+name.split(".class")[0];
        try {
            Class pluginClass = Class.forName(name);
            Plugin plugin = (Plugin)pluginClass.newInstance();
            return plugin;
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        catch (InstantiationException e) {
            throw new RuntimeException(e);
        }
        catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void fileAdded(FileEvent event){
    	Plugin plugin = this.getPluginFromEvent(event);
    	this.plugins.add(plugin);
    	JMenuItem itemTools = new JMenuItem(event.getFileName().split(".class")[0]);
    	JMenuItem itemHelp = new JMenuItem(event.getFileName().split(".class")[0]);
    	itemTools.addActionListener(this);
    	itemHelp.addActionListener(this);
    	this.pluginsButtons.add(itemTools);
    	this.pluginsButtons.add(itemHelp);
    	this.tools.add(itemTools);
    	this.help.add(itemHelp);
    }
    
    
    public void fileRemoved(FileEvent event){
    	for(int i=0; i<this.tools.getItemCount();i++){
    		if(tools.getItem(i).getText().equals(event.getFileName().split(".class")[0])){
    			tools.remove(i);
    			help.remove(i);
    		}
    	}
    	for(Plugin plugin : plugins){
    		if(event.getFileName().split(".class")[0].equals(plugin.toString())){
    			plugins.remove(plugin);
    		}
    	}
    	for(JMenuItem item : pluginsButtons){
    		if(event.getFileName().split(".class")[0].equals(item.getText())){
    			pluginsButtons.remove(item);
    		}
    	}	
    }

}
