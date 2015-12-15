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

public class PhoneBook extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PhoneBook frame = new PhoneBook();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PhoneBook() {
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("My phone book");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnViewAll = new JButton("View All");
		btnViewAll.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnViewAll.setBounds(183, 180, 109, 36);
		btnViewAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {

							// ContactList namelist = new ContactList();
							// namelist2.populateList();
							ContactList frame = new ContactList();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnViewAll);

		JTextArea txtrMyPhoneBook = new JTextArea();
		txtrMyPhoneBook.setEditable(false);
		txtrMyPhoneBook.setFont(new Font("Dialog", Font.PLAIN, 45));
		txtrMyPhoneBook.setBackground(Color.LIGHT_GRAY);
		txtrMyPhoneBook.setText("My Phone Book");
		txtrMyPhoneBook.setBounds(44, 43, 350, 53);
		contentPane.add(txtrMyPhoneBook);
	}
}
