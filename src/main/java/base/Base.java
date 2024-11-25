package base;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class Base {
    public static IOSDriver driver;
    public FileReader reader;
    public Properties props;
    public WebDriverWait wait;
    public IOSDriver setupApplication() throws IOException {
        reader=new FileReader("src/main/resources/TestData.properties"); //need to use relative path
        props=new Properties();
        props.load(reader);
        DesiredCapabilities ds =new DesiredCapabilities();
        ds.setCapability("platformName", "iOS");
        ds.setCapability("appium:automationName", "XCUITest");
        ds.setCapability("appium:udid", props.getProperty("device_id"));
        ds.setCapability("appium:bundleId", props.getProperty("app_id"));
        driver = new IOSDriver(new URL("http://0.0.0.0:4723/"), ds);
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        return driver;
    }
}
