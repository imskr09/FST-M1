package HRMProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity6 {
    public static void main(String[] args) {
        // Set the path to geckodriver if needed
        // System.setProperty("webdriver.gecko.driver", "path/to/geckodriver.exe");

        // Initialize Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the OrangeHRM login page
        driver.get("http://alchemy.hguy.co/orangehrm");

        // Login
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();

        // Locate the Directory menu item
        WebElement directoryMenu = driver.findElement(By.id("menu_directory_viewDirectory"));

        // Verify visibility and clickability
        if (directoryMenu.isDisplayed() && directoryMenu.isEnabled()) {
            System.out.println("Directory menu is visible and clickable.");
            directoryMenu.click();

            // Verify the heading of the page
            WebElement heading = driver.findElement(By.xpath("//div[@class='head']/h1"));
            String headingText = heading.getText();
            if ("Search Directory".equals(headingText)) {
                System.out.println("Heading matches 'Search Directory'.");
            } else {
                System.out.println("Heading does not match. Found: " + headingText);
            }
        } else {
            System.out.println("Directory menu is not visible or not clickable.");
        }

        // Close the browser
        driver.quit();
    }
}
