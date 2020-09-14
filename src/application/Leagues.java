package application;

import java.util.ArrayList;

public class Leagues {
	
	public String name;
	public ArrayList<Team> teams = new ArrayList<>();
	
	/**
	 * This constructor allows you to create a league
	 * @return the name of the league 
	 */
	
	public String getName() {
		return name;
	}
	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 
	 * @return the teams in the league
	 */
	public ArrayList<Team> getTeams() {
		return teams;
	}
	
	/**
	 * 
	 * @param teams
	 */
	public void setTeams(ArrayList<Team> teams) {
		this.teams = teams;
	}
	@Override
	public String toString() {
		return "Leagues [name=" + name + ", teams=" + teams + "]";
	}

	
}
