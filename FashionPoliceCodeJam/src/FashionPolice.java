import java.util.*;

import javax.swing.JFrame;

import java.io.*;

public class FashionPolice
{
	public static void main(String[] args) {
		createAndShowGUI();
	}
	private static void createAndShowGUI() {
		JFrame frame = new JFrame("Fashion Police");
		frame.add(new FashionPanel());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,700);
		frame.setVisible(true);
	}
}
