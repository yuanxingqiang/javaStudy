package com.dzwn.pocker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PockerCards {
	private Map<String,String> cards;
	
	
	public Map<String,String> getCards() {
		return cards;
	}


	public void setCards(Map<String,String> cards) {
		this.cards = cards;
	}
	
	/**
	 * 初始化扑克牌
	 */
	public PockerCards(){
		System.out.println("初始化扑克牌......");
		cards = new HashMap<String,String>();
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
				String num = "";
				if(j==0){
				    num="A";	
				}else if(j<10){
					num=j+1+"";
				}else if(j==10){
					num="J";
				}else if(j==11){
					num="Q";
				}else if(j==12){
					num="K";
				}
				Map<String,String> card = new HashMap<String,String>();
				cards.put(type, num);
			}
		}
		cards.put("小王", "小王");
		cards.put("大王", "大王");
		
		System.out.println("扑克牌初始化完毕！");
	}
}
