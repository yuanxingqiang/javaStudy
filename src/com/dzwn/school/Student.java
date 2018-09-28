package com.dzwn.school;

import java.io.Serializable;

public class Student implements Serializable{
    private String studentId;
    private String studentName;
    
    //ע�⣡�����������transient���Σ�
    private transient int studentAge;//��Ԫ�ز������jvmĬ�ϵ����л�������������Լ��ƶ������л�
    
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
	
	//transient���л�����ǩ��
	private void writeObject(java.io.ObjectOutputStream s)throws java.io.IOException{
	    s.defaultWriteObject();//��jvm��Ĭ�����л���Ԫ�ؽ������л�����
	    s.writeInt(studentAge);//�Լ����studentAge�����л�
	}
	
	//transient�����л��ķ���
	private void readObject(java.io.ObjectInputStream s)throws java.io.IOException, ClassNotFoundException{
		s.defaultReadObject();//��jvm��Ĭ�Ϸ����л���Ԫ�ؽ��з����л�����
		this.studentAge = s.readInt();//�Լ����studentAge�ķ����л�
	}
}
