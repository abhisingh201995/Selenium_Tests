package SeleniumTricks;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle_Demo {
	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver", "Path to the driver");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		// Load the website
		driver.get("http://www.naukri.com/");

		// It will return the parent window name as a String
		String parent = driver.getWindowHandle();

		Set<String> s = driver.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> It = s.iterator();

		while (It.hasNext()) {

			String child_window = It.next();

			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);

				System.out.println(driver.switchTo().window(child_window).getTitle());

				driver.close();
			}

		}
		// switch to the parent window
		driver.switchTo().window(parent);

		// Minimize window with Robot class
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ALT);
		robot.keyPress(KeyEvent.VK_SPACE);
		robot.keyPress(KeyEvent.VK_N);
		robot.keyRelease(KeyEvent.VK_ALT);
		robot.keyRelease(KeyEvent.VK_SPACE);
		robot.keyRelease(KeyEvent.VK_N);

		// Minimize window with set position

		driver.manage().window().setPosition(new Point(-2000, 0));
}
}
