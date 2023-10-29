package tests;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;
import pages.components.TableComponent;

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
                .setBirthday(testData.randomDate)
                .setSubjects(testData.randomSubject)
                .setHobbies(testData.randomHobbies)
                .setPicture(testData.imageName)
                .setUserAddress(testData.streetAddress)
                .setUserState(testData.randomState)
                .setUserCity(testData.getRandomCity());
        registrationFormPage
                .hitSubmitWithBothLegs();

        tableComponent
                .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Student Email", testData.randomEmail)
                .checkResult("Mobile", testData.randomPhoneNumber)
                .checkResult("Date of Birth", testData.getRandomDate())
                .checkResult("Subjects", testData.randomSubject)
                .checkResult("Hobbies", testData.randomHobbies)
                .checkResult("Picture", testData.imageName)
                .checkResult("Address", testData.streetAddress)
                .checkResult("State and City", testData.randomState)
                .checkResult("State and City", testData.getRandomCity());
    }
}