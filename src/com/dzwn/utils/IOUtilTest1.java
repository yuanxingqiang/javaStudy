package com.dzwn.utils;

import java.io.IOException;

public class IOUtilTest1 {

	public static void main(String[] args) {
		try {
			IOUtil.printHex("F:\\demo1\\exam.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
