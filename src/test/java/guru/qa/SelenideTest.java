package guru.qa;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideTest {

    @Test

    public void TestIssueSearch(){
        SelenideLogger.addListener("allure",new AllureSelenide());

        open("https://github.com/");
        $(".header-search-input").click();
        $(".header-search-input").setValue("Selenide");
        $(".header-search-input").submit();
        $(linkText("selenide/selenide")).click();
        $("#issues-tab").click();
        $(withText("1915")).shouldHave(text("1915"));
}

}
