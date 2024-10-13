package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        //Configuration.holdBrowserOpen = true; // Используется только для отладки тестов, убираем
        Configuration.timeout = 5000;
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");

        // Заполнение полей ввода
        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Gavrilov");
        $("#userEmail").setValue("alex.gav@mail.ru");
        $("#userNumber").setValue("9103445775");

        // Выбор радиокнопки (Gender)
        $("#gender-radio-2").parent().click();  // Female

        // Установка даты рождения
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("1984");
        $(".react-datepicker__day--012").click();  // 12 января

        // Ввод предметов
        $("#subjectsInput").setValue("Math").pressEnter();

        // Установка чекбоксов (Hobbies)
        $("#hobbies-checkbox-1").parent().click();  // Sport
        $("#hobbies-checkbox-3").parent().click();  // Music

        // Загрузка файла
        $("#uploadPicture").uploadFromClasspath("picture.png");

        // Заполнение адреса
        $("#currentAddress").setValue("133 Street");

        // Выбор штата и города (Пример: NCR -> Noida)
        $("#state").click();
        $("#react-select-3-option-0").click(); // Выбор "NCR", с использованием нужного селектора, считаем от 0
        $("#city").click();
        $("#react-select-4-option-2").click(); // Выбор "Noida", с использованием нужного селектора, считаем от 0

        // Отправка формы
        $("#submit").click();

        // Проверка вывода по отдельности
        $(".modal-content").shouldHave(text("Alex Gavrilov"));
        $(".modal-content").shouldHave(text("alex.gav@mail.ru"));
        $(".modal-content").shouldHave(text("9103445775"));
        $(".modal-content").shouldHave(text("Female"));
        $(".modal-content").shouldHave(text("January"));
        $(".modal-content").shouldHave(text("Sports"));
        $(".modal-content").shouldHave(text("Music"));
        $(".modal-content").shouldHave(text("133 Street"));
        $(".modal-content").shouldHave(text("NCR Noida"));

        // Проверка загрузки изображения
        $(".modal-content").shouldHave(text("picture.png"));
    }
}
