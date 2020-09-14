package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class controller {
	
/**
 * 
 * This first function takes  the input from the GUI, creates a player and saves it in the database 
 * 
 * @param name1Display
 * @param name2Display
 * @param name3Display
 * @param phoneDisplay
 * @param emailDisplay
 * @param goalDisplay
 * @param playerTeam1
 */
	
	public void addPlayer(TextField name1Display, TextField name2Display,TextField name3Display, TextField phoneDisplay, TextField emailDisplay, TextField goalDisplay, TextField playerTeam1){
		
		String nameDisplay1 = name1Display.getText();
		String nameDisplay2 = name2Display.getText();
		String nameDisplay3 = name3Display.getText();
		String phoneDisplay1 = phoneDisplay.getText();
		String emailDisplay1 = emailDisplay.getText();
		int  goalDisplay1 = Integer.parseInt(goalDisplay.getText());
		//boolean keeper1 = keeper;
		String playerTeam2 = playerTeam1.getText();

		
        try {
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/footballleague", "root", "Liverpool96!");
			java.sql.PreparedStatement stmt=con.prepareStatement("insert into players values(default, ?,?,?,?,?,?,?,?)");  
	            
	        	//set parameters for statement
	            stmt.setString(1, nameDisplay1);
	            stmt.setString(2, nameDisplay2);
	            stmt.setString(3, nameDisplay3);
	            stmt.setString(4, phoneDisplay1);
	            stmt.setString(5, emailDisplay1);
	            stmt.setInt(6, goalDisplay1); 
	            stmt.setInt(7, '0');
	            stmt.setString(8, playerTeam2); 
	            int i=stmt.executeUpdate();  
	            System.out.println(i+" records inserted");        
	            con.close();  
        
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	/**
	 * This function takes input from the GUI and removes the player 
	 * @param name1Display
	 * @param name2Display
	 * @param name3Display
	 * @param phoneDisplay
	 * @param emailDisplay
	 * @param goalDisplay
	 * @param playerTeam1
	 */
	public void deletePlayer(TextField name1Display, TextField name2Display,TextField name3Display, TextField phoneDisplay, TextField emailDisplay, TextField goalDisplay, TextField playerTeam1){
		
		String nameDisplay1 = name1Display.getText();
		String nameDisplay2 = name2Display.getText();
		String nameDisplay3 = name3Display.getText();
		String phoneDisplay1 = phoneDisplay.getText();
		String emailDisplay1 = emailDisplay.getText();
		int  goalDisplay1 = Integer.parseInt(goalDisplay.getText());
		//boolean keeper1 = keeper;
		String playerTeam2 = playerTeam1.getText();

		
        try {
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/footballleague", "root", "Liverpool96!");
			java.sql.PreparedStatement stmt=con.prepareStatement("delete from players where firstname=? && middlename =? && lastname=? && phone=? && email=? && goalsscored=? && isKeeper=? && teamName=?");  
	            
	        	//set parameters for statement
	            stmt.setString(1, nameDisplay1);
	            stmt.setString(2, nameDisplay2);
	            stmt.setString(3, nameDisplay3);
	            stmt.setString(4, phoneDisplay1);
	            stmt.setString(5, emailDisplay1);
	            stmt.setInt(6, goalDisplay1); 
	            stmt.setInt(7, '0');
	            stmt.setString(8, playerTeam2); 
	            int i=stmt.executeUpdate();  
	            System.out.println(i+" records deleted");        
	            con.close();  
        
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	/**
	 * This function takes the name of the player and displayes the amount of goals they have scored 
	 * @param name1Display
	 * @param name2Display
	 * @param name3Display
	 * @param goalDisplay
	 */
	public void searchPlayer(TextField name1Display, TextField name2Display,TextField name3Display, TextField goalDisplay){
		String nameDisplay1 = name1Display.getText();
		String nameDisplay2 = name2Display.getText();
		String nameDisplay3 = name3Display.getText();
		int  goalDisplay1 = Integer.parseInt(goalDisplay.getText());
		
		
        try {
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/footballleague", "root", "Liverpool96!");
			java.sql.PreparedStatement stmt=con.prepareStatement("select firstname && middlename && lastname && goalsscored from players where firstname=? && middlename =? && lastname=?");  
	            
	        	//set parameters for statement
	            stmt.setString(1, nameDisplay1);
	            stmt.setString(2, nameDisplay2);
	            stmt.setString(3, nameDisplay3);
	           // stmt.setInt(4, goalDisplay1); 
	            
	            ResultSet rs = stmt.executeQuery();
	            
	            while(rs.next()){
	                //Retrieve by column name
	            	String nameDisplay11 = rs.getString("firstname");
	                String nameDisplay12 = rs.getString("middlename");
	                String nameDisplay13 = rs.getString("lastname");
	                int goalDisplay11 = rs.getInt("goalsscored");

	                //Display values
	                System.out.print("First Name: " + nameDisplay11);
	                System.out.print(", Middle Name: " + nameDisplay12);
	                System.out.print(", Last Name: " + nameDisplay13);
	                System.out.println(", Goals Scored : " + goalDisplay11); 
	                con.close();  
	            }}
        
         catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        }
	
/**
 * This function will take the team name and display all the players on that team 
 * 
 * @param teamName
 * @param displayTeam
 */
	public void displayPlayerfromTeam(TextField teamName, TextArea displayTeam){
		
		String teamName1 = teamName.getText();
		
        try {
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/footballleague", "root", "Liverpool96!");
			java.sql.PreparedStatement stmt=con.prepareStatement("select * from players where teamName=?");  
	            
	        	//set parameters for statement
	            stmt.setString(1, teamName1);

	            
	            ResultSet rs = stmt.executeQuery();
	            
	            while(rs.next()){
	                //Retrieve by column name
	            	//int id = rs.getInt("playersid");
	            	String nameDisplay11 = rs.getString("firstname");
	                String nameDisplay12 = rs.getString("middlename");
	                String nameDisplay13 = rs.getString("lastname");
	                String playerPhone = rs.getString("phone");
	                String playerEmail = rs.getString("email");
	                int goalDisplay11 = rs.getInt("goalsscored");
	                String team = rs.getString("teamName");

	                //Display values
	                System.out.print("First Name: " + nameDisplay11);
	                System.out.print(", Middle Name: " + nameDisplay12);
	                System.out.print(", Last Name: " + nameDisplay13);
	                System.out.print(", Phone: " + playerPhone);
	                System.out.print(", Email: " + playerEmail);
	                System.out.println(", Goals Scored : " + goalDisplay11); 
	                System.out.println(", Team : " + team); 
	                
	                
	                
	                displayTeam.clear();
	            	String DisplayString = (nameDisplay11 + " " +  nameDisplay12  + " " + nameDisplay13 + " " + playerPhone + " " + playerEmail + " " + goalDisplay11 + " " + team );
	                displayTeam.setText(DisplayString); 
	                
	            }}
        
         catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * This fucntion takes input from the GUI and creates a manaager and saves it to the database 
	 * @param managerDisplay1
	 * @param managerDisplay2
	 * @param managerDisplay3
	 * @param managerPhone1
	 * @param managerEmail1
	 * @param managerDOB1
	 * @param managerRating1
	 * @param managerTeam1
	 */
	public void addManager(TextField managerDisplay1, TextField managerDisplay2, TextField managerDisplay3, TextField managerPhone1,  TextField managerEmail1, TextField managerDOB1, TextField managerRating1, TextField managerTeam1){
		
		String managerDisplay = managerDisplay1.getText();
		String managerDisplayA = managerDisplay2.getText();
		String managerDisplayC = managerDisplay3.getText();
		String managerPhone = managerPhone1.getText();
		String managerEmail = managerEmail1.getText();
		String managerDOB = managerDOB1.getText();
		//String  managerRating = managerRating1.getText();
		String managerTeam = managerTeam1.getText();
		
		
        try {
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/footballleague", "root", "Liverpool96!");
			java.sql.PreparedStatement stmt=con.prepareStatement("insert into managers values(default, ?,?,?,?,?,?,?,?)");  
	            
	        	//set parameters for statement
	            stmt.setString(1, managerDisplay);
	            stmt.setString(2, managerDisplayA);
	            stmt.setString(3, managerDisplayC);
	            stmt.setString(4, managerPhone);
	            stmt.setString(5, managerEmail);
	            stmt.setString(6, managerDOB); 
	            stmt.setString (7, "10");
	            stmt.setString(8, managerTeam);
	            
	            int i=stmt.executeUpdate();  
	            System.out.println(i+" records inserted");        
	            con.close();  
        
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
		
		
	/**
	 * This function takes input from the GUI and creates a team and saves it in the database 
	 * 
	 * @param teamName
	 * @param teamColour
	 */
	public void addTeam(TextField teamName, TextField teamColour){
		
		String teamName1 = teamName.getText();
		String teamColour1 = teamColour.getText();
		
        try {
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/footballleague", "root", "Liverpool96!");
			java.sql.PreparedStatement stmt=con.prepareStatement("insert into team values(default,?,?)");  
	            
	        	//set parameters for statement
	            stmt.setString(1, teamName1);
	            stmt.setString(2, teamColour1);

	            
	            int i=stmt.executeUpdate();  
	            System.out.println(i+" records inserted");        
	            con.close();  
        
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
		
		
		
	}