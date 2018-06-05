package com.dzwn.utils;

import java.io.File;
import java.io.IOException;

public class IOUtilTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			IOUtil.copyFile(new File("D:\\adcfg.json"), new File("D:\\adcfg1.json"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
