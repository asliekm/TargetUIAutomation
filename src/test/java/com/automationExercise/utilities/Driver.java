package com.automationExercise.utilities;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.time.Duration;

/**
 * The {@code Driver} class is a utility for managing WebDriver instances using the Singleton pattern.
 * It provides methods to get a WebDriver instance and close it.
 */
public class Driver {

    // Thread-local variable to hold WebDriver instances
    private static final ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    // Private constructor to prevent instantiation from outside
    private Driver() {
    }

    /**
     * Gets the singleton instance of WebDriver. If the instance is not initialized, it initializes it based on the
     * browser type specified in the configuration.
     *
     * @return The WebDriver instance.
     */
    public static WebDriver getDriver() {
        if (driverPool.get() == null) {
            String browserType = System.getProperty("BROWSER", ConfigurationReader.getProperty("browser"));
            System.out.println("Browser: " + browserType);
            // Initialize WebDriver based on browser type
            switch (browserType) {
                case "remote-chrome":
                    driverPool.set(initRemoteWebDriver(new ChromeOptions(), "54.196.44.18"));
                    break;
                case "remote-firefox":
                    driverPool.set(initRemoteWebDriver(new FirefoxOptions(), "54.162.50.13"));
                    break;
                case "chrome":
                    driverPool.set(new ChromeDriver());
                    break;
                case "firefox":
                    driverPool.set(new FirefoxDriver());
                    break;
                case "edge":
                    driverPool.set(new EdgeDriver());
                    break;
                case "headless-chrome":
                    ChromeOptions headlessOptions = new ChromeOptions();
                    headlessOptions.addArguments("--headless=new");
                    driverPool.set(new ChromeDriver(headlessOptions));
                    break;
                default:
                    throw new IllegalArgumentException("Invalid browser type specified in the configuration: " + browserType);
            }

            // Maximize the browser window and set implicit wait
            driverPool.get().manage().window().maximize();
            driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        return driverPool.get();
    }

    private static WebDriver initRemoteWebDriver(Object options, String gridAddress) {
        try {
            URL url = new URL("http://" + gridAddress + ":4444/wd/hub");
            return new RemoteWebDriver(url, (Capabilities) options);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to initialize remote WebDriver", e);
        }
    }

    /**
     * Closes the WebDriver instance and removes it from the thread-local variable.
     * If the instance is not null, it quits the WebDriver.
     */
    public static void closeDriver() {
        if (driverPool.get() != null) {
            driverPool.get().quit(); // Quit the WebDriver instance
            driverPool.remove(); // Remove the WebDriver instance from the thread-local variable
        }
    }
}
