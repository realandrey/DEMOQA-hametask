package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000;
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");

        // Заполнение полей ввода
        $("#firstName").setValue("John");
        $("#lastName").setValue("Doe");
        $("#userEmail").setValue("john.doe@example.com");
        $("#userNumber").setValue("1234567890");

        // Выбор радиокнопки (Gender)
        $("#gender-radio-1").parent().click();  // Male

        // Установка даты рождения
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("October");
        $(".react-datepicker__year-select").selectOption("1995");
        $(".react-datepicker__day--009").click();  // 9 октября

        // Ввод предметов
        $("#subjectsInput").setValue("Math").pressEnter();

        // Установка чекбоксов (Hobbies)
        $("#hobbies-checkbox-1").parent().click();  // Спорт
        $("#hobbies-checkbox-2").parent().click();  // Чтение

        // Загрузка файла
        $("#uploadPicture").uploadFile(new File("src/test/picture.png"));

        // Заполнение адреса
        $("#currentAddress").setValue("123 Main Street");

        // Выбор штата и города (Пример: NCR -> Delhi)
        $("#state").click();
        $x("//div[text()='NCR']").click();
        $("#city").click();
        $x("//div[text()='Delhi']").click();

        // Отправка формы
        $("#submit").click();

        // Проверка вывода
        $(".modal-content").shouldHave(text("John Doe"),
                text("john.doe@example.com"),
                text("1234567890"),
                text("Male"),
                text("Math"),
                text("Sports"),
                text("Reading"),
                text("123 Main Street"),
                text("NCR Delhi"));
    }
}
