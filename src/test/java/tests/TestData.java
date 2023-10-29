package tests;

import com.github.javafaker.Faker;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class TestData {
    Faker faker = new Faker(new Locale("en"));

    String[] NCR = new String[]{"Delhi", "Gurgaon", "Noida"};
    String[] UttarPradesh = new String[]{"Agra", "Lucknow", "Merrut"};
    String[] Haryana = new String[]{"Karnal", "Panipat"};
    String[] Rajasthan = new String[]{"Jaipur", "Jaiselmer"};

    public String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            streetAddress = faker.address().streetAddress(),
            randomEmail = faker.internet().emailAddress(),
            randomPhoneNumber = faker.number().digits(10),
            randomGender = faker.options().option("Male", "Female", "Other"),
            randomSubject = faker.options().option("Arts", "Biology", "Chemistry", "English", "Hindi", "Maths", "Physics"),
            randomHobbies = faker.options().option("Sports", "Reading", "Music"),

    randomState = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");

    public String getRandomCity() {
        String[] selectedList = null;
        String randomValue;

        switch (randomState) {
            case "NCR":
                selectedList = NCR;
                break;
            case "Uttar Pradesh":
                selectedList = UttarPradesh;
                break;
            case "Haryana":
                selectedList = Haryana;
                break;
            case "Rajasthan":
                selectedList = Rajasthan;
                break;
            default:
                break;
        }
        assert selectedList != null;
        int randomIndex = faker.number().numberBetween(0, selectedList.length - 1);
        randomValue = selectedList[randomIndex];
        return randomValue;
    }

    public Date
            randomDate = faker.date().birthday(0, 100);

    public String getRandomDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(randomDate);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int year = calendar.get(Calendar.YEAR);
        SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM", new Locale("en"));
        String monthName = monthFormat.format(randomDate);
        return (day + " " + monthName + "," + year);
    }

    public String imageName = faker.lorem().word() + ".jpg";

    BufferedImage image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);
    File outputFile = new File("src/test/resources/" + imageName);

    {
        try {
            ImageIO.write(image, "jpg", outputFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
