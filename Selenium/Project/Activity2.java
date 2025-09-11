package HRMProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {
    public static void main(String[] args) {
        // Set the path to geckodriver if needed
        // System.setProperty("webdriver.gecko.driver", "path/to/geckodriver.exe");

        // Initialize Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Navigate to the URL
        driver.get("http://alchemy.hguy.co/orangehrm");

        // Find the header image element (update the selector if needed)
        WebElement headerImage = driver.findElement(By.xpath("//div[@id='divLogo']/img"));

        // Get the src attribute (URL) of the image
        String imageUrl = headerImage.getAttribute("src");
        System.out.println("Header image URL: " + imageUrl);

        // Close the browser
        driver.quit();
    }
}