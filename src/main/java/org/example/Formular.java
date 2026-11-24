package org.example;

import com.microsoft.playwright.Browser;
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
        prohlizec = playwright.chromium().launch();
        stranka = prohlizec.newPage();
    }

    @Test
    public void formTest(){
        stranka.navigate("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");


    }


}
