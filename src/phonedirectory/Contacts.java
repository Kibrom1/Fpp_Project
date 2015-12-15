package phonedirectory;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.AbstractListModel;

public class Contacts extends JFrame {
	
	public Contacts() {
		JPanel contentpane = new JPanel();
		setVisible(true);
		setBounds(50, 100, 300, 200);
	}
	
	JButton btnNew = new JButton("Click me");
	
	public static void main(String[] args){
		new Contacts();
	}

}
