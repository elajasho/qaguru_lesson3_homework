package pages;

import com.codeborne.selenide.SelenideElement;
import org.jetbrains.annotations.NotNull;
import pages.components.CalendarComponent;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static tests.TestData.imagePath;

public class RegistrationFormPage {
    /////SelenidePageElements
    CalendarComponent birthday = new CalendarComponent();
    SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userNumberInput = $("#userNumber"),
            userInputSubjects = $("#subjectsInput"),
            userPictureInput = $("#uploadPicture"),
            userHobbiesInput1 = $(byText("Sports")),
            userHobbiesInput2 = $(byText("Reading")),
            userHobbiesInput3 = $(byText("Music")),
            userAddressInput = $("#currentAddress"),
            userStateInput = $("#react-select-3-input"),
            userCityInput = $("#react-select-4-input"),
    // userGenderSelector = $(".custom-control-label"),
    //userGenderSelector = $("input[value='value']"),
    userBirthdaySelector = $("#dateOfBirthInput"),
            userSubjectSelector = $("#subjectsInput"),
            userStateSelector = $("#state"),
            userCitySelector = $("#city"),
            submitButtonSelector = $("#submit");

    /////PageActions
    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    public RegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationFormPage userNumberInput(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setGender(String value) {
        //userGenderSelector.
                $("input[value='" + value + "']").doubleClick();
        return this;
    }

    public RegistrationFormPage setBirthday() {
        userBirthdaySelector.click();
        birthday.setDate();
        return this;
    }

    public RegistrationFormPage setSubjects(String value) {
        userInputSubjects.setValue(value);
        userSubjectSelector.pressTab();
        return this;
    }

    public RegistrationFormPage setPicture() {
        userPictureInput.uploadFile(new File(imagePath));
        return this;
    }

    public RegistrationFormPage setHobbiesSports(@NotNull String value) {
        if (value.equals("Yes")) {
            userHobbiesInput1.click();
        }
        return this;
    }

    public RegistrationFormPage setHobbiesReading(@NotNull String value) {
        if (value.equals("Yes")) {
            userHobbiesInput2.click();
        }
        return this;
    }

    public RegistrationFormPage setHobbiesMusic(@NotNull String value) {
        if (value.equals("Yes")) {
            userHobbiesInput3.click();
        }
        return this;
    }

    public RegistrationFormPage setUserAddress(String value) {
        userAddressInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setUserState(String value) {
        userStateSelector.click();
        userStateInput.setValue(value).pressEnter();
        return this;
    }

    public void setUserCity(String value) {
        userCitySelector.click();
        userCityInput.setValue(value).pressEnter();
    }

    public void hitSubmitWithBothLegs() {

        submitButtonSelector.click();
    }

    public RegistrationFormPage removeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }
}
