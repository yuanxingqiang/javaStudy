package com.dzwn.utils;

import java.io.File;
import java.io.IOException;

public class IOUtilTest1 {

	public static void main(String[] args) {
		try {
			//IOUtil.printHex("F:\\demo1\\exam.txt");
//			File srcFile = new File("F:\\小说\\三体\\三体1.txt");
//			File destFile = new File("F:\\小说\\三体\\三体副本副本.txt");
//			IOUtil.copyTextFile(srcFile, destFile);
//			IOUtil.copyFileByBuffer(srcFile, destFile);
			IOUtil.brAndbwOrPw("F:\\小说\\三体\\三体1.txt", "F:\\小说\\三体\\三体副本副本.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
