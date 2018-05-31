package com.dzwn.pocker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PockerCards {
	//一套扑克牌
	private List<Map<String,Object>> cards;
	
	
	public List<Map<String,Object>> getCards() {
		return cards;
	}


	public void setCards(List<Map<String,Object>> cards) {
		this.cards = cards;
	}
	
	/**
	 * 初始化扑克牌
	 */
	public PockerCards(){
		System.out.println("初始化扑克牌......");
		cards = new ArrayList<Map<String,Object>>();
		for(int i=0;i<4;i++){
			for(int j=0;j<13;j++){
				String type="";
				if(i==0){
					type = "♠黑桃";
				}else if(i==1){
					type = "♥红心";
				}else if(i==2){
					type = "♣梅花";
				}else if(i==3){
					type = "♦方片";
				}
				String numString = "";
				if(j==0){
				    numString="A";	
				}else if(j<10){
					numString=j+1+"";
				}else if(j==10){
					numString="J";
				}else if(j==11){
					numString="Q";
				}else if(j==12){
					numString="K";
				}
				Map<String,Object> card = new HashMap<String,Object>();
				card.put(type, numString);
				card.put("num", j+1);
				cards.add(card);
			}
		}
		Map bigGhost = new HashMap<String,Object>();
		Map smallGhost = new HashMap<String,Object>();
		bigGhost.put("大王","大王");
		bigGhost.put("num",15);
		smallGhost.put("小王","小王");
		smallGhost.put("num",14);
		cards.add(bigGhost);
		cards.add(smallGhost);
		System.out.println("扑克牌初始化完毕！");
	}
}
