package github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Selenide.*;

public class EnterprizeTest {
    @BeforeAll
    static void setup() {
        Configuration.browserSize = "2160x1440";
        Configuration.baseUrl = "https://github.com";
    }

    @Test
    void navigateToEnterprise() {
        // Открываем главную страницу
        open("");

        // Наводим курсор на пункт меню Solutions
        $$(".HeaderMenu-link").findBy(Condition.text("Solutions")).hover();

        // Кликаем на Enterprise
        $$(".HeaderMenu-dropdown a").findBy(Condition.text("Enterprise")).click();

        // Проверяем, что заголовок страницы содержит нужный текст
        $("[id=\"hero-section-brand-heading\"]").shouldHave(Condition.text("The AI-powered developer platform."));
    }
}