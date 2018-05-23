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
    		System.out.println("����������������");
    		name = sc.next();
    		handCards = new ArrayList<String>();
    		playerType = "���";
    	}else{
    		String[] chars = {"��","��","î","��","δ","��","��","��","��","��","һ","��","��","Ǭ","��","��","��","��","ɽ","��","��","��"};
    		Random random = new Random();
    		int middleNameNumber = random.nextInt(chars.length-1);
    		int lastNameNumber = random.nextInt(chars.length-1);
    		name = chars[middleNameNumber]+chars[lastNameNumber];
    		handCards = new ArrayList<String>();
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
	public List<String> getHandCards() {
		return handCards;
	}
	public void setHandCards(List<String> handCards) {
		this.handCards = handCards;
	}
}
