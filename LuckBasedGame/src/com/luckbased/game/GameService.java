/**
 * 
 */
package com.luckbased.game;

/**
 * @author Sanjay
 *
 */
public class GameService {

	private String winnername;
	private int priority;
	private String card;
	
	
	public GameService(String winnername, int priority, String card) {
		super();
		this.winnername = winnername;
		this.priority = priority;
		this.card = card;
	}
	public String getWinnername() {
		return winnername;
	}
	public int getPriority() {
		return priority;
	}
	public String getCard() {
		return card;
	}
	
	
}
