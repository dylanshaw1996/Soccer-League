package application;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tab;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.sql.*;
import java.util.ArrayList;

/**
 * 
 * @author Dylan Shaw
 * 
 * 
 * This application is a football league application, it allows you to create players, managers & teams and add them to the league.
 * 
 */

public class main extends Application {
	
	   Button button;
	   private static  Label       nameLabel1, nameLabel2, nameLabel3, phoneLabel, emailLabel, goalLabel, keeperLabel, managerLabel1, managerLabel2, managerLaber3, managerPhone,  managerEmail, managerDOB, managerRating, teamLabel, colourLabel, playerTeam, managerTeam;
	   private static  Button      add, remove, search, addManager, update, managerNameSort, managerRatingSort, teamAdd, playerList, teamList; 
	   private static CheckBox	   keeper;
	   private static  TextArea    display, displayManager, displayTeam;
	   private static  TextField   name1Display, name2Display, name3Display, phoneDisplay, emailDisplay, goalDisplay, managerEmail1, managerDisplay1, managerDisplay2, managerDisplay3, managerPhone1,  managerDOB1, managerRating1, teamName, teamColour, playerTeam1, managerTeam1;
	   private controller          controll;

    public static void main(String[] args) {
        launch(args);

    }

    public void start(Stage primaryStage) {

    	
    	/**
    	 * 
    	 * This is the view of the application, it has 3 tabs, one for adding a player, one for adding a manager and one for adding a team
    	 *  
    	 * 
    	 * 
    	 */

        TabPane tabPane = new TabPane();
	    controll = new controller();

	    
        Tab tabA = new Tab();
        tabA.setText("Create A Player");
	    nameLabel1 = new Label ("FirstName");
	    name1Display = new TextField();
	    nameLabel2 = new Label ("MiddleName");
	    name2Display = new TextField ();
	    nameLabel3 = new Label ("LastName");
	    name3Display = new TextField ();
	    phoneLabel = new Label ("Phone");
	    phoneDisplay = new TextField ("");
	    emailLabel = new Label ("Email");
	    emailDisplay = new TextField ("");
	    goalLabel = new Label ("Goals Scored/Saved");
	    goalDisplay = new TextField ("");
	    keeperLabel = new Label("Is the player a keeper");
	    keeper = new CheckBox("");
	    playerTeam = new Label ("Team");
	    playerTeam1 = new TextField ("");
	    
	    VBox vA = new VBox(20);
	    vA.getChildren().addAll(nameLabel1, nameLabel2, nameLabel3, phoneLabel, emailLabel, goalLabel, playerTeam, keeperLabel);
	    VBox vB = new VBox(10);
	    vB.getChildren().addAll(name1Display, name2Display, name3Display, phoneDisplay, emailDisplay, goalDisplay, playerTeam1, keeper);
	    HBox r4 = new HBox (20);
	    r4.getChildren().addAll(vA, vB);
	    add = new Button("Add");
	    add.setOnAction(e -> controll.addPlayer(name1Display, name2Display, name3Display, phoneDisplay, emailDisplay, goalDisplay, playerTeam1));
	    remove = new Button("Remove");
	    remove.setOnAction(e -> controll.deletePlayer(name1Display, name2Display, name3Display, phoneDisplay, emailDisplay, goalDisplay, playerTeam1));
	    search = new Button("Search");
	    search.setOnAction(e -> controll.searchPlayer(name1Display, name2Display, name3Display, goalDisplay));
	    update = new Button("Update");
	    HBox r1 = new HBox(20);
	    r1.getChildren().addAll(add, remove, search, update);
		VBox layout = new VBox(10);
	    display = new TextArea("Display serached player");
	    double width = 800;
	    display.setPrefWidth(width);
	    HBox r2 = new HBox (20);
	    r2.getChildren().addAll(display);
	    layout.setPadding(new Insets(20, 20, 20, 20));
	    layout.getChildren().addAll(r4, r1, r2);
        tabA.setContent(layout);
        
        
        
        
        
        Tab tabB = new Tab();
        tabB.setText("Create A Manager");
        managerLabel1 = new Label ("FirstName");
        managerDisplay1 = new TextField();
        managerLabel2 = new Label ("MiddleName");
        managerDisplay2 = new TextField ();
        managerLaber3 = new Label ("LastName");
        managerDisplay3 = new TextField ();
        managerPhone = new Label ("Phone");
        managerPhone1 = new TextField ("");
        managerEmail = new Label ("Email");
        managerEmail1 = new TextField ("");
        managerDOB = new Label ("DOB");
        managerDOB1 = new TextField ("");
        managerRating = new Label("Manager Rating 1-10");
        managerRating1 = new TextField("");
        managerTeam = new Label ("Team");
        managerTeam1 = new TextField("");
        addManager = new Button("Add");
        addManager.setOnAction(e -> controll.addManager(managerDisplay1, managerDisplay2, managerDisplay3, managerPhone1,  managerEmail1, managerDOB1, managerRating1, managerTeam1));
        managerNameSort = new Button ("Sort Managers By Name");
        managerRatingSort = new Button ("Sort Managers By Rating");
	    HBox m1 = new HBox(20);
	    m1.getChildren().addAll(addManager, managerNameSort, managerRatingSort);
	    VBox v11 = new VBox(20);
	    v11.getChildren().addAll(managerLabel1, managerLabel2, managerLaber3, managerPhone,  managerEmail, managerDOB, managerRating, managerTeam);
	    VBox v2 = new VBox(10);
	    v2.getChildren().addAll(managerDisplay1, managerDisplay2, managerDisplay3, managerPhone1,  managerEmail1, managerDOB1, managerRating1, managerTeam1);
	    HBox rA = new HBox (20);
	    rA.getChildren().addAll(v11, v2);
	    displayManager = new TextArea("Display sorted managers");
	    double width1 = 800;
	    displayManager.setPrefWidth(width1);
	    HBox m2 = new HBox (20);
	    m2.getChildren().addAll(displayManager);
		VBox layout1 = new VBox(10);
	    layout1.setPadding(new Insets(20, 20, 20, 20));
		layout1.getChildren().addAll(rA, m1, m2);
        tabB.setContent(layout1);
        
        
        Tab tabC = new Tab();
        tabC.setText("Create A Team");
        teamLabel = new Label("Team Name");
        teamName = new TextField("");
        colourLabel = new Label("What is the team's colour");
        teamColour = new TextField ("");
        VBox t1 = new VBox(20);
        t1.getChildren().addAll(teamLabel, colourLabel);
        VBox t2 = new VBox(20);
        t2.getChildren().addAll(teamName, teamColour);
        HBox tA = new HBox(20);
        tA.getChildren().addAll(t1, t2);   
        teamAdd = new Button("Add");
        teamAdd.setOnAction(e -> controll.addTeam(teamName, teamColour));
        playerList = new Button("List Player in Team");
        playerList.setOnAction(e -> controll.displayPlayerfromTeam(teamName, displayTeam));
        teamList = new Button("List Teams");
        displayTeam = new TextArea("Display the players/team");
	    double width2 = 800;
	    displayTeam.setPrefWidth(width2);
	    HBox tC = new HBox (20);
	    tC.getChildren().addAll(displayTeam);
        HBox tB = new HBox(20);
        tB.getChildren().addAll(teamAdd, playerList, teamList);
        VBox v3 = new VBox(10);
        v3.setPadding(new Insets(20, 20, 20, 20));
        v3.getChildren().addAll(tA, tB, tC);
        tabC.setContent(v3);
        
        
        tabPane.getTabs().add(tabA);
        tabPane.getTabs().add(tabB);
        tabPane.getTabs().add(tabC);

        VBox vBox = new VBox(tabPane);
        Scene scene = new Scene(vBox , 800, 500);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Football League");

        primaryStage.show();
    }
}