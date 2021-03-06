package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.Project;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class SelenoidMobileDriver implements WebDriverProvider {
    public static URL getSelenoidUrl() {
        try {
            return new URL("https://user1:1234@selenoid.autotests.cloud/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {

        desiredCapabilities.setCapability("platformName", Project.selenoidConfig.platformName());
        desiredCapabilities.setCapability("deviceName", Project.selenoidConfig.deviceName());
        desiredCapabilities.setCapability("version", Project.selenoidConfig.version());
        desiredCapabilities.setCapability("locale", Project.selenoidConfig.locale());
        desiredCapabilities.setCapability("language", Project.selenoidConfig.language());
        desiredCapabilities.setCapability("enableVNC", true);
        desiredCapabilities.setCapability("enableVideo", true);
        desiredCapabilities.setCapability("appPackage", Project.selenoidConfig.appPackage());
        desiredCapabilities.setCapability("appActivity", Project.selenoidConfig.appActivity());
        desiredCapabilities.setCapability("app", apkUrl());

        return new AndroidDriver(getSelenoidUrl(), desiredCapabilities);
    }

    private URL apkUrl() {
        try {
            return new URL("https://github.com/wikimedia/apps-android-wikipedia/releases/download/latest/app-alpha-universal-release.apk");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}