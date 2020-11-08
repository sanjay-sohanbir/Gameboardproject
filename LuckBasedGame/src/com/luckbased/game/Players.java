/**
 * 
 */
package com.luckbased.game;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sanjay
 *
 */
public class Players {
	
	List<String> players= new ArrayList<String>();

	public List<String> getPlayers() {
		return players;
	}

	public void addPlayer(String name) {
		
		this.players.add(name);
		
	}

}
