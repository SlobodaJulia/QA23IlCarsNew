package manager;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase{
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLogin(){
        click(By.xpath("//a[text()=' Log in ']"));
    }
    public void fillLoginForm(String email, String password){

        type(By.id("email"),email);
        type(By.id("password"),password);
        //input[@id='password']
    }
    public void fillLoginForm(User user){

        type(By.id("email"),user.getEmail());
        type(By.id("password"),user.getPassword());
        //input[@id='password']
    }


    public void YallaButtonSubmit(){
        click(By.xpath("//button[@type='submit']"));
    }



     public boolean isLogged() {
        return isElementPresent(By.xpath("//*[.=' Logout ']"));
    }




    public void logout() {
        click(By.xpath("//*[.=' Logout ']"));
    }

    public void clickOkButton() {
        click(By.xpath("//button[text()='Ok']"));
    }


}

