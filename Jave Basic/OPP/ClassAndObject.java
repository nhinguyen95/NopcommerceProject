package OPP;

import org.apache.commons.collections4.Get;
import org.testng.annotations.Test;

public class ClassAndObject {
//Viết chương trình quản lý SV : Nhập/xuất thông tin/tính điểm TB

private String studentName;
private int studentID;
private float knowledgePoint;
private float practicePoint;
private float getAveragePoint;

public String getStudentName() {
	return studentName;
}
public void setStudentName(String studentName) {
	this.studentName = studentName;
}
public int getStudentID() {
	return studentID;
}
public void setStudentID(int studentID) {
	this.studentID = studentID;
}
public float getKnowledgePoint() {
	return knowledgePoint;
}
public void setKnowledgePoint(float knowledgePoint) {
	this.knowledgePoint = knowledgePoint;
}
public float getPracticePoint() {
	return practicePoint;
}
public void setPracticePoint(float practicePoint) {
	this.practicePoint = practicePoint;
}
private float getAveragePoint() {
	return (this.knowledgePoint + this.practicePoint * 2) /3;
}
private void showStudentInfor() {
	System.out.println("*********************************");
	System.out.println("Student ID = " + getStudentID());
	System.out.println("Student Name = " + getStudentName());
	System.out.println("Student Knowledge Point = " + getKnowledgePoint());
	System.out.println("Student Practice Point = " + getPracticePoint());
	System.out.println("Student Average Point = " + getAveragePoint());
	System.out.println("*********************************");
}
public static void main(String[] arg) {
	ClassAndObject student01 = new ClassAndObject();
	student01.setStudentID(01);
	student01.setStudentName("student first");
	student01.setKnowledgePoint(5.0f);
	student01.setPracticePoint(7.8f);
	student01.showStudentInfor();
}
}
