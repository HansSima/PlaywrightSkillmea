import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class FormularTest {
    private Playwright playwright;
    private Browser prohlizec;
    private Page stranka;
    private FormularPage formularPage;

    @Before
    public void setUp(){
        playwright = Playwright.create();
        prohlizec = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        stranka = prohlizec.newPage();
        formularPage = new FormularPage(stranka);
    }

    @After
    public void uklid(){
        playwright.close();
    }

    @Given("Uzivatel je na strance formulare")
    public void uzivatelJeNaStranceFormulare() {
        stranka.navigate("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
    }

    @When("Uzivatel zaskrtne radiobutton male")
    public void uzivatelZaskrtneRadiobuttonMale() {
        formularPage.kliknutiNaMaleRadiobutton();
    }

    @And("Uzivatel zaskrtne radiobutton female")
    public void uzivatelZaskrtneRadiobuttonFemale() {
       formularPage.kliknutiNaFemaleRadiobutton();
    }

    @Then("Uzivatel vidi zaskrtnuto female")
    public void uzivatelVidiZaskrtnutoFemale() {
        formularPage.jeFemaleRadiobuttonZaskrtnut();
    }

    @And("Uzivatel vidi zaskrtnuto male")
    public void uzivatelVidiZaskrtnutoMale() {
        formularPage.jeMaleRadiobuttonZaskrtnut();
    }
}
