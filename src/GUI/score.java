package GUI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DataBase.MyConnection;

public class score {

	
	
	public void insertStudent(char operation, Integer Sid, Integer Cid,double scr, String descp) 
	{
		
		Connection con = MyConnection.getConnection();
		PreparedStatement ps;
		
		
		if(operation == 'i')
		{
			try {
				ps = con.prepareStatement("INSERT INTO public.score(student_id, course_id, student_score, description) VALUES (?, ?, ?, ?);");
			
				ps.setInt(1, Sid);
				ps.setInt(2, Cid);
				ps.setDouble(3, scr);
				ps.setString(4, descp);
			
				
				if(ps.executeUpdate() > 0) {
					JOptionPane.showMessageDialog(null, "Score Added");
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
		public void updateStudent(char operation, Integer Sid, Integer Cid,double scr, String descp) {
		Connection con = MyConnection.getConnection();
		PreparedStatement ps;
		
		
		if(operation == 'u')
		{
			try {
				ps = con.prepareStatement("UPDATE public.score SET  student_score=?, description=? WHERE student_id=? AND course_id=?;");
				ps.setDouble(1, scr);
				ps.setString(2, descp);
				ps.setInt(3, Sid);
				ps.setInt(4, Cid);
				
				if(ps.executeUpdate() > 0) {
					JOptionPane.showMessageDialog(null, "Score Data Updated");
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public void deleteStudent(char operation, Integer Sid, Integer Cid, Double scr, String descp) {
		Connection con = MyConnection.getConnection();
		PreparedStatement ps;
		
		
		if(operation == 'd')
		{
			try {
				ps = con.prepareStatement("DELETE FROM public.score WHERE student_id = ? AND course_id = ?;");
				
				ps.setInt(1, Sid);
				ps.setInt(2, Cid);
				
				if(ps.executeUpdate() > 0) {
					JOptionPane.showMessageDialog(null, "Score Deleted");
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	public void fillScoreJtable(JTable tableScore) {
		
		Connection con = MyConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("SELECT * FROM public.score");
			ResultSet rs = ps.executeQuery();
			DefaultTableModel model = (DefaultTableModel) tableScore.getModel();
			
			Object[] row;
			
			while(rs.next()) {
				row = new Object[4];
				row[0] = rs.getInt(1);
				row[1] = rs.getInt(2);
				row[2] = rs.getDouble(3);
				row[3] = rs.getString(4);
				model.addRow(row);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
public void showAllScoresForm(JTable tableAllScore) {
		
		Connection con = MyConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("SELECT student_id, first_name, last_name,label, student_score FROM public.score\r\n" + 
										"INNER JOIN student as stab on stab.id = student_id\r\n" + 
										"INNER JOIN public.course as ctab on ctab.id = course_id;");
			ResultSet rs = ps.executeQuery();
			DefaultTableModel model = (DefaultTableModel) tableAllScore.getModel();
			
			Object[] row;
			
			while(rs.next()) {
				row = new Object[5];
				row[0] = rs.getInt(1);
				row[1] = rs.getString(2);
				row[2] = rs.getString(3);
				row[3] = rs.getString(4);
				row[4] = rs.getDouble(5);
				model.addRow(row);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
	
	
	
}
