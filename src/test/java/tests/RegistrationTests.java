package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TestBase {


    @BeforeMethod
    public void preConditions() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
        }

    }
    @Test
    public void registrationSuccess(){
        Random random = new Random();
        int i = random.nextInt(1000);
        System.out.println(System.currentTimeMillis());
        int z = (int)System.currentTimeMillis()/1000%3600;
        User user = new User()
                .withFirstName("Lora")
                .withLastName("Snow")
                .withEmail("snow"+z+"@gmail.com")
                .withPassword("Ssnow9876542$");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicy();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "You are logged in success");

    }

    @Test
    //button submit does not active
    public void registrationEmptyName(){
        User user = new User()
                .withFirstName("")
                .withLastName("Snow")
                .withEmail("snow@gmail.com")
                .withPassword("Ssnow9876542$");


        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
        Assert.assertEquals(app.getHelperUser().getErrorText(), "Name is required");
    }

    @Test
    //message appears  last name required
    //yalla button is not active
    public void registrationEmptyLastName(){

        User user = new User()
                .withFirstName("Lara")
                .withLastName("")
                .withEmail("snow@gmail.com")
                .withPassword("Ssnow9876542$");


        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
        Assert.assertEquals(app.getHelperUser().getErrorText(), "Last name is required");

    }

    @Test
    //yalla button is disabled
    //message appears wrong email format
    public void registrationWrongEmail(){
        User user = new User()
                .withFirstName("Lara")
                .withLastName("Snow")
                .withEmail("snow@gmailcom")
                .withPassword("Ssnow9876542$");


        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
        Assert.assertEquals(app.getHelperUser().getErrorText(), "Wrong email format");
    }

    @Test

    //message appears password wrong
    public void registrationWrongPassword(){
        User user = new User()
                .withFirstName("Lara")
                .withLastName("Snow")
                .withEmail("snow@gmail.com")
                .withPassword("fsnow9876542$");


        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
        Assert.assertEquals(app.getHelperUser().getErrorText(), "Password must contain 1 uppercase letter, 1 lowercase letter, 1 number and one special symbol of [@$#^&*!]");

    }



    @AfterMethod
    public void postConditions() {
        app.getHelperUser().clickOkButton();
    }


}
