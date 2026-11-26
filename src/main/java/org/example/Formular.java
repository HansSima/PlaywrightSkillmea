package org.example;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Formular {
    private Playwright playwright;
    private Browser prohlizec;
    private Page stranka;

    @BeforeEach
    public void setUp(){
        playwright = Playwright.create();
        prohlizec = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        stranka = prohlizec.newPage();

        //Toto je pro TraceViewer
        stranka.context().tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(true));
    }

    @AfterEach
    public void uklid(){
        //Toto je pro TraceViewer
        stranka.context().tracing().stop(new Tracing.StopOptions()
                .setPath(Paths.get("trace.zip")));

        playwright.close();
    }

    @Test
    public void formTest(){
        stranka.navigate("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        stranka.locator("#name").fill("Petra");
        stranka.locator("#email").fill("jan@email.com");

        stranka.locator("#gender").check();
        //Lokalizace a zaskrtnuti female
        stranka.locator("xpath=/html/body/main/div/div/div[2]/form/div[3]/div/div/div[2]/input").check();
        //stranka.pause();
        stranka.locator("#mobile").fill("3434383544");

        assertThat(stranka.locator("xpath=/html/body/main/div/div/div[2]/form/div[3]/div/div/div[2]/input")).isChecked();
        assertThat(stranka.locator("xpath=/html/body/main/div/div/div[2]/form/h1")).hasText("Student Registration Form");
        assertThat(stranka).hasURL("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        assertThat(stranka.locator("#gender")).not().isChecked();
    }

}
