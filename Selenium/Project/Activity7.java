package HRMProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity7 {
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

        // Click on "My Info"
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();

        // Click on "Qualifications" in the left menu
        driver.findElement(By.linkText("Qualifications")).click();

        // Click "Add" button under Work Experience
        driver.findElement(By.id("addWorkExperience")).click();

        // Fill in Work Experience details
        driver.findElement(By.id("experience_employer")).sendKeys("ABC Corp");
        driver.findElement(By.id("experience_jobtitle")).sendKeys("Software Engineer");

        // Save Work Experience
        driver.findElement(By.id("btnWorkExpSave")).click();

        // Close the browser
        driver.quit();
    }
}