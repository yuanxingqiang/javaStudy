package com.dzwn.pocker;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Player {
    private String name;
    private List<String> handCards;
    private String playerType;
    
    public Player(){}
    public Player(int type){
    	if(type==0){
    		Scanner sc = new Scanner(System.in);
    		System.out.println("请输入您的姓名：");
    		name = sc.next();
    		handCards = new ArrayList<String>();
    		playerType = "玩家";
    	}else{
    		String[] chars = {"子","寅","卯","辰","未","申","丁","己","辛","壬","一","三","天","乾","坤","月","风","雷","山","泽","震","兑"};
    		Random random = new Random();
    		int middleNameNumber = random.nextInt(chars.length-1);
    		int lastNameNumber = random.nextInt(chars.length-1);
    		name = chars[middleNameNumber]+chars[lastNameNumber];
    		handCards = new ArrayList<String>();
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
	public List<String> getHandCards() {
		return handCards;
	}
	public void setHandCards(List<String> handCards) {
		this.handCards = handCards;
	}
}
