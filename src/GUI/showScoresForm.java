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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class showScoresForm extends JFrame {

	private JPanel contentPane;
	private final JScrollPane scrollPane = new JScrollPane();
	private JTable tableAllScore;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					showScoresForm frame = new showScoresForm();
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
	public showScoresForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 708, 643);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(0, 0, 682, 604);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAllScores = new JLabel("All Scores");
		lblAllScores.setBounds(253, 11, 190, 40);
		lblAllScores.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblAllScores.setBackground(Color.WHITE);
		panel.add(lblAllScores);
		scrollPane.setBounds(10, 97, 662, 473);
		panel.add(scrollPane);
		
		tableAllScore = new JTable();
		tableAllScore.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Student Id", "First Name", "Last Name", "Course", "Score"
			}
		));
		scrollPane.setViewportView(tableAllScore);
		sc.showAllScoresForm(tableAllScore);
		tableAllScore.setRowHeight(40);
		tableAllScore.setShowGrid(true);
		tableAllScore.setGridColor(Color.yellow);
		tableAllScore.setSelectionBackground(Color.GREEN);
	}
}
