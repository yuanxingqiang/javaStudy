package com.dzwn.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOUtil {
	
	/**
	 * 读取制定文件内容，按照16进制输出到控制台
	 * 并且每输出10byte换行
	 * @param fileName
	 */
	public static void printHex(String fileName)throws IOException{
		//把文件作为字节流进行读操作
		FileInputStream in=new FileInputStream(fileName);
		int b;
		int i=0;
		while((b=in.read())!=-1){
			if(Math.abs(b)<=0xf){
				//单位数前面补0
				System.out.print("0");
			}
			System.out.print(Integer.toHexString(b&0xff)+" ");
			if(++i%10==0){
				System.out.println();
			}
		}
		in.close();
	}
	
	public static void printHexByByteArray(String fileName)throws IOException{
		FileInputStream in=new FileInputStream(fileName);
		byte[] buf=new byte[20*1024];
		
		/*
		 * 从in中批量读取字节，放入到buf字节数组中，从第
		 * 0个开始放，最多放buf.length个，返回的是读到的
		 * 字节的个数
		 */
//		int bytes=in.read(buf,0,buf.length);
//		int j=0;
//		for(int i=0;i<bytes;i++){
//			if(Math.abs(buf[i])<=0xf){
//				System.out.print("0");
//			}
//			System.out.print(Integer.toHexString(buf[i]&0xff)+" ");
//		}
		
		/*
		 * 若流内容太长，需要反复使用buf的算法
		 */
		int bytes=0;
		int j=0;
		while((bytes=in.read(buf,0,buf.length))!=-1){
			for(int i=0;i<bytes;i++){
				if(Math.abs(buf[i])<=0xf){
					System.out.print("0");
				}
				System.out.print(Integer.toHexString(buf[i]&0xff)+" ");
				if(++j%10==0){
					System.out.println();
				}
			}
		}
		
	}
	
	public static void copyFile(File srcFile,File destFile)throws IOException{
		if(!srcFile.exists()){
			throw new IllegalArgumentException("文件："+srcFile+"不存在");
		}
		if(!srcFile.isFile()){
			throw new IllegalArgumentException(srcFile+"不是文件");
		}
		FileInputStream in = new FileInputStream(srcFile);
		FileOutputStream out = new FileOutputStream(destFile,true);
		byte[] buf = new byte[8*1024];
		int b;
		while((b = in.read(buf,0,buf.length))!=-1){
			out.write(buf,0,b);
			out.flush();//最好加上
		}
		in.close();
		out.close();
		
	}

}
