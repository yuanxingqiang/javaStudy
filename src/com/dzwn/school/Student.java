package com.dzwn.school;

import java.io.Serializable;

public class Student implements Serializable{
    private String studentId;
    private String studentName;
    
    //注意！！！这里加了transient修饰！
    private transient int studentAge;//该元素不会进行jvm默认的序列化，但可以完成自己制定的序列化
    
    public Student(){}
    
    public Student(String studentId,String studentName,int studentAge){
        super();
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentAge = studentAge;
    }
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getStudentAge() {
		return studentAge;
	}
	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentAge=" + studentAge + "]";
	}
	
	//transient序列化方法签名
	private void writeObject(java.io.ObjectOutputStream s)throws java.io.IOException{
	    s.defaultWriteObject();//把jvm能默认序列化的元素进行序列化操作
	    s.writeInt(studentAge);//自己完成studentAge的序列化
	}
	
	//transient反序列化的方法
	private void readObject(java.io.ObjectInputStream s)throws java.io.IOException, ClassNotFoundException{
		s.defaultReadObject();//把jvm能默认反序列化的元素进行反序列化操作
		this.studentAge = s.readInt();//自己完成studentAge的反序列化
	}
}
