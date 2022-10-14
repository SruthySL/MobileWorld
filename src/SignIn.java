import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignIn {
	
	WebDriver driver;
	static {
		System.setProperty("webdriver.chrome.driver", "C:/Users/sruthy.sl/Downloads/chromedriver_win32/chromedriver.exe");
		
	}
	@BeforeMethod
	public void initBrowser() {
		driver = new ChromeDriver();
		driver.get("https://qualicoach.org/mwapp/index.html");
	}
	
	 @Test(description="user can signin with valid username and password")
	    public void  signIn() {
	        LandingPage ob= new LandingPage(driver);
	        ob.SignIn("Sruthy","Sruthy15");
	        Assert.assertEquals(driver.getCurrentUrl(),"https://qualicoach.org/mwapp/sign.html");
	    }
	    
	    @Test(description="user cant signin by leaving username field empty")
	    public void  Signinvalid() {
	        LandingPage ob= new LandingPage(driver);
	        ob.SignIn(" ","sruthy15");
	        Assert.assertEquals(driver.getCurrentUrl(),"https://qualicoach.org/mwapp/sign.html");
	        driver.quit();
	    }
	    
	    
	    @Test(description="user cant signin by leaving both username and password field empty" )
	    public void  Signinemptyvalid() {
	        LandingPage ob= new LandingPage(driver);
	        ob.SignIn(" "," ");
	        Assert.assertEquals(driver.getCurrentUrl(),"https://qualicoach.org/mwapp/sign.html");
	        driver.quit();
	    }
	    
	    @Test(description="user cant signin by entering less than 3 characters in username")
	    public void  Signinpominavalid() {
	       LandingPage ob= new LandingPage(driver);
	        ob.SignIn("Sr","Sruthy15 ");
	        Assert.assertEquals(driver.getCurrentUrl(),"https://qualicoach.org/mwapp/sign.html");
	        driver.quit();
	    }
	    
	    @Test(description="user cant signin by entering more than 20 characters in username")
	    public void  Signinusermoretwentyinavalid() {
	        LandingPage ob= new LandingPage(driver);
	        ob.SignIn("Sruthylathikananda","Sruthy123 ");
	        Assert.assertEquals(driver.getCurrentUrl(),"https://qualicoach.org/mwapp/sign.html");
	        driver.quit();
	    }
	    
	    
	    @Test(description="user cant signin by entering special characters in password")
	    public void  Signinpassspecialinavalid() {
	        LandingPage ob= new LandingPage(driver);
	        ob.SignIn("Sruthy","Sruthy!@");
	        Assert.assertEquals(driver.getCurrentUrl(),"https://qualicoach.org/mwapp/sign.html");
	        driver.quit();
	    }

}
