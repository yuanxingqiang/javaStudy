package com.dzwn.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.dzwn.school.Student;

public class ObjectSerializeDemo {

	public static void main(String[] args)throws Exception {
		String file = "F:\\С˵\\����\\demo\\obj.dat";
		//1.��������л�
//		FileOutputStream fos = new FileOutputStream(file);
//		ObjectOutputStream oos = new ObjectOutputStream(fos);
//		Student student = new Student("10001","����",20);
//		oos.writeObject(student);
//		oos.flush();
//		oos.close();
		
		//2.����ķ����л�
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Student stu = (Student)ois.readObject();
		System.out.println(stu);
		ois.close();
	}

}
