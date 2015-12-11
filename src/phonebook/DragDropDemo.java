package phonebook;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.Color;


public class DragDropDemo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DragDropDemo frame = new DragDropDemo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DragDropDemo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("View All");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(63, 159, 109, 61);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						namelist frame = new namelist();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(268, 159, 109, 61);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						searchname frame = new searchname();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			
			}
		});
		contentPane.add(btnNewButton_1);
		
		JTextArea txtrMyPhoneBook = new JTextArea();
		txtrMyPhoneBook.setEditable(false);
		txtrMyPhoneBook.setFont(new Font("Monotype Corsiva", Font.PLAIN, 58));
		txtrMyPhoneBook.setBackground(Color.LIGHT_GRAY);
		txtrMyPhoneBook.setText("My Phone Book");
		txtrMyPhoneBook.setBounds(44, 43, 350, 78);
		contentPane.add(txtrMyPhoneBook);
	}
}
