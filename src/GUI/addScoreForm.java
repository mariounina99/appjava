package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class addScoreForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField_StudentId;
	private final JScrollPane scrollPane = new JScrollPane();
	private JTextField textField_Score;
	private JTable tableScore;
	public static JComboBox comboBoxCourse;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addScoreForm frame = new addScoreForm();
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
	student std = new student();
	score sc = new score();
	DefaultTableModel model;
	private JTextField textField_Description;
	public addScoreForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1175, 625);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.YELLOW);
		panel.setBounds(0, 0, 1152, 575);
		contentPane.add(panel);
		
		JLabel lblAddCourse = new JLabel("Add Score");
		lblAddCourse.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblAddCourse.setBackground(Color.WHITE);
		lblAddCourse.setBounds(434, 11, 207, 40);
		panel.add(lblAddCourse);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setIcon(new ImageIcon(addScoreForm.class.getResource("/images/icons8-close-window-50.png")));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancel.setBounds(39, 491, 137, 47);
		panel.add(btnCancel);
		
	
		
		JLabel lblCourseId = new JLabel("Course Id:");
		lblCourseId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCourseId.setBounds(26, 247, 76, 14);
		panel.add(lblCourseId);
		
		JLabel lblScore = new JLabel("Score:");
		lblScore.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblScore.setBounds(58, 297, 44, 14);
		panel.add(lblScore);
		
		textField_StudentId = new JTextField();
		textField_StudentId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_StudentId.setColumns(10);
		textField_StudentId.setBounds(112, 188, 216, 20);
		panel.add(textField_StudentId);
		
		JLabel lblStudentId = new JLabel(" Student Id:");
		lblStudentId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStudentId.setBounds(10, 191, 92, 14);
		panel.add(lblStudentId);
		scrollPane.setBounds(667, 96, 460, 442);
		panel.add(scrollPane);
		
		tableScore = new JTable();
		tableScore.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int rowIndex = tableScore.getSelectedRow();
			textField_StudentId.setText(tableScore.getValueAt(rowIndex, 0).toString());
			
			}
		});
		tableScore.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "First Name", "Last Name", "Sex", "BirthDate", "Phone", "Address"
			}
		));
		tableScore.getColumnModel().getColumn(3).setResizable(false);
		scrollPane.setViewportView(tableScore);
		
		textField_Score = new JTextField();
		textField_Score.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_Score.setColumns(10);
		textField_Score.setBounds(112, 294, 216, 20);
		panel.add(textField_Score);
		
		 JComboBox  comboBoxCourse = new JComboBox();
		comboBoxCourse.setBounds(112, 245, 217, 22);
		panel.add(comboBoxCourse);
		c.fillCourseCombo(comboBoxCourse);
		std.fillStudentJtable(tableScore, "");
		HideColumn(6);
		HideColumn(5);
		HideColumn(4);
		HideColumn(3);
		model = (DefaultTableModel)tableScore.getModel();
		tableScore.setRowHeight(40);
		tableScore.setShowGrid(true);
		tableScore.setGridColor(Color.yellow);
		tableScore.setSelectionBackground(Color.red);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDescription.setBounds(10, 347, 92, 17);
		panel.add(lblDescription);
		
		textField_Description = new JTextField();
		textField_Description.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_Description.setColumns(10);
		textField_Description.setBounds(112, 345, 216, 20);
		panel.add(textField_Description);
		
		JButton buttonAddScore = new JButton("Add");
		buttonAddScore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int stdId = Integer.valueOf(textField_StudentId.getText());
				int crsId = c.getCourseId(comboBoxCourse.getSelectedItem().toString());
				double scr = Double.valueOf(textField_Score.getText());
				sc.insertStudent('i', stdId, crsId,scr, textField_Description.getText());
				
				try {
					editDeleteScore.tableScore1.setModel(new DefaultTableModel(null,new Object[] {"Student Id","Course Id","Score","Description"}));
					sc.fillScoreJtable(editDeleteScore.tableScore1);
				}catch(Exception ex) {
					System.out.println(ex.getMessage());
				}
				
				
				
			}
		});
		buttonAddScore.setIcon(new ImageIcon(addScoreForm.class.getResource("/images/icons8-add-50.png")));
		buttonAddScore.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonAddScore.setBounds(226, 491, 124, 47);
		panel.add(buttonAddScore);
	}
	private void HideColumn(int colIndex) {
		TableColumn col = tableScore.getColumnModel().getColumn(colIndex);
		col.setMaxWidth(0);
		col.setMinWidth(0);
		col.setPreferredWidth(0);
	}
}
