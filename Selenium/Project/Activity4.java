package HRMProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4 {
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

        // Click on PIM menu
        driver.findElement(By.id("menu_pim_viewPimModule")).click();

        // Click Add Employee
        driver.findElement(By.id("menu_pim_addEmployee")).click();

        // Fill in employee details
        String firstName = "John";
        String lastName = "Doe";
        driver.findElement(By.id("firstName")).sendKeys(firstName);
        driver.findElement(By.id("lastName")).sendKeys(lastName);

        // Save employee
        driver.findElement(By.id("btnSave")).click();

        // Go back to Employee List
        driver.findElement(By.id("menu_pim_viewEmployeeList")).click();

        // Search for the new employee
        driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys(firstName + " " + lastName);
        driver.findElement(By.id("searchBtn")).click();

        // Verify employee is listed
        boolean isEmployeePresent = driver.findElements(By.xpath("//a[text()='" + firstName + "']")).size() > 0;
        if (isEmployeePresent) {
            System.out.println("Employee " + firstName + " " + lastName + " added successfully.");
        } else {
            System.out.println("Employee not found in the list.");
        }

        // Close the browser
        driver.quit();
    }
}
