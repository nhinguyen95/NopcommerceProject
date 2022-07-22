package Java_Basic_Example;

import java.util.Scanner;
import org.testng.annotations.Test;

public class Condition_Statement_If_Else {
	Scanner scanner = new Scanner(System.in);

	public void TC_01() {

		int number = scanner.nextInt();
		if (number % 2 == 0) {
			System.out.println("Số : " + number + "là số chẵn");
		} else {
			System.out.println("Số : " + number + "là số lẻ");
		}
	}

	public void TC_02() {
		int numberA = scanner.nextInt();
		int numberB = scanner.nextInt();
		if (numberA >= numberB) {
			System.out.println(numberA + "lớn hơn hoặc bằng" + numberB);
		} else {
			System.out.println(numberA + "nhỏ hơn" + numberB);
		}
	}

	public void TC_03() {
		int A = scanner.nextInt();
		int B = scanner.nextInt();
		int C = scanner.nextInt();
		if (A > B && A > C) {
			System.out.println("Số lớn nhất là " + A);
		} else if (B > C) {
			System.out.println("Số lớn nhất là " + B);
		} else {
			System.out.println("Số lớn nhất là " + C);
		}
	}

	public void TC_04() {
		String nameA = scanner.nextLine();
		String nameB = scanner.nextLine();
		// Reference : String
		// Kiểm tra cái value của biến
		// Kiểm tra vị trí của biến trong vùng nhớ
		if (nameA.equals(nameB)) {
			System.out.println("Hai tên giống nhau");
		} else {
			System.out.println("Hai tên khác nhau");
		}
		// Dùng == cho kiểu dữ liệu nguyên thủy
		// kiểm tra value của biến
		/*
		 * if (nameA == nameB) { System.out.println("Hai tên giống nhau"); }else {
		 * System.out.println("Hai tên khác nhau"); }
		 */
	}

	public void TC_05() {
		int a = scanner.nextInt();
		if (10 < a && a < 100) {
			System.out.println(a + "Số nằm trong khoảng từ 10 -> 100");
		} else {
			System.out.println(a + "Số không nằm trong khoảng từ 10 -> 100");
		}
	}

	public void TC_06() {
		float studentPoint = scanner.nextFloat();
		if (studentPoint >= 8.5 && studentPoint <= 10) {
			System.out.println(studentPoint + " Rank A");
		} else if (studentPoint >= 7.5 && studentPoint < 8.5) {
			System.out.println(studentPoint + " is Rank B");
		} else if (studentPoint >= 5 && studentPoint < 7.5) {
			System.out.println(studentPoint + " is Rank C");
		} else if (studentPoint >= 0 && studentPoint < 5) {
			System.out.println(studentPoint + " is Rank D");
		} else {
			System.out.println("please re-enter");
		}
	}

	@Test
	public void TC_07() {
		int month = scanner.nextInt();
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			System.out.println("This month has 31 days");
		} else if (month == 4 || month == 6 || month == 9 || month == 11) {
			System.out.println("This month has 30 days");
		} else if (month == 2) {
			System.out.println("This month has 28 days");
		}
	}
}
