/**
 * 
 */
package com.luckbased.game;

/**
 * @author Sanjay
 *
 */
public enum Card {

	
		TWO("2",2),
		THREE("3",3),
		FOUR("4",4),
		FIVE("5",5),
		SIX("6",6),
		SEVEN("7",7),
		EIGHT("8",8),
		NINE("9",9),
		TEN("10",10),
		ELEVN ("J",11),
		TWELVE("Q",12),
		THIRTEEN("K",13),
		ONE("A",14);
	
		private final String name;
		private final int value;
		
		Card(String name , int value){
			
			this.name=name;
			this.value=value;
		}

		public String getName() {
			return name;
		}

		public int getValue() {
			return value;
		}
		
		
}
