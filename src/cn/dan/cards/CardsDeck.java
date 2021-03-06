package cn.dan.cards;

import cn.dan.card.Card;
import cn.dan.card.Constants;
import cn.dan.exception.UtestFailedException;
import cn.dan.util.Print;

public class CardsDeck extends Cards {
	
	public CardsDeck() {
				
		for(int i=0; i< Constants.POKER_NAME.length-2; i++) {
			for(int n=0; n<3; n++)
				add(Card.createCard(Constants.POKER_NAME[i]));
		}
		
		for(int i=0; i< Constants.POKER_NAME.length; i++)
			add(Card.createCard(Constants.POKER_NAME[i]));
		
		shuffle();
	}
	
	public Cards deals(Integer num) {
		
		if(size() < num)
			return null;
		
		Cards subCards = new Cards();
		
		for(int i=0; i<num; i++) {
			subCards.add(this.get(0));
			remove(0);
		}
		
		subCards.sort();
		
		return subCards;
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		
		CardsDeck deck = new CardsDeck();

		deck.sort();
		if(!deck.toString().equals("333344445555666677778888999910101010JJJJQQQQKKKKAAAA2222BR"))
		{
			Print.p("UTest failed: CardsDeck() failed!");
			throw new UtestFailedException();
		}	
		
		Cards johns = deck.deals(17);
		Cards marys = deck.deals(17);
		Cards lords = deck.deals(17+3);		
		
		
		if(!johns.toString().equals("33334444555566667") ||
		   !marys.toString().equals("7778888999910101010JJ") ||
		   !lords.toString().equals("JJQQQQKKKKAAAA2222BR"))
		{
			Print.p("UTest failed: deals() failed!");
			throw new UtestFailedException();
		}
				
		Cards error = deck.deals(1);	
		if(error != null) {
			Print.p("UTest failed: deal() failed!");
			throw new UtestFailedException();
		}
		
		Print.p("UTest passed");
	}
}

