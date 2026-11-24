package org.example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.BeforeEach;

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


}
