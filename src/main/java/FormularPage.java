import com.microsoft.playwright.Page;

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

}
