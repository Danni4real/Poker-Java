package cn.dan.cards;

import java.util.List;

import cn.dan.card.Card;
import cn.dan.exception.UtestFailedException;
import cn.dan.pattern.Pattern;
import cn.dan.util.Parse;
import cn.dan.util.Print;

public class CardsOut extends Cards {
	
	private Pattern pattern = null;
	
	private CardsOut() {}
	
	public static CardsOut createCardsOut(List<String> input) {
		Card card = null;
		CardsOut cardsOut = new CardsOut();
		
		for(String s: input) {
			card = Card.createCard(s);
			if(card == null)
				return null;
			cardsOut.add(card);
		}
			
		cardsOut.pattern = Pattern.getPattern(cardsOut);
		if(cardsOut.pattern == null)
			return null;
		
		return cardsOut;
	}
	
	
	public static void main(String[] args) {
		
		CardsOut out = CardsOut.createCardsOut(Parse.p("5678910"));
		
		if(!out.toString().equals("5678910")) {
			Print.p("UTest failed!");
			throw new UtestFailedException();
		}
		
		out = CardsOut.createCardsOut(Parse.p("12345"));
		if(out != null) {
			Print.p("UTest failed!");
			throw new UtestFailedException();
		}	
		out = CardsOut.createCardsOut(Parse.p("34"));
		if(out != null) {
			Print.p("UTest failed!");
			throw new UtestFailedException();
		}

		Print.p("UTest passed");
	}
}

