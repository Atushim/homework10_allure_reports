package guru.qa;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WithSteps {

    @Step("Открытие главной страницы")
    public void openMainPage() {
        open("https://github.com/");
    }

    @Step("Поиск репозитория {repo}")
    public void searchReposiroty(String repo) {
        $(".header-search-input").click();
        $(".header-search-input").setValue(repo);
        $(".header-search-input").submit();
    }

    @Step("Кликл по ссылке репозитория {repo}")
    public void clickRepositoryLink(String repo) {
        $(linkText(repo)).click();
    }

    @Step("Открытие страницы репозитория ")
    public void openIssueTab() {
        $("#issues-tab").click();
    }

    @Step("Проверка наличия issue репозитория c номером #{issue}")
    public void checkIssueNumber(int issue) {
        $(withText("#" + issue)).should(Condition.exist);
    }


}
