import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class FormularPage {
    private Page stranka;
    private String maleRadiobutton = "#gender";
    private String femaleRadiobutton = "xpath=/html/body/main/div/div/div[2]/form/div[3]/div/div/div[2]/input";

    FormularPage(Page stranka){
        this.stranka = stranka;
    }

    public void kliknutiNaMaleRadiobutton(){
        stranka.locator(maleRadiobutton).check();
    }

    public void kliknutiNaFemaleRadiobutton(){
        stranka.locator(femaleRadiobutton).check();
    }

    public void jeFemaleRadiobuttonZaskrtnut(){
        assertThat(stranka.locator(femaleRadiobutton)).isChecked();
    }

    public void jeMaleRadiobuttonZaskrtnut(){
        assertThat(stranka.locator(maleRadiobutton)).not().isChecked();
    }


}
