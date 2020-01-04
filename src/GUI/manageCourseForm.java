package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class manageCourseForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Label;
	private final JScrollPane scrollPane = new JScrollPane();
	public static JTable tableTab;
	private JTextField textField_Id;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					manageCourseForm frame = new manageCourseForm();
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
	course c = new course();
	public manageCourseForm() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1158, 574);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(0, 0, 1142, 535);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblManageCourse = new JLabel("Manage Course");
		lblManageCourse.setBounds(414, 11, 284, 40);
		lblManageCourse.setOpaque(true);
		lblManageCourse.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblManageCourse.setBackground(Color.WHITE);
		panel.add(lblManageCourse);
		
		textField_Label = new JTextField();
		textField_Label.setBounds(96, 244, 216, 20);
		textField_Label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_Label.setColumns(10);
		panel.add(textField_Label);
		
		JSpinner spinnerH = new JSpinner();
		spinnerH.setBounds(96, 297, 67, 24);
		spinnerH.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(spinnerH);
		
		JButton buttonRemove = new JButton("Remove");
		buttonRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!textField_Id.getText().equals("")) {
					
					int id = Integer.valueOf(textField_Id.getText());
					c.deleteStudent('d',id, null, null);
					manageCourseForm.tableTab.setModel(new DefaultTableModel(null,new Object[] {"Id","Label","Hours"}));
					c.fillCourseJtable(manageCourseForm.tableTab);
					textField_Id.setText("");
					textField_Label.setText("");
					spinnerH.setValue(0);
				}
			}
		});
		buttonRemove.setIcon(new ImageIcon(manageCourseForm.class.getResource("/images/icons8-close-window-50.png")));
		buttonRemove.setBounds(10, 427, 137, 47);
		buttonRemove.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(buttonRemove);
		
		JButton button_add = new JButton("Add");
		button_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCourseForm Addcf = new addCourseForm();
				Addcf.setVisible(true);
			
				Addcf.setLocationRelativeTo(null);
				Addcf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		button_add.setIcon(new ImageIcon(manageCourseForm.class.getResource("/images/icons8-add-50.png")));
		button_add.setBounds(306, 427, 124, 47);
		button_add.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(button_add);
		scrollPane.setBounds(455, 92, 677, 432);
		panel.add(scrollPane);
		
		tableTab = new JTable();
		tableTab.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = tableTab.getSelectedRow();
				textField_Id.setText(tableTab.getValueAt(index, 0).toString());
				textField_Label.setText(tableTab.getValueAt(index, 1).toString());
				spinnerH.setValue(Integer.valueOf(tableTab.getValueAt(index, 2).toString()));
			}
		});
		tableTab.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Label", "Hours"
			}
		));
		scrollPane.setViewportView(tableTab);
		
		JLabel label_label = new JLabel("Label:");
		label_label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_label.setBounds(44, 247, 42, 14);
		panel.add(label_label);
		
		JLabel label_Hours = new JLabel("Hours:");
		label_Hours.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_Hours.setBounds(39, 297, 47, 14);
		panel.add(label_Hours);
		
		textField_Id = new JTextField();
		textField_Id.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_Id.setColumns(10);
		textField_Id.setBounds(96, 188, 216, 20);
		panel.add(textField_Id);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblId.setBounds(62, 191, 21, 14);
		panel.add(lblId);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setIcon(new ImageIcon(manageCourseForm.class.getResource("/images/icons8-edit-50.png")));
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					int id = Integer.valueOf(textField_Id.getText());
					String label = textField_Label.getText();
					int hours  = Integer.valueOf(spinnerH.getValue().toString());
					c.updateStudent('u',id, label, hours);
					manageCourseForm.tableTab.setModel(new DefaultTableModel(null,new Object[] {"Id","Label","Hours"}));
					c.fillCourseJtable(manageCourseForm.tableTab);
					//JOptionPane.showMessageDialog(null, "Course Edited");
				}
		});
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEdit.setBounds(163, 427, 124, 47);
		panel.add(btnEdit);
		c.fillCourseJtable(tableTab);
		
		tableTab.setRowHeight(40);
		
		tableTab.setShowGrid(true);
		
		tableTab.setSelectionBackground(Color.yellow);
	}
	
}
