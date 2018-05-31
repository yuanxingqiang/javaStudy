package com.dzwn.pocker;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Player {
    private String name;
    private List<Map<String,Object>> handCards;
    private String playerType;
    
    /**
     * 初始构造方法
     */
    public Player(){}
    
    /**
     * 新建构造方法，初始化玩家，输出玩家的姓名。
     * @param type 玩家类型，0为人类，1为电脑
     */
    public Player(int type){
    	if(type==0){
    		Scanner sc = new Scanner(System.in);
    		System.out.println("请输入您的姓名：");
    		name = sc.next();
    		handCards = new ArrayList<Map<String,Object>>();
    		playerType = "玩家";
    	}else{
    		String[] chars = {"子","寅","卯","辰","未","申","丁","己","辛","壬","一","三","天","乾","坤","月","风","雷","山","泽","震","兑"};
    		Random random = new Random();
    		int middleNameNumber = random.nextInt(chars.length-1);
    		int lastNameNumber = random.nextInt(chars.length-1);
    		name = chars[middleNameNumber]+chars[lastNameNumber];
    		handCards = new ArrayList<Map<String,Object>>();
    		playerType = "电脑"+type;
    	}
    	System.out.println(playerType+"姓名："+name);
    }
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Map<String,Object>> getHandCards() {
		return handCards;
	}
	public void setHandCards(List<Map<String,Object>> handCards) {
		this.handCards = handCards;
	}
	
	public Map<String,Object> getBiggerCard(){
		if((int)handCards.get(0).get("num")>(int)handCards.get(1).get("num")){
			return handCards.get(0);
		}else{
			return handCards.get(1);
		}
	}
}
