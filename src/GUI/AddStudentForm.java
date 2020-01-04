package GUI;
import java.util.Date;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class AddStudentForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField_FName;
	private JTextField textField_LName;
	private JTextField textField_Phone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudentForm frame = new AddStudentForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @return 
	 */
	student std = new student();
	public  AddStudentForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 665);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 224, 208));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
		);
		panel.setLayout(null);
		
		JLabel lblNewStudent = new JLabel("New Student");
		lblNewStudent.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewStudent.setBounds(194, 38, 195, 40);
		panel.add(lblNewStudent);
		
		JLabel lblFirstStudent = new JLabel("First Name:");
		lblFirstStudent.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFirstStudent.setBounds(44, 125, 84, 14);
		panel.add(lblFirstStudent);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLastName.setBounds(44, 174, 84, 14);
		panel.add(lblLastName);
		
		JLabel lblSex = new JLabel("Sex:");
		lblSex.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSex.setBounds(92, 221, 36, 14);
		panel.add(lblSex);
		
		JLabel lblBirhdate = new JLabel("BirthDate:");
		lblBirhdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBirhdate.setBounds(44, 274, 84, 14);
		panel.add(lblBirhdate);
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPhone.setBounds(79, 321, 49, 14);
		panel.add(lblPhone);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAddress.setBounds(67, 369, 61, 14);
		panel.add(lblAddress);
		
		textField_FName = new JTextField();
		textField_FName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_FName.setBounds(148, 122, 284, 20);
		panel.add(textField_FName);
		textField_FName.setColumns(10);
		
		textField_LName = new JTextField();
		textField_LName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_LName.setColumns(10);
		textField_LName.setBounds(148, 171, 284, 20);
		panel.add(textField_LName);
		
		textField_Phone = new JTextField();
		textField_Phone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar())) {
					e.consume();
				}
			}
		});
		textField_Phone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		textField_Phone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_Phone.setColumns(10);
		textField_Phone.setBounds(148, 318, 284, 20);
		panel.add(textField_Phone);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBounds(148, 219, 61, 23);
		panel.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBounds(222, 219, 76, 23);
		panel.add(rdbtnFemale);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(148, 274, 284, 20);
		panel.add(dateChooser);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(148, 366, 284, 84);
		panel.add(textArea);
		
		
		
		
		JButton btnAddStudent = new JButton("Add");
		btnAddStudent.setIcon(new ImageIcon(AddStudentForm.class.getResource("/images/icons8-add-50.png")));
		btnAddStudent.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAddStudent.addActionListener(new ActionListener() {
			 public boolean verifText() {
					
					if(textField_FName.getText().equals("") ||  textField_LName.getText().equals("") || textField_Phone.getText().equals("") || textArea.getText().equals("") || dateChooser.getDate() == null) {
						JOptionPane.showMessageDialog(null, "One or More Empty Field");
						return false;
					}else if 
						(dateChooser.getDate().compareTo(new Date()) > 0) {
						JOptionPane.showMessageDialog(null, "No Student From The Future Are Allowed");
						return false;
					}
					
					else {
						return true;
					
						
					}
					}
				
			 public void actionPerformed(ActionEvent e) {
				 String fname = textField_FName.getText();
				 String lname = textField_LName.getText();
				 String phone = textField_Phone.getText();
				 String address = textArea.getText();
				 String  sex = "Male";
				 if(rdbtnFemale.isSelected()) {
					 sex = "Female";
				 }
				 
				 if(verifText()) {
					 SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
					 String bdate = dateFormat.format(dateChooser.getDate());
					 student  std = new student();
						std.insertStudent('i', 1, fname, lname, sex, bdate, phone, address);
						MainFrame.lblStdCount.setText("Students Count = "+Integer.toString(MyFunction.CountData("public.student")));
						try {
							managaStudentsForm.table.setModel(new DefaultTableModel(null,new Object[] {"First Name","Last Name","Sex","Phone","Address","Id","BirthDate"}));
							std.fillStudentJtable(managaStudentsForm.table,"");
						}catch(Exception ex) {
							
							System.out.println(ex.getMessage());
						}
						
						
						
				 }
				 
			
				 
			}
		});
		btnAddStudent.setBounds(308, 484, 124, 47);
		panel.add(btnAddStudent);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setIcon(new ImageIcon(AddStudentForm.class.getResource("/images/icons8-close-window-50.png")));
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancel.setBounds(146, 484, 137, 47);
		panel.add(btnCancel);
		contentPane.setLayout(gl_contentPane);
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnMale);
		bg.add(rdbtnFemale);
		rdbtnMale.setSelected(true);
		
	}
}
