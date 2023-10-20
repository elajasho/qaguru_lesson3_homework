package pages;

import com.codeborne.selenide.SelenideElement;
import org.jetbrains.annotations.NotNull;
import pages.components.CalendarComponent;

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
            userHobbiesInput1 = $("label[for='hobbies-checkbox-1']"),
            userHobbiesInput2 = $("label[for='hobbies-checkbox-2']"),
            userHobbiesInput3 = $("label[for='hobbies-checkbox-3']"),
            userAddressInput = $("#currentAddress"),
            userStateInput = $("#react-select-3-input"),
            userCityInput = $("#react-select-4-input"),
            userGenderSelector = $(".custom-control-label"),
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

    public RegistrationFormPage setGender() {
        userGenderSelector.click();
        return this;
    }

    public RegistrationFormPage setBirthday(String day, String month, String year) {
        userBirthdaySelector.click();
        birthday.setDate(day, month, year);

        return this;

    }

    public RegistrationFormPage setSubjects(String value) {
        userInputSubjects.setValue(value);
        userSubjectSelector.pressTab();
        return this;
    }

    public RegistrationFormPage setPicture(String value) {

        userPictureInput.uploadFromClasspath(value);
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

    public RegistrationFormPage setUserCity(String value) {
        userCitySelector.click();
        userCityInput.setValue(value).pressEnter();

        return this;
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
