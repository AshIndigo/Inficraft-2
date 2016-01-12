package com.philindigo.inficraft;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.filechooser.FileFilter;

public class Test {

	private static JFrame frame = new JFrame();
	static JFileChooser filechooser = new JFileChooser();
	static FileReader fr;
	static PrintWriter pw;

	// Start the editor (No text based commands this time)
	// Phil dont mess with this
	public static void main(String[] args) {
		
		// Setup the initial window
		frame.setSize(new Dimension(500,400));
		frame.setVisible(true);
		frame.setDefaultCloseOperation(3);
		filechooser.setCurrentDirectory(new File(System.getProperty("user.home") + "/Documents"));
		// Setup text field
		final JTextArea textbox = new JTextArea();
		textbox.setLineWrap(true);
		frame.getContentPane().add(textbox);
		textbox.setSize(new Dimension(400,300));
		// Setup the toolbar
		JToolBar toolBar = new JToolBar();
		frame.getContentPane().add(toolBar, BorderLayout.NORTH);
		JButton b1 = new JButton("Load");
		toolBar.add(b1);
		JButton b2 = new JButton("Save");
		toolBar.add(b2);
		// Load button script
		b1.addActionListener(new ActionListener()
	    {
		      public void actionPerformed(ActionEvent e) {
		    	  
		    	  try {
		    	  filechooser.showOpenDialog(frame);
		    	  File file = filechooser.getSelectedFile();
				  fr = new FileReader(file);
			      BufferedReader br = new BufferedReader(fr);
			      StringBuilder b = new StringBuilder();
			      String line;
				  line = br.readLine();
				  while (line != null) {
					  b.append(line);
					  line = br.readLine();
				  }
				  textbox.setText(b.toString());
			    	  }
		      catch (Exception e1) {
		    	  e1.printStackTrace();
		      }
		      }
	    });
		// Save button script
		b2.addActionListener(new ActionListener()
	    {
		      public void actionPerformed(ActionEvent e) {
		    	 
		    	  filechooser.showSaveDialog(frame);
		    	  File file = filechooser.getSelectedFile();
		    	  try {
		    		pw = new PrintWriter(file);
			    	pw.println(textbox.getText());
			    	pw.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		      }
	    });
		
	}
}
