package pages;

import static com.codeborne.selenide.Selenide.*;

public class POAutomationPracticeForm {

    public void openPage() {
        open("/automation-practice-form");
    }

    public void setFirstName(String firstName) {
        $("#firstName").setValue(firstName);
    }

    public void setLastName(String lastName) {
        $("#lastName").setValue(lastName);
    }

    public void setEmail(String email) {
        $("#userEmail").setValue(email);
    }

    public void setGender(String gender) {
        if (gender.equals("Female")) {
            $("#gender-radio-2").parent().click();
        }
    }

    public void setPhoneNumber(String number) {
        $("#userNumber").setValue(number);
    }

    public void setBirthDate(String month, String year, String day) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--" + day).click();
    }

    public void setSubjects(String subject) {
        $("#subjectsInput").setValue(subject).pressEnter();
    }

    public void setHobbies(String... hobbies) {
        for (String hobby : hobbies) {
            if (hobby.equals("Sport")) $("#hobbies-checkbox-1").parent().click();
            if (hobby.equals("Music")) $("#hobbies-checkbox-3").parent().click();
        }
    }

    public void uploadPicture(String fileName) {
        $("#uploadPicture").uploadFromClasspath(fileName);
    }

    public void setAddress(String address) {
        $("#currentAddress").setValue(address);
    }

    public void selectStateAndCity(String state, String city) {
        $("#state").click();
        $("#react-select-3-option-0").click();
        $("#city").click();
        $("#react-select-4-option-2").click();
    }

    public void submitForm() {
        $("#submit").click();
    }
}
