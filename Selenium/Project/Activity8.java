package HRMProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity8 {
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

        // Navigate to Dashboard and click Apply Leave
        driver.findElement(By.id("menu_leave_viewLeaveModule")).click();
        driver.findElement(By.id("menu_leave_applyLeave")).click();

        // Select leave type
        driver.findElement(By.id("applyleave_txtLeaveType")).sendKeys("DayOff"); // Change as needed

        // Enter leave duration
        driver.findElement(By.id("applyleave_txtFromDate")).clear();
        driver.findElement(By.id("applyleave_txtFromDate")).sendKeys("2025-08-20");
        driver.findElement(By.id("applyleave_txtToDate")).clear();
        driver.findElement(By.id("applyleave_txtToDate")).sendKeys("2025-08-20");

        // Click Apply
        driver.findElement(By.id("applyBtn")).click();

        // Navigate to My Leave page to check status
        driver.findElement(By.id("menu_leave_viewMyLeaveList")).click();

        // Optionally, you can add code here to verify the status of the leave application

        // Close the browser
        driver.quit();
    }
}