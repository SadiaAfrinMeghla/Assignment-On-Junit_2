import com.sun.source.doctree.ThrowsTree;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MyJunit2 {

    WebDriver driver;

    @BeforeAll
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    @Test
    public void GuestRegistrationForm() throws InterruptedException {
        driver.get("https://demo.wpeverest.com/user-registration/guest-registration-form/");
        driver.manage().window().maximize();
        Thread.sleep(1000);

        driver.findElement(By.id("first_name")).sendKeys("Sadia Afrin ");//First Name
        driver.findElement(By.id("last_name")).sendKeys("Meghla");//Last NAme
        driver.findElement(By.id("user_email")).sendKeys("sadiameghla@gmail.com");//Email
        driver.findElement(By.id("radio_1665627729_Female")).click();// Select Gender (Radio button)
        driver.findElement(By.id("user_pass")).sendKeys("SadiaMeghla**03");//Password


        driver.findElement(By.id("input_box_1665629217")).sendKeys("Bangladeshi");   //Nationality
        driver.findElement(By.id("phone_1665627880")).click();//phone number

        List<WebElement> phoneNumbers = driver.findElements(By.id("phone_1665627880"));//Phone number
        phoneNumbers.get(1).sendKeys("01751719925");//emergency phone number

        // DOB
        WebElement dropdownElen = driver.findElement(By.cssSelector("input[data-id='date_box_1665628538']"));
        dropdownElen.click();
        dropdownElen.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);

        //Country -------------------
        WebElement dropdown= driver.findElement(By.id("country_1665629257"));
        Select option2 = new Select(dropdown);
        option2.selectByVisibleText("Bangladesh");

        List<WebElement> emergencyContacts = driver.findElements(By.id("phone_1665627865"));//Emergency Contact
        emergencyContacts.get(1).sendKeys("0987654321");

        Util.scroll(driver, 500);
        Thread.sleep(2000);

        //Arrival Data-----------------

        WebElement dropdownElen1 = driver.findElement(By.cssSelector("input[data-id='date_box_1665629845']"));
        dropdownElen1.click();
        dropdownElen1.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);


        driver.findElement(By.id("number_box_1665629930")).sendKeys("-3");//Length of Stay
        driver.findElement(By.id("input_box_1665630010")).sendKeys("1 3");//Room and bed
        driver.findElement(By.id("textarea_1665630078")).sendKeys("SQA and Dhaka");  //Occupation and PlaceOf Employment
        driver.findElement(By.id("radio_1665627931_Yes")).click();  //Parking
        driver.findElement(By.id("radio_1665627997_Single Room")).click();//Room Preference

        Util.scroll(driver, 500);
        Thread.sleep(2000);
        driver.findElement(By.id("radio_1665628131_None")).click();//Dietary


        Util.scroll(driver, 400);

        WebElement dropdown1= driver.findElement(By.id("select_1665628361"));
        Select value3 = new Select(dropdown1);
        value3.selectByVisibleText("Town Hall");

        Thread.sleep(5000);

        driver.findElement(By.id("privacy_policy_1665633140")).click(); // Privacy Policy
        driver.findElement(By.cssSelector("button[type='submit']")).click();


        // After submitting the form, check for success or error messages
        try {
            // Locate the success or error message element
            WebElement messageElement = driver.findElement(By.id("ur-submit-message-node"));
            String messageActual = messageElement.getText();
            System.out.println("Actual Message: " + messageActual);

            // Handle both scenarios: Success or Email already exists
            if (messageActual.contains("User successfully registered")) {
                System.out.println("Test Passed: Registration successful.");
            } else if (messageActual.contains("Email already exists")) {
                System.out.println("Test Passed: Email already exists error handled.");
            } else {
                System.out.println("Test Failed: Unexpected message - " + messageActual);
            }

        } catch (Exception e) {
            System.out.println("Test Failed: No message found.");
        }

    }

}
























