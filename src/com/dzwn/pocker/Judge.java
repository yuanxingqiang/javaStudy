package com.dzwn.pocker;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class Judge {
	
	/**
	 * 裁判发牌程序
	 * @param pc 初始化好的扑克牌
	 * @param p1  玩家（人类）
	 * @param p2  玩家（电脑）
	 * @return String 返回字符串发牌完毕
	 */
	public String deal(PockerCards pc,Player p1,Player p2){
		Map<String,String> cards = pc.getCards();
		for(int i=0;i<4;i++){
			Random random = new Random();
			int cardNumber = random.nextInt(cards.size()-1);
			if(i%2==0){
				p1.getHandCards()(cards.get(cardNumber));
				cards.remove(cardNumber);
			}else{
				p2.getHandCards().add(cards.get(cardNumber));
				cards.remove(cardNumber);
			}
		}
		return "发牌完毕！";
	}
	
	public String compare(Player p1,Player p2){
		String p1sCard1 = p1.getHandCards().get(0).substring(p1.getHandCards().get(0).length()-1, p1.getHandCards().get(0).length());
		String p1sCard2 = p1.getHandCards().get(1).substring(p1.getHandCards().get(1).length()-1, p1.getHandCards().get(0).length());
		String p2sCard1 = p2.getHandCards().get(0).substring(p2.getHandCards().get(0).length()-1, p2.getHandCards().get(0).length());
		String p2sCard2 = p2.getHandCards().get(1).substring(p2.getHandCards().get(1).length()-1, p2.getHandCards().get(0).length());
		
		int p1sMaxCard = string2int(p1sCard1)>string2int(p1sCard2)?string2int(p1sCard1):string2int(p1sCard2);
		int p2sMaxCard = string2int(p1sCard1)>string2int(p1sCard2)?string2int(p1sCard1):string2int(p1sCard2);
		
		return "A";
	}
	
	/**
	 * 将扑克牌点数由字母转换成数字
	 * @param card 扑克牌的字母
	 * @return 扑克牌点数对应的数字
	 */
	private int string2int(String card){
		int cardsInt=0;
		if(card.equals("A")){
			cardsInt=1;
		}else if(card.equals("J")){
			cardsInt=11;
		}else if(card.equals("Q")){
			cardsInt=12;
		}else if(card.equals("K")){
			cardsInt=13;
		}else if(card.equals("小王")){
			cardsInt=14;
		}else if(card.equals("大王")){
			cardsInt=15;
		}else{
			cardsInt=Integer.parseInt(card);
		}
		
		return cardsInt;
	}
	
}
