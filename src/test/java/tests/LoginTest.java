package tests;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTest extends TestBase {

    @BeforeMethod
    public void preCondition() {

        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
        }
    }

    @Test
    public void loginSuccess1() {
        User user= new User().withEmail("bondijulia@gmail.com").withPassword("445566BbNn)(!");
        //user.setEmail("bondijulia@gmail.com");
        //user.setPassword("445566BbNn)(!");

        app.getHelperUser().openLogin();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().YallaButtonSubmit();

        //Assert.assertTrue(app.getHelperUser().isLogged());
        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");



    }
    @Test
    public void loginSuccess() {
        app.getHelperUser().openLogin();
        app.getHelperUser().fillLoginForm("bondijulia@gmail.com", "445566BbNn)(!");
        app.getHelperUser().YallaButtonSubmit();

        //Assert.assertTrue(app.getHelperUser().isLogged());
        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");
       


    }
    @Test
    public void loginSuccessModel() {
        app.getHelperUser().openLogin();
        app.getHelperUser().fillLoginForm("bondijulia@gmail.com", "445566BbNn)(!");
        app.getHelperUser().YallaButtonSubmit();

        //Assert.assertTrue(app.getHelperUser().isLogged());
        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");



    }
    @AfterMethod
    public void postConditions() {
        app.getHelperUser().clickOkButton();

    }

}
