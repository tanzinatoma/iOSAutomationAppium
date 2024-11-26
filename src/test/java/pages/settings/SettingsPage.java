package pages.settings;
import base.Base;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class SettingsPage extends Base {
    By settings_page = AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == 'Settings'`]");
    By general_option = AppiumBy.iOSClassChain("**/XCUIElementTypeCell[`name == 'General'`]");
    By general_back_option = AppiumBy.accessibilityId("General");
    By settings_back_option = AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == 'Settings'`]");
    By accessibility_option = AppiumBy.accessibilityId("Accessibility");
    By display_and_text_size = AppiumBy.accessibilityId("Display & Text Size");
    By bold_toggle = AppiumBy.iOSClassChain("**/XCUIElementTypeSwitch[`name == 'Bold Text'`]");
    public By bold_text = AppiumBy.accessibilityId("ENHANCE_TEXT_LEGIBILITY");
    By keyboard_option = AppiumBy.iOSClassChain("**/XCUIElementTypeCell[`name == 'Keyboard'`]");
    By keyboard_list = AppiumBy.iOSClassChain("**/XCUIElementTypeCell[`name == 'Keyboards'`]");
    By add_keyboard = AppiumBy.iOSClassChain("**/XCUIElementTypeCell[`name == 'AddNewKeyboard'`]");
    By search_keyboard = AppiumBy.accessibilityId("Search");
    By search_result_table = AppiumBy.iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeTable");


    public void click_general(){
        driver.findElement(general_option).click();
    }
    public void click_accessibility(){
        driver.findElement(accessibility_option).click();
    }
    public void click_display_and_text_size(){
        driver.findElement(display_and_text_size).click();
    }
    public void activate_bold_toggle(){
        driver.findElement(bold_toggle).click();
    }

    public void back_to_settings_page() {
        while (true) {
            try {
                boolean settings_visible = driver.findElement(settings_page).isDisplayed();
                if (settings_visible) {
                    System.out.println("Settings page is visible. Exiting the loop.");
                    break;
                }
            } catch (NoSuchElementException e) {

            }

            try {
                if (driver.findElement(settings_back_option).isDisplayed()) {
                    System.out.println("Settings back option is active. Navigating back.");
                    driver.findElement(settings_back_option).click();
                    continue;
                }
            } catch (NoSuchElementException ignored) {
            }

            try {
                if (driver.findElement(general_back_option).isDisplayed()) {
                    System.out.println("General page is active. Navigating back.");
                    driver.findElement(general_back_option).click();
                    continue;
                }
            } catch (NoSuchElementException ignored) {
            }

            try {
                if (driver.findElement(accessibility_option).isDisplayed()) {
                    System.out.println("Accessibility page is active. Navigating back.");
                    driver.findElement(accessibility_option).click();
                    continue;
                }
            } catch (NoSuchElementException ignored) {
            }

            System.out.println("No navigation options found. Breaking the loop.");
            break;
        }
    }

    public void click_keyboard_option(){
        driver.findElement(keyboard_option).click();
    }
    public void click_keyboard_list(){
        driver.findElement(keyboard_list).click();
    }
    public void click_add_keyboard(){
        driver.findElement(add_keyboard).click();
    }
    public void search_keyboard(String value){
        driver.findElement(search_keyboard).sendKeys(value);
    }
    public void select_keyboard_from_result(String keyboard){
        String search_result_xpath = "//XCUIElementTypeCell[@label='"+ keyboard +"']";
        By search_result = By.xpath(search_result_xpath);
        WebElement table = driver.findElement(search_result_table);
        WebElement result = table.findElement(search_result);
        result.click();
    }
}

