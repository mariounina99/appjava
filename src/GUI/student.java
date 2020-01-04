package GUI;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DataBase.MyConnection;


public class student {
	private Connection con;
	private Statement st;
	public student() {
	
	con= MyConnection.getConnection();
	try {
		 st = con.createStatement();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}


	
	public void insertStudent(char operation, Integer id, String fname, String lname, String sex,
											String bdate, String phone, String address) 
	{
		
		Connection con = MyConnection.getConnection();
		PreparedStatement ps;
		
		
		if(operation == 'i')
		{
			try {
				ps = con.prepareStatement("INSERT INTO public.student(first_name, last_name, sex, birthdate, phone, address)VALUES (?,?,?,?,?,?)");
				ps.setString(1, fname);
				ps.setString(2, lname);
				ps.setString(3, sex);
				ps.setString(4, bdate);
				ps.setString(5, phone);
				ps.setString(6, address);
				
				
				if(ps.executeUpdate() > 0) {
					JOptionPane.showMessageDialog(null, "New Student Added");
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
		public void fillStudentJtable(JTable table, String valueToSearch) {
			
				Connection con = MyConnection.getConnection();
				PreparedStatement ps;
				try {
					ps = con.prepareStatement("SELECT * FROM public.student WHERE CONCAT('first_name', 'last_name', 'phone', 'address')LIKE ?");
					ps.setString(1, "%"+valueToSearch+"%");
					
					ResultSet rs = ps.executeQuery();
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					
					Object[] row;
					
					while(rs.next()) {
						row = new Object[7];
						row[0] = rs.getInt(1);
						row[1] = rs.getString(2);
						row[2] = rs.getString(3);
						row[3] = rs.getString(4);
						row[4] = rs.getString(5);
						row[5] = rs.getString(6);
						row[6] = rs.getString(7);
						
						
						model.addRow(row);
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		public void updateStudent(char operation, Integer id,String fname, String lname, String sex,String bdate,
				 String phone, String address) {
			Connection con = MyConnection.getConnection();
			PreparedStatement ps;
			
			
			if(operation == 'u')
			{
				try {
					ps = con.prepareStatement("UPDATE public.student SET first_name=?, last_name=?, sex=?, birthdate=?,phone=?, address=? WHERE id = ?;");
					ps.setString(1, fname);
					ps.setString(2, lname);
					ps.setString(3, sex);
					ps.setString(4, bdate);
					ps.setString(5, phone);
					ps.setString(6, address);
					ps.setInt(7, id);
					
					if(ps.executeUpdate() > 0) {
						JOptionPane.showMessageDialog(null, "Studente Data Updated");
					}
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
		public void deleteStudent(char operation, Integer id,String fname, String lname, String sex,String bdate,
				 String phone, String address) {
			Connection con = MyConnection.getConnection();
			PreparedStatement ps;
			
			
			if(operation == 'd')
			{
				int YesOrNo = JOptionPane.showConfirmDialog(null, "The Scores Will Be Also Deleted","Delete Student",JOptionPane.OK_CANCEL_OPTION,0);
				
				if(YesOrNo == JOptionPane.OK_OPTION) {
					try {
						ps = con.prepareStatement("DELETE FROM public.student WHERE id = ?;");
						
						ps.setInt(1, id);
						
						if(ps.executeUpdate() > 0) {
							JOptionPane.showMessageDialog(null, "Studente Deleted");
						}
						
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}

		
		
}
		
		
		