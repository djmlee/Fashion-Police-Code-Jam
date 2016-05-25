import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class FashionPanel extends JPanel{

	//Member Variables
	JTextField pants,
			   shirts,
			   jackets,
			   days;
	
	JButton outfitsButton;

	String readPants,
		   readShirts,
		   readJackets,
		   readDays;
	
	int amt_Pants,
		amt_Shirts,
		amt_Jackets,
		amt_Days;
	
	ArrayList<Integer> arr;
	
	//Default constructor
	public FashionPanel(){
		setBackground(Color.GRAY);
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		setPreferredSize(new Dimension(500, 500));
		setMaximumSize(new Dimension(10000, 500));

		pants = new JTextField(1);
		shirts = new JTextField(1);
		jackets = new JTextField(1);
		days = new JTextField(1);
		
		outfitsButton = new JButton("Set Outfit");

		
		/* Create User Input Tool */

			add(Box.createRigidArea(new Dimension(0,250)));
			add(new JLabel("Pants(1-9)"));
			add(pants); 
			add(new JLabel("Shirts(1-9)"));
			add(shirts); 
			add(new JLabel("Jackets(1-9)"));
			add(jackets);
			add(new JLabel("Days You Can Wear the Same Outfit"));
			add(days);
	
			add(outfitsButton);
			
			//Prep the button for ActionEvents
			ButtonListener listener = new ButtonListener();
			outfitsButton.addActionListener(listener);

	}//Constructor
	
	
	/**
	 * Handle Button Press
	 * @author dinsdalelee
	 *
	 */
	private class ButtonListener implements ActionListener{
	
		@Override
		public void actionPerformed(ActionEvent e){
				if(e.getSource().equals(outfitsButton)){
					textRead();
					System.out.println("Pants: " + amt_Pants);
						System.out.println("Shirts: " + amt_Shirts);
					System.out.println("Jackets: " + amt_Jackets);
					System.out.println("Days: " + amt_Days);
					
					oFrame textFrame = new oFrame();
					
					oFrame oframe = new oFrame();
					oframe.initialize();
					textFrame.smallerFrame();
				}
		}
			
	}
	

	/**
	 * Accept User Input from JTextfield
	 * Parse into Int for program use
	 * @author dinsdalelee
	 */
	private void textRead(){
		//Get Text from JTextField
		readPants = new String(pants.getText());
		readShirts = new String(shirts.getText());
		readJackets = new String(jackets.getText());
		readDays = new String(days.getText());
		
		//Parse into Int for use
		amt_Pants = Integer.parseInt(readPants);
		amt_Shirts = Integer.parseInt(readShirts);
		amt_Jackets = Integer.parseInt(readJackets);
		amt_Days = Integer.parseInt(readDays);
		
		System.out.println("====================");
		calculate();
		System.out.println("====================");
	}
	
	/**
	 * Draw Graphics
	 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setFont(new Font("Helvetica", Font.BOLD, 70));
		g.setColor(Color.magenta);
		g.drawString("Fashion Police", 5, 70);
	}
	
	
	/**
	 * Method to calculate amount of days you can get away with
	 * without getting caught by the Fashion Police
	 * @author dinsdalelee
	 */
	private void calculate(){
		
		arr = new ArrayList<Integer>();
         if (amt_Days >= amt_Jackets)
         {
             System.out.println(amt_Pants * amt_Shirts * amt_Jackets);
             for (int i = 0; i < amt_Pants; i++)
                 for (int j = 0; j < amt_Shirts; j++)
                     for (int k = 0; k < amt_Jackets; k++){
                         System.out.println((i + 1) + " " + (j + 1) + " " + (k + 1));
                         readArr(i,j,k);
                     }
         }
         else if (amt_Days >= amt_Shirts)
         {
             System.out.println(amt_Pants * amt_Shirts * amt_Days);
             for (int i = 0; i < amt_Pants; i++)
                 for (int j = 0; j < amt_Shirts; j++)
                     for (int k = 0; k < amt_Days; k++){
                         System.out.println((i + 1) + " " + (j + 1) + " " + (k + 1));
                         readArr(i,j,k);
                     }
         }
         else
         {
             System.out.println(amt_Days * amt_Pants * amt_Shirts);
             for (int i = 0; i < amt_Shirts; i++)
                 for (int j = 0; j < amt_Pants; j++)
                     for (int k = 0; k < amt_Days; k++){
                         System.out.println((j + 1) + " " + ((i + j + k) % amt_Shirts + 1) + " " + (i + 1));
                         readArr(i,j,k);
                     }
         }
         

	}//calculate

   /**
    * Read into arr
    * @param i
    * @param j
    * @param k
    */
    private void readArr(int i,int j, int k){
   	 	arr.add(i + 1);
   	 	arr.add(j + 1);
   	 	arr.add(k + 1);
    }
    
    /**
     * Second Window Frame
     * @author dinsdalelee
     *
     */
	public class oFrame extends JFrame{
			
		JFrame outfit_frame;
		OutFitPanel oPanel;
		JLabel output;
		JPanel panel;
		
		public oFrame(){}
		public void initialize(){
			outfit_frame = new JFrame("Outfits");
			outfit_frame.setSize(1024,768);
			outfit_frame.setMaximumSize(new Dimension(1024,10000));
			outfit_frame.setBackground(Color.GRAY);
			outfit_frame.setVisible(true);
			outfit_frame.setResizable(false);
			oPanel = new OutFitPanel(arr);
			JScrollPane scroll = new JScrollPane(oPanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
					JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			outfit_frame.add(scroll);
			
		}
		private void smallerFrame(){
			outfit_frame = new JFrame("Outfit Grid");
			panel = new JPanel(new GridLayout(0,1));
			JScrollPane scroll = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
					JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			
			outfit_frame.setSize(250,250);
			outfit_frame.setMaximumSize(new Dimension(1024,10000));
			outfit_frame.setBackground(Color.GRAY);
			outfit_frame.setVisible(true);
			outfit_frame.setResizable(false);

			outfit_frame.add(scroll);
			
			int counter = 0;
			output = new JLabel("OUTFIT COMBINATIONS");
			panel.add(output);

			for(int i = 0; i < arr.size(); i++){
				if(counter == 3)
				{
					counter = 0;
					output = new JLabel("<html> <br></br> </html>");
					panel.add(output);
				} 
				
				output = new JLabel(arr.get(i) + " ");
				panel.add(output);
				counter++;
				
				System.out.println ("====");
				System.out.println(arr.get(i) + " " + arr.get(i+1) + " " + arr.get(i+2));
			}
		}//smallFrame

	}
}
