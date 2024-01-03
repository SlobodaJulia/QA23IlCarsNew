package manager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase{
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLogin(){
        click(By.xpath("//a[@class='navigation-link'][normalize-space()='Log in']"));
    }
    public void fillLoginForm(String email, String password){

        type(By.xpath("//input[@id='email']"),email);
        type(By.xpath("//input[@id='password']"),password);
        //input[@id='password']
    }

    public void YallaButtonSubmit(){
        click(new By.ByCssSelector("button[type='submit']"));
    }



     public boolean isLogged() {
        return isElementPresent(By.xpath("//a[normalize-space()='Logout']"));
     }



    public void logout() {
        click(By.xpath("//a[normalize-space()='Logout']"));
    }
}

