package pages;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.POAutomationPracticeForm;
import components.ResultModalComponent;

public class AutomationPracticeForm {

    POAutomationPracticeForm formPage = new POAutomationPracticeForm();
    ResultModalComponent resultModal = new ResultModalComponent();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000;
    }

    @Test
    void fillFormTest() {
        formPage.openPage();

        formPage.setFirstName("Alex");
        formPage.setLastName("Gavrilov");
        formPage.setEmail("alex.gav@mail.ru");
        formPage.setGender("Female");
        formPage.setPhoneNumber("9103445775");
        formPage.setBirthDate("January", "1984", "12");
        formPage.setSubjects("Math");
        formPage.setHobbies("Sport", "Music");
        formPage.uploadPicture("picture.png");
        formPage.setAddress("133 Street");
        formPage.selectStateAndCity("NCR", "Noida");
        formPage.submitForm();

        resultModal.checkResult("Alex Gavrilov");
        resultModal.checkResult("alex.gav@mail.ru");
        resultModal.checkResult("9103445775");
        resultModal.checkResult("Female");
        resultModal.checkResult("January");
        resultModal.checkResult("Sports");
        resultModal.checkResult("Music");
        resultModal.checkResult("133 Street");
        resultModal.checkResult("NCR Noida");
        resultModal.checkResult("picture.png");
    }
}