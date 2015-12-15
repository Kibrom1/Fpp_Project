package phonebook;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;

public class ContactList extends JFrame {

	private JPanel contentPane;
	Connection conn = null;
	Statement stmt = null;

	JList list;
	JButton btnReturn;
	JButton btnNew;
	ListModel lstmodel;

	public ContactList() throws FileNotFoundException {
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		conn = DBConnection.getConnection();
		try {
			setTitle("List of Contacts");
			setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);

			btnReturn = new JButton("Return");
			btnReturn.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnReturn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnReturn.setBounds(239, 208, 98, 32);
			contentPane.add(btnReturn);

			btnNew = new JButton("     New");
			btnNew.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnNew.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								ContactDetail frame = new ContactDetail();
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
			});
			btnNew.setBounds(107, 208, 107, 32);
			contentPane.add(btnNew);
			populateList();// { "Kibrom", "Haile", "Sahile" };
		} catch (Exception ex) {
			ex.getMessage();
		}

	}

	@SuppressWarnings("unchecked")
	public void populateList() throws SQLException {
		String[] nameList = null;
		String phoneNumber;
		String name;

		// ArrayList names = new ArrayList<>();
		try {
			DefaultListModel<String> model = new DefaultListModel<>();
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT name,phoneNumber,email,address FROM Contact order by name asc";
			ResultSet resultSet = stmt.executeQuery(sql);
			while (resultSet.next()) {
				String names = resultSet.getString("name");
				model.addElement(names);
			}
			list = new JList<String>(model);// list.setModel(model);
			list.setBounds(163, 67, 250, 164);
			list.setToolTipText("");
			list.setBounds(33, 11, 366, 164);
			contentPane.add(list);
			resultSet.close();

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			//conn.close();
		}
	}
}
