package cn.dan.cards;


public class CardsInhand extends Cards {
	
	public CardsInhand(Cards cards) {
		addAll(cards);
	}
	
	public boolean playOut(Cards cardsOut) {		
		return removeAll(cardsOut);
	}
	
	public static void main(String[] args) {	
				
	}
}

