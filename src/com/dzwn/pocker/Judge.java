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
		List<Map<String,Object>> cards = pc.getCards();
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
		return "发牌完毕！";
	}
	
	/**
	 * 比谁的点数大
	 * @param p1 玩家
	 * @param p2 电脑
	 * @return 比牌大小的结果
	 */
	public String compare(Player p1,Player p2){
		String result = "";
		if((int)p1.getBiggerCard().get("num")>(int)p2.getBiggerCard().get("num")){
			result = p1.getName()+"赢";
		}else if((int)p1.getBiggerCard().get("num")<(int)p2.getBiggerCard().get("num")){
			result = p2.getName()+"赢";
		}else if((int)p1.getBiggerCard().get("num")==(int)p2.getBiggerCard().get("num")){
			if(p1.getBiggerCard().get("type").equals("♠黑桃")){
				result =  p1.getName()+"赢";
			}else if(p1.getBiggerCard().get("type").equals("♥红心") && (p2.getBiggerCard().get("type").equals("♣梅花") || p2.getBiggerCard().get("type").equals("♦方片"))){
				result =  p1.getName()+"赢";
			}else if(p1.getBiggerCard().get("type").equals("♣梅花") && p2.getBiggerCard().get("type").equals("♦方片")){
				result =  p1.getName()+"赢";
			}else{
				result =  p2.getName()+"赢";
			}
		}
		return result;
	}
	
	/**
	 * 展示两位玩家的手牌
	 * @param p1 玩家
	 * @param p2 电脑
	 */
	public void showCards(Player p1,Player p2){
		System.out.println(p1.getName()+"的手牌："+p1.getHandCards().get(0).get("type")+p1.getHandCards().get(0).get("num")+"、"+p1.getHandCards().get(1).get("type")+p1.getHandCards().get(1).get("num"));
		System.out.println(p2.getName()+"的手牌："+p2.getHandCards().get(0).get("type")+p2.getHandCards().get(0).get("num")+"、"+p2.getHandCards().get(1).get("type")+p2.getHandCards().get(1).get("num"));
	}

	
}
