package Core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BrowserHelper {
    protected WebDriver driver;

    public WebDriver chrome(String URL) {

        Map<String, Integer> contentSettings = new HashMap<String, Integer>();
        Map<String, Object> profile = new HashMap<String, Object>();
        Map<String, Object> prefs = new HashMap<String, Object>();

        // options : default - 0, allow - 1, block - 2
        contentSettings.put("notifications", 2);
        contentSettings.put("geolocation", 2);
        profile.put("managed_default_content_settings", contentSettings);
        prefs.put("profile", profile);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--remote-allow-origins=*");

        WebDriverManager.chromedriver().setup();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
       // driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.get(URL);
        driver.manage().window().maximize();
        return driver;

    }

    public WebDriver firefox(String URL) {

        // disable firefox notification - false:enabled - true:disabled
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(new FirefoxProfile());
        options.addPreference("dom.webnotifications.enabled", false);
        options.addPreference("geo.enabled", true);
        options.addPreference("geo.prompt.testing", true);
        options.addPreference("geo.prompt.testing.allow", true);
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver(options);
        //driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.get(URL);
        driver.manage().window().maximize();
        return driver;
    }

    public void closeTab() {

        driver.close();
    }

    public void closeBrowser() {

        driver.quit();
    }

}
