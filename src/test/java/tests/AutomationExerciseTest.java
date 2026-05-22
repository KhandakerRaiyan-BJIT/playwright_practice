package tests;

import com.microsoft.playwright.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AutomationExerciseTest {

    @Test
    public void testFlow() {
        try (Playwright playwright = Playwright.create();
             Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
             BrowserContext context = browser.newContext()) {

            Page page = context.newPage();
            page.navigate("https://automationexercise.com/");

            page.locator("a[href='/login']").click();
//            Assert.assertEquals(page.title(), "Automation Exercise - Signup");

            page.locator("input[placeholder='Name']").fill("Interview");
            page.locator("input[data-qa='signup-email']").fill("yalj5sphf6555566@jkotypc12.com");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            page.locator("button[data-qa='signup-button']").click();

            Assert.assertEquals(page.title(), "Automation Exercise - Signup");

            page.locator("#id_gender1").check();
            page.locator("#password").fill("Abcd@1234");
            page.locator("#days").selectOption("1");
            page.locator("#months").selectOption("October");
            page.locator("#years").selectOption("1999");
            page.locator("#newsletter").check();
            page.locator("#optin").check();

            page.locator("#first_name").fill("Raiyan");
            page.locator("#last_name").fill("Khandaker");
            page.locator("#company").fill("ABC");
            page.locator("#address1").fill("Niketon");
            page.locator("#address2").fill("Gulshan");
            page.locator("#country").selectOption("India");
            page.locator("#state").fill("Dhaka");
            page.locator("#city").fill("Dhaka");
            page.locator("#zipcode").fill("1212");
            page.locator("#mobile_number").fill("01711200000");
            page.locator("button[data-qa='create-account']").click();

            Assert.assertEquals(page.title(), "Automation Exercise - Account Created");
            page.locator(".btn.btn-primary").click();

            page.locator("a[href='/products']").click();

        }
    }
}