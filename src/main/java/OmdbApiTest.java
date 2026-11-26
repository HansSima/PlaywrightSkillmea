import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class OmdbApiTest {
    private Playwright playwright;
    private APIRequestContext api;

    @BeforeEach
    public void setup(){
        playwright = Playwright.create(new Playwright.CreateOptions()
                .setEnv(Map.of("PLAYWRIGHT_SKIP_BROWSER_DOWNLOAD", "1")));
        api = playwright.request().newContext();
    }

    @Test
    public void testApi(){
        APIResponse odpoved = api.get("http://www.omdbapi.com/?apikey=d60fea12&i=tt1375666");
        System.out.println(odpoved.text());

        assertThat(odpoved).isOK();

    }


}
