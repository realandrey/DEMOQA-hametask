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
        $("#uploadPicture").uploadFile(new File("src/test/picture.png"));

        // Заполнение адреса
        $("#currentAddress").setValue("133 Street");

        // Выбор штата и города (Пример: NCR -> Delhi)
        $("#state").click();
        $x("//div[text()='NCR']").click();
        $("#city").click();
        $x("//div[text()='Noida']").click();

        // Отправка формы
        $("#submit").click();

        // Проверка вывода
        $(".modal-content").shouldHave(text("Alex Gavrilov"),
                text("alex.gav@mail.ru"),
                text("9103445775"),
                text("Female"),
                text("January"),
                text("Sports"),
                text("Music"),
                text("133 Street"),
                text("NCR Noida"));
    }
}
