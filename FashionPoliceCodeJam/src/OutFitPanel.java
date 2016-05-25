import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class OutFitPanel extends JPanel {

	ArrayList<Integer> arr;
	
	Vector <JLabel>  pVec, sVec,jVec;
	Vector <ImageIcon> pimgVec, simgVec, jimgVec;
	Vector <String> p_urlVec, s_urlVec, j_urlVec, 
					pnameVec, snameVec, jnameVec; //urlVec, name
	JLabel title;
	
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 1024, 70);
		g.setFont(new Font("Helvetica", Font.BOLD, 70));
		g.setColor(Color.magenta);
		g.drawString("Outfits you can wear", 150, 60);
		
	}
	
	//Constructor
	public OutFitPanel(ArrayList<Integer> ar){
		setBackground(Color.BLACK);
		setLayout(new FlowLayout(FlowLayout.CENTER));
		setPreferredSize(new Dimension(1024, 768));
		setMaximumSize(new Dimension(10000, 10000));
		
		arr = new ArrayList<Integer>();
		arr = ar;
		
		add(Box.createRigidArea(new Dimension(1024,70)));
		pictureRead();

		arrAssign();
		
		displayArr();
		revalidate();
	}
	
	/**
	 * Display ArrayList
	 */
	public void displayArr(){
		int counter = 0;
		System.out.println("=================");
		for(int i = 0; i < arr.size(); i++){
			if(counter == 3){ System.out.println(); counter = 0;}
			System.out.print(arr.get(i) + " ");
			counter++;
		}
	}
	
	/**
	 * Read in Images from Files
	 */
	private void pictureRead(){
		pVec = new Vector<JLabel>();
		sVec = new Vector<JLabel>();
		jVec = new Vector<JLabel>(); 
			//jVec is a Vector of JLabels, [0-9] = pant1-10, [10-19] = shirt1-10, [20-29] = jacket1-10
		p_urlVec = new Vector<String>();
		s_urlVec = new Vector<String>();
		j_urlVec = new Vector<String>();
			//urlVec contains eg. "pant1.png" - "pant10.png", "shirt1.png" - "shirt10.png", "jacket1.png" - "jacket10.png"
		pimgVec = new Vector<ImageIcon>();
		simgVec = new Vector<ImageIcon>();
		jimgVec = new Vector<ImageIcon>();
			//imgVec contains Image Icons to be added to the jVec
		pnameVec = new Vector<String>();
		snameVec = new Vector<String>();
		jnameVec = new Vector<String>();
		
		//img, url & nameVecs are all size 30
		//Initializing urlVec & nameVec
		for(int i = 1; i <= 10; i++){
			p_urlVec.add("pant" + Integer.toString(i) + ".png");
			pnameVec.add("pant" + Integer.toString(i));
		} for(int i = 1; i <= 10; i++){
			s_urlVec.add("shirts" + Integer.toString(i) + ".png");
			snameVec.add("shirts" + Integer.toString(i));
		} for(int i = 1; i <= 10; i++){
			j_urlVec.add("jackets" + Integer.toString(i) + ".png");
			jnameVec.add("jackets" + Integer.toString(i));
		}
		
		//Initializing imgVec & jLabel Vec
		
		for(int i = 0; i < 10; i++){
			pimgVec.add(new ImageIcon(p_urlVec.get(i)));
			pVec.add(new JLabel("", pimgVec.get(i), JLabel.CENTER));
		}
		for(int i = 0; i < 10; i++){
			simgVec.add(new ImageIcon(s_urlVec.get(i)));
			sVec.add(new JLabel("", simgVec.get(i), JLabel.CENTER));
		}	
		for(int i = 0; i < 10; i++){
			jimgVec.add(new ImageIcon(j_urlVec.get(i)));
			jVec.add(new JLabel("", jimgVec.get(i), JLabel.CENTER));
			
		}
		

		/*
		pant1 = new ImageIcon("pant1.png");
		pl1 = new JLabel("", pant1, JLabel.CENTER);
		*/
		System.out.println("ImageSource Vec size: " + pimgVec.size());
		System.out.println("URLSource Vec size: " + p_urlVec.size());
		System.out.println("pVec Vec size: " + pVec.size());
		System.out.println("sVec Vec size: " + sVec.size());
		System.out.println("jVec Vec size: " + jVec.size());
		

	}
	
	/**
	 * Tester function to display all of the loaded images. 
	 */
	public void displayAllClothing(){
		for(int i = 0; i < jVec.size(); i++){
			add(pVec.get(i));
			add(sVec.get(i));
			add(jVec.get(i));
		}
	}
	
	/**
	 * 
	 */
	public void arrAssign(){
		int counter = 0;
		for(int i = 0; i < arr.size(); i++){
			
			for(int j = 0; j < 10; j++){
				
				if(counter == 3)
					counter = 0;
				
				else if(arr.get(i) == j && counter == 0){
					add(Box.createRigidArea(new Dimension(300,5)));
					//Displaying pant2, shirt2, jacket 2 for some reason
					pVec.set(j, new JLabel("",pimgVec.get(j),JLabel.CENTER));
					add(pVec.get(j));
					break;
				}
				else if(arr.get(i) == j && counter == 1){
					//Program is trying to add the same 
					sVec.set(j, new JLabel("",simgVec.get(j),JLabel.CENTER));
					add(sVec.get(j));
					break;
				}
				else if(arr.get(i) == j && counter == 2){
					jVec.set(j, new JLabel("",jimgVec.get(j),JLabel.CENTER));
					add(jVec.get(j));
					add(Box.createRigidArea(new Dimension(300,5)));
					break;
				}
			}//nested
			counter++;
		}
		
	}//arrAssign
}
