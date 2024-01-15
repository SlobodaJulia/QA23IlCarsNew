package manager;
import models.User;
import org.openqa.selenium.*;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLogin() {
        click(By.xpath("//a[text()=' Log in ']"));
    }

    public void fillLoginForm(String email, String password) {

        type(By.id("email"), email);
        type(By.id("password"), password);
        //input[@id='password']
    }

    public void fillLoginForm(User user) {

        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());
        //input[@id='password']
    }


    public void YallaButtonSubmit() {
        click(By.xpath("//button[@type='submit']"));
    }


    public boolean isLogged() {
        return isElementPresent(By.xpath("//*[.=' Logout ']"));
    }


    public void logout() {
        click(By.xpath("//*[.=' Logout ']"));
    }

    public void clickOkButton() {
        if (isElementPresent(By.xpath("//button[text()='Ok']")))
            click(By.xpath("//button[text()='Ok']"));

    }

    public String getErrorText() {
        return wd.findElement(By.cssSelector("div.error")).getText();
    }

    public boolean isYallaButtonNotActive() {
        boolean res = isElementPresent(By.cssSelector("button[disabled]"));
        WebElement element = wd.findElement(By.cssSelector("button[type='submit']"));
        boolean result = element.isEnabled();
        return res && !result;
    }

    public void openRegistrationForm() {
        click(By.xpath("//a[text()=' Sign up ']"));
    }

    public void fillRegistrationForm(User user) {
        type(By.id("name"), user.getFirstName());
        type(By.id("lastName"), user.getLastName());
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());
    }

    public void checkPolicy() {
        //click(By.id("terms-of-use"));/0x0
        // click(By.cssSelector("label[for='terms-of-use']"));

        //variant 2
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("document.querySelector('#terms-of-use').click()");
    }

    public void checkPolicyXY() {
        if (!wd.findElement(By.id("terms-of-use")).isSelected()) {

            Dimension size = wd.manage().window().getSize();
            System.out.println("Wigh screen--> " + size.getWidth());

            WebElement label = wd.findElement(By.cssSelector("label[for ='terms-of-use']"));
            Rectangle rect = label.getRect();
            int w = rect.getWidth();
            int xOffSet = -w / 2;
            Actions actions = new Actions(wd);
            actions.moveToElement(label, xOffSet, 0).click().release().perform();
        }
    }
}


