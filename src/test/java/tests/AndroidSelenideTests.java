package tests;

import com.codeborne.selenide.Condition;
import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;


public class AndroidSelenideTests extends TestBase {

    @Test
    @DisplayName("Test for Getting started")
    void gettingStartedTest() {
        step("Verify Title on first page", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("The Free Encyclopedia …in over 300 languages"));
        });
        step("Verify Title on second page", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("New ways to explore"));
        });
        step("Verify Title on third page", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("Reading lists with sync"));
        });
        step("Verify Title on fourth page", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("Send anonymous data"));
        });
        step("Finish Getting started tour", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_done_button")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/main_toolbar_wordmark")).shouldBe(Condition.visible);
        });
    }
}
