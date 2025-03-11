import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;

public class ClaroAutomation {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "libs/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        // Maximize the window to ensure full visibility of elements
        driver.manage().window().maximize();

        driver.get("https://www.usclaro.com/");

        try {
            // Step 1: Accept Cookies
            try {
                WebElement acceptCookies = wait.until(ExpectedConditions.elementToBeClickable(By.id("onetrust-accept-btn-handler")));
                acceptCookies.click();
                System.out.println("Cookies accepted!");
            } catch (TimeoutException e) {
                System.out.println("Cookies button not found or not needed.");
            }

            // Step 2: Hover over "Solutions" to display the submenu and click Broadband
            WebElement solutionsMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("text-block-3")));
            actions.moveToElement(solutionsMenu).perform();
            System.out.println("Mouse hovered over Solutions!");

            // **PAUSE FORCED** to ensure the submenu appears
            Thread.sleep(2000);  // Increased pause time to ensure the submenu appears

            // Step 3: Find and click on Broadband in the submenu using a direct XPath
            WebElement broadbandLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href, 'solution/broadband')]")));
            broadbandLink.click();  // Click directly on the Broadband link
            System.out.println("Clicked on Broadband!");

            // Step 4: Check if the Broadband page has opened by checking the title
            wait.until(ExpectedConditions.titleContains("Broadband"));
            System.out.println("Broadband page loaded!");

            // Step 5: Wait for the form section to be visible, then scroll to it
            WebElement formSection = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("contact-form")));  // Adjust name as necessary
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", formSection);
            System.out.println("Scrolled to the form!");

            // Step 6: Wait for the input fields to be visible and fill them out using their 'name' attributes
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email"))).sendKeys("Marianna.vasq@gmail.com");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("first_name"))).sendKeys("Marianna");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("last_name"))).sendKeys("Vasquez");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("company"))).sendKeys("Claro");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("phone"))).sendKeys("+1234564564566");

            // Step 7: Select "Cyber Security" in the "Interested in" field
            Select dropdown = new Select(driver.findElement(By.name("interest"))); // Replace with the correct NAME for the dropdown
            dropdown.selectByVisibleText("Cyber Security");
            System.out.println("Selected Cyber Security!");

            // Step 8: Click the "Submit" button
            WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.name("submit")));
            submitButton.click();
            System.out.println("Clicked Submit!");

            // Step 9: Check if the "Invalid CAPTCHA" message appears
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[contains(text(), 'Invalid CAPTCHA')]"), "Invalid CAPTCHA"));
            System.out.println("Invalid CAPTCHA message displayed!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
