package tests;

import base.Base;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.SettingsPage;

import java.io.IOException;

public class SettingsTest extends Base {
    SettingsPage stp = new SettingsPage();
    @BeforeTest
    public void setup() throws IOException {
        driver = setupApplication();
    }

    @Test
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
    }
}
