package com.dzwn.pocker;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PockerCards pc = new PockerCards();//��ʼ���˿���
		Player p1 = new Player(0);
		Player p2 = new Player(1);
		
		System.out.println("׼��������y/n");
		String ready = sc.next();
		if(ready.equals("y"))
		System.out.println("��ʼ����......");
		Judge jd = new Judge();
		System.out.println(jd.deal(pc, p1, p2));
		System.out.println("������ƣ�");
		for(int i=0;i<p1.getHandCards().size();i++){
			System.out.print((String)p1.getHandCards().get(i).get("type")+p1.getHandCards().get(i).get("point")+" ");
		}
		System.out.println("");
		System.out.println(jd.compare(p1, p2));
		jd.showCards(p1, p2);
		

	}

}
