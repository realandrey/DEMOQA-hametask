package components;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class ResultModalComponent {

    public void checkResult(String expectedText) {
        $(".modal-content").shouldHave(text(expectedText));
    }
}
