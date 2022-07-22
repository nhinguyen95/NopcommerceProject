package Java_Basic_Example;
import java.util.Iterator;
import java.util.Scanner;
import org.testng.annotations.Test;

public class For_ForEach {
	Scanner scanner = new Scanner(System.in);

	public void TC_01_For_Ex3() {
		int number = scanner.nextInt();
		for (int i = number; i < 100; i++) {
			if (i % 2 == 0) {
				System.out.println(i);
			}
		}
	}

	public void TC_02_For_Ex7() {
		// Đề bài : in giai thừa số nguyên được nhập vào từ bàn phím
		int number = scanner.nextInt();
		int operator = 1;
		for (int i = 1; i <= number; i++) {
			operator *= i;
		}
		System.out.println("Giai thua cua so " + number + " la : " + operator);
	}

	public void TC_03_For_Ex1() {
		// Đề bài :nhập số nguyên n từ bàn phím và hiển thị ra các số từ 1 đến n
		int number = scanner.nextInt();
		for (int i = 0; i <= number; i++) {
			System.out.println(i);

		}
	}

	public void TC_04_For_Ex2() {
		// Đề bài :nhập số nguyên a,b từ bàn phím và hiển thị ra các số từ a đến b
		int numberA = scanner.nextInt();
		int numberB = scanner.nextInt();
		for (int i = numberA; i <= numberB; i++) {
			System.out.println(i);
		}
	}

	public void TC_04_For_Ex3() {
		// Đề bài : in ra tổng các số chẵn từ dãy số nguyên có độ lớn từ 1 đến 10
		int numberA = scanner.nextInt();
		for (int i = 1; i <= numberA; i++) {
			if (i % 2 == 0) {
				System.out.println(i);
			}
		}
	}

	// @Test -> đang sai
	public void TC_05_For_Ex4() {
		// Đề bài : nhập từ bàn phím số nguyên a , b - hiển thị ra tổng các số từ a - b
		int numberA = scanner.nextInt();
		int numberB = scanner.nextInt();
		int tong = 0;
		for (int i = numberA; i < numberB; i++) {
			// Đang sai đk này -> làm lại
			tong += i;
			System.out.println(i);
		}
	}

	// @Test-> đang sai
	public void TC_06_For_Ex5() {
		// Đề bài : nhập từ bàn phím số nguyên n - hiển thị ra tổng các số lẻ từ 0 -n
		int number = scanner.nextInt();
		int operator = 0;
		for (int i = number; i > 0; i++) {
			if (i % 2 != 0) {
				operator += i;
				System.out.println(operator);
			}
		}
	}

	public void TC_07_For_Ex6() {
		// Đề bài : nhập từ bàn phím số nguyên a , b - hiển thị ra tổng các số từ a - b
		int numberA = scanner.nextInt();
		int numberB = scanner.nextInt();
		int tong = 0;
		for (int i = numberA; i <= numberB; i++) {
			if (i % 3 == 0) {
				System.out.println(i);
			}
		}
	}

}
