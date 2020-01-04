package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	
	public static JLabel lblWelcome;
	public static JLabel lblStdCount;
	public static JLabel lblCoursesCount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 862, 512);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("");
		setJMenuBar(menuBar);
		
		JMenu mnStudent = new JMenu("Student");
		mnStudent.setIcon(new ImageIcon(MainFrame.class.getResource("/images/icons8-manager-50.png")));
		menuBar.add(mnStudent);
		
		JMenuItem mntmAdd = new JMenuItem("Add");
		mntmAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStudentForm AddSf = new AddStudentForm();
				AddSf.setVisible(true);
				AddSf.pack();
				AddSf.setLocationRelativeTo(null);
				AddSf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		
		});
		mntmAdd.setIcon(new ImageIcon(MainFrame.class.getResource("/images/icons8-student-registration-24.png")));
		mnStudent.add(mntmAdd);
		
		JMenuItem mntmMange = new JMenuItem("Manage");
		mntmMange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				managaStudentsForm mngSf = new managaStudentsForm();
				mngSf.setVisible(true);
				
				mngSf.setLocationRelativeTo(null);
				mngSf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
			
		});
		mntmMange.setIcon(new ImageIcon(MainFrame.class.getResource("/images/icons8-admin-settings-male-24.png")));
		mnStudent.add(mntmMange);
		
		JMenu mnCourse = new JMenu("Course");
		mnCourse.setIcon(new ImageIcon(MainFrame.class.getResource("/images/icons8-course-50.png")));
		menuBar.add(mnCourse);
		
		JMenuItem menuitemAdd = new JMenuItem("Add");
		menuitemAdd.setIcon(new ImageIcon(MainFrame.class.getResource("/images/icons8-add-new-24.png")));
		menuitemAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCourseForm Addcf = new addCourseForm();
				Addcf.setVisible(true);
			
				Addcf.setLocationRelativeTo(null);
				Addcf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		mnCourse.add(menuitemAdd);
		
		JMenuItem mntmManage = new JMenuItem("Manage");
		mntmManage.setIcon(new ImageIcon(MainFrame.class.getResource("/images/icons8-teacher-24.png")));
		mnCourse.add(mntmManage);
		
		JMenu mnScore = new JMenu("Score");
		mnScore.setIcon(new ImageIcon(MainFrame.class.getResource("/images/icons8-report-card-50.png")));
		menuBar.add(mnScore);
		
		JMenuItem mntmAdd_1 = new JMenuItem("Add");
		mntmAdd_1.setIcon(new ImageIcon(MainFrame.class.getResource("/images/icons8-add-new-24.png")));
		mntmAdd_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addScoreForm AddSF = new addScoreForm();
				AddSF.setVisible(true);
			
				AddSF.setLocationRelativeTo(null);
				AddSF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		mnScore.add(mntmAdd_1);
		
		JMenuItem mntmEditdelete = new JMenuItem("Edit/Delete");
		mntmEditdelete.setIcon(new ImageIcon(MainFrame.class.getResource("/images/icons8-edit-property-24.png")));
		mntmEditdelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editDeleteScore eddSF = new editDeleteScore();
				eddSF.setVisible(true);
				
				eddSF.setLocationRelativeTo(null);
				eddSF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			}
		});
		mnScore.add(mntmEditdelete);
		
		JMenuItem mntmShowScores = new JMenuItem("Show Scores");
		mntmShowScores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				showScoresForm shSF = new showScoresForm();
				shSF.setVisible(true);
				shSF.setLocationRelativeTo(null);
				shSF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		mntmShowScores.setIcon(new ImageIcon(MainFrame.class.getResource("/images/icons8-show-property-24.png")));
		mnScore.add(mntmShowScores);
		mntmManage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manageCourseForm Mngcf = new manageCourseForm();
				Mngcf.setVisible(true);
			
				Mngcf.setLocationRelativeTo(null);
				Mngcf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});

		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(Color.BLUE);
		panel.setBounds(10, 203, 272, 135);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblStdCount = new JLabel("Students Count =");
		lblStdCount.setForeground(Color.WHITE);
		lblStdCount.setBounds(10, 46, 215, 29);
		panel.add(lblStdCount);
		lblStdCount.setFont(new Font("Tahoma", Font.ITALIC, 24));
		
	 	lblWelcome = new JLabel("Welcome <####>");
		lblWelcome.setFont(new Font("Tahoma", Font.ITALIC, 24));
		lblWelcome.setBounds(161, 56, 215, 29);
		contentPane.add(lblWelcome);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setForeground(Color.WHITE);
		panel_1.setBackground(Color.RED);
		panel_1.setBounds(563, 203, 272, 135);
		contentPane.add(panel_1);
		
		lblCoursesCount = new JLabel("Courses Count =");
		lblCoursesCount.setForeground(Color.WHITE);
		lblCoursesCount.setFont(new Font("Tahoma", Font.ITALIC, 24));
		lblCoursesCount.setBounds(10, 46, 215, 29);
		panel_1.add(lblCoursesCount);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(MainFrame.class.getResource("/images/icons8-school-100.png")));
		label.setBounds(10, 11, 107, 106);
		contentPane.add(label);
	}
}
