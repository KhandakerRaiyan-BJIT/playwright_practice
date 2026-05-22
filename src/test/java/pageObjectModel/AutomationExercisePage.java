package pageObjectModel;


import com.microsoft.playwright.Page;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class AutomationExercisePage {
    Page page;
    public AutomationExercisePage(Page page) {
        this.page = page;
    }


    //All locators
    String loginLink = "a[href='/login']";
    String nameInput = "input[placeholder='Name']";
    String emailInput = "input[data-qa='signup-email']";
    String signupButton = "button[data-qa='signup-button']";
    String maleRadio = "#id_gender1";
    String passwordInput = "#password";
    String daysDropdown = "#days";
    String monthsDropdown = "#months";
    String yearsDropdown = "#years";
    String newsletterCheckbox = "#newsletter";
    String optinCheckbox = "#optin";
    String firstNameInput = "#first_name";
    String lastNameInput = "#last_name";
    String companyInput = "#company";
    String address1Input = "#address1";
    String address2Input = "#address2";
    String countryDropdown = "#country";
    String stateInput = "#state";
    String cityInput = "#city";
    String zipInput = "#zipcode";
    String mobileInput = "#mobile_number";
    String createAccountButton = "button[data-qa='create-account']";
    String continueButton = ".btn.btn-primary";
    String productsLink = "a[href='/products']";
    String productHover = ":nth-child(3) > .product-image-wrapper > .single-products > .productinfo";
    String addToCartHoverButton = ":nth-child(3) > .product-image-wrapper > .single-products > .productinfo > .btn";
    String popupContinueButton = ".btn.btn-success.close-modal.btn-block";
    String viewProductLink = "a[href='/product_details/2']";
    String addToCartButton = "button[type='button']";
    String popupViewCartLink = "body > section:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > p:nth-child(2) > a:nth-child(1) > u:nth-child(1)";
    String proceedToCheckoutButton = ".btn.btn-default.check_out";
    String commentInput = "textarea[name='message']";
    String nameOnCardInput = "input[name='name_on_card']";
    String cardNumberInput = "input[name='card_number']";
    String cvcInput = "input[placeholder='ex. 311']";
    String expireMonthInput = "input[placeholder='MM']";
    String expireYearInput = "input[placeholder='YYYY']";
    String submitButton = "#submit";


    public void openWebsite() {
        page.navigate("https://automationexercise.com/");
    }



    public void clickLogin() {
        page.locator(loginLink).click();
    }



    public void verifyLoginSignupPage() {
        try {
            assertThat(page).hasURL("https://automationexercise.com/login");
            System.out.println("Login Signup Page Verified");

        } catch (AssertionError e) {
            System.out.println("Login Signup Page Verification Failed");
            System.out.println("Actual Title: " + page.title());
            throw e;
        }
    }



    public void fillSignupForm(String name, String email) {
        page.locator(nameInput).fill(name);
        page.locator(emailInput).fill(email);
        page.locator(signupButton).click();
    }



    public void verifySignupPage() {
        try {
            assertThat(page).hasURL("https://automationexercise.com/signup");
            System.out.println("Signup Page Verified");
        } catch (AssertionError e) {
            System.out.println("Signup Page Verification Failed");
            System.out.println("Actual Title: " + page.title());
            throw e;
        }
    }



    public void fillPersonalDetails() {
        page.locator(maleRadio).check();
        page.locator(passwordInput).fill("Abcd@1234");
        page.locator(daysDropdown).selectOption("1");
        page.locator(monthsDropdown).selectOption("October");
        page.locator(yearsDropdown).selectOption("1999");
        page.locator(newsletterCheckbox).check();
        page.locator(optinCheckbox).check();
    }



    public void fillAddressDetails() {
        page.locator(firstNameInput).fill("Raiyan");
        page.locator(lastNameInput).fill("Khandaker");
        page.locator(companyInput).fill("ABC");
        page.locator(address1Input).fill("Niketon");
        page.locator(address2Input).fill("Gulshan");
        page.locator(countryDropdown).selectOption("India");
        page.locator(stateInput).fill("Dhaka");
        page.locator(cityInput).fill("Dhaka");
        page.locator(zipInput).fill("1212");
        page.locator(mobileInput).fill("01711200000");
    }



    public void clickCreateAccount() {
        page.locator(createAccountButton).click();
    }



    public void verifyAccountCreatedPage() {
        try {
            assertThat(page).hasURL("https://automationexercise.com/account_created");
            System.out.println("Account Created Page Verified");
        } catch (AssertionError e) {
            System.out.println("Account Created Page Verification Failed");
            System.out.println("Actual Title: " + page.title());
            throw e;
        }
    }



    public void clickContinue() {
        page.locator(continueButton).click();
    }



    public void clickProducts() {
        page.locator(productsLink).click();
    }



    public void verifyProductsPage() {
        try {
            assertThat(page).hasURL("https://automationexercise.com/products");
            System.out.println("Products Page Verified");
        } catch (AssertionError e) {
            System.out.println("Products Page Verification Failed");
            System.out.println("Actual Title: " + page.title());
            throw e;
        }
    }



    public void addFirstProduct() {
        page.locator(productHover).hover();
        page.locator(addToCartHoverButton).click();
        page.locator(popupContinueButton).click();
    }



    public void addSecondProduct() {
        page.locator(viewProductLink).click();
        page.locator(addToCartButton).click();
        page.locator(popupViewCartLink).click();
    }



    public void verifyCheckoutPage() {
        try {
            assertThat(page).hasURL("https://automationexercise.com/view_cart");
            System.out.println("Checkout Page Verified");
        } catch (AssertionError e) {
            System.out.println("Checkout Page Verification Failed");
            System.out.println("Actual Title: " + page.title());
            throw e;
        }
    }



    public void proceedToCheckout() {
        page.locator(proceedToCheckoutButton).click();
    }



    public void fillComment(String comment) {
        page.locator(commentInput).fill(comment);
    }



    public void placeOrder() {
        page.locator(proceedToCheckoutButton).click();
    }



    public void verifyPaymentPage() {
        try {
            assertThat(page).hasURL("https://automationexercise.com/payment");
            System.out.println("Payment Page Verified");
        } catch (AssertionError e) {
            System.out.println("Payment Page Verification Failed");
            System.out.println("Actual Title: " + page.title());
            throw e;
        }
    }



    public void fillPaymentDetails() {
        page.locator(nameOnCardInput).fill("Raiyan Khandaker");
        page.locator(cardNumberInput).fill("11111111111");
        page.locator(cvcInput).fill("111");
        page.locator(expireMonthInput).fill("06");
        page.locator(expireYearInput).fill("2028");
    }



    public void clickSubmit() {
        page.locator(submitButton).click();
    }



    public void verifyOrderPlacedPage() {
        try {
            assertThat(page).hasURL("https://automationexercise.com/payment_done/*");
            System.out.println("Order Placed Page Verified");
        } catch (AssertionError e) {
            System.out.println("Order Placed Page Verification Failed");
            System.out.println("Actual Title: " + page.title());
            throw e;
        }
    }
}