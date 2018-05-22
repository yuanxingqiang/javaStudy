package com.dzwn.pocker;

import java.util.ArrayList;
import java.util.List;

public class PockerCards {
	private List<String> cards;
	
	
	public List<String> getCards() {
		return cards;
	}


	public void setCards(List<String> cards) {
		this.cards = cards;
	}


	public PockerCards(){
		System.out.println("初始化扑克牌......");
		cards = new ArrayList<String>();
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
				cards.add(type+num);
			}
		}
		cards.add("大王");
		cards.add("小王");
		System.out.println("扑克牌初始化完毕！");
	}
}
