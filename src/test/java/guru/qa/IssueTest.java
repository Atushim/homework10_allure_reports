package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class IssueTest {

    private static final String REPOSITORY = "selenide/selenide";
    private static final int ISSUE = 1915;

    @Test
    public void testLambdaStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открытие главной страницы", () -> {
            open("https://github.com/");
        });
        step("Поиск репозитория " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").setValue(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Клик по ссылке репозитория", () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Открытие страницы репозитория", () -> {
            $("#issues-tab").click();
        });
        step("Проверка наличия issue репозитория", () -> {
            $(withText("#" + ISSUE)).should(Condition.exist);
        });

    }

    @Test
    public void testAnnotatedStep() {
        WithSteps steps = new WithSteps();

        steps.openMainPage();
        steps.searchReposiroty(REPOSITORY);
        steps.clickRepositoryLink(REPOSITORY);
        steps.openIssueTab();
        steps.checkIssueNumber(ISSUE);
    }

}

