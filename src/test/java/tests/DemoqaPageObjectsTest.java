package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;
import pages.components.TableComponent;

import static pages.components.CalendarComponent.*;
import static tests.TestData.*;

public class DemoqaPageObjectsTest extends TestBase {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    TableComponent tableComponent = new TableComponent();
    TestData testData = new TestData();

    @Test
    void mainTest() {
        registrationFormPage
                .openPage()
                .removeBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(randomEmail)
                .userNumberInput(randomPhoneNumber)
                .setGender(randomGender)
                .setBirthday()
                .setSubjects(randomSubject)
                .setPicture()
                .setHobbiesSports(randomSport)
                .setHobbiesReading(randomReading)
                .setHobbiesMusic(randomMusic)
                .setUserAddress(streetAddress)
                .setUserState(randomState)
                .setUserCity(testData.getRandomCity());

        registrationFormPage
                .hitSubmitWithBothLegs();

        tableComponent
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", randomEmail)
                .checkResult("Mobile", randomPhoneNumber)
                .checkResult("Date of Birth", checkDay + " " + checkMonth + "," + checkYear)
                .checkResult("Subjects", randomSubject)
                .checkResult("Picture", imageName)
                .checkResult("Address", streetAddress)
                .checkResult("State and City", randomState)
                .checkResult("State and City", testData.getRandomCity());

        if (randomSport.equals("Yes")) {
            tableComponent.checkResult("Hobbies", "Sports");
        }
        if (randomReading.equals("Yes")) {
            tableComponent.checkResult("Hobbies", "Reading");
        }
        if (randomMusic.equals("Yes")) {
            tableComponent.checkResult("Hobbies", "Music");
        }
    }
}