package Java_Basic_Example;
import org.testng.annotations.Test;

public class DataType_Casting_Operator {
	
public void TC_01() {
	int a = 6;
	int b = 2;
	System.out.println("Tong P1 =" + (a+b));
	System.out.println("Hieu P2 =" + (a-b));
	System.out.println("Tich P3 =" + (a*b));
	System.out.println("Thuong P4 =" + (a/b));
}

	
public void TC_02() {
		float dai = 7.5f;
		float rong = 3.8f ;
		System.out.println("Dien tich Hcn = " + (dai*rong));
		
	}
	
public void TC_03() {
			String name ="hello Automation testing";
			System.out.println(name);
			
		}

public void TC_04_Operator_Age() {
	String nameP1 ="Tuan";
	int ageP2 = 23 ;
	System.out.println("After 15 years , age of "+ nameP1 + " will be " +(ageP2+15) );
	}

public void TC_05_Operator_Swapping() {
	int a = 4 ;
	int b = 3 ;
	a = a + b;
	b = a - b ;
	a = a - b ;
	System.out.println("After swapping then a = " + a );
	System.out.println("After swapping then b = " + b );
}

@Test
public void TC_07_Operator_Condition() {
	int a = 5 ;
	int b = 4 ;
	boolean value = (a > b) ? true :false;
	System.out.println("Gia tri = " + value);
	
}
}
