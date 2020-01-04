package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DataBase.MyConnection;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class LoginForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField_username;
	private JPasswordField passwordField;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm frame = new LoginForm();
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
	public LoginForm() {
		setLocationByPlatform(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 636, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLoginForm = new JLabel("Login Form");
		lblLoginForm.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblLoginForm.setBounds(243, 42, 145, 27);
		contentPane.add(lblLoginForm);
		
		textField_username = new JTextField();
		textField_username.setBounds(226, 117, 162, 20);
		contentPane.add(textField_username);
		textField_username.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsername.setBounds(97, 120, 76, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(97, 215, 76, 14);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(226, 214, 162, 20);
		contentPane.add(passwordField);
		
	
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCancel.setIcon(new ImageIcon(LoginForm.class.getResource("/images/icons8-close-window-50.png")));
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setBounds(123, 303, 145, 36);
		contentPane.add(btnCancel);
		
		JLabel lbl_U = new JLabel("*");
		lbl_U.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_U.setBounds(392, 104, 15, 14);
		contentPane.add(lbl_U);
		lbl_U.setVisible(false);
		
		JLabel lbl_P = new JLabel("*");
		lbl_P.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_P.setBounds(392, 201, 15, 14);
		contentPane.add(lbl_P);
		lbl_P.setVisible(false);
		
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setIcon(new ImageIcon(LoginForm.class.getResource("/images/icons8-add-50.png")));
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbl_U.setVisible(false);
				lbl_P.setVisible(false);
				if(textField_username.getText().equals("")) {
				
					lbl_U.setVisible(true);
				}  if(String.valueOf(passwordField.getPassword()).equals(""))
				{
					lbl_P.setVisible(true);
				}
				else {
					
					Connection con = MyConnection.getConnection();
					PreparedStatement ps;
					
					try {
						ps = con.prepareStatement("SELECT * FROM public.user WHERE username = ? AND password = ?");
						ps.setString(1, textField_username.getText());
						ps.setString(2, String.valueOf( passwordField.getPassword()));
						
						ResultSet rs = ps.executeQuery();
						
						if(rs.next())
						{
							MainFrame mf = new MainFrame();
							mf.setVisible(true);
							mf.setExtendedState(JFrame.MAXIMIZED_BOTH);
							MainFrame.lblWelcome.setText("Welcome<"+textField_username.getText()+">");
							MainFrame.lblStdCount.setText("Students Count = "+Integer.toString(MyFunction.CountData("public.student")));
							MainFrame.lblCoursesCount.setText("Courses Count = "+Integer.toString(MyFunction.CountData("public.course")));
						}else {
							JOptionPane.showMessageDialog(null, "Incorrectt Username Or Password", "Login Failed", 2);
						}
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				}
			
		});
		btnLogin.setBounds(352, 303, 136, 36);
		contentPane.add(btnLogin);
		this.setLocationRelativeTo(null);
	}
}
