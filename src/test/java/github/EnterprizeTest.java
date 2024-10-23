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

        // Наводим курсор на пункт меню "Solutions"
        $$(".HeaderMenu-link") // Ищем все элементы меню
                .findBy(Condition.text("Solutions")) // Ищем элемент по тексту "Solutions"
                .hover(); // Наведение мыши

        // Кликаем по элементу "Enterprise" в выпадающем меню
        $$(".HeaderMenu-dropdown a") // Ищем все ссылки в выпадающем меню
                .findBy(Condition.text("Enterprise")) // Ищем по тексту "Enterprise"
                .click(); // Кликаем по ссылке

        // Проверяем, что заголовок страницы содержит нужный текст
        $("[id=\"hero-section-brand-heading\"]").shouldHave(Condition.text("The AI-powered developer platform."));
    }
}