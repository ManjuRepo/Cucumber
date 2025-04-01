package Steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {

    private WebDriver driver;

    // Default constructor (required by Cucumber)
    public Login() {
        // WebDriver initialization will be handled separately
    }

    // Method to initialize WebDriver explicitly
    public void setDriver(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "username")
    WebElement txt_Username;

    @FindBy(name = "password")
    WebElement txt_Password;

    @FindBy(xpath = "//*[@type='submit']")
    WebElement btn_Login;

    @Given("User is Opening the Browser")
    public void SetUp_Env() {
        driver = new ChromeDriver();  // Initialize WebDriver inside the method
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        
        // Initialize elements now that driver is set
        PageFactory.initElements(driver, this);
    }

    @When("User Login Using Username {string} and Password {string}")
    public void user_login(String Username, String Password) {
        txt_Username.sendKeys(Username);
        txt_Password.sendKeys(Password);
    }

    @And("click on Login button")
    public void click_on_login_button() {
        btn_Login.click();
    }

    @Then("redirected to HRM Home page")
    public void Home_page() {
        driver.close();
    }
}
