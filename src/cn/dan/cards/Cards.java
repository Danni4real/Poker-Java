package cn.dan.cards;import java.util.*;import cn.dan.card.*;import cn.dan.exception.UtestFailedException;import cn.dan.util.Print;public class Cards {			private List<Card> list = new LinkedList<Card>();			public Cards() {}			public Cards clone() {		Cards cloned = new Cards();				for(Card c: list)			cloned.add(c.clone());				return cloned;	}	public boolean remove(Card card) {		for(int i=0; i<size(); i++) {			if(get(i).equals(card))			{				remove(i);				return true;			}		}				return false;	}	public boolean removeAll(Cards cards) {				Cards cloned = clone();				for(Card c: cards.list) {			if(!cloned.remove(c))				return false;		}				for(Card c: cards.list)			remove(c);					return true;	}	@Override	public String toString() {				String s = new String();				for(Card card: list)			s += card;				return s;	}		public int size() {		return list.size();	}	public boolean add(Card card) {		return list.add(card);	}		public boolean addAll(Cards cards) {		return list.addAll(cards.list);	}		public Card get(int index) {		return list.get(index);	}		public Card remove(int index) {		return list.remove(index);	}		public void shuffle() {		Collections.shuffle(list);	}		public void sort() {		Collections.sort(list);	}												public static void main(String[] args) {				Cards cards = new Cards();		Cards cardsOut = new Cards();		Cards cardsClone = null;				cardsOut.add(Card.createCard("3"));		cardsOut.add(Card.createCard("3"));				cards.add(Card.createCard("3"));		cards.add(Card.createCard("4"));		cards.add(Card.createCard("3"));		cards.add(Card.createCard("3"));		cards.add(Card.createCard("3"));			if(!cards.toString().equals("34333"))		{			Print.p("UTest failed: toString() failed!");			throw new UtestFailedException();		}				cardsClone = cards.clone();				if(cards == cardsClone ||		   cards.get(0) == cardsClone.get(0) ||		   cards.get(1) == cardsClone.get(1) ||		   cards.get(2) == cardsClone.get(2) ||		   cards.get(3) == cardsClone.get(3) ||		   cards.get(4) == cardsClone.get(4))		{			Print.p("UTest failed: clone() failed!");			throw new UtestFailedException();		}				if(!cards.get(0).equals(cardsClone.get(0)) ||		   !cards.get(1).equals(cardsClone.get(1)) ||		   !cards.get(2).equals(cardsClone.get(2)) ||		   !cards.get(3).equals(cardsClone.get(3)) ||		   !cards.get(4).equals(cardsClone.get(4)) )		{			Print.p("UTest failed: clone() failed!");			throw new UtestFailedException();		}				if(!cards.remove(Card.createCard("3"))) {			Print.p("UTest failed: toString() failed!");			throw new UtestFailedException();		}		if(!cards.toString().equals("4333"))		{			Print.p("UTest failed: toString() failed!");			throw new UtestFailedException();		}		if(cards.remove(Card.createCard("9"))) {			Print.p("UTest failed: toString() failed!");			throw new UtestFailedException();		}		if(!cards.removeAll(cardsOut)) {			Print.p("UTest failed: toString() failed!");			throw new UtestFailedException();		}		if(!cards.toString().equals("43"))		{			Print.p("UTest failed: toString() failed!");			throw new UtestFailedException();		}		if(cards.removeAll(cardsOut)) {			Print.p("UTest failed: toString() failed!");			throw new UtestFailedException();		}		if(!cards.toString().equals("43"))		{			Print.p("UTest failed: toString() failed!");			throw new UtestFailedException();		}		Print.p("UTest passed");	}}