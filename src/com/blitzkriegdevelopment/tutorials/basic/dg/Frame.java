package com.blitzkriegdevelopment.tutorials.basic.dg;

import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Frame extends JFrame{
	
	Frame() {
		add(new Board());
		setTitle("GUI Example");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(820,240);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
}
