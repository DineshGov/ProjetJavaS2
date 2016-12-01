/**
 * 
 */
package mmorpg;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * @author Dinesh
 *
 */
public class Fenetre extends JFrame{

	public Fenetre(String titre,int x,int y){
		super(titre);
		//this.initialise();
		this.setSize(x,y);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void initialise(){
		Container c= this.getContentPane();
		c.add(this.getPanelCentre(), BorderLayout.CENTER);	
	}
	
	public JPanel getPanelCentre() {
		JPanel jpn= new JPanel(new BoxLayout(jpn, Y_AXIS));
		
		return null;
	}

	public static void main(String[] args) {
		Fenetre fen= new Fenetre("RPG",700,500);
	}

		
}
