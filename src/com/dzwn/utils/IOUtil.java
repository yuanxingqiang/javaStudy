package com.dzwn.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class IOUtil {
	
	/**
	 * 读取指定文件内容，按照16进制输出到控制台
	 * 并且每输出10byte换行
	 * @param fileName 被读取的文件
	 * @throws IOException IO异常
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
	
	/**
	 * 读取指定文件内容，按照16进制输出到控制台(使用byte数组方式读取)
	 * 并且每输出10byte换行
	 * @param fileName 被读取的文件
	 * @throws IOException IO异常
	 */
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
	
	/**
	 * 将文件复制一份（字节流，可以复制任何文件）
	 * @param srcFile 复制的源文件
	 * @param destFile 复制的目标文件
	 * @throws IOException IO异常
	 */
	public static void copyFile(File srcFile,File destFile)throws IOException{
		if(!srcFile.exists()){
			throw new IllegalArgumentException("文件："+srcFile+"不存在");
		}
		if(!srcFile.isFile()){
			throw new IllegalArgumentException(srcFile+"不是文件");
		}
		FileInputStream in = new FileInputStream(srcFile);
		FileOutputStream out = new FileOutputStream(destFile,true);//加true是追加写
		byte[] buf = new byte[8*1024];
		int b;
		while((b = in.read(buf,0,buf.length))!=-1){
			out.write(buf,0,b);
			out.flush();//最好加上
		}
		in.close();
		out.close();
		
	}
	
	/**
	 * 将文本文件复制一份（字符转换流，只能复制文本文件）
	 * @param srcFile 复制的源文件
	 * @param destFile 复制的目标文件
	 * @throws IOException IO异常
	 */
	public static void copyTextFile(File srcFile,File destFile)throws IOException{
		if(!srcFile.exists()){
			throw new IllegalArgumentException("文件："+srcFile+"不存在");
		}
		if(!srcFile.isFile()){
			throw new IllegalArgumentException(srcFile+"不是文件");
		}
		FileInputStream in = new FileInputStream(srcFile);
		FileOutputStream out = new FileOutputStream(destFile,true);//加true是追加写
		InputStreamReader isr = new InputStreamReader(in,"utf-8");
		OutputStreamWriter osw = new OutputStreamWriter(out,"utf-8");
		char[] buf = new char[8*1024];
		int i;
		while((i=isr.read(buf))!=-1){
			osw.write(buf,0,i);
			osw.flush();
		}
		osw.close();
		isr.close();
		out.close();
		in.close();
	}
	
	/**
	 * 利用带缓冲的字节流进行文件拷贝
	 * @param srcFile
	 * @param destFile
	 * @throws IOException
	 */
	public static void copyFileByBuffer(File srcFile, File destFile)throws IOException{
		if(!srcFile.exists()){
			throw new IllegalArgumentException("文件："+srcFile+"不存在");
		}
		if(!srcFile.isFile()){
			throw new IllegalArgumentException(srcFile+"不是文件");
		}
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));
		int c;
		while((c = bis.read())!=-1){
			bos.write(c);
			bos.flush();//刷新缓冲区，必须写这一步，否则无法将字节放入缓冲区
		}
		bos.close();
		bis.close();
	}
	
	
	/**
	 * 将文本文件复制一份（字符流，只能复制文本文件）
	 * @param srcFile 源文件路径及文件名
	 * @param destFile 目标文件路径及文件名
	 * @throws IOException IO异常
	 */
	public static void copyTextFile(String srcFile,String destFile)throws IOException{
		if(!new File(srcFile).exists()){
			throw new IllegalArgumentException("文件："+srcFile+"不存在");
		}
		if(!new File(srcFile).isFile()){
			throw new IllegalArgumentException(srcFile+"不是文件");
		}
		FileReader fr = new FileReader(srcFile);
		FileWriter fw = new FileWriter(destFile,true);//加true是追加写
		char[] buf = new char[8*1024];
		int i;
		while((i=fr.read(buf))!=-1){
			fw.write(buf,0,i);
			fw.flush();
		}
		fw.close();
		fr.close();
	}
	
	/**
	 * 使用字符流的过滤器复制文件
	 * @param srcFile
	 * @param destFile
	 * @throws IOException
	 */
	public static void brAndbwOrPw(String srcFile,String destFile)throws IOException{
		if(!new File(srcFile).exists()){
			throw new IllegalArgumentException("文件："+srcFile+"不存在");
		}
		if(!new File(srcFile).isFile()){
			throw new IllegalArgumentException(srcFile+"不是文件");
		}
		FileInputStream fis = new FileInputStream(srcFile);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		
		//以下两种构造分别为BufferedWriter的和PrintWritter的构造过程
//		FileOutputStream fos = new FileOutputStream(destFile);
//		OutputStreamWriter osw = new OutputStreamWriter(fos);
//		BufferedWriter bw = new BufferedWriter(osw);
		
		PrintWriter pw = new PrintWriter(destFile);
		
		
		String line;
		while((line = br.readLine()/*一次读一行*/)!=null){
			
			//以下分别为BufferedWriter的和PrintWritter的写流的过程
//			bw.write(line);
//			bw.newLine();//换行操作
//			bw.flush();
			
			pw.println(line);//自动换行
		}
		//与之对应的关闭资源
//		bw.close();
		pw.close();
		br.close();
	}

}
