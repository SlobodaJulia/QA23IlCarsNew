package tests;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTest extends TestBase {

    @BeforeMethod
    public void preConditions() {

        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
        }
    }

    @Test
    public void loginSuccess1() {
        logger.info("Start");
        User user= new User().withEmail("bondijulia@gmail.com").withPassword("445566BbNn)(!");
        //user.setEmail("bondijulia@gmail.com");
        //user.setPassword("445566BbNn)(!");

        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();

        //Assert.assertTrue(app.getHelperUser().isLogged());
        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");
        logger.info("End");



    }
    @Test
    public void loginSuccess() {
        logger.info("Start");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("bondijulia@gmail.com", "445566BbNn)(!");
        app.getHelperUser().submit();

        //Assert.assertTrue(app.getHelperUser().isLogged());
        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");
        logger.info("End");


    }
    @Test
    public void loginSuccessModel() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("bondijulia@gmail.com", "445566BbNn)(!");
        app.getHelperUser().submit();

        //Assert.assertTrue(app.getHelperUser().isLogged());
        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");



    }


    @Test
    public void loginWrongEmail(){
       		
		User user = new User().withEmail("alex@gmailcom").withPassword("445566BbNn)(!");

        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(), "It'snot look like email");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());



    }
    @Test
    public void loginWrongEmailwithoutSht(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("alexgmail.com", "445566BbNn)(!");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(), "It'snot look like email");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());



    }
    @Test
    public void loginWrongPassword(){
        User user = new User().withEmail("bondijulia@gmail.com").withPassword("44");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");

    }


    @Test
    public void loginUnregisteredUser(){
        User user = new User().withEmail("duck@gmail.com").withPassword("Ddag123456$");

        app.getHelperUser().openLoginForm();
       app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();
       Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");

    }


    @AfterMethod
    public void postConditions() {
        app.getHelperUser().clickOkButton();

    }
}
