package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class DemoqaFillFormTest extends TestBase {
    @Test
    void mainTest() {

        open("/automation-practice-form");

        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Petrov");
        $("#userEmail").setValue("test@email.test");
        $(".custom-control-label").click();
        $("#userNumber").setValue("1234567890");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("2004");
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__day--004").click();

        $("#subjectsInput").setValue("m").pressTab();

        $("#uploadPicture").uploadFromClasspath("1.jpg");

        $("label[for='hobbies-checkbox-1']").click();
        $("label[for='hobbies-checkbox-2']").click();
        $("#currentAddress").setValue("somewhere");

        $("#state").click();
        $("#react-select-3-input").setValue("Uttar Pradesh").pressEnter();
        $("#city").click();
        $("#react-select-4-input").setValue("Agra").pressEnter();

        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(
                text("Ivan "),
                text("Petrov"),
                text("1234567890"),
                text("04 May,2004"),
                text("Maths"),
                text("Sports, Reading"),
                text("1.jpg"),
                text("somewhere"),
                text("Uttar Pradesh Agra")
        );

    }
}