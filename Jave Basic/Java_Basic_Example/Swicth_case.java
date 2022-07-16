package Java_Basic_Example;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Swicth_case {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Scanner scanner = new Scanner(System.in);

	@Parameters("browser")
	public void TC_01_Browser(String browserName) {
		switch (browserName) {
		case "chrome":
			System.setProperty("webdriver.gecko.driver", projectPath + "\\Browser\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", projectPath + "\\Browser\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "edge":
			System.setProperty("webdriver.gecko.driver", projectPath + "\\Browser\\geckodriver.exe");
			driver = new EdgeDriver();
			break;
		case "ie":
			System.setProperty("webdriver.gecko.driver", projectPath + "\\Browser\\geckodriver.exe");
			driver = new InternetExplorerDriver();
			break;
		default:
			new RuntimeException("Please input correct the browser name!");
			break;
		}
		System.out.println(browserName);
		System.out.println(driver.toString());
		driver.quit();
	}

	public void TC_02() {
		int month = scanner.nextInt();
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println("This month has 31 days");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("This month has 30 days");
			break;
		case 2:
			System.out.println("This month has 28 days");
			break;

		default:
			System.out.println("Tháng vừa nhập sai định dạng !");
			break;
		}
	}

	public void TC_03() {
		int number = scanner.nextInt();
		switch (number) {
		case 1:
			System.out.println("One");
			break;
		case 3:
			System.out.println("Three");
			break;
		case 5:
			System.out.println("Five");
			break;
		case 7:
			System.out.println("Seven");
			break;
		case 8:
			System.out.println("Eight");
			break;
		case 10:
			System.out.println("Ten");
			break;
		case 4:
			System.out.println("Four");
			break;
		case 6:
			System.out.println("Six");
			break;
		case 9:
			System.out.println("Nine");
			break;
		case 2:
			System.out.println("Two");
			break;
		default:
			System.out.println("Please re-enter");
			break;
		}
	}

	public void TC_04() {
		String operator = scanner.nextLine();
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		switch (operator) {
		case "+" :
			System.out.println("a + b = " + (a + b));
			break;
		case "-" :
			System.out.println("a - b = " + (a - b));
			break;
		case "*" :
			System.out.println("a  b = " + (a * b));
			break;
		case "/" :
			System.out.println("a / b = " + (a / b));
			break;
		case "%" :
			System.out.println("a % b = " + (a % b));
			break;
		default:
			System.out.println("Vui lòng nhập đúng định dạng!");
			break;
		}
}
}