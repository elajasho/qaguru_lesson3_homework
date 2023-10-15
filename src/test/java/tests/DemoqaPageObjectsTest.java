package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;
import pages.components.TableComponent;


public class DemoqaPageObjectsTest extends TestBase {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    TableComponent tableComponent = new TableComponent();

    @Test
    void mainTest() {

        registrationFormPage
                .openPage()
                .setFirstName("Ivan")
                .setLastName("Petrov")
                .setUserEmail("test@email.test")
                .userNumberInput("1234567890")
                .setGender()
                .setBirthday("04", "July", "2001")
                .setSubjects("m")
                .setPicture("1.jpg")
                .setHobbiesSports("Yes")
                .setHobbiesReading("Yes")
                .setHobbiesMusic("No")
                .setUserAddress("A long time ago in a galaxy far, far away")
                .setUserState("Uttar Pradesh")
                .setUserCity("Agra")
                .hitSubmitWithBothLegs();
        tableComponent
                .checkTitle()
                .checkResult("Student Name", "Ivan Petrov")
                .checkResult("Student Email", "test@email.test")
                .checkResult("Mobile", "1234567890")
                .checkResult("Date of Birth", "04 July,2001")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Sports, Reading")
                .checkResult("Picture","1.jpg")
                .checkResult("Address","A long time ago in a galaxy far, far away")
                .checkResult("State and City","Uttar P")
        ;

    }
}