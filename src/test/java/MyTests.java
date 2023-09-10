import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class MyTests  {
    @BeforeAll
    static void beforeall(){
        Configuration.browser = "firefox";
        Configuration.holdBrowserOpen = false;
        Configuration.browserSize = "1300x1200";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";

        }


    @Test
    void mainTest() {

        System.out.println("\u001B[34m" + "____Test started____" + "\u001B[0m");

        open("/automation-practice-form");



        System.out.println("\u001B[34m" + "____Fill in Name email and number____" + "\u001B[0m");

        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Petrov");
        $("#userEmail").setValue("test@email.test");
        $(".custom-control-label").click();
        $("#userNumber").setValue("1234567890");



        System.out.println("\u001B[34m" + "____Fill in in date of birth____" + "\u001B[0m");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("2004");
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__day--004").click();



        System.out.println("\u001B[34m" + "____Choose subject____" + "\u001B[0m");

        $("#subjectsInput").setValue("maths").pressTab();



        System.out.println("\u001B[34m" + "____Upload file____" + "\u001B[0m");

        $("#uploadPicture").uploadFile(new File("src/test/resources/1.jpg"));



        System.out.println("\u001B[34m" + "____Fill in hobbies and address____" + "\u001B[0m");

        $("label[for='hobbies-checkbox-1']").click();
        $("label[for='hobbies-checkbox-2']").click();
        $("#currentAddress").setValue("somewhere");

        $("#state").click();
        $("#react-select-3-input").setValue("Uttar Pradesh").pressEnter();
        $("#city").click();
        $("#react-select-4-input").setValue("Agra").pressEnter();


        $("#submit").click();

        System.out.println("\u001B[34m" + "____Checking results____" + "\u001B[0m");

        //Thread.sleep(5000);





        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(
                text("Ivan "),
                text("Petrov"),
                text("1234567890"),
                text("04 May,2004"),
           //     text("Maths"),    //надо добиться стабильного результата по этому полю
                text("Sports, Reading"),
                text("1.jpg"),
                text("somewhere"),
                text("Uttar Pradesh Agra")
        );

             System.out.println("\u001B[34m" + "<<<<<<DONE>>>>>>>" + "\u001B[0m");

    }
}