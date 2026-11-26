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

public class FormularTest {
    private Playwright playwright;
    private Browser prohlizec;
    private Page stranka;

    @Before
    public void setUp(){
        playwright = Playwright.create();
        prohlizec = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        stranka = prohlizec.newPage();
    }

    @After
    public void uklid(){
        playwright.close();
    }

    @Given("Uzivatel je na strance formulare")
    public void uzivatelJeNaStranceFormulare() {

    }

    @When("Uzivatel zaskrtne radiobutton male")
    public void uzivatelZaskrtneRadiobuttonMale() {

    }

    @And("Uzivatel zaskrtne radiobutton female")
    public void uzivatelZaskrtneRadiobuttonFemale() {

    }

    @Then("Uzivatel vidi zaskrtnuto female")
    public void uzivatelVidiZaskrtnutoFemale() {

    }

    @And("Uzivatel vidi zaskrtnuto male")
    public void uzivatelVidiZaskrtnutoMale() {

    }
}
