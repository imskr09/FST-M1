package HRMProject;



	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;

	public class Activity1 {
	    public static void main(String[] args) {
	        // Set the path to geckodriver if needed
	        // System.setProperty("webdriver.gecko.driver", "path/to/geckodriver.exe");

	        // Initialize Firefox driver
	        WebDriver driver = new FirefoxDriver();

	        // Navigate to the URL
	        driver.get("http://alchemy.hguy.co/orangehrm");

	        // Get the title of the website
	        String title = driver.getTitle();
	        System.out.println("Website title is: " + title);

	        // Verify the title matches exactly
	        if (title.equals("OrangeHRM")) {
	            System.out.println("Title matches 'OrangeHRM'. Closing browser.");
	        } else {
	            System.out.println("Title does not match. Found: " + title);
	        }

	        // Close the browser
	        driver.quit();
	    }
	}
