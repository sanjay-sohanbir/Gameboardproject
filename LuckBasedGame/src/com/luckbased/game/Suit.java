/**
 * 
 */
package com.luckbased.game;

/**
 * @author Sanjay
 *
 */
public enum Suit {
	
	HEART("H"),
	SPRED("S"),
	DIAMOND("D"),
	CLUB("C");
	
	private final String suitname;
	
		Suit(String suitname){
			this.suitname=suitname;
			
		}

		public String getSuitname() {
			return suitname;
		}

}
