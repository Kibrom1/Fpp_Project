package phonebook;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;

public class ContactDetail extends JFrame {
	private final JLabel lblNewLabel = new JLabel("Name");
	private JTextField txtName;
	private JTextField txtPhoneNumber;
	private JTextField txtEmail;
	private JTextField txtAddress;
	private JPanel contentPane;
	// Database connectivity details
	Connection conn = null;
	Statement stmt = null;

	public ContactDetail() {
		setTitle("Adding Detail");
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));

		txtName = new JTextField();
		txtName.setColumns(10);

		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);

		txtAddress = new JTextField();
		txtAddress.setColumns(10);

		JButton btnReturn = new JButton("Return");
		btnReturn.setHorizontalAlignment(SwingConstants.RIGHT);
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnReturn.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							conn = DBConnection.getConnection();
							String name = txtName.getText();
							String insertSql = "delete FROM Contact where name = " + "(?) limit 1";
							PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(insertSql);

							preparedStmt.setString(1, name);

							if (preparedStmt.execute())
								JOptionPane.showMessageDialog(btnDelete, "Deleted Successfully");

							// ContactList frame = new ContactList();
							// frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							conn = DBConnection.getConnection();
							String name = txtName.getText();
							String phoneNumber = txtPhoneNumber.getText();
							String email = txtEmail.getText();
							String address = txtAddress.getText();
							String insertSql = "insert into Contact(name, phoneNumber,email,address)"
									+ "values(?, ?, ?, ?)";
							PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(insertSql);

							preparedStmt.setString(1, name);
							preparedStmt.setString(2, phoneNumber);
							preparedStmt.setString(3, email);
							preparedStmt.setString(4, address);

							if (preparedStmt.execute())
								JOptionPane.showMessageDialog(btnSave, "Registered Successfully");

							ContactList frame = new ContactList();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JButton btnSearch = new JButton("Search");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(44)
										.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 80,
												GroupLayout.PREFERRED_SIZE)
										.addGap(47).addComponent(txtName, GroupLayout.PREFERRED_SIZE, 188,
												GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(25)
								.addComponent(lblPhoneNumber, GroupLayout.PREFERRED_SIZE, 120,
										GroupLayout.PREFERRED_SIZE)
								.addGap(26).addComponent(txtPhoneNumber, GroupLayout.PREFERRED_SIZE, 188,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(
								gl_contentPane.createSequentialGroup().addGap(44)
										.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 53,
												GroupLayout.PREFERRED_SIZE)
										.addGap(74).addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 188,
												GroupLayout.PREFERRED_SIZE))
						.addGroup(
								gl_contentPane.createSequentialGroup().addGap(44)
										.addComponent(lblAddress, GroupLayout.PREFERRED_SIZE, 81,
												GroupLayout.PREFERRED_SIZE)
										.addGap(46).addComponent(txtAddress, GroupLayout.PREFERRED_SIZE, 188,
												GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(131,
								Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup().addGap(44)
						.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE).addGap(10)
						.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(btnSearch).addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
						.addComponent(btnReturn, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
						.addGap(39)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(36)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(4).addComponent(lblNewLabel,
										GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtName, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(2).addComponent(lblPhoneNumber,
								GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtPhoneNumber, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
				.addGap(15)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(lblEmail)
						.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
				.addGap(2)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(17).addComponent(lblAddress,
								GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtAddress, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
				.addGap(31)
				.addGroup(
						gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 38,
												GroupLayout.PREFERRED_SIZE)
								.addComponent(btnReturn, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSearch)))
						.addContainerGap(101, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}

	public void searchResult() {
		try {
			conn = DBConnection.getConnection(); // DriverManager.getConnection(url,
													// user, password);
			// String name = txtName.getText();
			String searchSql = "select id, name, email, address from Contact where name = '"
					+ "' order by name asc limit 1";
			stmt = conn.createStatement();
			ResultSet resultSet = stmt.executeQuery(searchSql);
			while (resultSet.next()) {
				txtName.setText(resultSet.getString("name"));
				txtPhoneNumber.setText(resultSet.getString("phonNumber"));
				txtEmail.setText(resultSet.getString("email"));
				txtAddress.setText(resultSet.getString("address"));
			}

			ContactDetail frames = new ContactDetail();
			frames.setVisible(true);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(txtAddress, "There is no contact with name: " + txtName.getText());
		}
	}
}
