package com.dzwn.utils;

import java.io.File;
import java.io.IOException;

public class IOUtilTest1 {

	public static void main(String[] args) {
		try {
			//IOUtil.printHex("F:\\demo1\\exam.txt");
			File srcFile = new File("F:\\С˵\\����\\����1.txt");
			File destFile = new File("F:\\С˵\\����\\���帱������.txt");
			IOUtil.copyTextFile(srcFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
