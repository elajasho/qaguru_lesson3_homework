package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;
import pages.components.TableComponent;

import java.util.Locale;


public class DemoqaPageObjectsTest extends TestBase {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    TableComponent tableComponent = new TableComponent();

    Faker faker = new Faker(new Locale("en"));


    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String streetAddress = faker.address().streetAddress();
    String randomEmail = faker.internet().emailAddress();
    String randomhoneNumber = faker.number().digits(10);
    String randomDay = String.format("%02d", faker.number().numberBetween(1, 30));
    String randomMonth = faker.options().option("January", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
    String randomYear = String.valueOf(faker.number().numberBetween(1900, 2100));
    String randomSubject = faker.options().option("Arts", "Biology", "Chemistry", "English", "Hindi", "Maths", "Physics");



    @Test
    void mainTest() {

        registrationFormPage
                .openPage()
                .removeBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(randomEmail)
                .userNumberInput(randomhoneNumber)
                .setGender()
                .setBirthday(randomDay, randomMonth, randomYear)
                .setSubjects(randomSubject)
                .setPicture("1.jpg")
                .setHobbiesSports("Yes")
                .setHobbiesReading("Yes")
                .setHobbiesMusic("No")
                .setUserAddress(streetAddress)
                .setUserState("Uttar Pradesh")
                .setUserCity("Agra");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        registrationFormPage
                .hitSubmitWithBothLegs();





        tableComponent
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", randomEmail)
                .checkResult("Mobile", randomhoneNumber)
                .checkResult("Date of Birth", randomDay + " " + randomMonth + "," + randomYear)
                .checkResult("Subjects", randomSubject)
                .checkResult("Hobbies", "Sports, Reading")
                .checkResult("Picture", "1.jpg")
                .checkResult("Address", streetAddress)
                .checkResult("State and City", "Uttar P")
        ;
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}