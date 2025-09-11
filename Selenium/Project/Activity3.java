package HRMProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {
    public static void main(String[] args) {
        // Set the path to geckodriver if needed
        // System.setProperty("webdriver.gecko.driver", "path/to/geckodriver.exe");

        // Initialize Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the OrangeHRM login page
        driver.get("http://alchemy.hguy.co/orangehrm");

        // Find username and password fields and enter credentials
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");

        // Click the login button
        driver.findElement(By.id("btnLogin")).click();

        // Verify that the homepage has opened (check for presence of dashboard)
        boolean isDashboardPresent = driver.findElement(By.id("menu_dashboard_index")).isDisplayed();
        if (isDashboardPresent) {
            System.out.println("Login successful. Homepage is displayed.");
        } else {
            System.out.println("Login failed or homepage not displayed.");
        }

        // Close the browser
        driver.quit();
    }
}
