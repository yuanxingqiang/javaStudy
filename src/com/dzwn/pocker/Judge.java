package com.dzwn.pocker;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class Judge {
	
	/**
	 * ���з��Ƴ���
	 * @param pc ��ʼ���õ��˿���
	 * @param p1  ��ң����ࣩ
	 * @param p2  ��ң����ԣ�
	 * @return String �����ַ����������
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
		return "������ϣ�";
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
	 * ���˿��Ƶ�������ĸת��������
	 * @param card �˿��Ƶ���ĸ
	 * @return �˿��Ƶ�����Ӧ������
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
		}else if(card.equals("С��")){
			cardsInt=14;
		}else if(card.equals("����")){
			cardsInt=15;
		}else{
			cardsInt=Integer.parseInt(card);
		}
		
		return cardsInt;
	}
	
}
