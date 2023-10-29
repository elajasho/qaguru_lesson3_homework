package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;
import pages.components.TableComponent;

import static com.codeborne.selenide.Selenide.sleep;


public class DemoqaPageObjectsTest extends TestBase {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    TableComponent tableComponent = new TableComponent();
    TestData testData = new TestData();

    @Test
    void mainTest() {
        registrationFormPage
                .openPage()
                .removeBanners()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setUserEmail(testData.randomEmail)
                .userNumberInput(testData.randomPhoneNumber)
                .setGender(testData.randomGender)
                .setBirthday()
                .setSubjects(testData.randomSubject)
                .setHobbies(testData.randomHobbies)
                .setPicture(testData.imageName)
                .setUserAddress(testData.streetAddress)
                .setUserState(testData.randomState)
                .setUserCity(testData.getRandomCity());
        sleep(3000);
        registrationFormPage
                .hitSubmitWithBothLegs();

        tableComponent
                .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Student Email", testData.randomEmail)
                .checkResult("Mobile", testData.randomPhoneNumber)
             //   .checkResult("Date of Birth", checkDay + " " + checkMonth + "," + checkYear)
                .checkResult("Subjects", testData.randomSubject)
                .checkResult("Hobbies", testData.randomHobbies)
                .checkResult("Picture", testData.imageName)
                .checkResult("Address", testData.streetAddress)
                .checkResult("State and City", testData.randomState)
                .checkResult("State and City", testData.getRandomCity());
sleep(3000);
    }
}