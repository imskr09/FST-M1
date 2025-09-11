package HRMProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Activity9 {
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

        // Navigate to "My Info"
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();

        // Click on "Emergency Contacts" in the left menu
        driver.findElement(By.linkText("Emergency Contacts")).click();

        // Retrieve all rows from the emergency contacts table
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='emgcontact_list']/tbody/tr"));

        // Print all information for each contact
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            for (WebElement cell : cells) {
                System.out.print(cell.getText() + " | ");
            }
            System.out.println();
        }

        // Close the browser
        driver.quit();
    }
}