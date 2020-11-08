/**
 * 
 */
package com.luckbased.game;

import java.util.*;

/**
 * @author Sanjay
 *
 */
public class Deck {
	
	List<String> collectioncard= new ArrayList<>();

	/**
	 * 
	 */
	public Deck() {
		Suit suits[] = Suit.values();
		Card cards[] = Card.values();
		
		for (int i = 0; i < suits.length; i++) {
			
			for (int j = 0; j < cards.length; j++) {
				collectioncard.add(suits[i].getSuitname()+cards[j].getName());
			}
		}
		
	}

	public List<String> getCollectioncard() {
		return collectioncard;
	}

	public void setCollectioncard(List<String> collectioncard) {
		this.collectioncard = collectioncard;
	}
	
	

	

}
