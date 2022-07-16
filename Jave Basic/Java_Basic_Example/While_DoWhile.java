package Java_Basic_Example;
import java.util.Scanner;
import org.testng.annotations.Test;

public class While_DoWhile {
	Scanner scanner = new Scanner(System.in);

	public void TC_01_While() {
		int number = scanner.nextInt();
		while (number < 100) {
			if (number % 2 == 0) {
				System.out.println(number);
			}
			number++;
		}
	}

	public void TC_02_Do_While() {
		//Đề bài : in ra số chẵn
		int number1 = scanner.nextInt();
		do {
			if (number1 % 2 == 0) {
				System.out.println(number1);
				number1++;
			}
		} while (number1 < 100);
	}
	@Test
	public void TC_05_Excersice3() {
		//Đề bài : nhập số nguyên n từ bàn phím , hiển thị tổng các số lẻ từ 0-n
		int number = scanner.nextInt();
		int operator = 0;
		while (number > 0) {
			if (number % 2 != 0) {
				operator += number;
				// operator = operator + number
			}
			number--;
		}
		System.out.println(operator);
	}

	public void TC_06_Excersice4() {
		//Đề bài : nhập số nguyên a và b , in ra mh các số chia hết cho 3 và 5
		int numberA = scanner.nextInt();
        int numberB = scanner.nextInt();
		while (numberA < numberB) {
			if (numberA % 3 == 0 && numberA % 3 == 0 ) {
			    System.out.println(numberA);
			   
			}		
			 numberA ++ ;
		}
	}

    public void TC_07_Excersice5() {
		// Đề bài : tính giai thừa từ số nguyên n nhập từ bàn phím
		int number = scanner.nextInt();
		int operator = 1;
		while (number > 0) { {
				operator *= number;
				// operator = operator X number
			}
			number--;
		}
		System.out.println(operator);
	}
	
	
	//@Test -> đang sai
	public void TC_08_Excersice6() {
		// Đề bài :in ra console tổng các số chẵn từ dãy số nguyên có độ lớn 1 - 10
		int number = scanner.nextInt();
	while (number < 10 ) {
		if (number % 2 == 0) {
			System.out.println(number);
			number--;
		}	
	}
	}
}