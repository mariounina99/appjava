package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class managaStudentsForm extends JFrame {


	private JPanel contentPane;
	private JTextField textFieldFname;
	private JTextField textFieldLname;
	private JTextField textFieldPhone;
	private JTextField textField_id;
	 
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					managaStudentsForm frame = new managaStudentsForm();
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
	student std = new student();
	
	public  JScrollPane scrollPane = new JScrollPane();
	public static JTable table;
	
	private JTextField textFieldEnter;
	public managaStudentsForm() {
 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1267, 673);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 255));
		panel.setBounds(0, 0, 1251, 634);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblManageStudents = new JLabel("Manage Students");
		lblManageStudents.setBounds(419, 11, 350, 40);
		lblManageStudents.setFont(new Font("Tahoma", Font.BOLD, 36));
		panel.add(lblManageStudents);
		
		JLabel label_1 = new JLabel("First Name:");
		label_1.setBounds(10, 174, 84, 14);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Last Name:");
		label_2.setBounds(10, 222, 84, 14);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Sex:");
		label_3.setBounds(45, 269, 36, 14);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("BirthDate:");
		label_4.setBounds(10, 326, 84, 20);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("Phone:");
		label_5.setBounds(23, 382, 49, 14);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("Address:");
		label_6.setBounds(23, 440, 61, 14);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(label_6);
		
		textFieldFname = new JTextField();
		textFieldFname.setBounds(104, 171, 284, 20);
		textFieldFname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldFname.setColumns(10);
		panel.add(textFieldFname);
		
		textFieldLname = new JTextField();
		textFieldLname.setBounds(104, 219, 284, 20);
		textFieldLname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldLname.setColumns(10);
		panel.add(textFieldLname);
		
		textFieldPhone = new JTextField();
		textFieldPhone.setBounds(104, 379, 284, 20);
		textFieldPhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldPhone.setColumns(10);
		panel.add(textFieldPhone);
		
		JRadioButton radioButtonM = new JRadioButton("Male");
		radioButtonM.setBounds(105, 267, 61, 23);
		panel.add(radioButtonM);
		
		JRadioButton radioButtonF = new JRadioButton("Female");
		radioButtonF.setBounds(189, 267, 76, 23);
		panel.add(radioButtonF);
		
		JDateChooser dateChooser1 = new JDateChooser();
		dateChooser1.setBounds(104, 326, 284, 20);
		panel.add(dateChooser1);
		
		JTextArea textAreaAd = new JTextArea();
		textAreaAd.setBounds(104, 437, 284, 84);
		panel.add(textAreaAd);
		
		JButton button = new JButton("Add");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStudentForm AddSf = new AddStudentForm();
				AddSf.setVisible(true);
				AddSf.pack();
				AddSf.setLocationRelativeTo(null);
				AddSf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		button.setBounds(315, 544, 124, 47);
		button.setIcon(new ImageIcon(managaStudentsForm.class.getResource("/images/icons8-add-50.png")));
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(button);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setBounds(10, 544, 137, 47);
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				if(textField_id.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "No Student Selected");
				}else {
				int id = Integer.valueOf(textField_id.getText());
				std.deleteStudent('d',id,null, null, null,null, null,null);
				std.fillStudentJtable(table, "");
				table.setModel(new DefaultTableModel(null,new Object[] {"Id","First Name","Last Name","Sex","BirthDate","Phone","Address"}));
				std.fillStudentJtable(table, textFieldEnter.getText());
				MainFrame.lblStdCount.setText("Students Count = "+Integer.toString(MyFunction.CountData("public.student")));
				
				textField_id.setText("");
				textFieldFname.setText("");
				textFieldLname.setText("");
				textFieldPhone.setText("");
				textAreaAd.setText("");
				radioButtonF.setSelected(false);
				radioButtonM.setSelected(false);
				dateChooser1.setDate(null);
				}
			}
		});
		btnRemove.setIcon(new ImageIcon(managaStudentsForm.class.getResource("/images/icons8-close-window-50.png")));
		btnRemove.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(btnRemove);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(169, 544, 124, 47);
		btnEdit.addActionListener(new ActionListener() {
			 public boolean verifText() {
					
					if(textFieldFname.getText().equals("") ||  textFieldLname.getText().equals("") || textFieldPhone.getText().equals("") || textAreaAd.getText().equals("") || textField_id.getText().equals("") ||  dateChooser1.getDate() == null) {
						JOptionPane.showMessageDialog(null, "One or More Empty Field");
						return false;
					}else if 
						(dateChooser1.getDate().compareTo(new Date()) > 0) {
						JOptionPane.showMessageDialog(null, "No Student From The Future Are Allowed");
						return false;
					}
				
					else {
						return true;
					}
					}
			public void actionPerformed(ActionEvent e) {
				 String fname = textFieldFname.getText();
				 String lname = textFieldLname.getText();
				 String phone = textFieldPhone.getText();
				 String address = textAreaAd.getText();
				 int id = Integer.valueOf(textField_id.getText());
				 String  sex = "Male";
				 if(radioButtonF.isSelected()) {
					 sex = "Female";
					 }
//				 }else if(radioButtonM.isSelected()) {
//					 sex = "Male";
//				 }
				 
				 if(verifText()) {
					 SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
					 String bdate = dateFormat.format(dateChooser1.getDate());
					 student  std = new student();
						std.updateStudent('u',id,fname, lname, sex, bdate,phone, address);
						//MainFrame.lblStdCount.setText("Students Count = "+Integer.toString(MyFunction.CountData("public.student")));
						managaStudentsForm.table.setModel(new DefaultTableModel(null,new Object[] {"First Name","Last Name","Sex","Phone","Address","Id","BirthDate"}));
						std.fillStudentJtable(managaStudentsForm.table,"");
				 }
				 }
			}
		
		
			
			
		);
		
		btnEdit.setIcon(new ImageIcon(managaStudentsForm.class.getResource("/images/icons8-edit-50.png")));
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(btnEdit);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setBounds(59, 129, 29, 17);
		lblId.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblId);
		
		textField_id = new JTextField();
		textField_id.setEditable(false);
		textField_id.setBounds(104, 127, 150, 20);
		textField_id.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_id.setColumns(10);
		panel.add(textField_id);
		
		
		
		
		JLabel lblEnterValueTo = new JLabel("Enter Value To Search");
		lblEnterValueTo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEnterValueTo.setBounds(466, 91, 177, 17);
		panel.add(lblEnterValueTo);
		
		textFieldEnter = new JTextField();
		textFieldEnter.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				table.setModel(new DefaultTableModel(null,new Object[] {"Id","First Name","Last Name","Sex","BirthDate","Phone","Address"}));
				std.fillStudentJtable(table, textFieldEnter.getText());
			}
			@Override
			public void keyPressed(KeyEvent e) {
				table.setModel(new DefaultTableModel(null,new Object[] {"Id","First Name","Last Name","Sex","BirthDate","Phone","Address"}));
				std.fillStudentJtable(table, textFieldEnter.getText());
			}
			@Override
			public void keyReleased(KeyEvent e) {
				table.setModel(new DefaultTableModel(null,new Object[] {"Id","First Name","Last Name","Sex","BirthDate","Phone","Address"}));
				std.fillStudentJtable(table, textFieldEnter.getText());
			}
		});
		textFieldEnter.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldEnter.setColumns(10);
		textFieldEnter.setBounds(653, 91, 284, 20);
		panel.add(textFieldEnter);
		scrollPane.setBounds(449, 146, 792, 477);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setForeground(Color.GRAY);
		table.setRowHeight(40);
		table.setShowGrid(true);
		table.setGridColor(Color.yellow);
		table.setSelectionBackground(Color.WHITE);
		table.addMouseListener(new MouseAdapter() {
			int rowIndex;
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				 rowIndex = table.getSelectedRow();
				 radioButtonF.setSelected(false);
					radioButtonM.setSelected(false);
				
				if(model.getValueAt(rowIndex, 3).toString().equals("Male")) {
						
					radioButtonM.setSelected(true);
				
					}else {
						radioButtonF.setSelected(true);
					
					}
				textFieldFname.setText(model.getValueAt(rowIndex, 1).toString());
				textFieldLname.setText(model.getValueAt(rowIndex, 2).toString());
				textFieldPhone.setText(model.getValueAt(rowIndex, 5).toString());
				textAreaAd.setText(model.getValueAt(rowIndex, 6).toString());
				textField_id.setText(model.getValueAt(rowIndex, 0).toString());
				
				Date bdate;
				try {
					bdate = new SimpleDateFormat("dd-MM-yyyy").parse(model.getValueAt(rowIndex, 4).toString());
					dateChooser1.setDate(bdate);
					
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		table.addKeyListener(new KeyAdapter() {
			int rowIndex;
			public void keyReleased(KeyEvent e) {
				 rowIndex = table.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN)
				{
					textFieldFname.setText(model.getValueAt(rowIndex, 1).toString());
					textFieldLname.setText(model.getValueAt(rowIndex, 2).toString());
					textFieldPhone.setText(model.getValueAt(rowIndex, 5).toString());
					textAreaAd.setText(model.getValueAt(rowIndex, 6).toString());
					textField_id.setText(model.getValueAt(rowIndex, 0).toString());
					
					if(model.getValueAt(rowIndex, 3).toString().equals("Male")) {
						
						radioButtonM.setSelected(true);
						radioButtonF.setSelected(false);
						}else {
							radioButtonF.setSelected(true);
							radioButtonM.setSelected(false);
						}
					
					
					Date bdate;
					try {
						bdate = new SimpleDateFormat("dd-MM-yyyy").parse(model.getValueAt(rowIndex, 4).toString());
						dateChooser1.setDate(bdate);
						
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				" Id", "First Name", "Last Name", "Sex", "BirthDate", "Phone", "Address"
			}
		));
		std.fillStudentJtable(table, "");
		scrollPane.setViewportView(table);
		ButtonGroup bg = new ButtonGroup();
		bg.add(radioButtonM);
		bg.add(radioButtonF);
		
		
	}
}
