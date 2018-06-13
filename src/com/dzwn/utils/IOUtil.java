package com.dzwn.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IOUtil {
	
	/**
	 * ��ȡָ���ļ����ݣ�����16�������������̨
	 * ����ÿ���10byte����
	 * @param fileName ����ȡ���ļ�
	 * @throws IOException IO�쳣
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
	
	/**
	 * ��ȡָ���ļ����ݣ�����16�������������̨(ʹ��byte���鷽ʽ��ȡ)
	 * ����ÿ���10byte����
	 * @param fileName ����ȡ���ļ�
	 * @throws IOException IO�쳣
	 */
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
	
	/**
	 * ���ļ�����һ�ݣ��ֽ��������Ը����κ��ļ���
	 * @param srcFile ���Ƶ�Դ�ļ�
	 * @param destFile ���Ƶ�Ŀ���ļ�
	 * @throws IOException IO�쳣
	 */
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
	
	/**
	 * ���ı��ļ�����һ�ݣ��ַ�����ֻ�ܸ����ı��ļ���
	 * @param srcFile ���Ƶ�Դ�ļ�
	 * @param destFile ���Ƶ�Ŀ���ļ�
	 * @throws IOException IO�쳣
	 */
	public static void copyTextFile(File srcFile,File destFile)throws IOException{
		if(!srcFile.exists()){
			throw new IllegalArgumentException("�ļ���"+srcFile+"������");
		}
		if(!srcFile.isFile()){
			throw new IllegalArgumentException(srcFile+"�����ļ�");
		}
		FileInputStream in = new FileInputStream(srcFile);
		FileOutputStream out = new FileOutputStream(destFile,true);
		InputStreamReader isr = new InputStreamReader(in,"utf-8");
		OutputStreamWriter osw = new OutputStreamWriter(out,"utf-8");
		char[] c = new char[8*1024];
		int i;
		while((i=isr.read(c))!=-1){
			osw.write(c,0,i);
			osw.flush();
		}
		osw.close();
		isr.close();
		out.close();
		in.close();
	}

}
