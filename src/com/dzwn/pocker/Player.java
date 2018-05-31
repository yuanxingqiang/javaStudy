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
     * ��ʼ���췽��
     */
    public Player(){}
    
    /**
     * �½����췽������ʼ����ң������ҵ�������
     * @param type ������ͣ�0Ϊ���࣬1Ϊ����
     */
    public Player(int type){
    	if(type==0){
    		Scanner sc = new Scanner(System.in);
    		System.out.println("����������������");
    		name = sc.next();
    		handCards = new ArrayList<Map<String,Object>>();
    		playerType = "���";
    	}else{
    		String[] chars = {"��","��","î","��","δ","��","��","��","��","��","һ","��","��","Ǭ","��","��","��","��","ɽ","��","��","��"};
    		Random random = new Random();
    		int middleNameNumber = random.nextInt(chars.length-1);
    		int lastNameNumber = random.nextInt(chars.length-1);
    		name = chars[middleNameNumber]+chars[lastNameNumber];
    		handCards = new ArrayList<Map<String,Object>>();
    		playerType = "����"+type;
    	}
    	System.out.println(playerType+"������"+name);
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
