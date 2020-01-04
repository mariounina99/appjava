package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class editDeleteScore extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldStudent;
	private JTextField textField_Score;
	private JTextField textField_Desc;
	private JTextField textField_Course;
	public static JTable tableScore1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					editDeleteScore frame = new editDeleteScore();
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
	score sc = new score();
	DefaultTableModel model;
	public editDeleteScore() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 984, 651);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.YELLOW);
		panel.setBounds(0, 0, 973, 612);
		contentPane.add(panel);
		
		JLabel lblEditDelete = new JLabel("Edit / Delete Score");
		lblEditDelete.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblEditDelete.setBackground(Color.WHITE);
		lblEditDelete.setBounds(297, 11, 356, 40);
		panel.add(lblEditDelete);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int sid = Integer.valueOf(textFieldStudent.getText());
				int	cid =Integer.valueOf(textField_Course.getText());
				sc.deleteStudent('d', sid, cid, null, null);
				tableScore1.setModel(new DefaultTableModel(null, new Object[]{"Student Id", "Course Id", "Score","Description"}));
				sc.fillScoreJtable(tableScore1);
			}
			
		});
		btnRemove.setIcon(new ImageIcon(editDeleteScore.class.getResource("/images/icons8-close-window-50.png")));
		btnRemove.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRemove.setBounds(10, 490, 135, 47);
		panel.add(btnRemove);
		
		JLabel label_1 = new JLabel("Course Id:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(26, 247, 76, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Score:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_2.setBounds(58, 297, 44, 14);
		panel.add(label_2);
		
		textFieldStudent = new JTextField();
		textFieldStudent.setEditable(false);
		textFieldStudent.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldStudent.setColumns(10);
		textFieldStudent.setBounds(112, 188, 216, 20);
		panel.add(textFieldStudent);
		
		JLabel label_3 = new JLabel(" Student Id:");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_3.setBounds(10, 191, 92, 14);
		panel.add(label_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(458, 95, 481, 442);
		panel.add(scrollPane);
		
		tableScore1 = new JTable();
		tableScore1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int rowIndex = tableScore1.getSelectedRow();
				textFieldStudent.setText(tableScore1.getValueAt(rowIndex, 0).toString());
				textField_Course.setText(tableScore1.getValueAt(rowIndex, 1).toString());
				textField_Score.setText(tableScore1.getValueAt(rowIndex, 2).toString());
				textField_Desc.setText(tableScore1.getValueAt(rowIndex, 3).toString());
			}
		});
		tableScore1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Student Id", "Course Id", "Score", "Description"
			}
		));
		scrollPane.setViewportView(tableScore1);
		
		textField_Score = new JTextField();
		textField_Score.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_Score.setColumns(10);
		textField_Score.setBounds(112, 294, 216, 20);
		panel.add(textField_Score);
		
		JLabel label_4 = new JLabel("Description:");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_4.setBounds(10, 347, 92, 17);
		panel.add(label_4);
		
		textField_Desc = new JTextField();
		textField_Desc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_Desc.setColumns(10);
		textField_Desc.setBounds(112, 345, 216, 20);
		panel.add(textField_Desc);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sid = Integer.valueOf(textFieldStudent.getText());
				int	cid =Integer.valueOf(textField_Course.getText());
				double scr = Double.valueOf(textField_Score.getText());
				String ds = textField_Desc.getText();
				sc.updateStudent('u', sid, cid, scr, ds);
				tableScore1.setModel(new DefaultTableModel(null, new Object[]{"Student Id", "Course Id", "Score","Description"}));
				sc.fillScoreJtable(tableScore1);
			}
		});
		btnEdit.setIcon(new ImageIcon(editDeleteScore.class.getResource("/images/icons8-edit-50.png")));
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEdit.setBounds(166, 490, 124, 47);
		panel.add(btnEdit);
		
		textField_Course = new JTextField();
		textField_Course.setEditable(false);
		textField_Course.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_Course.setColumns(10);
		textField_Course.setBounds(112, 246, 216, 20);
		panel.add(textField_Course);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addScoreForm AddScf = new addScoreForm();
				AddScf.setVisible(true);
			
				AddScf.setLocationRelativeTo(null);
				AddScf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnAdd.setIcon(new ImageIcon(editDeleteScore.class.getResource("/images/icons8-add-50.png")));
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAdd.setBounds(309, 490, 124, 47);
		panel.add(btnAdd);
		sc.fillScoreJtable(tableScore1);
		tableScore1.setRowHeight(40);
		tableScore1.setShowGrid(true);
		tableScore1.setGridColor(Color.BLACK);
		tableScore1.setSelectionBackground(Color.yellow);
	}
}
