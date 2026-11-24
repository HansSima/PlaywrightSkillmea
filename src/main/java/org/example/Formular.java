package org.example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Formular {
    private Playwright playwright;
    private Browser prohlizec;
    private Page stranka;

    @BeforeEach
    public void setUp(){
        playwright = Playwright.create();
        prohlizec = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        stranka = prohlizec.newPage();
    }

    @Test
    public void formTest(){
        stranka.navigate("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        stranka.locator("#name").fill("Petra");
        stranka.locator("#email").fill("jan@email.com");

        stranka.locator("#gender").check();
        stranka.locator("xpath=/html/body/main/div/div/div[2]/form/div[3]/div/div/div[2]/input").check();
        //stranka.pause();
        stranka.locator("#mobile").fill("3434383544");



    }

}
