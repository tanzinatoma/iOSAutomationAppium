package tests;

import base.Base;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.settings.SettingsPage;

import java.io.IOException;

public class SettingsTest extends Base {
    SettingsPage stp = new SettingsPage();
    @BeforeTest
    public void setup() throws IOException {
        driver = setupApplication();
    }

    //@Test (priority = 1)
    public void update_text_bold(){
        stp.click_accessibility();
        stp.click_display_and_text_size();
        int previous_width = driver.findElement(stp.bold_text).getSize().getWidth();
        stp.activate_bold_toggle();
        int new_width = driver.findElement(stp.bold_text).getSize().getWidth();
        if (new_width > previous_width) {
            System.out.println("Text is bolded, width increased");
        } else {
            System.out.println("Text bold removed, width decreased");
        }
        stp.back_to_settings_page();
    }

   @Test (priority = 2)
        public void add_keyboard(){
            stp.click_general();
            stp.click_keyboard_option();
            stp.click_keyboard_list();
            stp.click_add_keyboard();
            stp.search_keyboard(props.getProperty("keyboard"));
            stp.select_keyboard_from_result(props.getProperty("keyboard"));
        }

    @AfterTest
    public void close() throws IOException {
        driver.quit();
    }
}
