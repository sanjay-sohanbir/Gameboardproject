/**
 * 
 */
package com.luckbased.game;

import java.util.*;

/**
 * @author Sanjay
 *
 */
public class Simulator {

	
	Players pl= null;
	Deck deck = null;
	
	List<String> randomcardslist = new ArrayList<>();
	List<String> playerList = new ArrayList<>();
	List<String> cardList = new ArrayList<>();
	
	Map<String , List<String>> finalList = new HashMap<String , List<String>>();
	
	List<GameService> result = new ArrayList<GameService>(); 
	
	public Simulator() {
		super();
		pl = new Players();
		deck = new Deck();
	}

	public List<String> getRandomcardslist() {
		return randomcardslist;
	}

	public List<GameService> getResult() {
		return result;
	}

	
	public void addPlayers(String name) {
		
		pl.addPlayer(name);
	}
	
	public void shuffle() {
		Collections.shuffle(deck.getCollectioncard());
		randomcardslist.addAll(deck.getCollectioncard());
	}
	
	public void setPlayerCard() {
		shuffle();
		Integer nop = pl.getPlayers().size();// 4 player 
		for(int i=0;i<nop;i++) {
			int t = i;
			playerList.add(pl.getPlayers().get(i));
			System.out.print("PlayerName : "+pl.getPlayers().get(i));
			for(int j=0;j<3;j++) {
				cardList.add(getRandomcardslist().get(t));
				System.out.print (" card place ::  "+t);
				t += nop;
				
			}
			System.out.println();
		}
		System.out.println("playerList "+playerList);
		System.out.println("cardList  "+cardList);
		
		int c = 0;
		for(int i=0;i<pl.getPlayers().size();i++) {
			List<String> l= new ArrayList<String>();
			l.add(cardList.get(c++));
			l.add(cardList.get(c++));
			l.add(cardList.get(c++));
			finalList.put(pl.getPlayers().get(i),l);
		}
		System.out.println("finalList      "+finalList);
	}
	
	
	public int cardValue(String cardname) {
		int c = 0;
		for(Card val:Card.values()){
			String card = val.getName();
			if(card.equals(cardname)) {
				c=val.getValue();
			}
		}
		return c;
		
	}
	
	public void cardIdentify() {

		int seq[] = new int[3];
		String orinalCard;
		
		for(int j=0;j<finalList.size();j++) {
			String player = pl.getPlayers().get(j);
			List<String> playerCards = finalList.get(pl.getPlayers().get(j));
			
			System.out.println("playerCards ***********"+playerCards);
			orinalCard = finalList.get(player).toString();
			String first = playerCards.get(0);
			String second = playerCards.get(1);
			String third = playerCards.get(2);
			
			String c1 = first.substring(0, 1);
			String c2 = second.substring(0, 1);
			String c3 = third.substring(0, 1);
			String d1 = first.substring(1);
			String d2 = second.substring(1);
			String d3 = third.substring(1);
			System.out.println("substring *********** d1 "+d1 +" d2 "+d2+" d3 "+d3);	
			seq[0] = cardValue(d1);
			seq[1] = cardValue(d2);
			seq[2] = cardValue(d3);
	
			Arrays.sort(seq);// 14 13 12
			if(seq[2] == 14 && seq[0] == 2 && seq[1] == 3) {
				seq[0] = 1;
				seq[1] = 2;
				seq[2] = 3;
			}
			int total=0;
			int points = 0;
			
			// Rule no 1 is A trail (three cards of the same number) is the highest possible combination.
		
				if((seq[0]==seq[1]) && (seq[1] ==seq[2])) {
					total = total + 50;
					points = show(seq,total,points);
					
					System.out.println("Winner is  *********** highest possible combination");
				}
			// Rule no 2 is  The next highest is a sequence(numbers in order e.g., 4,5,6. A is considered to have a value of 1).
			
				else if((seq[0]==(seq[1]-1)) && seq[0]==(seq[2]-2)) {
					total = total + 30;
					points = show(seq,total,points);
					
					if(seq[0] == 1 && seq[1] == 2 && seq[2] == 3) {
					seq[0] = 2;
					seq[1] = 3;
					seq[2] = 14;
					}
					
					if(c1.equals(c2) && c2.equals(c3) && c3.equals(c1)) {
						total = total + 25;
						points = show(seq,total,points);
						System.out.println("Winner is  *********** highest is a sequence with same color");
					}	
					
					points = show(seq,total,points);
					System.out.println("Winner is  *********** highest is a sequence");
				}
				
			//Rule no 3 is The next highest is a pair of cards (e.g.: two Kings or two 10s).	
				
				else if((seq[0]==seq[1]) || (seq[1]==seq[2])) {
					total = total + 15;
					points = show(seq,total,points);
					
					System.out.println("Winner is  *********** highest is a pair " +seq[0]+" "+seq[1]+" "+seq[2]);
				}
				// Rule no 4 is If all else fails, the top card (by number value wins).
				else {	
					points = show(seq,total,points);

					System.out.println("Winner is  *********** highest is a number value of the card");
				}
				

				
			System.out.println("Player : " + pl.getPlayers().get(j));
			System.out.println("Points : "+ points);
			System.out.println("=========================================");
			
			
			result.add(new GameService(pl.getPlayers().get(j),points,orinalCard));
		}	
		
		
		
		
	}
	public int show(int seq[],int total,int sum) {
		int minSeq = 2;
		int maxSeq = 14;
		int[] seqValues = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130};
		total = total + seq[0] + seq[1] + seq[2];
		
		for(int i = minSeq; i <= maxSeq; i++) {
			if (seq[2] == i) {
				total += seqValues[i-minSeq];
				break;
			}
		}
		return total;
	}
	
	public void result() {
		result.sort(Comparator.comparing(g -> g.getPriority()));
		Collections.reverse(result);
		
		GameService winner = result.get(0);
		System.out.println("Winner Player");
		System.out.println("===========================================");
		System.out.println("Name : " + winner.getWinnername());
		System.out.println("Points : " + winner.getPriority());
		System.out.println("Card : " + winner.getCard());
	}
	
	public void winner() {
		cardIdentify();
		result();
	}
	
	
}
