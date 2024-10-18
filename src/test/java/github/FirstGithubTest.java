package github;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class FirstGithubTest {

    @Test
    void shouldFindJunitAtSoftAssertions() {
        // открываем страницу селенид в гитхаб
        open("https://github.com/selenide/selenide");

        // Переходим в раздел WIKI проекта
        $("[data-tab-item='i5wiki-tab']").click();

        //  Убеждаемся, что в списке страниц (Pages) есть страница SoftAssertions
        $$("ul.internal present").findBy(text("Soft assertions"));

        // Открываем страницу SoftAssertions,
        $("[href=\"/selenide/selenide/wiki/SoftAssertions\"]").click();

        //Проверяем что внутри есть пример кода для JUnit5
        $("#wiki-body").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}"));

        sleep(5000); // Ожидаем для визуальной проверки
    }
}
