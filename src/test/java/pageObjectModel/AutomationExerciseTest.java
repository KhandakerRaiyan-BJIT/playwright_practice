package pageObjectModel;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class AutomationExerciseTest {

    Playwright playwright;
    Browser browser;
    BrowserContext context;
    Page page;
    AutomationExercisePage automation;



    @BeforeTest
    public void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
        context = browser.newContext();
        page = context.newPage();
        automation = new AutomationExercisePage(page);
    }



    @Test
    public void testFlow() {
        automation.openWebsite();
        automation.clickLogin();
        automation.verifyLoginSignupPage();
        automation.fillSignupForm("Interview", "yalj5sphf601@jkotypc12.com");
        automation.verifySignupPage();

        automation.fillPersonalDetails();
        automation.fillAddressDetails();
        automation.clickCreateAccount();
        automation.verifyAccountCreatedPage();
        automation.clickContinue();

        automation.clickProducts();
        automation.verifyAccountCreatedPage();

        automation.addFirstProduct();
        automation.addSecondProduct();

        automation.verifyCheckoutPage();
        automation.proceedToCheckout();
        automation.fillComment("ok");
        automation.placeOrder();
        automation.verifyPaymentPage();

        automation.fillPaymentDetails();
        automation.clickSubmit();
        automation.clickContinue();
        automation.verifyOrderPlacedPage();
    }



    @AfterTest
    public void tearDown() {
            browser.close();
    }
}