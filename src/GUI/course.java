package GUI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.plaf.ComboBoxUI;
import javax.swing.table.DefaultTableModel;

import DataBase.MyConnection;

public class course {
	private Connection con;
	private Statement st;
	public course() {
	
	con= MyConnection.getConnection();
	try {
		 st = con.createStatement();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}


	
	public void insertStudent(char operation, Integer id, String label, Integer hours) 
	{
		
		Connection con = MyConnection.getConnection();
		PreparedStatement ps;
		
		
		if(operation == 'i')
		{
			try {
				ps = con.prepareStatement("INSERT INTO public.course(label, hours_number)VALUES (?, ?);");
			
				ps.setString(1, label);
				ps.setInt(2,hours);
			
				
				if(ps.executeUpdate() > 0) {
					JOptionPane.showMessageDialog(null, "New Course Added");
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
		public void updateStudent(char operation, Integer id, String label, Integer hours) {
		Connection con = MyConnection.getConnection();
		PreparedStatement ps;
		
		
		if(operation == 'u')
		{
			try {
				ps = con.prepareStatement("UPDATE public.course SET label=?, hours_number=? WHERE id = ?;");
				ps.setString(1, label);
				ps.setInt(2, hours);
				ps.setInt(3, id);
					
				
				if(ps.executeUpdate() > 0) {
					JOptionPane.showMessageDialog(null, "Course Data Updated");
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public void deleteStudent(char operation, Integer id, String label, Integer hours) {
		Connection con = MyConnection.getConnection();
		PreparedStatement ps;
		
		
		if(operation == 'd')
		{
			int YesOrNo = JOptionPane.showConfirmDialog(null, "The Scores Will Be Also Deleted","Delete Score",JOptionPane.OK_CANCEL_OPTION,0);
			
			if(YesOrNo == JOptionPane.OK_OPTION) {
			
			try {
				ps = con.prepareStatement("DELETE FROM public.course WHERE id = ?;");
				
				ps.setInt(1, id);
				
				if(ps.executeUpdate() > 0) {
					JOptionPane.showMessageDialog(null, "Course Deleted");
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
	}
		public boolean isCourseExist(String courseName) {
			boolean isExist = false;
			Connection con = MyConnection.getConnection();
			PreparedStatement ps;
			try {
				ps = con.prepareStatement("SELECT * FROM public.course WHERE label = ?");
				ps.setString(1, courseName);
				
				ResultSet rs = ps.executeQuery();
			
				
				if(rs.next()) {
					isExist = true;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return isExist;
		}
		public void fillCourseJtable(JTable tableTab) {
			
			Connection con = MyConnection.getConnection();
			PreparedStatement ps;
			try {
				ps = con.prepareStatement("SELECT * FROM public.course");
				
				
				ResultSet rs = ps.executeQuery();
				DefaultTableModel model = (DefaultTableModel) tableTab.getModel();
				
				Object[] row;
				
				while(rs.next()) {
					row = new Object[3];
					row[0] = rs.getInt(1);
					row[1] = rs.getString(2);
					row[2] = rs.getInt(3);
				
					
					
					model.addRow(row);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		
		
	public int getCourseId(String courseLabel) {
		int courseId = 0;
		
		Connection con = MyConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("SELECT * FROM public.course WHERE label = ?");
			ps.setString(1, courseLabel);
			
			ResultSet rs = ps.executeQuery();
		
			
			if(rs.next()) {
				courseId = rs.getInt("Id");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return courseId;
	}
	public void fillCourseCombo(JComboBox combo) {
		
		Connection con = MyConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("SELECT * FROM public.course");
			
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
			
				combo.addItem(rs.getString(2));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}
