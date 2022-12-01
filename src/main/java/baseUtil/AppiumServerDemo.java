package baseUtil;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.util.HashMap;


import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AppiumServerDemo {
	
		public static String NodeExePath = "C:\\Program Files\\nodejs\\node.exe";
		public static String Appiumjspath = "C:\\Users\\faraz\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js";
	    private static AppiumDriver driver;
	    private static AppiumServiceBuilder appbuilder;
	    private static AppiumDriverLocalService service;
	    public static String ServerAddress = "127.0.0.1";
	    

	    @BeforeClass
	    public static void startAppiumServer() {

	    	appbuilder =  new AppiumServiceBuilder();
	    	appbuilder.usingDriverExecutable(new File(NodeExePath));
	    	appbuilder.withAppiumJS(new File(Appiumjspath));
	    	appbuilder.withIPAddress(ServerAddress);
	    	appbuilder.usingPort(4723);
	    	appbuilder.withArgument(GeneralServerFlag.LOG_LEVEL, "info");
	    	appbuilder.withLogFile(new File(System.getProperty("user.dir")+"\\AppiumLogs\\applogs.txt"));
	    	service = AppiumDriverLocalService.buildService(appbuilder);
	    	service.start();

	    }
	

	    @BeforeMethod
	    public void startSession() {
	        DesiredCapabilities caps = new DesiredCapabilities();
	        caps.setCapability("deviceName", "Faraz Dasurkar");
			caps.setCapability ("platformName", "Android");
			caps.setCapability("platformVersion", "12");
			caps.setCapability("appPackage", "in.org.vidyalaya.android") ;
			caps.setCapability("appActivity", "in.org.vidyalaya.android.activities.SplashActivity");
	

	        driver = new AndroidDriver<MobileElement>(service.getUrl(), caps);
	    }
	

	    @AfterMethod
	    public void endSession() {
	        try {
	            driver.quit();
	        } catch (Exception ign) {}
	    }
	

	    @AfterClass
	    public static void stopAppiumServer() {
	        service.stop();
	    }
	

	    @Test
	    public void test() {
	        // test code goes here
	        assertTrue(true);
	    }
}