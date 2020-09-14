package application;

public class Player extends Person {
	
	public Person person;
	public int goalsScored; 
	public boolean goalie;
	
	/**
	 * 
	 * @return the player person 
	 */
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	/**
	 * 
	 * @return the amount of goals scored 
	 */
	public int getGoalsScored() {
		return goalsScored;
	}
	public void setGoalsScored(int goalsScored) {
		this.goalsScored = goalsScored;
	}
	/**
	 * 
	 * @return if the player is a goalie 
	 */
	public boolean isGoalie() {
		return goalie;
	}
	public void setGoalie(boolean goalie) {
		this.goalie = goalie;
	}
	@Override
	public String toString() {
		return "Player [person=" + person + ", goalsScored=" + goalsScored + ", goalie=" + goalie + "]";
	}
	
	
}
