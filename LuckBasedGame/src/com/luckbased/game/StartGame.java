/**
 * 
 */
package com.luckbased.game;

/**
 * @author Sanjay
 *
 */ class StartGame {

	 /**
		 * @param args
		 */
	public static void main(String[] args) {
		
		Simulator start = new Simulator();
		
			start.addPlayers("Dev");
			start.addPlayers("mandal");
			start.addPlayers("sanju");
			start.addPlayers("don");
			start.setPlayerCard();
			start.winner();
		
	}

}
