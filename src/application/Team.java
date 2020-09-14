package application;

import java.util.ArrayList;

public class Team {
	
	public Manager manager; 
	public String name; 
	public ArrayList<Player> players = new ArrayList<>();
	public String teamColor;
	/**
	 * 
	 * @return the manager of the tea, 
	 */
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	/**
	 * 
	 * @return the name of the team
	 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 
	 * @return the list of players on the team 
	 */
	public ArrayList<Player> getPlayers() {
		return players;
	}
	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
	/**
	 * 
	 * @return the jersey colour
	 */
	public String getTeamColor() {
		return teamColor;
	}
	public void setTeamColor(String teamColor) {
		this.teamColor = teamColor;
	}
	@Override
	public String toString() {
		return "Team [manager=" + manager + ", name=" + name + ", players=" + players + ", teamColor=" + teamColor
				+ "]";
	}	
	

}
