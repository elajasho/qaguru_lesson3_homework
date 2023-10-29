package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


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
            userAddressInput = $("#currentAddress"),
            userStateInput = $("#react-select-3-input"),
            userCityInput = $("#react-select-4-input"),
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

    public RegistrationFormPage setHobbies(String value) {
        $(byText(value)).click();
        return this;
    }

    public RegistrationFormPage setPicture(String value) {
        userPictureInput.uploadFile(new File("src/test/resources/" + value));
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