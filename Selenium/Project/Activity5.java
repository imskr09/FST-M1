package HRMProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity5 {
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

        // Click Edit button
        driver.findElement(By.id("btnSave")).click();

        // Edit Name fields
        driver.findElement(By.id("personal_txtEmpFirstName")).clear();
        driver.findElement(By.id("personal_txtEmpFirstName")).sendKeys("Jane");
        driver.findElement(By.id("personal_txtEmpLastName")).clear();
        driver.findElement(By.id("personal_txtEmpLastName")).sendKeys("Smith");

        // Select Gender (Female)
        driver.findElement(By.id("personal_optGender_2")).click();

        // Select Nationality
        Select nationality = new Select(driver.findElement(By.id("personal_cmbNation")));
        nationality.selectByVisibleText("Indian");

        // Set Date of Birth
        driver.findElement(By.id("personal_DOB")).clear();
        driver.findElement(By.id("personal_DOB")).sendKeys("1990-01-01");

        // Save changes
        driver.findElement(By.id("btnSave")).click();

        // Close the browser
        driver.quit();
    }
}