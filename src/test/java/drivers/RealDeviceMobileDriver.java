package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.Project;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RealDeviceMobileDriver implements WebDriverProvider {
    public static URL getAppiumUrl() {
        try {
            return new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {

        desiredCapabilities.setCapability("platformName", Project.realDeviceConfig.platformName());
        desiredCapabilities.setCapability("deviceName", Project.realDeviceConfig.deviceName());
        desiredCapabilities.setCapability("version", Project.realDeviceConfig.version());
        desiredCapabilities.setCapability("locale", Project.realDeviceConfig.locale());
        desiredCapabilities.setCapability("language", Project.realDeviceConfig.language());
        desiredCapabilities.setCapability("appPackage", Project.realDeviceConfig.appPackage());
        desiredCapabilities.setCapability("appActivity", Project.realDeviceConfig.appActivity());
        desiredCapabilities.setCapability("app",
                getAbsolutePath("src/test/resources/app-alpha-universal-release.apk"));

        return new AndroidDriver(getAppiumUrl(), desiredCapabilities);
    }

    private String getAbsolutePath(String filePath) {
        File file = new File(filePath);
        assertTrue(file.exists(), filePath + " not found");

        return file.getAbsolutePath();
    }
}
