package com.dzwn.pocker;

import java.util.List;
import java.util.Random;

public class Judge {
	public String deal(PockerCards pc,Player p1,Player p2){
		List<String> cards = pc.getCards();
		for(int i=0;i<4;i++){
			Random random = new Random();
			int cardNumber = random.nextInt(cards.size()-1);
			if(i%2==0){
				p1.getHandCards().add(cards.get(cardNumber));
				cards.remove(cardNumber);
			}else{
				p2.getHandCards().add(cards.get(cardNumber));
				cards.remove(cardNumber);
			}
		}
		return "·¢ÅÆÍê±Ï£¡";
	}
}
