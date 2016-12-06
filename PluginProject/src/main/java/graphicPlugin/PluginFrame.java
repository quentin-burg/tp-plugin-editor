package graphicPlugin;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * 
 * @author Burg Quentin - Menit Alan - Omietanski Alexia
 * 
 * Create the graphical part for the plugin project
 *
 */
public class PluginFrame extends JFrame implements ActionListener{
	
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
	
	public PluginFrame(){
		this.setLocationRelativeTo(null);
	    this.setTitle("Plugin Project");
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setSize(400, 400);
	    
	    this.getContentPane().add(scroll, BorderLayout.CENTER);
	    
	    this.file.add(newFile);
	    open.addActionListener(this);
		this.file.add(open);
		this.file.addSeparator();
		exit.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent arg0) {
		        System.exit(0);
		      }
		});
		this.file.add(exit);
		
		this.menuBar.add(file);
		this.menuBar.add(tools);
		this.menuBar.add(help);
		this.setJMenuBar(menuBar);
		
	    this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		int returnVal = fileChooser.showOpenDialog(PluginFrame.this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            this.readFile(file.toString());
		}
	}
	
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
    
	public static void main(String[] args){
		PluginFrame frame = new PluginFrame();
	}
	

}
