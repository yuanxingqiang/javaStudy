package com.dzwn.pocker;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Player {
    private String name;
    private Map<String,String> handCards;
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
    		handCards = new HashMap<String,String>();
    		playerType = "���";
    	}else{
    		String[] chars = {"��","��","î","��","δ","��","��","��","��","��","һ","��","��","Ǭ","��","��","��","��","ɽ","��","��","��"};
    		Random random = new Random();
    		int middleNameNumber = random.nextInt(chars.length-1);
    		int lastNameNumber = random.nextInt(chars.length-1);
    		name = chars[middleNameNumber]+chars[lastNameNumber];
    		handCards = new HashMap<String,String>();
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
	public Map<String,String> getHandCards() {
		return handCards;
	}
	public void setHandCards(Map<String,String> handCards) {
		this.handCards = handCards;
	}
}
