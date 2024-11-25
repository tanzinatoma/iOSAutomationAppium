package pages;
import base.Base;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class SettingsPage extends Base {
    By general_option = AppiumBy.iOSClassChain("**/XCUIElementTypeCell[`name == 'General'`]");
    By accessibility_option = AppiumBy.accessibilityId("Accessibility");
    By display_and_text_size = AppiumBy.accessibilityId("Display & Text Size");
    By bold_toggle = AppiumBy.iOSClassChain("**/XCUIElementTypeSwitch[`name == 'Bold Text'`]");
    public By bold_text = AppiumBy.accessibilityId("ENHANCE_TEXT_LEGIBILITY");

    public void click_accessibility(){
        driver.findElement(accessibility_option).click();
    }
    public void click_display_and_text_size(){
        driver.findElement(display_and_text_size).click();
    }
    public void activate_bold_toggle(){
        driver.findElement(bold_toggle).click();
    }
}

