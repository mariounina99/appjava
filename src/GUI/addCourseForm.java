package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;

public class addCourseForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField_CourseLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addCourseForm frame = new addCourseForm();
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
	public addCourseForm() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(0, 0, 554, 466);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAddCourse = new JLabel("Add Course");
		lblAddCourse.setBackground(Color.WHITE);
		lblAddCourse.setOpaque(true);
		lblAddCourse.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblAddCourse.setBounds(163, 11, 207, 40);
		panel.add(lblAddCourse);
		
		JLabel lblLabel = new JLabel("Label:");
		lblLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLabel.setBounds(72, 114, 42, 14);
		panel.add(lblLabel);
		
		textField_CourseLabel = new JTextField();
		textField_CourseLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_CourseLabel.setColumns(10);
		textField_CourseLabel.setBounds(124, 111, 284, 20);
		panel.add(textField_CourseLabel);
		
		JLabel lblHours = new JLabel("Hours:");
		lblHours.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHours.setBounds(72, 160, 47, 14);
		panel.add(lblHours);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, 0, 300, 1));
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinner.setBounds(124, 155, 67, 24);
		panel.add(spinner);
		
		JButton button_AddCourse = new JButton("Add");
		button_AddCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!c.isCourseExist(textField_CourseLabel.getText())) {
					String label = textField_CourseLabel.getText();
					int hours  = Integer.valueOf(spinner.getValue().toString());
					c.insertStudent('i',1, label, hours);
					MainFrame.lblCoursesCount.setText("Courses Count = "+Integer.toString(MyFunction.CountData("public.course")));
					
					try {
						manageCourseForm.tableTab.setModel(new DefaultTableModel(null,new Object[] {"Id","Label","Hours"}));
						c.fillCourseJtable(manageCourseForm.tableTab);
					}catch(Exception ex) {
						System.out.println(ex.getMessage());
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "Course Already Exists");
				}
				
			}
		});
		button_AddCourse.setIcon(new ImageIcon(addCourseForm.class.getResource("/images/icons8-add-50.png")));
		button_AddCourse.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_AddCourse.setBounds(284, 271, 124, 47);
		panel.add(button_AddCourse);
		
		JButton btnCancelCourse = new JButton("Cancel");
		btnCancelCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelCourse.setIcon(new ImageIcon(addCourseForm.class.getResource("/images/icons8-close-window-50.png")));
		btnCancelCourse.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancelCourse.setBounds(72, 271, 137, 47);
		panel.add(btnCancelCourse);
	}
}
