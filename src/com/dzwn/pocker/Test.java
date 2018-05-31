package com.dzwn.pocker;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PockerCards pc = new PockerCards();//初始化扑克牌
		Player p1 = new Player(0);
		Player p2 = new Player(1);
		
		System.out.println("准备好了吗？y/n");
		String ready = sc.next();
		if(ready.equals("y"))
		System.out.println("开始发牌......");
		Judge jd = new Judge();
		System.out.println(jd.deal(pc, p1, p2));
		System.out.println("你的手牌：");
		for(int i=0;i<p1.getHandCards().size();i++){
			System.out.print(p1.getHandCards().get(i).get+"	");
		}
		
		System.out.println(jd.compare(p1, p2));
		jd.showCards(p1, p2);
		

	}

}
