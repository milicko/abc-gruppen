package driver;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.URI;

public class DriverFactory {


    private static final String BROWSER_TYPE_PROPERTY = "browser";

    public WebDriver getDriver() {
        if (_driver == null) {
            createDriver(determineDriverType());
        }
        return _driver;
    }

    public void setDriver(WebDriver driver) {
        this._driver = driver;
    }

    private static WebDriver _driver;


    /**
     * Returning DriverType based on "browser" system propertie
     *
     * @return - DriverType
     */
    public DriverType determineDriverType() {
        String typeProperty = System.getProperty(BROWSER_TYPE_PROPERTY);

        if (typeProperty == null | typeProperty.equals("")) {

            throw new RuntimeException(String.format("System property for browser %s wasn't set! Set system property -D%s", BROWSER_TYPE_PROPERTY, BROWSER_TYPE_PROPERTY));
        }

        DriverType driverType = DriverType.getDriverTypeByPropertyName(typeProperty);


        return driverType;
    }

    public String getDirverPath(DriverType driverType) {

        String os = System.getProperty("os.name");
        String driverPath;
        File file = null;

        switch (os) {

            case "Mac OS X":
                switch (driverType) {
                    case CHROME:
                        file = new File(getClass().getClassLoader().getResource("chromedriver_mac").getPath());
                        break;
                    case FIREFOX:
                        file = new File(getClass().getClassLoader().getResource("geckodriver_mac").getPath());
                        break;

                }

                break;
            case "Linux":
                switch (driverType) {
                    case CHROME:
                        file = new File(getClass().getClassLoader().getResource("chromedriver_linux").getPath());
                        break;
                    case FIREFOX:
                        file = new File(getClass().getClassLoader().getResource("geckodriver_linux").getPath());
                        break;

                }
                break;
            default:
                switch (driverType) {
                    case CHROME:
                        file = new File(getClass().getClassLoader().getResource("chromedriver.exe").getPath());
                        break;
                    case FIREFOX:
                        file = new File(getClass().getClassLoader().getResource("geckodriver.exe").getPath());
                        break;

                }
                break;
        }

        file.setExecutable(true);
        driverPath = file.getPath();
        return driverPath;
    }


    /**
     * Creating web driver for specific browser based on system property "browser"
     *
     * @return WebDriver
     */
    public WebDriver createDriver(DriverType type) {
        WebDriver driver = null;


        switch (type) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", getDirverPath(type));
                setDriver(_driver = new ChromeDriver());
                _driver.manage().window().maximize();
                break;
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", getDirverPath(type));
                setDriver(_driver = new FirefoxDriver());
                break;

        }

        return driver;

    }


}