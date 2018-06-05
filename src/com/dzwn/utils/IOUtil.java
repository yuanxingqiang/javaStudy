package com.dzwn.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOUtil {
	
	/**
	 * ��ȡ�ƶ��ļ����ݣ�����16�������������̨
	 * ����ÿ���10byte����
	 * @param fileName
	 */
	public static void printHex(String fileName)throws IOException{
		//���ļ���Ϊ�ֽ������ж�����
		FileInputStream in=new FileInputStream(fileName);
		int b;
		int i=0;
		while((b=in.read())!=-1){
			if(Math.abs(b)<=0xf){
				//��λ��ǰ�油0
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
		 * ��in��������ȡ�ֽڣ����뵽buf�ֽ������У��ӵ�
		 * 0����ʼ�ţ�����buf.length�������ص��Ƕ�����
		 * �ֽڵĸ���
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
		 * ��������̫������Ҫ����ʹ��buf���㷨
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
			throw new IllegalArgumentException("�ļ���"+srcFile+"������");
		}
		if(!srcFile.isFile()){
			throw new IllegalArgumentException(srcFile+"�����ļ�");
		}
		FileInputStream in = new FileInputStream(srcFile);
		FileOutputStream out = new FileOutputStream(destFile,true);
		byte[] buf = new byte[8*1024];
		int b;
		while((b = in.read(buf,0,buf.length))!=-1){
			out.write(buf,0,b);
			out.flush();//��ü���
		}
		in.close();
		out.close();
		
	}

}
